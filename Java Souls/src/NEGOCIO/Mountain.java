package NEGOCIO;

import java.util.ArrayList;

public class Mountain extends PlaceArchetype {
    private ArrayList<Floor> floorList;
    private int tilePosition;

    public Mountain() {
        super(-15, -9, -4, -3);
        this.tilePosition = 1;
        this.floorList = new ArrayList<>();
        generateMountain();
    }


    public boolean checkMountain(Player player) {
        if (player.getxPosition() >= getxPositionMinimum() && player.getxPosition() <= getxPositionMaximum()) {
            if (player.getyPosition() <= getyPositionMinimum() && player.getyPosition() >= getyPositionMaximum()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Floor> getFloorList() {
        return floorList;
    }

    public int getTilePosition() {
        return tilePosition;
    }

    private void generateMountain() {
        Floor floor1 = new Floor(0);
        floor1.addTile(new Tile(1, "Tienes una puerta al Oeste.", 0, 0, 0, 2, SPECIAL.NONE));
        floor1.addTile(new Tile(2, "Tienes un pasillo al Norte y al Oeste. Hay una puerta al Este.", 3, 0, 1, 4, SPECIAL.BATTLE));
        floor1.addTile(new Tile(3, "Tienes una puerta al Norte y al Este. Hay un pasillo al Sur.", 16, 2, 17, 0, SPECIAL.BATTLE));
        floor1.addTile(new Tile(4, "Tienes un pasillo al Norte, al Este y al Oeste.", 18, 0, 2, 8, SPECIAL.BATTLE));
        floor1.addTile(new Tile(5, "Tienes un pasillo al Norte y al Oeste.", 6, 0, 0, 18, SPECIAL.BATTLE));
        floor1.addTile(new Tile(6, "Tienes un pasillo al Sur y una puerta al Este", 0, 5, 15, 0, SPECIAL.BATTLE));
        floor1.addTile(new Tile(7, "Has entrado en la habitación. Hay una puerta al Norte, Sur y al Oeste.", 13, 18, 0, 9, SPECIAL.BATTLE));
        floor1.addTile(new Tile(8, "Tienes un pasillo al Este. Hay una puerta al Norte y al Oeste.", 9, 0, 4, 12, SPECIAL.BATTLE));
        floor1.addTile(new Tile(9, "Has entrado en la habitación. Hay una puerta al Sur, al Este y al Oeste.", 0, 8, 7, 10, SPECIAL.BATTLE));
        floor1.addTile(new Tile(10, "Has entrado en la habitación. Hay una puerta al Sur y al Este.", 0, 11, 9, 0, SPECIAL.CHEST));
        floor1.addTile(new Tile(11, "Has entrado en la habitación. Hay una puerta al Norte.", 10, 0, 0, 0, SPECIAL.TROPHY));
        floor1.addTile(new Tile(12, "Has entrado en la habitación. Hay una puerta al Este.", 0, 0, 8, 0, SPECIAL.CHEST));
        floor1.addTile(new Tile(13, "Has entrado en la habitación. Hay una puerta al Sur y al Oeste.", 0, 7, 0, 14, SPECIAL.BATTLE));
        floor1.addTile(new Tile(14, "Has entrado en la gran habitación. Hay una puerta al Este.", 0, 0, 13, 0, SPECIAL.TROPHY));
        floor1.addTile(new Tile(15, "Has entrado en la habitación. Hay una puerta al Oeste,", 0, 0, 0, 6, SPECIAL.CHEST));
        floor1.addTile(new Tile(16, "Has entrado en la habitación. Hay una puerta al Sur.", 0, 3, 0, 0, SPECIAL.BATTLE));
        floor1.addTile(new Tile(17, "Has entrado en la habitación. Hay una puerta al Oeste.", 0, 0, 0, 3, SPECIAL.CHEST));
        floor1.addTile(new Tile(18, "Tienes una puerta al Norte, un pasillo al Sur y al Este.", 7, 4, 5, 0, SPECIAL.BATTLE));
        this.floorList.add(floor1);
    }

    public void updateTilePosition(int newTile) {
        this.tilePosition = newTile;
    }

}
