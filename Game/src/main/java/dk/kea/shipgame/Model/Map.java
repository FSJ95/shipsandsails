package dk.kea.shipgame.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Map implements Serializable {

    @Id
    private int mapID;
    private int height;
    private int width;

    public Map() {
    }

    public Map(int mapID, int height, int width, int player_nationality) {
        this.mapID = mapID;
        this.height = height;
        this.width = width;
    }

    public int getMapID() {
        return mapID;
    }

    public void setMapID(int mapID) {
        this.mapID = mapID;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

}
