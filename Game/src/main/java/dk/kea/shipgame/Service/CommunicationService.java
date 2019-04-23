package dk.kea.shipgame.Service;

import dk.kea.shipgame.Model.Order;
import dk.kea.shipgame.Model.Ship;
import dk.kea.shipgame.Model.Weather;
import dk.kea.shipgame.Repository.CommunicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunicationService {

    @Autowired
    CommunicationRepo communicationRepo;

    public boolean initComm(String ip) //returns true if server - use to determine if to send Weather
    {
        return communicationRepo.initComm(ip);
    }

    public void exchangeWeather(Weather weather) //exchange weather - if server then decide weather, if client receive weather
    {
        communicationRepo.exchangeWeather(weather);
    }

    public void exchangeOrders(List<Ship> ships, List<Order> orders) //exchange orders
    {
        communicationRepo.exchangeOrders(ships, orders);
    }

    public void exchangeAttackResolved(List<Ship> ships) //receive info on enemy surviving ships
    {
        communicationRepo.exchangeAttackResolved(ships);
    }

    public boolean initHost(){
        return communicationRepo.initHost();
    }

    public void sendMsg(Object object){
        communicationRepo.sendMsg(object);
    }

    public Object recieveMsg(){
        return communicationRepo.recieveMsg();
    }
}
