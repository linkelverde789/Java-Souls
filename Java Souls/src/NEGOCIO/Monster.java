package NEGOCIO;

public class Monster {
    private int gold;
    private int damage;
    private int defense;
    private int experience;
    private int ActualLifePoint;
    private int level;
    private String name;

    public Monster(int damage, int defense, int lifePoints, int level, String name, int gold) {
        this.gold = gold;
        this.damage = damage;
        this.defense = defense;
        this.experience = level*20;
        this.ActualLifePoint = lifePoints;
        this.level = level;
        this.name = name;
    }

    public int getGold() {
        return gold;
    }

    public int getDamage() {
        return damage / 10;
    }

    public int getDefense() {
        return defense / 10;
    }

    public int getExperience() {
        return experience;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public int getActualLifePoint() {
        return ActualLifePoint;
    }

    public void modifyActualLifePoints(int damage) {
        ActualLifePoint -= damage;
    }
}
