package dk.kea.shipgame.Service;

import dk.kea.shipgame.Model.Map;
import dk.kea.shipgame.Model.Nationality;
import dk.kea.shipgame.Repository.MapRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapService {

    @Autowired
    MapRepo mapRepo;

    public List<Nationality> fetchAllNationalities(){

        return mapRepo.fetchAllNationalities();

    }

}
