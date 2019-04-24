package dk.kea.shipgame.Repository;

import dk.kea.shipgame.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MapRepo {

    @Autowired
    JdbcTemplate template;

    public List<Nationality> fetchAllNationalities(){

        String sql = "SELECT * FROM Nationality";
        RowMapper<Nationality> rowMapper = new BeanPropertyRowMapper<>(Nationality.class);

        return template.query(sql, rowMapper);
    }

    public List<Ship> generateInitalShips(Map map, int player_nationality, boolean isClient){

        List<Ship> ships = new ArrayList<>();
        List<Nationality> nationalities = fetchAllNationalities();

        int len = nationalities.size();

        Nationality myNationality = new Nationality();

        Shiptype shipType = new Shiptype();

        for(int i=0; i<len; i++) {
            if (nationalities.get(i).getId() == player_nationality) {
                myNationality = nationalities.get(i);
            }
        }

        for (int i = 0; i<3; i++) {
            if (i==0) {

                int x;
                Direction dir;
                int id;
                if (isClient) {
                    x = map.getWidth()-1;
                    dir = Direction.SW;
                    id = 4;
                } else {
                    x = 0;
                    dir = Direction.SE;
                    id = 1;
                }

                int y = 0;
                Coordinate coordinate = new Coordinate(x, y);
                Ship ship = new Ship(id, shipType, myNationality, coordinate, dir,
                        0, 100, 100, 100, 0, 0);
                ships.add(ship);

            } else if (i==1) {
                int x;
                Direction dir;
                int id;
                if (isClient) {
                    x = map.getWidth()-1;
                    dir = Direction.NW;
                    id = 5;
                } else {
                    x = 0;
                    dir = Direction.SE;
                    id = 2;
                }
                int y = map.getHeight()/2;
                Coordinate coordinate = new Coordinate(x, y);
                Ship ship = new Ship(id, shipType, myNationality, coordinate, dir,
                        0, 100, 100, 100, 0, 0);
                ships.add(ship);

            } else if (i==2) {
                int x;
                Direction dir;
                int id;
                if (isClient) {
                    x = map.getWidth()-1;
                    dir = Direction.NW;
                    id = 6;
                } else {
                    x = 0;
                    dir = Direction.NE;
                    id = 3;
                }
                int y = map.getHeight()-1;
                Coordinate coordinate = new Coordinate(x, y);
                Ship ship = new Ship(id, shipType, myNationality, coordinate, dir,
                        0, 100, 100, 100, 0, 0);
                ships.add(ship);

            }
        }

        return ships;
    }
}
