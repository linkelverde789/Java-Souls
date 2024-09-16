package NEGOCIO;

public class Shield extends ItemArchetype {
    public Shield(String name, String description, int cost, int actionPoints) {
        super(name, description, cost, actionPoints);
    }

    @Override
    public String toString() {
        return getName() +
                ". Precio: " + getCost() +
                ". Defensa: " + getActionPoints();
    }
}
