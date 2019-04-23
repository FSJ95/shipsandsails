package dk.kea.shipgame.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

public class Map implements Serializable {

    private int height;
    private int width;

    public Map() {
    }

    public Map(int height, int width) {
        this.height = height;
        this.width = width;
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
