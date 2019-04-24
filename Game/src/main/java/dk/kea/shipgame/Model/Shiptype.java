package dk.kea.shipgame.Model;

public class Shiptype {
    private int id;
    private String type;
    private int max_speed;
    private int max_speed_change;
    private int max_sailors;
    private int max_hull;
    private int max_sail;
    private int rows_of_guns;
    private int guns_per_row;
    private int sailor_per_gun;
    private int number_of_sails;
    private int sailor_per_sail;
    private int number_of_turns;
    private int sail_50_speed;
    private int sail_25_speed;
    private int sail_10_speed;
    private int sail_0_speed;

    public Shiptype() {
    }

    public Shiptype(int id, String type, int max_speed, int max_speed_change, int max_sailors, int max_hull, int max_sail, int rows_of_guns, int guns_per_row, int sailor_per_gun, int number_of_sails, int sailor_per_sail, int number_of_turns, int sail_50_speed, int sail_25_speed, int sail_10_speed, int sail_0_speed) {
        this.id = id;
        this.type = type;
        this.max_speed = max_speed;
        this.max_speed_change = max_speed_change;
        this.max_sailors = max_sailors;
        this.max_hull = max_hull;
        this.max_sail = max_sail;
        this.rows_of_guns = rows_of_guns;
        this.guns_per_row = guns_per_row;
        this.sailor_per_gun = sailor_per_gun;
        this.number_of_sails = number_of_sails;
        this.sailor_per_sail = sailor_per_sail;
        this.number_of_turns = number_of_turns;
        this.sail_50_speed = sail_50_speed;
        this.sail_25_speed = sail_25_speed;
        this.sail_10_speed = sail_10_speed;
        this.sail_0_speed = sail_0_speed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getMax_sailors() {
        return max_sailors;
    }

    public void setMax_sailors(int max_sailors) {
        this.max_sailors = max_sailors;
    }

    public int getMax_hull() {
        return max_hull;
    }

    public void setMax_hull(int max_hull) {
        this.max_hull = max_hull;
    }

    public int getMax_sail() {
        return max_sail;
    }

    public void setMax_sail(int max_sail) {
        this.max_sail = max_sail;
    }

    public int getRows_of_guns() {
        return rows_of_guns;
    }

    public void setRows_of_guns(int rows_of_guns) {
        this.rows_of_guns = rows_of_guns;
    }

    public int getGuns_per_row() {
        return guns_per_row;
    }

    public void setGuns_per_row(int guns_per_row) {
        this.guns_per_row = guns_per_row;
    }

    public int getSailor_per_gun() {
        return sailor_per_gun;
    }

    public void setSailor_per_gun(int sailor_per_gun) {
        this.sailor_per_gun = sailor_per_gun;
    }

    public int getNumber_of_sails() {
        return number_of_sails;
    }

    public void setNumber_of_sails(int number_of_sails) {
        this.number_of_sails = number_of_sails;
    }

    public int getSailor_per_sail() {
        return sailor_per_sail;
    }

    public void setSailor_per_sail(int sailor_per_sail) {
        this.sailor_per_sail = sailor_per_sail;
    }

    public int getNumber_of_turns() {
        return number_of_turns;
    }

    public void setNumber_of_turns(int number_of_turns) {
        this.number_of_turns = number_of_turns;
    }

    public int getSail_50_speed() {
        return sail_50_speed;
    }

    public void setSail_50_speed(int sail_50_speed) {
        this.sail_50_speed = sail_50_speed;
    }

    public int getSail_25_speed() {
        return sail_25_speed;
    }

    public void setSail_25_speed(int sail_25_speed) {
        this.sail_25_speed = sail_25_speed;
    }

    public int getSail_10_speed() {
        return sail_10_speed;
    }

    public void setSail_10_speed(int sail_10_speed) {
        this.sail_10_speed = sail_10_speed;
    }

    public int getSail_0_speed() {
        return sail_0_speed;
    }

    public void setSail_0_speed(int sail_0_speed) {
        this.sail_0_speed = sail_0_speed;
    }
}
