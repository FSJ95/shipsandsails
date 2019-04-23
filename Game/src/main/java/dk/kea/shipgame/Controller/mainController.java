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
@SessionAttributes(value = { "generatedMap", "shipList" })
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

        communicationService.resetCom();
        model.addAttribute("nationalities", mapService.fetchAllNationalities());
        model.addAttribute( "state", "index");

        return "index";
    }

    @PostMapping("/server")
    public String createServer(@ModelAttribute Map map, @ModelAttribute("player_nationality") String player_nationality, Model model){

        if (communicationService.initHost()){
            communicationService.sendMsg((Object) map);

            List<Ship> ships = mapService.generateInitalShips(map, Integer.parseInt(player_nationality), false);
            model.addAttribute("generatedMap", map);
            model.addAttribute("shipList", ships);

            communicationService.sendMsg((Object) ships);

            ships.addAll((List<Ship>) communicationService.recieveMsg());
            return "redirect:/server";
        } else {
            return "redirect:/";
        }

    }

    @PostMapping("/client")
    public String createClient(@ModelAttribute("ipadress") String ipadress, @ModelAttribute("player_nationality") String player_nationality, Model model){

        if (communicationService.initComm(ipadress)) {

            Map map = (Map) communicationService.recieveMsg();
            List<Ship> ships = mapService.generateInitalShips(map, Integer.parseInt(player_nationality), true);
            model.addAttribute("generatedMap", map);
            model.addAttribute("shipList", ships);
            communicationService.sendMsg((Object) ships);

            ships.addAll((List<Ship>) communicationService.recieveMsg());
            return "redirect:/client";

        } else {
            return "redirect:/";
        }




    }



    @GetMapping("/client")
    public String client(@ModelAttribute("generatedMap") Map map, @ModelAttribute("shipList") List<Ship> ships, Model model){

        if(map.getMapID() < 0){
            return "redirect:/";
        }

        model.addAttribute( "state", "client");
        model.addAttribute("generatedMap", map);
        model.addAttribute("ships", ships);

        return "index";
    }

    @GetMapping("/server")
    public String server(@ModelAttribute("generatedMap") Map map, @ModelAttribute("shipList") List<Ship> ships, Model model){

        if(map.getMapID() < 0){
            return "redirect:/";
        }

        model.addAttribute( "state", "server");
        model.addAttribute("generatedMap", map);
        model.addAttribute("ships", ships);

        return "index";
    }


}
