package NEGOCIO;

import java.util.ArrayList;

public class Village extends PlaceArchetype {
    ArrayList<ItemArchetype> Inventory;

    public Village() {
        super(-6, 6);
        this.Inventory = new ArrayList<>();
        Inventory.add(new Chest().generateSword());
        Inventory.add(new Chest().generateSword());
        Inventory.add(new Chest().generateShield());
        Inventory.add(new Chest().generateShield());
        Inventory.add(new Chest().generateSpell());
        Inventory.add(new Chest().generateSpell());
    }

    public boolean checkVillage(Player player) {
        return this.getxPositionMaximum() == player.getxPosition() && this.getyPositionMaximum() == player.getyPosition();
    }

    public ArrayList<ItemArchetype> getInventory() {
        return Inventory;
    }
}
