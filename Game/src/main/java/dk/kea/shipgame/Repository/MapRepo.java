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

    public List<Ship> generateInitalShips(Map map){

        List<Ship> ships = new ArrayList<>();
        List<Nationality> nationalities = fetchAllNationalities();

        int len = nationalities.size();

        Nationality myNationality = new Nationality();

        for(int i=0; i<len; i++) {
            if (nationalities.get(i).getId() == map.getPlayer_nationality()) {
                myNationality = nationalities.get(i);
            }
        }

        for (int i = 0; i<3; i++) {
            if (i==0) {

                int x = 0;
                int y = 0;
                Coordinate coordinate = new Coordinate(x, y);
                Ship ship = new Ship(1, 1, myNationality, coordinate, Direction.SE,
                        0, 100, 100, 100, 0, 0);
                ships.add(ship);

            } else if (i==1) {

                int x = 0;
                int y = map.getHeight()/2;
                Coordinate coordinate = new Coordinate(x, y);
                Ship ship = new Ship(2, 2, myNationality, coordinate, Direction.SE,
                        0, 100, 100, 100, 0, 0);
                ships.add(ship);

            } else if (i==2) {

                int x = 0;
                int y = map.getHeight()-1;
                Coordinate coordinate = new Coordinate(x, y);
                Ship ship = new Ship(3, 3, myNationality, coordinate, Direction.NE,
                        0, 100, 100, 100, 0, 0);
                ships.add(ship);

            }
        }

        return ships;
    }

}
