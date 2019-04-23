package dk.kea.shipgame.Repository;
import dk.kea.shipgame.Model.*;
import dk.kea.shipgame.Service.IMove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MoveRepo implements IMove {

    @Autowired
    JdbcTemplate template;

    List<Coordinate> coordinateList;

    @Override
    public void movement(List<Ship> ships, List<Order> orders, Weather weather) {

        Coordinate coordinate = new Coordinate(5,5);
        Ship ship1 = new Ship(1, 1, "Danmark", "Kaptajn Boosted", coordinate, Direction.SW,
                0, 100, 100, 100, 0, 0);
        ships.add(ship1);

        Order order = new Order(1, 1, 1, 2, coordinateList, true, false, 1, coordinate);



        }
}
