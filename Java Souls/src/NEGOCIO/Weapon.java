package NEGOCIO;

public class Weapon extends ItemArchetype{

    public Weapon(String name, String description, int cost, int actionPoints) {
        super(name, description, cost, actionPoints);
    }


    @Override
    public String toString() {
        return getName() + ". " + getDescription() + ". Precio: " + getCost() + ". Daño: "+getActionPoints();
    }
}
