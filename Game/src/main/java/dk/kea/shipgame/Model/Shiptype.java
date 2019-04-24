package dk.kea.shipgame.Model;

public class Shiptype {

    private int ship_type_id;
    private String type;
    private int max_speed;
    private int max_speed_change;
    private int speed_75;
    private int speed_50;
    private int speed_25;
    private int max_health;
    private int damage;


    public Shiptype() {
    }

    public Shiptype(int ship_type_id, String type, int max_speed, int max_speed_change, int speed_75, int speed_50, int speed_25, int max_health, int damage) {
        this.ship_type_id = ship_type_id;
        this.type = type;
        this.max_speed = max_speed;
        this.max_speed_change = max_speed_change;
        this.speed_75 = speed_75;
        this.speed_50 = speed_50;
        this.speed_25 = speed_25;
        this.max_health = max_health;
        this.damage = damage;
    }

    public int getShip_type_id() {
        return ship_type_id;
    }

    public void setShip_type_id(int ship_type_id) {
        this.ship_type_id = ship_type_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMax_speed() {
        return max_speed;
    }

    public void setMax_speed(int max_speed) {
        this.max_speed = max_speed;
    }

    public int getMax_speed_change() {
        return max_speed_change;
    }

    public void setMax_speed_change(int max_speed_change) {
        this.max_speed_change = max_speed_change;
    }

    public int getSpeed_75() {
        return speed_75;
    }

    public void setSpeed_75(int speed_75) {
        this.speed_75 = speed_75;
    }

    public int getSpeed_50() {
        return speed_50;
    }

    public void setSpeed_50(int speed_50) {
        this.speed_50 = speed_50;
    }

    public int getSpeed_25() {
        return speed_25;
    }

    public void setSpeed_25(int speed_25) {
        this.speed_25 = speed_25;
    }

    public int getMax_health() {
        return max_health;
    }

    public void setMax_health(int max_health) {
        this.max_health = max_health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
