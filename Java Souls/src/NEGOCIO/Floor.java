package NEGOCIO;

import java.util.ArrayList;

public class Floor {
    private ArrayList<Tile> tileList;
    private int value;

    public Floor(int value) {
        this.value = value;
        this.tileList = new ArrayList<>();
    }

    public void addTile(Tile tile) {
        tileList.add(tile);
    }

    public ArrayList<Tile> getTileList() {
        return tileList;
    }

}
