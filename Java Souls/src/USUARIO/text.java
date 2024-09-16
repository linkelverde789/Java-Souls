package USUARIO;

import NEGOCIO.*;

import java.util.ArrayList;
import java.util.Scanner;

public class text {
    Scanner scanner = new Scanner(System.in);

    //Entrada y Salida de Datos
    public int scannerInt() {
        try {
            System.out.print("→ ");
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
        }
        return -1;
    }

    public String scannerString() {
        System.out.print("→ ");
        return scanner.next();
    }

    public void cleanConsole() {
        for (int i = 0; i <= 50; i++) {
            System.out.println();
        }
    }

    public void esperarEntreSecciones() {
        try {
            Thread.sleep(1500); // 1000 milisegundos = 1 segundos Por defecto pon 1500
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void wrongData() {
        System.out.println("Dato incorrecto...");
    }

    //Textos del combate
    public void startDungeon() {
        System.out.println("Has entrado en la mazmorra");
        esperarEntreSecciones();
    }

    public void sucessfullDefense() {
        System.out.println("Te has defendido del ataque.");
    }

    public void startCombatText(Monster monster) {
        System.out.println("¡Oh, no! Te enfrentas a un " + monster.getName());
    }

    public int showEarnedGold(int gold) {
        System.out.println("Has ganado: " + gold + " monedas.");
        return gold;
    }

    public void menuCombatText(Player player) {
        System.out.println();
        System.out.println("Tu vida: " + player.getActualLifePoint());
        System.out.println("1)Atacar 2)Defender 3)Usar hechizo 4)Usar poción");
    }

    public void monsterTurn(Monster monster) {
        System.out.println("Le toca al " + monster.getName());
    }

    public void monsterAttack() {
        System.out.println("¡Te va a atacar!");
        System.out.println();
    }

    public void monsterWait(Monster monster) {
        System.out.println("El " + monster.getName() + " te está mirando.");
        System.out.println();
    }

    public void playerWin() {
        System.out.println("¡Has ganado!");
    }

    public void playerDeath() {
        System.out.println("Has muerto...");
        esperarEntreSecciones();
    }

    public void endProgram() {
        System.exit(0);
    }


    public int showDamage(int damage) {
        if (damage == 0) {
            showFail();
        } else {
            System.out.println("Daño: " + damage);
        }
        return damage;
    }

    public void showFail() {
        System.out.println("El ataque falló...");
    }

    public void playerLevelUp(Player player) {
        System.out.println();
        System.out.println("¡Has subido de nivel!");
        System.out.println("Nivel: " + player.getLevel());
        System.out.println("Vida máxima: " + player.getMaxLifePoint());
    }

    public void showInventoryPotion(Player player) {
        int i = 1;
        for (ItemArchetype item : player.getInventory()) {
            if (item instanceof Potion) {
                System.out.println(i + ". " + item.getName() + ": " + item.getDescription());
                i++;
            }
        }
        System.out.println("0. Salir.");
    }

    //Textos del pueblo
    public void welcomeVillage() {
        System.out.println("¡Bienvenido a la villa!");
    }

    public int startVillage() {
        System.out.println();
        System.out.println("1)Comprar. 2)Vender.");
        System.out.println("3)Descansar en la posada. 4)Salir.");
        return scannerInt();
    }

    public void showVillageInventory(ArrayList<ItemArchetype> village) {
        int i = 1;
        System.out.println("¿Qué quieres comprar?");
        for (ItemArchetype item : village) {
            System.out.println(i + ". " + item);
            i++;
        }
        System.out.println("0. Salir");
    }

    public void showPriceHostel(Player player) {
        System.out.println("Una habitación cuesta 150 monedas.");
        System.out.println("¿Quieres descansar?");
        System.out.println("Tu dinero: " + player.getGold() + " monedas.");
        System.out.println("1)Sí.   2)No.");
    }

    public void notEnoughGold() {
        System.out.println("No tienes suficiente dinero.");
    }

    public void villageHostel() {
        System.out.println("Te has ido a dormir.");
        esperarEntreSecciones();
        System.out.println("Has recuperado todos tus puntos de vida.");
        esperarEntreSecciones();
    }

    public void farewellVillage() {
        System.out.println("Te has ido del pueblo.");
    }

    public void showSoldItem(ItemArchetype item) {
        System.out.println("Has vendido: " + item.getName());
        System.out.println();
    }

    public void showBoughItem(ItemArchetype item) {
        System.out.println("Has comprado: " + item.getName());
        System.out.println();
    }

    //Movimientos por el mundo
    public void worldBorder(int limitX, int limitY) {
        if (limitX == 1) {
            System.out.print("Estás en el borde Este");
        } else if (limitX == -1) {
            System.out.print("Estás en el borde Oeste");
        }
        if (limitX != 0 && limitY != 0) {
            System.out.print(", ");
        }
        if (limitY == 1) {
            System.out.print("Estás en el borde Norte");
        } else if (limitY == -1) {
            System.out.print("Estás en el borde Sur");
        }
    }

    public int worldMovement() {
        System.out.println();
        System.out.println("1)Norte 2)Sur");
        System.out.println("3)Este  4)Oeste");
        System.out.println("5)Estadísticas");
        return scannerInt();
    }

    public void playerMovement(int movement) {
        System.out.print("Has avanzado hacia el ");
        if (movement == 1) {
            System.out.println("Norte.");
        } else if (movement == 2) {
            System.out.println("Sur.");
        } else if (movement == 3) {
            System.out.println("Este.");
        } else if (movement == 4) {
            System.out.println("Oeste.");
        }
    }

    //Movimiento por la mazmorra
    public int DungeonMovement() {
        System.out.println();
        System.out.println("1)Norte 2)Sur");
        System.out.println("3)Este  4)Oeste");
        System.out.println("5)Estadísticas");
        System.out.println("6)Huir");
        return scannerInt();
    }

    public void tileDescription(Tile tile) {
        System.out.println(tile.getDecription());
    }

    public void cantMove(int position) {
        if (position == 1) {
            System.out.println("No puedes avanzar hacia el Norte.");
        } else if (position == 2) {
            System.out.println("No puedes avanzar hacia el Sur.");
        } else if (position == 3) {
            System.out.println("No puedes avanzar hacia el Este.");
        } else {
            System.out.println("No puedes avanzar hacia el Oeste.");
        }
    }

    public void runAway() {
        System.out.println("Has huido...");
    }

    //Interacciones con Objetos
    public void nothing() {
        System.out.println("El cofre está vacío...");
        esperarEntreSecciones();
    }

    public ItemArchetype showItem(ItemArchetype item) {
        System.out.println("Has obtenido: " + item);
        esperarEntreSecciones();
        return item;
    }

    public void addItemToInventory() {
        System.out.println("¿Quieres quedarte con el objeto?");
        System.out.println("1)Sí   2)No");
    }

    public void addedItemToInventory() {
        System.out.println("Objeto añadido");
        esperarEntreSecciones();
        cleanConsole();
    }

    public void maxInventorySpace() {
        System.out.println("No tienes espacio en el inventario.");
        esperarEntreSecciones();
        cleanConsole();
    }

    public void leaveItem() {
        System.out.println("Has dejado el objeto.");
        esperarEntreSecciones();
        cleanConsole();
    }

    public void isSpecialKey(boolean specialKey) {
        if (specialKey) {
            System.out.println("Has abierto la puerta de la mazmorra.");
            esperarEntreSecciones();
        } else {
            System.out.println("No puedes abrir la puerta de la mazmorra. Debes encontrar la llave");
            esperarEntreSecciones();
        }
        esperarEntreSecciones();
    }

    public void chestOpening() {
        System.out.println("¡Has encontrado un cofre!");
        esperarEntreSecciones();
    }

    //Jugador
    public void cantUseSpell() {
        System.out.println("No puedes usar este objeto aquí");
    }

    public int showInventory(Player player) {
        int i = 1;
        for (ItemArchetype item : player.getInventory()) {
            System.out.println(i + ". " + item);
            i++;
        }
        System.out.println("0. Salir.");
        return scannerInt();
    }

    public void showEquipment(Player player) {
        if (player.getWeapon() != null) {
            System.out.println("Arma: " + player.getWeapon());
        } else {
            System.out.println("No tienes un arma equipada...");
        }
        if (player.getShield() != null) {
            System.out.println("Escudo: " + player.getShield());
        } else {
            System.out.println("No tienes un escudo equipado...");
        }
    }

    public void showPlayerStats(Player player) {
        System.out.println(player);
        System.out.println("1)Ver inventario");
        System.out.println("2)Ver equipo");
        System.out.println("3)Ver hechizos");
        System.out.println("0)Salir");
    }

    public void showSpellList(Player player) {
        int i = 1;
        for (ItemArchetype item : player.getSpellsList()) {
            System.out.println(i + ". " + item);
            i++;
        }
        System.out.println("0. Salir.");
    }

    public int askEquip(ItemArchetype item) {
        if (item instanceof Shield || item instanceof Weapon) {
            System.out.println("¿Quieres equiparte con: " + item.getName() + "?");
        } else if (item instanceof Spells) {
            System.out.println("¿Quieres aprender: " + item.getName() + "?");
        } else if (item instanceof Potion) {
            System.out.println("¿Quieres usar: " + item.getName() + "?");
        }
        System.out.println("1)Sí   2)No");
        return scannerInt();
    }

    public int askHeal() {
        System.out.println("1)Sí   2)No");
        return scannerInt();
    }

    public int askThrowAway() {
        System.out.println("¿Quieres tirarlo?");
        System.out.println("1)Sí   2)No");
        return scannerInt();
    }

    public void maxLimitSpells(boolean spellLearned) {
        if (spellLearned) {
            System.out.println("Hechizo aprendido.");
        } else {
            System.out.println("Límite de hechizos aprendidos.");
        }
    }

    public void showKey() {
        System.out.println("Has obtenido una llave.");
        esperarEntreSecciones();
    }

    public void showDungeonKey() {
        System.out.println("Has obtenido la llave de la Mazmorra del Mago.");
        esperarEntreSecciones();
    }

    public void showCantOpenDoor() {
        System.out.println("No puedes abrir la puerta, te hace falta la llave.");
        esperarEntreSecciones();
    }

    public void forestEnd() {
        System.out.println("El bosque a tu alrededor comienza a desaparecer...");
        esperarEntreSecciones();
        cleanConsole();
        System.out.println("Te encuentras en el exterior");
        esperarEntreSecciones();
    }

    public void noneEvent() {
        System.out.println("No hay nada a tu alrededor.");
    }

    public void sellItem() {
        System.out.println("¿Qué quieres vender?");
    }

    public void whatToDo() {
        System.out.println("¿Con qué vas a interactuar?");
    }

    public void showHeal() {
        System.out.println("Has recuperado puntos de vida.");
    }

    public void forestWelcome() {
        System.out.println("Has entrado en el bosque.");
        esperarEntreSecciones();
        System.out.println("Avanzas poco a poco, pero sientes que te estás perdiendo...");
        esperarEntreSecciones();
        cleanConsole();
        System.out.println("No sabes cómo has entrado, pero estás dentro de una mazmorra.");
        esperarEntreSecciones();
        System.out.println("Te rodean paredes llenas de musgo y plantas.");
        esperarEntreSecciones();
    }

    public void noForest() {
        System.out.println("Te has acercado donde antes estaba el bosque.");
        esperarEntreSecciones();
        System.out.println("Te encuentras mareado....");
        esperarEntreSecciones();
        cleanConsole();
        System.out.println("Al abrir los ojos, te encuentras en otro sitio...");
        esperarEntreSecciones();
    }

    public void emptySpellList() {
        System.out.println("No conoces ningún hechizo...");
    }

    public void startMountain() {
        System.out.println("Has entrado en la cueva de la montaña");
        esperarEntreSecciones();
        cleanConsole();
    }

    public void mageDeathDialog() {
        String reset = "\u001B[0m";
        String rojo = "\u001B[31m";
        String verde = "\u001B[32m";
        String amarillo = "\u001B[33m";
        String azul = "\u001B[34m";
        String morado = "\u001B[35m";
        String cyan = "\u001B[36m";
        String blanco = "\u001B[37m";


        System.out.println("Mago: " + rojo + "Te dije que era fútil luchar contra mí.");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Vuelve al lugar del que viniste.");
        System.out.println(reset);
        playerDeath();
        endProgram();
    }

    public void mageWinDialog() {
        String azul = "\u001B[34m";
        String reset = "\u001B[0m";
        String rojo = "\u001B[31m";
        System.out.println("Mago: " + rojo + "¿Qué?");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("¿Cómo? ¿Cómo me has vencido?" + reset);
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("El mago está sangrando profundamente.");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Mago: " + rojo + "En el fondo da igual.");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Todo da igual, realmente.");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Esto ya ha pasado. ¿El diario del principio? Mío.");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Yo soy tú. Tú eres yo.");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Ahora te toca a ti gobernar este reino.");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println(reset + "Ves al mago caer al suelo, sin vida.");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Empiezas a marearte. Todo ha pasado muy rápido...");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Caes al suelo, rendido por tu aventura.");
        esperarEntreSecciones();
        esperarEntreSecciones();
        cleanConsole();
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Te despiertas en otro sitio. Un sitio que te es familiar.");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Escuchas una voz: ");
        esperarEntreSecciones();
        System.out.println(azul + "... el examen consiste en crear una clase, con sus métodos y las excepciones.");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println(reset + "Santiago: " + azul + "Tengo copias con una letra mayor por si tienen problemas para leerla." + reset);
        esperarEntreSecciones();
        esperarEntreSecciones();
        esperarEntreSecciones();
        esperarEntreSecciones();
        cleanConsole();
        System.out.println("¡Gracias por jugar!");
        endProgram();
    }

    public void mageDialog() {
        String reset = "\u001B[0m";
        String rojo = "\u001B[31m";
        System.out.println("Mago: " + rojo + "¡Idiota!");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Te has atrevido a llegar hasta aquí, ¿para qué?");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Nunca podrás vencerme.");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Ni ahora, ni todas las veces que lo has intentado.");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Seguirás a mi merced hasta el final de los tiempos.");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Prepárate a morir...");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("¡PARA SIEMPRE!");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println(reset);
    }

    public void start() {
        String amarillo = "\u001B[33m";
        String reset = "\u001B[0m";
        System.out.println("Te despiertas en una habitación. No sabes donde estás...");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("A tus pies tienes un diario amarillento. Decides leerlo: ");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println(amarillo + "Hola. No sé si alguien leerá este diario, pero espero que sirva de algo.");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Si lees esto es que has sido atrapado por el Mago, como todos los que hemos estado aquí.");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Por favor. Mátalo. Yo ya estaré muerto, y el anterior a mí, y el anterior...");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Necesitamos vengarnos. Te lo suplico.");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Bueno, de nada servirá suplicar. He recolectado un poco de información de este lugar.");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Hay una niebla que recubre todo el lugar. No podrás ver más allá de un palmo. Además, las cosas cambian continuamente.");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Pero hay ciertos lugares que se mantienen, parece ser. Solo he podido comprobar el pueblo, que se encuentra al Sureste.");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Los Otros han afirmado que existe una cueva con un arma sagrada al Suroeste.");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("También afirman que hay un bosque al Noreste. Se supone que hay algo para abrir una puerta...");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Si te fijas, todos los lugares están en las diagonales, así que el Mago deberá encontrarse en el Noroeste.");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Ahora saldré a buscarlo, y volveré para apuntar la ruta.");
        System.out.println(reset);
        esperarEntreSecciones();
        System.out.println("El diario acaba ahí...");
        esperarEntreSecciones();
        esperarEntreSecciones();
        System.out.println("Decides salir del lugar. A tu alrededor no hay nada, ni la casa donde estabas...");

    }
}