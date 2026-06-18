# Java-Souls

Java-Souls is a text-based RPG written in Java where the player explores a mysterious world to defeat a powerful mage. The game is presented entirely in Spanish and features a classic turn-based combat system, exploration, and character progression. The player awakens in an unknown place with only a diary hinting at a cyclical struggle against an evil mage, setting them on a quest for vengeance.

## Features

*   **Text-Based Adventure:** Navigate the world and interact with it through a command-line interface. All story, dialogue, and descriptions are in Spanish.
*   **Turn-Based Combat:** Engage in strategic, dice-roll-based combat against a variety of monsters from the Bestiary.
*   **World Exploration:** Move across a grid-based world map and discover special locations like a village, a multi-level dungeon, an enchanted forest, and a treacherous mountain cave.
*   **Character Progression:** Gain experience from battles to level up, increasing your health and overall power.
*   **Loot and Inventory:** Find chests containing gold, weapons, shields, and spells. Manage your inventory and equip the best gear for your adventure.
*   **Story-Driven:** Follow a narrative that pits you against a powerful mage in a repeating cycle, culminating in a final confrontation.

## Game World

The game world is composed of several key locations, each with unique challenges and rewards.

*   **The World:** A misty, open area where random events like monster encounters or finding treasure chests can occur. It connects all other major locations.
*   **The Village:** A safe haven located to the southeast where you can buy and sell items, and rest at the inn to restore your health.
*   **The Forest:** An enchanted forest dungeon to the northeast. You must find a key within its depths to unlock the path to the final dungeon.
*   **The Mountain:** A dangerous cave system to the southwest, rumored to hold legendary items for the worthy adventurer.
*   **The Dungeon:** The final, multi-floor lair of the Master Mage, located in the northwest. You must fight your way through its treacherous halls to face the ultimate boss.

## Getting Started

### Prerequisites

*   Java Development Kit (JDK) 8 or higher must be installed on your system.

### Running from the Command Line

1.  Clone the repository to your local machine:
    ```sh
    git clone https://github.com/linkelverde789/Java-Souls.git
    ```
2.  Navigate to the source directory:
    ```sh
    cd Java-Souls/"Java Souls"/src
    ```
3.  Compile the Java files:
    ```sh
    javac main.java
    ```
4.  Run the game:
    ```sh
    java main
    ```

### Running with an IDE

1.  Clone the repository.
2.  Open the `Java-Souls/Java Souls` directory as a project in your favorite Java IDE (e.g., IntelliJ IDEA, Eclipse).
3.  Locate the `src/main.java` file and run it.

## Project Structure

The project code is organized into several key components:

*   `src/main.java`: The main entry point of the application.
*   `src/gameBuilder.java`: The core game engine that manages the game loop, combat logic, character movement, and event handling.
*   `src/USUARIO/text.java`: Handles all console input and output, presenting game text, dialogue, and menus to the player in Spanish.
*   `src/NEGOCIO/`: A package containing all the game logic and data models.
    *   **Entities:** `Player.java`, `Monster.java`, `Bestiary.java`.
    *   **World & Locations:** `PlaceArchetype.java` and its subclasses `World.java`, `Dungeon.java`, `Forest.java`, `Mountain.java`, and `Village.java`. Each location is composed of `Tile.java` objects.
    *   **Items:** `ItemArchetype.java` and its subclasses `Weapon.java`, `Shield.java`, `Potion.java`, and `Spells.java`.
    *   **Mechanics:** `Die.java` for simulating dice rolls (D20, D12, etc.) used in combat and other random events.
