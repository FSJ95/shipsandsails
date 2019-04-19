package dk.kea.shipgame.Model;

import javax.persistence.Entity;
import javax.persistence.Id;


public class Weather {

    private int weatherID;
    private Direction windDirection; //ENUM N, NE, SE, S, SW, NW
    private int windSpeed; //0 - 5

    public Weather() {
    }

    public Weather(int weatherID, Direction windDirection, int windSpeed) {
        this.weatherID = weatherID;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
    }

    public int getWeatherID() {
        return weatherID;
    }

    public void setWeatherID(int weatherID) {
        this.weatherID = weatherID;
    }

    public Direction getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Direction windDirection) {
        this.windDirection = windDirection;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }
}
