package dk.kea.shipgame.Controller;

import dk.kea.shipgame.Model.Map;
import dk.kea.shipgame.Model.Ship;
import dk.kea.shipgame.Service.CommunicationService;
import dk.kea.shipgame.Service.FetchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Controller
public class mainController {

    @Autowired
    FetchService mapService;

    @Autowired
    CommunicationService communicationService;

    List<Ship> shipList = new ArrayList<>();
    Map map;

    @GetMapping("/")
    public String index(Model model){

        communicationService.resetCom();
        model.addAttribute("nationalities", mapService.fetchAllNationalities());
        model.addAttribute( "state", "index");

        return "index";
    }

    @PostMapping("/server")
    public String createServer(WebRequest wr, Model model){
        int mapHeight = Integer.parseInt(Objects.requireNonNull(wr.getParameter("height")));
        int mapWidth = Integer.parseInt(Objects.requireNonNull(wr.getParameter("width")));
        map = new Map(mapHeight,mapWidth);

        int playerNationality = Integer.parseInt(Objects.requireNonNull(wr.getParameter("player_nationality")));

        shipList = mapService.generateInitalShips(map, playerNationality, false);

        if (communicationService.initHost()){

            communicationService.sendMsg((Object) map);

            communicationService.sendMsg((Object) shipList);

            shipList.addAll((List<Ship>) communicationService.recieveMsg());
            return "redirect:/server";
        } else {
            return "redirect:/";
        }

    }

    @PostMapping("/client")
    public String createClient(WebRequest wr, Model model){

        String ipAdress = wr.getParameter("ipadress");
        int playerNationality = Integer.parseInt(Objects.requireNonNull(wr.getParameter("player_nationality")));

        if (communicationService.initComm(ipAdress)) {

            map = (Map) communicationService.recieveMsg();

            shipList = mapService.generateInitalShips(map, playerNationality, true);

            communicationService.sendMsg((Object) shipList);

            shipList.addAll((List<Ship>) communicationService.recieveMsg());
            return "redirect:/client";

        } else {
            return "redirect:/";
        }

    }


    @GetMapping("/client")
    public String client(Model model){

        model.addAttribute( "state", "client");
        model.addAttribute("generatedMap", map);
        model.addAttribute("shipList", shipList);

        return "index";
    }

    @GetMapping("/server")
    public String server(Model model){

        model.addAttribute( "state", "server");
        model.addAttribute("generatedMap", map);
        model.addAttribute("shipList", shipList);

        return "index";
    }


}
