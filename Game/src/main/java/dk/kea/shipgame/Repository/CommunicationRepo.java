package dk.kea.shipgame.Repository;

import java.io.*;
import java.net.*;
import java.util.*;
import dk.kea.shipgame.Model.Order;
import dk.kea.shipgame.Model.Ship;
import dk.kea.shipgame.Model.Weather;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class CommunicationRepo {

    private ServerSocket servSock;
    private Socket link;
    final int PORT = 1234;

    public void sendMsg(){
        try {

            ObjectOutputStream oos = new ObjectOutputStream(this.link.getOutputStream());

            oos.writeBoolean(true);
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void recieveMsg(){
        try {

            ObjectInputStream ois = new ObjectInputStream(this.link.getInputStream());

            System.out.println(ois.readBoolean());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean initComm(String ip) //returns true if server - use to determine if to send Weather
    {

        try {
            System.out.println("\n* Trying to connect *\n");
            InetAddress host = InetAddress.getByName(ip);
            int PORT = 1234;
            link = new Socket(host,PORT);
            if(link.isConnected()) {
                System.out.println("\n* Connected to the server... *\n");
            }

        } catch (Exception e){
            System.out.println(e);
        }
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

    public boolean initHost() {
        try {

            servSock = new ServerSocket(PORT);

            link = servSock.accept();

            return true;

        } catch (Exception e) {

            System.out.println(e);
            return false;
        }
    }
}
