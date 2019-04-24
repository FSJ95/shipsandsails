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
public class FetchRepo {

    @Autowired
    JdbcTemplate template;


    public List<Shiptype> fetchAllShipTypes(){

        String sql = "SELECT * FROM Ship_type";
        RowMapper<Shiptype> rowMapper = new BeanPropertyRowMapper<>(Shiptype.class);

        return template.query(sql, rowMapper);
    }

    public List<Nationality> fetchAllNationalities(){

        String sql = "SELECT * FROM Nationality";
        RowMapper<Nationality> rowMapper = new BeanPropertyRowMapper<>(Nationality.class);

        return template.query(sql, rowMapper);
    }

    public List<Ship> generateInitalShips(Map map, int player_nationality, boolean isClient){

        // Our final list of ships we want to return
        List<Ship> ships = new ArrayList<>();

        // Fetch all nationalities and ship-types
        List<Shiptype> shiptypes = fetchAllShipTypes();
        List<Nationality> nationalities = fetchAllNationalities();

        // Make len the length of the fetched nationalities list.
        int len = nationalities.size();

        // Initalize the player nationality class.
        Nationality nationality = new Nationality();

        // Set the chosen player nationality
        for(int i=0; i<len; i++) {
            if (nationalities.get(i).getNationality_id() == player_nationality) {
                nationality = nationalities.get(i);
            }
        }

        // Create 3 ships.
        for (int i = 0; i<3; i++) {

            // Initialize some values for later use.
            int x = 0;
            int y = 0;
            int id = 0;
            Direction dir = null;
            Ship ship = new Ship();
            Coordinate coordinate = new Coordinate();

            if (i==0) {

                // Different values depending whether server or client.
                if (isClient) {
                    x = map.getWidth()-1;
                    dir = Direction.SW;
                    id = 4;
                } else {
                    x = 0;
                    dir = Direction.SE;
                    id = 1;
                }

                y = 0;

            } else if (i==1) {

                if (isClient) {
                    x = map.getWidth()-1;
                    dir = Direction.NW;
                    id = 5;
                } else {
                    x = 0;
                    dir = Direction.SE;
                    id = 2;
                }

                y = map.getHeight()/2;

            } else if (i==2) {

                if (isClient) {
                    x = map.getWidth()-1;
                    dir = Direction.NW;
                    id = 6;
                } else {
                    x = 0;
                    dir = Direction.NE;
                    id = 3;
                }
                y = map.getHeight()-1;

            }

            coordinate = new Coordinate(x, y);
            ship = new Ship(id, shiptypes.get(i), nationality, coordinate, dir, 0, shiptypes.get(i).getMax_health(), 0, 1);
            ships.add(ship);

        }

        return ships;
    }

}
