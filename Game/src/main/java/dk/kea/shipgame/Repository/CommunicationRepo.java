package dk.kea.shipgame.Repository;

import java.io.*;
import java.net.*;

import dk.kea.shipgame.Model.Order;
import dk.kea.shipgame.Model.Ship;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class CommunicationRepo {

    private ServerSocket servSock;
    private Socket link;
    final int PORT = 1234;

    public void sendMsg(Object object){
        try {

            ObjectOutputStream oos = new ObjectOutputStream(this.link.getOutputStream());

            oos.writeObject(object);
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object recieveMsg(){
        System.out.println("\n* Recieving message *\n");
        try {

            ObjectInputStream ois = new ObjectInputStream(this.link.getInputStream());
            
            System.out.println("\n* Recieved message *\n");
            return ois.readObject();

        } catch (ClassNotFoundException | IOException a) {
            a.printStackTrace();
        }
        System.out.println("\n* ERROR *\n");
        return null;
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
                return true;
            }


        } catch (Exception e){
            System.out.println(e);
        }
    return false;
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

    public void resetCom(){
        try {
            link.close();
            servSock.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
