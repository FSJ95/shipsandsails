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
    public void movement(List<Ship> ships, List<Order> orders) {

        /*

        Coordinate coordinate = new Coordinate(5,5);
        Nationality nationality = new Nationality(1,"Danmark", "Red", "Captain Boosted");
        Shiptype shipType = new Shiptype();

        Ship ship1 = new Ship(1, shipType, nationality, coordinate, Direction.SW,
                0, 100, 100, 100, 0, 0);
        ships.add(ship1);

        Order order = new Order(1, 1, 1, 2, coordinateList, true, false, 1, coordinate);

        String sql = "UPDATE ships SET sailors=?, hull=? WHERE id=?";

        template.update(sql, ship1.getSailors(), ship1.getHull_health());

        */


        }
}
