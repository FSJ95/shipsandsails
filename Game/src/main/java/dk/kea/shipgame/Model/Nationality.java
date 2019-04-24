package dk.kea.shipgame.Model;

import java.io.Serializable;

public class Nationality implements Serializable {

    private int nationality_id;
    private String country;
    private String color;
    private String captain;

    public Nationality(){

    }

    public Nationality(int nationality_id, String country, String color, String captain) {
        this.nationality_id = nationality_id;
        this.country = country;
        this.color = color;
        this.captain = captain;
    }

    public int getNationality_id() {
        return nationality_id;
    }

    public void setNationality_id(int nationality_id) {
        this.nationality_id = nationality_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }
}
