package dk.kea.shipgame.Repository;

import dk.kea.shipgame.Model.Order;
import dk.kea.shipgame.Model.Ship;
import dk.kea.shipgame.Model.Weather;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class CommunicationRepo {
    public boolean initComm(String ip) //returns true if server - use to determine if to send Weather
    {
        return false;
    }

    public void exchangeWeather(Weather weather) //exchange weather - if server then decide weather, if client receive weather
    {

    }

    public void exchangeOrders(List<Ship> ships, List<Order> orders) //exchange orders
    {

    }

    public void exchangeAttackResolved(List<Ship> ships) //receive info on enemy surviving ships
    {

    }
}
