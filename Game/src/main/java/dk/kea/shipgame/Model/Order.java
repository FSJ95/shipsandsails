package dk.kea.shipgame.Model;

import java.util.List;

public class Order
{

    private int order_id;
    private int ship_id;
    private int turnNumber; //which turn does the order belong to
    private int turn; //sharp left, left, straight, right, sharp right - Enum?
    private List<Coordinate> coordinateList; //ship coordinates from origin to destination
    private boolean fire; //shoot? only possible if not loading
    private boolean load; //order load
    private int ammunitionType; //0=canonball, 1=chainball, 2=grapeshot
    private Coordinate target; //not possible to shoot straight forward or backward - Enum?

    public Order() {
    }

    public Order(int order_id, int ship_id, int turnNumber, int turn, List<Coordinate> coordinateList, boolean fire, boolean load, int ammunitionType, Coordinate target) {
        this.order_id = order_id;
        this.ship_id = ship_id;
        this.turnNumber = turnNumber;
        this.turn = turn;
        this.coordinateList = coordinateList;
        this.fire = fire;
        this.load = load;
        this.ammunitionType = ammunitionType;
        this.target = target;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getShip_id() {
        return ship_id;
    }

    public void setShip_id(int ship_id) {
        this.ship_id = ship_id;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public List<Coordinate> getCoordinateList() {
        return coordinateList;
    }

    public void setCoordinateList(List<Coordinate> coordinateList) {
        this.coordinateList = coordinateList;
    }

    public boolean isFire() {
        return fire;
    }

    public void setFire(boolean fire) {
        this.fire = fire;
    }

    public boolean isLoad() {
        return load;
    }

    public void setLoad(boolean load) {
        this.load = load;
    }

    public int getAmmunitionType() {
        return ammunitionType;
    }

    public void setAmmunitionType(int ammunitionType) {
        this.ammunitionType = ammunitionType;
    }

    public Coordinate getTarget() {
        return target;
    }

    public void setTarget(Coordinate target) {
        this.target = target;
    }
}