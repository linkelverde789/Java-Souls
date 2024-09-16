package NEGOCIO;

public class Potion extends ItemArchetype {

    public Potion(String name, String description, int cost, int actionPoints) {
        super(name, description, cost, actionPoints);
    }

    @Override
    public String toString() {
        return getName() + ". " + getDescription() + " Precio: " + getCost() + " Puntos de curación: " + getActionPoints();
    }
}
