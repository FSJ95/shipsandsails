package dk.kea.shipgame.Service;

import dk.kea.shipgame.Model.Order;
import dk.kea.shipgame.Model.Ship;
import dk.kea.shipgame.Model.Weather;
import dk.kea.shipgame.Repository.MoveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoveService {

    @Autowired
    MoveRepo moveRepo;

    public void movement(List<Ship> ships, List<Order> orders, Weather weather){
        moveRepo.movement(ships, orders, weather);
    }


}
