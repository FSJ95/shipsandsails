package dk.kea.shipgame.Controller;

import dk.kea.shipgame.Model.Map;
import dk.kea.shipgame.Model.Ship;
import dk.kea.shipgame.Service.CommunicationService;
import dk.kea.shipgame.Service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import java.util.List;


@Controller
@SessionAttributes(value = { "generatedMap" })
public class mainController {

    @Autowired
    MapService mapService;

    @Autowired
    CommunicationService communicationService;

    // Initalisere model attribute med MapID på -1, så hvis brugeren prøver at tilgå
    // "/server" uden at have oprettet server, bliver han sendt tilbage til forsiden.
    @ModelAttribute("generatedMap")
    public Map getMap() {
        Map map = new Map();
        map.setMapID(-1);
        return map;

    }

    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("nationalities", mapService.fetchAllNationalities());
        model.addAttribute( "state", "index");

        return "index";
    }

    @PostMapping("/server")
    public String createServer(@ModelAttribute Map map, Model model){

        communicationService.initHost();
        Map generatedMap = map;
        System.out.println(map.getMapID());
        model.addAttribute("generatedMap", generatedMap);

        return "redirect:/server";
    }

    @RequestMapping(value="/client", method=RequestMethod.POST)
    public String createClient(@ModelAttribute("ipadress") String ipadress,Model model){

        communicationService.initComm(ipadress);

        return "redirect:/client";
    }

    @GetMapping("/sendmsg")
    public String sendMsg(){
        communicationService.sendMsg();
        return "index";
    }


    @GetMapping("/client")
    public String server(Model model){


        return "index";
    }

    @GetMapping("/server")
    public String server(@ModelAttribute("generatedMap") Map map, Model model){

        if(map.getMapID() < 0){
            return "redirect:/";
        }

        //List<Ship> ships = mapService.getShips(map);

        model.addAttribute( "state", "server");
        model.addAttribute("generatedMap", map);
        //model.addAttribute("ships", ships);

        return "index";
    }


}
