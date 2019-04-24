package dk.kea.shipgame.Service;

import dk.kea.shipgame.Model.Map;
import dk.kea.shipgame.Model.Nationality;
import dk.kea.shipgame.Model.Ship;
import dk.kea.shipgame.Model.Shiptype;
import dk.kea.shipgame.Repository.FetchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FetchService {

    @Autowired
    FetchRepo fetchRepo;

    public List<Nationality> fetchAllNationalities(){

        return fetchRepo.fetchAllNationalities();

    }

    public List<Shiptype> fetchAllShipTypes(){

        return fetchRepo.fetchAllShipTypes();
    }

    public List<Ship> generateInitalShips(Map map, int player_nationality, boolean isClient){

        return fetchRepo.generateInitalShips(map, player_nationality, isClient);
    }

}
