package NEGOCIO;

import java.util.ArrayList;

public class Forest extends PlaceArchetype {
    private ArrayList<Floor> floorList;
    private int tilePosition;
    private boolean mainKey;

    public Forest() {
        super(4, 9, 15, 3);
        floorList = new ArrayList<>();
        generateForestWithFloors();
        this.tilePosition = 1;
        this.mainKey = false;
    }

    public boolean checkForest(Player player) {
        return (player.getxPosition() >= getxPositionMinimum() && player.getxPosition() <= getxPositionMaximum()) &&
                (player.getyPosition() <= getyPositionMaximum() && player.getyPosition() >= getyPositionMinimum());
    }

    public boolean checkMainForestDungeon() {
        return this.mainKey;
    }

    public void updateTilePosition(int newTile) {
        this.tilePosition = newTile;
    }

    public void findKey() {
        this.mainKey = true;
    }

    public void addFloor(Floor floor) {
        this.floorList.add(floor);
    }

    public void generateForestWithFloors() {
        Floor floor1 = new Floor(0);
        floor1.addTile(new Tile(1, "Hay un pasillo al Norte y al Sur.", 3, 2, 0, 0, SPECIAL.NONE));
        floor1.addTile(new Tile(2, "Tienes una puerta al Oeste, un pasillo al Norte y al Este.", 1, 0, 7, 12, SPECIAL.NONE));
        floor1.addTile(new Tile(3, "Tienes una puerta al Oeste, un pasillo al Sur y al Este.", 0, 1, 8, 13, SPECIAL.NONE));
        floor1.addTile(new Tile(4, "Tienes una puerta al Este, un pasillo al Sur y al Oeste.", 0, 5, 14, 8, SPECIAL.NONE));
        floor1.addTile(new Tile(5, "Tienes un pasillo al Norte y al Sur.", 4, 6, 9, 0, SPECIAL.NONE));
        floor1.addTile(new Tile(6, "Tienes una puerta al Este, un pasillo al Norte y al Oeste.", 5, 0, 16, 7, SPECIAL.NONE));
        floor1.addTile(new Tile(7, "Tienes una gran puerta al Norte, una puerta al Sur, un pasillo al Este y al Oeste. ", 10, 17, 6, 2, SPECIAL.NONE));
        floor1.addTile(new Tile(9, "Has llegado a un callejón sin salida. Solo puedes ir al Oeste", 0, 0, 0, 5, SPECIAL.BATTLE));
        floor1.addTile(new Tile(8, "Tienes una puerta al Norte, un pasillo al Este y al Oeste.", 18, 0, 4, 3, SPECIAL.NONE));
        floor1.addTile(new Tile(10, "Has entrado en la sala principal.", -1, -1, -1, -1, SPECIAL.FINAL)); //ESPECIAL
        floor1.addTile(new Tile(12, "Has entrado en la habitación. Solo tienes una puerta al Este.", 0, 0, 2, 0, SPECIAL.BATTLE));
        floor1.addTile(new Tile(13, "Has entrado en la habitación. Solo tienes una puerta al Este.", 0, 0, 3, 0, SPECIAL.BATTLE));
        floor1.addTile(new Tile(14, "Has entrado en la habitación. Solo tienes una puerta al Oeste.", 0, 0, 0, 4, SPECIAL.KEY));
        floor1.addTile(new Tile(16, "Has entrado en la habitación. Solo tienes una puerta al Oeste.", 0, 0, 6, 0, SPECIAL.BATTLE));
        floor1.addTile(new Tile(17, "Has entrado en la habitación. Solo tienes una puerta al Norte.", 7, 0, 0, 0, SPECIAL.CHEST));
        floor1.addTile(new Tile(18, "Has entrado en la habitación. Solo tienes una puerta al Sur.", 0, 8, 0, 0, SPECIAL.BATTLE));
        addFloor(floor1);
    }

    public ArrayList<Floor> getFloorList() {
        return floorList;
    }

    public int getTilePosition() {
        return tilePosition;
    }
}
