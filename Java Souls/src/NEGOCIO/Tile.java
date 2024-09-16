package NEGOCIO;

public class Tile {
    private int value;
    private String decription;
    private int North;
    private int South;
    private int East;
    private int West;

    public SPECIAL getSpecial() {
        return special;
    }

    private SPECIAL special;

    public Tile(int value, String decription, int north, int south, int east, int west, SPECIAL special) {
        this.value = value;
        this.decription = decription;
        this.North = north;
        this.South = south;
        this.East = east;
        this.West = west;
        this.special = special;
    }


    public int getValue() {
        return value;
    }

    public String getDecription() {
        return decription;
    }

    public int getNorth() {
        return North;
    }

    public int getSouth() {
        return South;
    }

    public int getEast() {
        return East;
    }

    public int getWest() {
        return West;
    }

    public void changeEvent() {
        this.special = SPECIAL.NONE;
    }
}
