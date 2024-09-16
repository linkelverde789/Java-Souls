package NEGOCIO;

public class Spells extends ItemArchetype {
    private SPELLTYPE spellType;

    public Spells(String name, String description, int cost, int actionPoints, SPELLTYPE spellType) {
        super(name, description, cost, actionPoints);
        this.spellType = spellType;
    }

    public SPELLTYPE getSpellType() {
        return spellType;
    }

    @Override
    public String toString() {
        if (this.spellType == SPELLTYPE.DAMAGE) {
            return super.toString() + ", Hechizo de daño.";
        }
        return super.toString() + ", Hechizo de curación.";
    }
}
