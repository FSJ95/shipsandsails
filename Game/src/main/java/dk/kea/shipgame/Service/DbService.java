package dk.kea.shipgame.Service;

import dk.kea.shipgame.Model.Map;
import dk.kea.shipgame.Model.Nationality;
import dk.kea.shipgame.Model.Ship;
import dk.kea.shipgame.Repository.DbRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {

    @Autowired
    DbRepo mapRepo;

    public List<Nationality> fetchAllNationalities(){

        return mapRepo.fetchAllNationalities();

    }

    public List<Ship> generateInitalShips(Map map, int player_nationality, boolean isClient){

        return mapRepo.generateInitalShips(map, player_nationality, isClient);
    }

}
