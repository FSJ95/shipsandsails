package dk.kea.shipgame.Repository;
import dk.kea.shipgame.Model.*;
import dk.kea.shipgame.Service.IMove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MoveRepo implements IMove {

    @Autowired
    JdbcTemplate template;


    @Override
    public void movement(List<Ship> ships, List<Order> orders, Weather weather) {

        Coordinate coordinate = new Coordinate(5,5);
        Ship ship1 = new Ship(1, 1, "Danmark", "Kaptajn Boosted", coordinate, Direction.SW,
                0, 100, 100, 100, 0, 0);
        ships.add(ship1);

        List<Coordinate> coordinateList = new List<Coordinate>();
    }

        Order order = new Order(1, 1, 1, 2, coordinateList, true, false, 1, int target) {


        }
}
