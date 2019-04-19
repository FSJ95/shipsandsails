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

}
