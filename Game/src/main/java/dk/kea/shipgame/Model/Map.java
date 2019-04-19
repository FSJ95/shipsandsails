package dk.kea.shipgame.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Map {

    @Id
    private int mapID;
    private int height;
    private int width;
    private int player_nationality;
    private int enemy_nationality;

    public Map() {
    }

    public Map(int mapID, int height, int width, int player_nationality, int enemy_nationality) {
        this.mapID = mapID;
        this.height = height;
        this.width = width;
        this.player_nationality = player_nationality;
        this.enemy_nationality = enemy_nationality;
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

    public int getPlayer_nationality() {
        return player_nationality;
    }

    public void setPlayer_nationality(int player_nationality) {
        this.player_nationality = player_nationality;
    }

    public int getEnemy_nationality() {
        return enemy_nationality;
    }

    public void setEnemy_nationality(int enemy_nationality) {
        this.enemy_nationality = enemy_nationality;
    }
}
