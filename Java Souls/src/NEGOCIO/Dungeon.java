package NEGOCIO;

import java.util.ArrayList;

public class Dungeon extends PlaceArchetype {

    private int level;
    private ArrayList<Floor> floorList;
    private int tilePosition; //es el valor de la casilla

    public Dungeon() {
        super(6, -6);
        this.floorList = new ArrayList<>();
        generateDungeonWithFloors();
        this.tilePosition = 1;
        this.level = 0;
    }

    private void generateDungeonWithFloors() {
        Floor floor1 = new Floor(0);
        floor1.addTile(new Tile(1, "Tienes una puerta al Norte, un pasillo al Este y al Oeste.", 4, 0, 2, 3, SPECIAL.NONE));
        floor1.addTile(new Tile(2, "Tienes una puerta al Este, un pasillo al Oeste y al Sur.", 0, 13, 16, 1, SPECIAL.NONE));
        floor1.addTile(new Tile(3, "Tienes una puerta al Oeste, un pasillo al Este y hacia el Sur.", 0, 10, 1, 5, SPECIAL.NONE));
        floor1.addTile(new Tile(4, "Has entrado en la habitación. Hay una puerta al Sur", 0, 1, 0, 0, SPECIAL.CHEST));
        floor1.addTile(new Tile(5, "Has entrado en la habitación. Hay una puerta hacia el Norte y hacia el Sur.", 6, 7, 3, 0, SPECIAL.NONE));
        floor1.addTile(new Tile(6, "Has entrado en la habitación.", 0, 5, 0, 0, SPECIAL.BATTLE));
        floor1.addTile(new Tile(7, "Has entrado en la habitación. Hay una puerta hacia el Norte y hacia el Sur.", 5, 9, 0, 0, SPECIAL.BATTLE));
        floor1.addTile(new Tile(9, "Has entrado en la habitación. Hay una puerta hacia el Norte.", 7, 0, 0, 0, SPECIAL.CHEST));
        floor1.addTile(new Tile(10, "Tienes una puerta al Este. Hay un pasillo al Norte.", 3, 0, 11, 0, SPECIAL.NONE));
        floor1.addTile(new Tile(11, "Has entrado una gran habitación. Al Norte hay unas escaleras. A los lados hay puertas.", 19, 0, 13, 10, SPECIAL.BATTLE));
        floor1.addTile(new Tile(13, "Hay unas puertas a tus lados. Al Norte hay un pasillo.", 2, 0, 14, 11, SPECIAL.NONE));
        floor1.addTile(new Tile(14, "Has entrado en la habitación. Hay un pasillo al Oeste", 0, 0, 0, 13, SPECIAL.CHEST));
        floor1.addTile(new Tile(16, "Has entrado en la habitación. Hay una puerta al Oeste y al Norte.", 17, 0, 0, 2, SPECIAL.NONE));
        floor1.addTile(new Tile(17, "Has entrado en la habitación. Hay una puerta al Sur.", 0, 16, 0, 0, SPECIAL.CHEST));
        floor1.addTile(new Tile(19, "Has bajado las escaleras.", 1, 1, 1, 1, SPECIAL.STAIRS));
        this.floorList.add(floor1);
        Floor floor2 = new Floor(1);
        floor2.addTile(new Tile(1, "Tienes un pasillo al Sur.", 0, 2, 0, 0, SPECIAL.NONE));
        floor2.addTile(new Tile(2, "Tienes un pasillo al Norte y al Este. Hay una puerta al Sur.", 1, 3, 9, 0, SPECIAL.NONE));
        floor2.addTile(new Tile(3, "Has entrado en la habitación. Tienes una puerta al Norte.", 2, 0, 0, 0, SPECIAL.BATTLE));
        floor2.addTile(new Tile(4, "Tienes un pasillo al Este. Hay una puerta al Sur.", 0, 5, 8, 0, SPECIAL.NONE));
        floor2.addTile(new Tile(5, "Has entrado en la habitación. Hay una puerta al Norte.", 4, 0, 0, 0, SPECIAL.BATTLE));
        floor2.addTile(new Tile(6, "Has entrado en la habitación. Hay una puerta al Sur.", 0, 7, 0, 0, SPECIAL.CHEST));
        floor2.addTile(new Tile(7, "Tienes un pasillo al Este. Hay una puerta al Norte.", 6, 0, 10, 0, SPECIAL.NONE));
        floor2.addTile(new Tile(8, "Tienes un pasillo al Sur y al Oeste. Hay una puerta al Este.", 0, 9, 11, 4, SPECIAL.NONE));
        floor2.addTile(new Tile(9, "Te rodean pasillos.", 8, 10, 14, 2, SPECIAL.NONE));
        floor2.addTile(new Tile(10, "Tienes un pasillo al Norte y al Oeste. Hay una puerta al Este.", 9, 0, 12, 7, SPECIAL.NONE));
        floor2.addTile(new Tile(11, "Has entrado en la habitación. Hay una puerta al Oeste.", 0, 0, 0, 8, SPECIAL.BATTLE));
        floor2.addTile(new Tile(12, "Has entrado en la habitación. Hay una puerta al Oeste", 0, 0, 0, 10, SPECIAL.BATTLE));
        floor2.addTile(new Tile(13, "Tienes un pasillo al Sur y al Este.", 0, 14, 16, 0, SPECIAL.NONE));
        floor2.addTile(new Tile(14, "Tienes un pasillo al Norte, al Sur y al Oeste.", 13, 15, 0, 9, SPECIAL.NONE));
        floor2.addTile(new Tile(15, "Tienes un pasillo al Norte y al Este.", 14, 0, 19, 0, SPECIAL.NONE));
        floor2.addTile(new Tile(16, "Tienes un pasillo al Oeste. Hay una puerta al Sur.", 0, 17, 0, 13, SPECIAL.BATTLE));
        floor2.addTile(new Tile(17, "Has entrado en la habitación. Hay una puerta al Norte.", 16, 0, 0, 0, SPECIAL.BATTLE));
        floor2.addTile(new Tile(18, "Has entrado en la habitación. Hay una puerta al Sur. Ves unas escaleras al Oeste.", 0, 19, 0, 20, SPECIAL.CHEST));
        floor2.addTile(new Tile(19, "Tienes un pasillo al Oeste. Hay una puerta al Norte.", 18, 0, 0, 15, SPECIAL.NONE));
        floor2.addTile(new Tile(20, "Has bajado las escaleras.", -1, -1, -1, -1, SPECIAL.STAIRS));
        this.floorList.add(floor2);
        Floor floor3 = new Floor(2);
        floor3.addTile(new Tile(1, "Te encuentras enfrente de unas grandes puertas. Sientes la presión de un gran poder.", 2, 0, 0, 0, SPECIAL.NONE));
        floor3.addTile(new Tile(2, "Has entrado en la habitación del Mago.", -1, -1, -1, -1, SPECIAL.FINAL));
        this.floorList.add(floor3);

    }

    public boolean checkDungeon(Player player) {
        return this.getxPositionMaximum() == player.getxPosition() && getyPositionMaximum() == player.getyPosition();
    }

    public void exitDungeon() {
        this.level = 0;
        floorList.clear();
        generateDungeonWithFloors();
    }

    public void goDownStairs() {
        this.level++;
        this.tilePosition = 1;
    }

    public int getTilePosition() {
        return tilePosition;
    }

    public void updateTilePosition(int newTile) {
        this.tilePosition = newTile;
    }

    public boolean isSpecialKey(Player player) {
        return player.isSpecialKey();
    }

    public int getLevel() {
        return level;
    }

    public ArrayList<Floor> getFloorList() {
        return floorList;
    }


//    public void changeSpecialEvent(int tileValue, int floor) {
//        for (Tiles item : floorList.get(floor).getTileList()) {
//            if (item.getValue() == tileValue && item.getSpecial() != SPECIAL.NONE) {
//                item.changeEvent();
//                return;
//            }
//        }
//    }
}
