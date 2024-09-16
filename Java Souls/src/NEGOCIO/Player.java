package NEGOCIO;

import java.util.ArrayList;

public class Player {
    private boolean specialKey;
    private int experience;
    private int actualLifePoint;
    private int maxLifePoint;
    private int level;
    private int xPosition;
    private int yPosition;
    private Weapon weapon;
    private Shield shield;
    private int gold;
    private final ArrayList<Spells> spellsList;
    private final ArrayList<ItemArchetype> inventory;

    //Constructor
    public Player() {
        this.specialKey = false;
        this.level = 1;
        this.maxLifePoint = 50;
        this.actualLifePoint = maxLifePoint;
        this.experience = 0;
        this.weapon = null;
        this.shield = null;
        this.gold = 0;
        this.spellsList = new ArrayList<>();
        this.inventory = new ArrayList<>();
        this.xPosition = 0;
        this.yPosition = 0;
    }

    //Mis métodos
    public void findSpecialKey() {
        this.specialKey = true;
    }

    public void updateXPosition(int movement) {
        this.xPosition += movement;
    }

    public void updateYPosition(int movement) {
        this.yPosition += movement;
    }

    public void updateMovement(int movement) {
        if (movement == 1) {
            updateYPosition(1);
        } else if (movement == 2) {
            updateYPosition(-1);
        } else if (movement == 3) {
            updateXPosition(1);
        } else if (movement == 4) {
            updateXPosition(-1);
        }
    }

    public void exitForest() {
        this.xPosition = 3;
        this.yPosition = 6;
    }

    public void exitMountain() {
        this.xPosition = -3;
        this.yPosition = -6;
    }

    public int getDamage() {
        if (this.getWeapon() != null) {
            return this.getWeapon().getActionPoints() / 10;
        }
        return 0;
    }

    public int getDefense() {
        if (this.getShield() != null) {
            return this.getShield().getActionPoints() / 10;
        }
        return 0;
    }

    public void updateLifePoint(int damage, boolean typeDamage) {
        if (typeDamage) {
            this.actualLifePoint -= damage;
        } else {
            if (this.actualLifePoint + damage >= maxLifePoint) {
                this.actualLifePoint = maxLifePoint;
            } else {
                this.actualLifePoint += damage;
            }

        }
    }

    public boolean checkLevelUp() {
        // la formula es (n^3), como la de pokemon, pero se adapta para que cueste un poco más subir de nivel.
        return this.experience >= 1.5 * Math.pow(level + 2, 3);
    }

    public boolean levelUp() {
        if (checkLevelUp()) {
            this.level++;
            this.maxLifePoint += 15;
            this.actualLifePoint = this.maxLifePoint;
            return true;
        }
        return false;
    }

    public void addExperiencePoints(Monster monster) {
        this.experience += monster.getExperience();
    }

    public void addItemToInventory(ItemArchetype item) {
        this.inventory.add(item);
    }

    public boolean addSpell(Spells spell) {
        if (this.spellsList.size() < 6 && this.inventory.contains(spell)) {
            this.spellsList.add(spell);
            this.inventory.remove(spell);
            return true;
        }
        return false;
    }

    public int useSpell(int position) {
        Spells actualSpell = this.spellsList.get(position - 1);
        this.spellsList.remove(actualSpell);
        return actualSpell.getActionPoints();
    }

    public boolean usePotionInCombat(int position) {
        int potionNumber = 0;
        for (ItemArchetype item : this.inventory) {
            if (item instanceof Potion) {
                potionNumber++;
            }
        }
        if (potionNumber >= position) {
            potionNumber = 0;
            for (ItemArchetype item : this.inventory) {
                if (item instanceof Potion) {
                    potionNumber++;
                    if (potionNumber == position) {
                        this.updateLifePoint(item.getActionPoints(), false);
                        this.removeItem(item);
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void usePotion(Potion item) {
        if (this.inventory.contains(item)) {
            this.updateLifePoint(item.getActionPoints(), false);
            this.removeItem(item);
        }
    }

    public void removeItem(ItemArchetype item) {
        this.inventory.remove(item);
    }

    public void equipWeapon(Weapon weapon) {
        if (inventory.contains(weapon)) {
            if (this.weapon != null) {
                Weapon actualWeapon = this.weapon;
                this.inventory.add(actualWeapon);
                this.weapon = weapon;
                this.inventory.remove(weapon);
                return;
            }
            this.weapon = weapon;
            this.inventory.remove(weapon);
        }
    }

    public void equipShield(Shield shield) {
        if (inventory.contains(shield)) {
            if (this.shield != null) {
                Shield actualShield = this.shield;
                this.inventory.add(actualShield);
                this.shield = shield;
                this.inventory.remove(shield);
                return;
            }
            this.shield = shield;
            this.inventory.remove(shield);
        }
    }

    public void addGold(int gold) {
        if (gold >= 0) {
            this.gold += gold;
        }
    }

    public void removeGold(int gold) {
        if (gold >= 0) {
            if (this.gold - gold <= 0) {
                this.gold = 0;
            } else {
                this.gold -= gold;
            }
        }
    }

    //Getter
    public boolean isSpecialKey() {
        return specialKey;
    }

    public int getExperience() {
        return experience;
    }

    public int getMaxLifePoint() {
        return maxLifePoint;
    }

    public int getActualLifePoint() {
        return actualLifePoint;
    }

    public int getLevel() {
        return level;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Shield getShield() {
        return shield;
    }

    public int getGold() {
        return gold;
    }

    public ArrayList<Spells> getSpellsList() {
        return spellsList;
    }

    public ArrayList<ItemArchetype> getInventory() {
        return inventory;
    }


    @Override
    public String toString() {
        return "Nivel: " + getLevel() + ". Dinero: " + getGold() + " Puntos de vida: " + getActualLifePoint() + "/" + getMaxLifePoint();
    }
}