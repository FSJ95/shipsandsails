package dk.kea.shipgame.Repository;
import dk.kea.shipgame.Model.Order;
import dk.kea.shipgame.Model.Ship;
import dk.kea.shipgame.Model.Weather;
import dk.kea.shipgame.Service.IMove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MoveRepo implements IMove {

    @Autowired
    JdbcTemplate template;


    @Override
    public void movement(List<Ship> ships, List<Order> orders, Weather weather) {

    }
}
