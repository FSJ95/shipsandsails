package dk.kea.shipgame.Controller;

import dk.kea.shipgame.Model.Map;
import dk.kea.shipgame.Model.Ship;
import dk.kea.shipgame.Service.CommunicationService;
import dk.kea.shipgame.Service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


        if (communicationService.initHost()){
            communicationService.sendMsg((Object) map);
        } else {
            return "redirect:/";
        }

        model.addAttribute("generatedMap", map);

        return "redirect:/server";
    }

    @PostMapping("/client")
    public String createClient(@ModelAttribute("ipadress") String ipadress, Model model){
        Map map = new Map();

        if (communicationService.initComm(ipadress)) {
            map = (Map) communicationService.recieveMsg();
        } else {
            return "redirect:/";
        }

        model.addAttribute("generatedMap", map);

        return "redirect:/client";
    }



    @GetMapping("/client")
    public String client(@ModelAttribute("generatedMap") Map map, Model model){

        if(map.getMapID() < 0){
            return "redirect:/";
        }

        List<Ship> ships = mapService.generateInitalShips(map);

        model.addAttribute( "state", "client");
        model.addAttribute("generatedMap", map);
        model.addAttribute("ships", ships);

        return "index";
    }

    @GetMapping("/server")
    public String server(@ModelAttribute("generatedMap") Map map, Model model){

        if(map.getMapID() < 0){
            return "redirect:/";
        }

        List<Ship> ships = mapService.generateInitalShips(map);

        model.addAttribute( "state", "server");
        model.addAttribute("generatedMap", map);
        model.addAttribute("ships", ships);

        return "index";
    }


}
