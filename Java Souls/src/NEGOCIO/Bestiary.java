package NEGOCIO;

import java.util.ArrayList;
import java.util.Random;

public class Bestiary {
    Random random = new Random();
    private ArrayList<Monster> bestiary;

    public Bestiary() {
        bestiary = new ArrayList<>();
        generateMonsters();
    }

    public void addBestiaryEntry(Monster monster) {
        bestiary.add(monster);
    }

    public void generateMonsters() {
        // no están ajustados, me da pereza
        this.addBestiaryEntry(new Monster(14, 5, 20, 2, "Velociprey", 90));
        this.addBestiaryEntry(new Monster(5, 7, 15, 1, "Oso", 40));
        this.addBestiaryEntry(new Monster(32, 10, 40, 4, "Grifo", 60));
        this.addBestiaryEntry(new Monster(31, 5, 30, 4, "Bruja", 200));
        this.addBestiaryEntry(new Monster(25, 10, 20, 3, "Fantasma", 150));
        this.addBestiaryEntry(new Monster(62, 60, 350, 7, "Dragon", 1000));
        this.addBestiaryEntry(new Monster(30, 10, 150, 4, "Espectro de las Sombras", 80));
        this.addBestiaryEntry(new Monster(70, 40, 250, 6, "Gólem de Lava", 150));
        this.addBestiaryEntry(new Monster(40, 15, 180, 4, "Banshee Lamentosa", 90));
        this.addBestiaryEntry(new Monster(60, 25, 220, 5, "Hidra Venenosa", 120));
        this.addBestiaryEntry(new Monster(35, 30, 200, 5, "Gnomo Mecánico", 100));
        this.addBestiaryEntry(new Monster(80, 50, 300, 7, "Quimera Infernal", 200));
        this.addBestiaryEntry(new Monster(90, 60, 350, 8, "Kraken Abisal", 250));
        this.addBestiaryEntry(new Monster(65, 35, 270, 6, "Yeti de las Montañas", 150));
        this.addBestiaryEntry(new Monster(45, 25, 230, 6, "Nigromante Arcano", 130));
        // Nivel 1
        this.addBestiaryEntry(new Monster(8, 2, 15, 1, "Duende", 50));
        this.addBestiaryEntry(new Monster(6, 3, 12, 1, "Limo", 40));

// Nivel 2
        this.addBestiaryEntry(new Monster(5, 3, 18, 2, "Guerrero Esquelético", 60));
        this.addBestiaryEntry(new Monster(14, 4, 20, 2, "Araña Gigante", 55));

// Nivel 3
        this.addBestiaryEntry(new Monster(16, 4, 25, 3, "Orco Berserker", 70));
        this.addBestiaryEntry(new Monster(24, 5, 22, 3, "Espectro", 65));

// Nivel 4
        this.addBestiaryEntry(new Monster(30, 6, 30, 4, "Quimera", 80));
        this.addBestiaryEntry(new Monster(25, 7, 28, 4, "Basilisco", 75));

// Nivel 5
        this.addBestiaryEntry(new Monster(32, 8, 35, 5, "Behemoth", 90));
        this.addBestiaryEntry(new Monster(46, 9, 32, 5, "Viverna", 85));

// Nivel 6
        this.addBestiaryEntry(new Monster(46, 10, 40, 6, "Dragón", 100));
        this.addBestiaryEntry(new Monster(51, 11, 38, 6, "Gigante", 95));

// Nivel 7
        this.addBestiaryEntry(new Monster(61, 12, 45, 7, "Liche", 110));
        this.addBestiaryEntry(new Monster(53, 13, 42, 7, "Hidra", 105));

// Nivel 8
        this.addBestiaryEntry(new Monster(75, 14, 50, 8, "Señor Demonio", 120));
        this.addBestiaryEntry(new Monster(60, 15, 48, 8, "Fénix", 115));

// Nivel 9
        this.addBestiaryEntry(new Monster(82, 16, 55, 9, "Kraken", 130));
        this.addBestiaryEntry(new Monster(72, 17, 52, 9, "Golem", 125));

// Nivel 10
        this.addBestiaryEntry(new Monster(96, 20, 60, 10, "Dragón Anciano", 150));
        this.addBestiaryEntry(new Monster(85, 18, 58, 10, "Titán", 140));
    }

    public Monster randomMonster(int playerLevel) {
        ArrayList<Monster> posibleMonster = new ArrayList<>();
        for (Monster item : bestiary) {
            if (item.getLevel() <= playerLevel / 2 + 1) {
                posibleMonster.add(item);
            }
        }
        return posibleMonster.get(random.nextInt(0, posibleMonster.size()));
    }
}