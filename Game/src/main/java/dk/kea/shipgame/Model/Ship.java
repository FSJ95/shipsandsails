package dk.kea.shipgame.Model;


import java.io.Serializable;
import java.util.Objects;

public class Ship implements Serializable{

    private int ship_id;
    private Shiptype shipType; //0=Brig, 1=Ship of the line, 2=Man at war
    private Nationality nationality;
    private Coordinate coordinate;
    private Direction direction; //ENUM, N, NE, SE, S, SW, NW
    private int speed; //change: speed last round +/- calculated change
    private int health;
    private int load; //load time
    private int currentAmmunitionType; //0=canonball, 1=chainball, 2=grapeshot

    public Ship() {
    }

    public Ship(int ship_id, Shiptype shipType, Nationality nationality, Coordinate coordinate, Direction direction, int speed, int health, int load, int currentAmmunitionType) {
        this.ship_id = ship_id;
        this.shipType = shipType;
        this.nationality = nationality;
        this.coordinate = coordinate;
        this.direction = direction;
        this.speed = speed;
        this.health = health;
        this.load = load;
        this.currentAmmunitionType = currentAmmunitionType;
    }

    public int getShip_id() {
        return ship_id;
    }

    public void setShip_id(int ship_id) {
        this.ship_id = ship_id;
    }

    public Shiptype getShipType() {
        return shipType;
    }

    public void setShipType(Shiptype shipType) {
        this.shipType = shipType;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public int getCurrentAmmunitionType() {
        return currentAmmunitionType;
    }

    public void setCurrentAmmunitionType(int currentAmmunitionType) {
        this.currentAmmunitionType = currentAmmunitionType;
    }
}