package NEGOCIO;

public class Chest {
    private int value;
    private int itemDamage;
    private int itemCost;


    public Chest() {
        this.value = new Die().getValueD100();
        this.itemDamage = new Die().getValueD100();
        this.itemCost = itemDamage/2;
    }

    public Weapon generateSword() {
        if (getValue() <= 22) {
            return new Weapon("Espada", "Espada normal", this.itemCost, this.itemDamage);
        } else if (getValue() <= 44) {
            return new Weapon("Arco", "Arco normal", this.itemCost, this.itemDamage);
        } else if (getValue() <= 66) {
            return new Weapon("Lanza", "Lanza normal", this.itemCost, this.itemDamage);
        } else if (getValue() <= 88) {
            return new Weapon("Hacha", "Hacha normal", this.itemCost, this.itemDamage);
        }
        return new Weapon("Cuchillo", "Cuchillo normal", this.itemCost, this.itemDamage);
    }

    public Shield generateShield() {
        if (getValue() <= 33) {
            return new Shield("Escudo Pequeño", null, this.itemCost, this.itemDamage);
        } else if (getValue() <= 66) {
            return new Shield("Escudo Mediano", null, this.itemCost, this.itemDamage);
        }
        return new Shield("Escudo Grande", null, this.itemCost, this.itemDamage);
    }

    public Spells generateSpell() {
        if (getValue() <= 40) {
            return new Spells("Luz curativa", "Luz que recupera puntos de vida", this.itemCost, this.itemDamage, SPELLTYPE.HEALER);
        } else if (getValue() <= 60) {
            return new Spells("Rayo de Hielo", "Daño de hielo a los enemigos", this.itemCost, this.itemDamage, SPELLTYPE.DAMAGE);
        } else if (getValue() <= 80) {
            return new Spells("Bola de fuego", "Daño de fuego a los enemigos", this.itemCost, this.itemDamage, SPELLTYPE.DAMAGE);
        }
        return new Spells("Ola de ácido", "Daño de ácido a los enemigos", this.itemCost, this.itemDamage, SPELLTYPE.DAMAGE);
    }

    public int generateGold() {
        return new Die().getValueD500();
    }

    public int getValue() {
        return value;
    }
}