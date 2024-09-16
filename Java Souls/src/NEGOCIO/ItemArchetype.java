package NEGOCIO;

public abstract class ItemArchetype {
    private String name;
    private String description;
    private int cost;
    private int actionPoints;

    public ItemArchetype(String name, String description, int cost, int actionPoints) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.actionPoints = actionPoints;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    public int getActionPoints() {
        return actionPoints;
    }
    @Override
    public String toString() {
        return name +
                ". " + description +
                ". Precio: " + cost +
                ". Poder: " + actionPoints;
    }
}