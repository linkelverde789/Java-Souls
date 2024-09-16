import NEGOCIO.*;
import USUARIO.text;

import javax.security.auth.login.AccountLockedException;

public class gameBuilder {
    USUARIO.text text = new text();

    public void startGame() {
        text.start();
        Player player = new Player();
        Weapon weapon = new Weapon("pepe", "pepe", 10, 99999);
        player.addItemToInventory(weapon);
        player.equipWeapon(weapon);
        movementGameBase(new World(), new Dungeon(), new Forest(), player, new Mountain());
    }

    //aqui van los métodos de aquellas clases que necesiten texto. Hay que ordenar
    //Combate
    public void startCombat(Player player, Monster monster) {
        text.startCombatText(monster);
        text.esperarEntreSecciones();
        int playerOptions;
        int playerItem;
        do {
            do {
                text.menuCombatText(player);
                playerItem = 1;
                playerOptions = text.scannerInt();
                text.esperarEntreSecciones();
                if (playerOptions == 1) {
                    monster.modifyActualLifePoints(playerAttack(monster, player));
                    text.esperarEntreSecciones();
                } else if (playerOptions == 3) {
                    if (!player.getSpellsList().isEmpty()) {
                        playerItem = text.scannerInt();
                        if (playerItem > 0 && playerItem < 6) {
                            if (player.getSpellsList().size() >= playerItem) {
                                if (player.getSpellsList().get(playerItem - 1).getSpellType() == SPELLTYPE.HEALER) {
                                    player.updateLifePoint(player.useSpell(playerItem), false);
                                    text.esperarEntreSecciones();
                                } else {
                                    monster.modifyActualLifePoints(text.showDamage(player.useSpell(playerItem)));
                                    text.esperarEntreSecciones();
                                }
                            } else {
                                text.wrongData();
                                playerItem = 0;
                            }
                        } else if (playerItem != 0) {
                            text.wrongData();
                            playerItem = 0;
                        }
                    } else {
                        text.emptySpellList();
                        playerItem = 0;
                        text.esperarEntreSecciones();
                        text.cleanConsole();
                    }
                } else if (playerOptions == 4) {
                    text.showInventoryPotion(player);
                    playerItem = text.scannerInt();
                    if (playerItem > 0 && playerItem < 11) {
                        if (player.usePotionInCombat(playerItem)) {
                            text.wrongData();
                            playerItem = 0;
                        }
                    }
                }
            } while (playerOptions < 1 || playerOptions > 4 || playerItem == 0);
            text.cleanConsole();
            if (monster.getActualLifePoint() > 0) {
                text.monsterTurn(monster);
                text.esperarEntreSecciones();
                if (new Die().getValueD100() <= 60) {
                    text.monsterAttack();
                    text.esperarEntreSecciones();
                    if (playerOptions == 2) {
                        player.updateLifePoint(text.showDamage(playerDefense(monsterAttack(player, monster), player)), true);
                    } else {
                        player.updateLifePoint(text.showDamage(monsterAttack(player, monster)), true);
                    }
                    text.esperarEntreSecciones();
                } else {
                    text.monsterWait(monster);
                    text.esperarEntreSecciones();
                }
            }
            text.cleanConsole();
        } while (player.getActualLifePoint() > 0 && monster.getActualLifePoint() > 0);

        if (finalCombat(monster)) {
            if (player.getActualLifePoint() <= 0) {
                text.mageDeathDialog();
            } else {
                text.playerWin();
                text.mageWinDialog();
            }
        } else {
            if (player.getActualLifePoint() > 0) {
                text.playerWin();
                player.addGold(text.showEarnedGold(monster.getGold()));
                player.addExperiencePoints(monster);
                while (player.levelUp()) {
                    text.playerLevelUp(player);
                }
            } else {
                text.playerDeath();
                text.endProgram();
            }
        }
        text.esperarEntreSecciones();
        text.cleanConsole();
    }

    public boolean finalCombat(Monster monster) {
        return monster.getName().equalsIgnoreCase("mago maestro");
    }

    public int monsterAttack(Player player, Monster monster) {
        Die playerDie = new Die();
        Die monsterDie = new Die();
        int playerDamage = 0;
        if (playerDie.getValueD20() == 20 || monsterDie.getValueD20() == 0) {
            playerDamage += 0; //equisdé
        } else if (playerDie.getValueD20() == 0 || monsterDie.getValueD20() == 20) {
            playerDamage = (int) (monsterDie.getValueD12() * 1.5 + monster.getDamage());
        } else if (playerDie.getValueD20() + player.getDamage() >= monsterDie.getValueD20()) {
            playerDamage = monsterDie.getValueD12() / 2 + monster.getDamage();
        } else if (playerDie.getValueD20() + player.getDamage() < monsterDie.getValueD20()) {
            playerDamage = monsterDie.getValueD12() + monster.getDamage();
        }
        return playerDamage;
    }

    public int playerAttack(Monster target, Player player) {
        /*Se lanza un D20 para ver si consigues un crítico, un fracaso o si atacas al 100% o 50%.
        Luego, atacas con un D12 más la décima parte del daño de tu arma. Se le resta la décima parte de la defensa del monstruo */

        Die playerDie = new Die();
        Die monsterDie = new Die();

        int damage = 0;
        if (playerDie.getValueD20() == 20 || monsterDie.getValueD20() == 0) {
            damage += playerDie.getValueD12() * 2 + player.getDamage();
        } else if (playerDie.getValueD20() == 0 || monsterDie.getValueD20() == 20) {
            damage += 0;
        } else if (playerDie.getValueD20() + player.getDamage() >= monsterDie.getValueD20()) {
            damage += playerDie.getValueD12() + player.getDamage() - target.getDefense();
        } else if (playerDie.getValueD20() + player.getDamage() < monsterDie.getValueD20()) {
            damage += playerDie.getValueD12() / 2 + player.getDamage() - target.getDefense();
        }
        return text.showDamage(Math.max(damage, 0));
    }

    public int playerDefense(int MonsterAttack, Player player) {
        /*Cuando el jugador elige Defensa se lanzan los dados. Si es un crítico defiendes completamente
         * Si es una pifia recibes el daño
         * Si ganas recibes un 25%
         * Si pierdes recibes un 50% */
        int damage = 0;
        Die playerDie = new Die();
        Die monsterDie = new Die();

        if (playerDie.getValueD20() == 20 || monsterDie.getValueD20() == 0) {
            damage += 0;
        } else if (playerDie.getValueD20() == 0 || monsterDie.getValueD20() == 20) {
            damage += MonsterAttack;
        } else if (playerDie.getValueD20() + player.getDefense() >= monsterDie.getValueD20()) {
            damage += MonsterAttack / 4 - player.getDefense();
        } else if (playerDie.getValueD20() + player.getDamage() < monsterDie.getValueD20()) {
            damage += MonsterAttack / 2 - player.getDefense();
        }
        if (damage <= 0) {
            text.sucessfullDefense();
        }
        return Math.max(damage, 0);
    }


    //Mazmorras
    public void moveInsideDungeon(Player player, Dungeon dungeon) {
        int userMovement;
        Tile actualTile = dungeon.getFloorList().get(0).getTileList().get(0);
        do {
            actualTile = removeSpecialTile(actualTile, player, dungeon);
            text.tileDescription(actualTile);
            text.esperarEntreSecciones();
            userMovement = text.DungeonMovement();
            if (userMovement != 6) {
                if (userMovement == 5) {
                    playerMenu(player);
                } else {
                    dungeon.updateTilePosition(moveInsidePlace(actualTile, userMovement));
                    for (Tile item : dungeon.getFloorList().get(dungeon.getLevel()).getTileList()) {
                        if (item.getValue() == dungeon.getTilePosition()) {
                            actualTile = item;
                            break;
                        }
                    }
                }

            } else {
                text.runAway();
            }
        } while (userMovement != 6);
        dungeon.exitDungeon();
        text.cleanConsole();
    }

    public void moveInsideForest(Forest forest, Player player) {
        int userMovement;
        Tile actualTile = forest.getFloorList().get(0).getTileList().get(0);
        do {
            removeSpecialTile(actualTile, player, forest);
            text.tileDescription(actualTile);
            userMovement = text.DungeonMovement();
            if (userMovement != 5) {
                forest.updateTilePosition(moveInsidePlace(actualTile, userMovement));
                for (Tile item : forest.getFloorList().get(0).getTileList()) {
                    if (item.getValue() == forest.getTilePosition()) {
                        actualTile = item;
                        break;
                    }
                }
                if (actualTile.getValue() == 10) {
                    if (!forest.checkMainForestDungeon()) {
                        actualTile = forest.getFloorList().get(0).getTileList().get(6);
                        text.showCantOpenDoor();
                    } else {
                        text.showDungeonKey();
                        player.findSpecialKey();
                        text.forestEnd();
                        player.exitForest();
                        return;
                    }
                }
            } else {
                text.runAway();
            }
        } while (userMovement != 5);
        player.exitForest();
    }

    public void moveInsideMountain(Mountain mountain, Player player) {
        int userMovement;
        Tile actualTile = mountain.getFloorList().get(0).getTileList().get(0);
        do {
            removeSpecialTile(actualTile, player, mountain);
            text.tileDescription(actualTile);
            userMovement = text.DungeonMovement();
            if (userMovement != 5) {
                mountain.updateTilePosition(moveInsidePlace(actualTile, userMovement));
                for (Tile item : mountain.getFloorList().get(0).getTileList()) {
                    if (item.getValue() == mountain.getTilePosition()) {
                        actualTile = item;
                        break;
                    }
                }
            } else {
                text.runAway();

            }
        } while (userMovement != 5);
        player.exitMountain();
    }

    public Tile removeSpecialTile(Tile actualTile, Player player, PlaceArchetype place) {
        text.cleanConsole();
        if (actualTile.getSpecial() != SPECIAL.NONE) {
            if (actualTile.getSpecial() == SPECIAL.CHEST) {
                text.chestOpening();
                generateRandomItem(new Chest(), player);
            } else if (actualTile.getSpecial() == SPECIAL.BATTLE) {
                startCombat(player, new Bestiary().randomMonster(player.getLevel()));
            }

            if (place instanceof Dungeon dungeon) {
                if (actualTile.getSpecial() == SPECIAL.STAIRS) {
                    dungeon.goDownStairs();
                    text.tileDescription(actualTile);
                    text.esperarEntreSecciones();
                    actualTile = dungeon.getFloorList().get(dungeon.getLevel()).getTileList().get(0);
                } else if (actualTile.getSpecial() == SPECIAL.FINAL) {
                    text.mageDialog();
                    startCombat(player, new Monster(70, 70, 500, 999, "Mago Maestro", 1000));
                }
            } else if (place instanceof Forest forest) {
                if (actualTile.getSpecial() == SPECIAL.KEY) {
                    text.showKey();
                    forest.findKey();
                    text.esperarEntreSecciones();
                }
            } else if (place instanceof Mountain) {
                if (actualTile.getSpecial() == SPECIAL.TROPHY) {
                    if (actualTile.getValue() == 11) {
                        encontrarEscudo(player);
                    } else if (actualTile.getValue() == 14) {
                        encontrarEspada(player);
                    }
                }
            }
            actualTile.changeEvent();
        }
        return actualTile;
    }

    public int moveInsidePlace(Tile actualTile, int playerMovement) {
        if (playerMovement >= 6 || playerMovement <= 0) {
            text.wrongData();
        } else {
            if (playerMovement == 1) {
                if (actualTile.getNorth() == 0) {
                    text.cantMove(1);
                } else {
                    return actualTile.getNorth();
                }
            } else if (playerMovement == 2) {
                if (actualTile.getSouth() == 0) {
                    text.cantMove(2);
                } else {
                    return actualTile.getSouth();
                }
            } else if (playerMovement == 3) {
                if (actualTile.getEast() == 0) {
                    text.cantMove(3);
                } else {
                    return actualTile.getEast();
                }
            } else {
                if (actualTile.getWest() == 0) {
                    text.cantMove(4);
                    text.cleanConsole();
                } else {
                    return actualTile.getWest();
                }
            }
        }
        return actualTile.getValue();
    }
    //Mundo

    public void checkPlace(Player player, Dungeon dungeon, Forest forest, Mountain mountain, Village village, World world) {
        if (village.checkVillage(player)) {
            startVillage(player, village);
        } else if (dungeon.checkDungeon(player)) {
            text.isSpecialKey(dungeon.isSpecialKey(player));
            if (dungeon.isSpecialKey(player)) {
                text.startDungeon();
                text.esperarEntreSecciones();
                text.cleanConsole();
                moveInsideDungeon(player, dungeon);
            }
        } else if (forest.checkForest(player)) {
            if (!player.isSpecialKey()) {
                text.forestWelcome();
                moveInsideForest(forest, player);
            } else {
                text.noForest();
                player.exitForest();
            }
        } else if (mountain.checkMountain(player)) {
            text.startMountain();
            moveInsideMountain(mountain, player);
        } else if (world.textYBorder(player.getyPosition()) != 0 || world.textXBorder(player.getxPosition()) != 0) {
            text.worldBorder(world.textXBorder(player.getxPosition()), world.textYBorder(player.getyPosition()));
            text.esperarEntreSecciones();
        } else {
            generateEvent(player);
        }
    }

    public void movementGameBase(World world, Dungeon dungeon, Forest forest, Player player, Mountain mountain) {
        int playerMovement;
        do { // no pasa nada si da error, nunca pasará, supongo.
            do {
                //System.out.println(player.getxPosition()+"/"+player.getyPosition());
                playerMovement = text.worldMovement();
                if (playerMovement <= 0 || playerMovement >= 6) {
                    text.wrongData();
                } else {
                    if (playerMovement == 5) {
                        playerMenu(player);
                    } else {
                        text.cleanConsole();
                        makeMovement(playerMovement, player, world);
                        text.esperarEntreSecciones();
                        checkPlace(player, dungeon, forest, mountain, new Village(), world);
                    }
                }
            } while (playerMovement <= 0 || playerMovement >= 5);
        } while (true);

    }//checkPlayerPosition

    public void generateEvent(Player player) {
        Die D100 = new Die();
        Chest chest = new Chest();
        if (D100.getValueD100() <= 40) {
            startCombat(player, new Bestiary().randomMonster(player.getLevel()));
        } else if (D100.getValueD100() <= 60) {
            text.chestOpening();
            generateRandomItem(chest, player);
        } else {
            text.noneEvent();
        }

    }

    public void makeMovement(int movement, Player player, World world) {
        player.updateMovement(movement);
        if (movement == 1) {
            if (world.checkYBorder(player.getyPosition()) == 1) {
                player.updateMovement(2);
            } else {
                text.playerMovement(movement);
            }

        } else if (movement == 2) {
            if (world.checkYBorder(player.getyPosition()) == -1) {
                player.updateMovement(1);
            } else {
                text.playerMovement(movement);
            }

        } else if (movement == 3) {
            if (world.checkXBorder(player.getxPosition()) == 1) {
                player.updateMovement(4);
            } else {
                text.playerMovement(movement);
            }

        } else if (movement == 4) {
            if (world.checkXBorder(player.getxPosition()) == -1) {
                player.updateMovement(3);
            } else {
                text.playerMovement(movement);
            }
        }
    }

    //Pueblo
    public void buyItem(Village village, Player player) {
        int villageOption;
        do {
            text.showVillageInventory(village.getInventory());
            villageOption = text.scannerInt();
            if (villageOption > 0 && villageOption <= village.getInventory().size()) {
                text.esperarEntreSecciones();
                ItemArchetype item = village.getInventory().get(villageOption - 1);
                if (player.getGold() >= item.getCost()) {
                    if (player.getInventory().size() >= 10) {
                        text.cleanConsole();
                        text.maxInventorySpace();
                    } else {
                        text.cleanConsole();
                        text.showBoughItem(item);
                        player.removeGold(item.getCost());
                        player.addItemToInventory(item);
                    }
                } else {
                    text.cleanConsole();
                    text.notEnoughGold();
                }
            } else if (villageOption < 0 || villageOption > village.getInventory().size()) {
                text.cleanConsole();
                text.wrongData();
            }
        } while (villageOption != 0);
        text.cleanConsole();
    }

    public void sellItem(Player player) {
        int villageOption;
        do {
            text.sellItem();
            text.showInventory(player);
            villageOption = text.scannerInt();
            text.cleanConsole();
            if (villageOption > 0 && villageOption <= player.getInventory().size()) {
                ItemArchetype soldItem = player.getInventory().get(villageOption - 1);
                text.cleanConsole();
                text.showSoldItem(soldItem);
                player.addGold(text.showEarnedGold(soldItem.getCost()));
                text.esperarEntreSecciones();
                player.removeItem(soldItem);
                text.cleanConsole();
            } else if (villageOption < 0 || villageOption > player.getInventory().size()) {
                text.cleanConsole();
                text.wrongData();
            }
        } while (villageOption != 0);
        text.cleanConsole();
    }

    public void rest(Player player) {
        int villageOption;
        do {
            text.showPriceHostel(player);
            villageOption = text.scannerInt();
            if (villageOption == 1) {
                text.esperarEntreSecciones();
                if (player.getGold() >= 150) {
                    text.cleanConsole();
                    text.villageHostel();
                    text.cleanConsole();
                    player.removeGold(150);
                    player.updateLifePoint(player.getMaxLifePoint(), false);
                } else {
                    text.cleanConsole();
                    text.notEnoughGold();
                }
            } else if (villageOption <= 0 || villageOption >= 3) {
                text.cleanConsole();
                text.wrongData();
            }
        } while (villageOption != 2);
        text.cleanConsole();
    }

    public void startVillage(Player player, Village village) {
        text.cleanConsole();
        text.welcomeVillage();
        int villageOption;
        do {
            villageOption = text.startVillage();
            text.cleanConsole();
            if (villageOption <= 4 && villageOption > 0) {
                if (villageOption == 1) {
                    buyItem(village, player);
                } else if (villageOption == 2) {
                    sellItem(player);
                } else if (villageOption == 3) {
                    rest(player);
                } else {
                    text.cleanConsole();
                    text.farewellVillage();
                }
            } else {
                text.cleanConsole();
                text.wrongData();
            }
        } while (villageOption != 4);
    }

    public void encontrarEspada(Player player) {
        Weapon espada = (Weapon) text.showItem(new Weapon("PepeSuor", "La espada de las leyendas", 1, 400));
        text.addItemToInventory();
        int userResponse;
        do {
            userResponse = text.scannerInt();
            if (userResponse == 1) {
                player.addItemToInventory(espada);
                text.addedItemToInventory();
            } else if (userResponse == 2) {
                throwAwayItem(espada, player);
            } else {
                text.wrongData();
            }
        } while (userResponse != 2 && userResponse != 1);
    }

    public void encontrarEscudo(Player player) {
        Shield escudo = (Shield) text.showItem(new Shield("PepeSild", "El escudo de las leyendas", 1, 400));
        text.addItemToInventory();
        int userResponse;
        do {
            userResponse = text.scannerInt();
            if (userResponse == 1) {
                player.addItemToInventory(escudo);
                text.addedItemToInventory();
            } else if (userResponse == 2) {
                throwAwayItem(escudo, player);
            } else {
                text.wrongData();
            }
        } while (userResponse != 2 && userResponse != 1);
    }

    //Cofre/Objetos
    public void generateRandomItem(Chest chest, Player player) {
        ItemArchetype item = null;
        if (chest.getValue() <= 22) {
            item = text.showItem(chest.generateSword());
        } else if (chest.getValue() <= 44) {
            item = text.showItem(chest.generateShield());
        } else if (chest.getValue() <= 66) {
            item = text.showItem(chest.generateSpell());
        } else if (chest.getValue() <= 88) {
            player.addGold(text.showEarnedGold(chest.generateGold()));
        } else {
            text.nothing();
        }
        if (item != null) {
            int playerOption;
            do {
                text.addItemToInventory();
                playerOption = text.scannerInt();
                if (playerOption == 1) {
                    if (player.getInventory().size() <= 9) {
                        player.addItemToInventory(item);
                        text.addedItemToInventory();
                    } else {
                        text.maxInventorySpace();
                    }
                } else if (playerOption == 2) {
                    text.leaveItem();
                } else {
                    text.wrongData();
                }
            } while (playerOption != 1 && playerOption != 2);
        }
    }

    //Jugador
    public void playerMenu(Player player) {
        int playerMovement;
        do {
            text.cleanConsole();
            text.showPlayerStats(player);
            playerMovement = text.scannerInt();
            if (playerMovement < 0 || playerMovement > 3) {
                text.wrongData();
            } else if (playerMovement == 1) {
                useInventoryItem(player);
            } else if (playerMovement == 2) {
                showEquipment(player);
            } else if (playerMovement == 3) {
                showInventorySpell(player);
            }
        } while (playerMovement != 0);
    }

    public void useInventoryItem(Player player) {
        int playerOption;
        do {
            text.cleanConsole();
            text.whatToDo();
            playerOption = text.showInventory(player);
            if (playerOption > 0 && playerOption <= player.getInventory().size()) {
                text.cleanConsole();
                ItemArchetype item = player.getInventory().get(playerOption - 1);
                int playerItem = text.askEquip(item);
                if (playerItem == 1) {
                    if (item instanceof Weapon) {
                        player.equipWeapon((Weapon) item);
                    } else if (item instanceof Shield) {
                        player.equipShield((Shield) item);
                    } else if (item instanceof Spells) {
                        text.maxLimitSpells(player.addSpell((Spells) item));
                    } else if (item instanceof Potion) {
                        player.usePotion((Potion) item);
                        text.showHeal();
                    }
                    text.esperarEntreSecciones();
                } else if (playerItem == 2) {
                    throwAwayItem(item, player);
                } else {
                    text.wrongData();
                }
            } else if (playerOption < 0 || playerOption > player.getInventory().size()) {
                text.cleanConsole();
                text.wrongData();
            }
        } while (playerOption != 0);
    }

    public void showEquipment(Player player) {
        text.cleanConsole();
        text.showEquipment(player);
        text.esperarEntreSecciones();
        text.esperarEntreSecciones();
        text.cleanConsole();
    }

    public void showInventorySpell(Player player) {
        text.cleanConsole();
        if (!player.getSpellsList().isEmpty()) {
            text.showSpellList(player);
            int playerOption = text.scannerInt();
            if (playerOption > 0 && playerOption <= player.getSpellsList().size()) {
                Spells item = player.getSpellsList().get(playerOption - 1);
                if (item.getSpellType() == SPELLTYPE.HEALER) {
                    int playerItem;
                    do {
                        playerItem = text.askHeal();
                        if (playerItem == 1) {
                            player.updateLifePoint(item.getActionPoints(), false);
                            player.useSpell(playerOption);
                            text.showHeal();
                        }
                    } while (playerItem != 1);
                } else {
                    text.cantUseSpell();
                }
            }
        } else {
            text.emptySpellList();
        }
        text.esperarEntreSecciones();
    }

    public void throwAwayItem(ItemArchetype item, Player player) {
        int playerOption;
        do {
            playerOption = text.askThrowAway();
            if (playerOption == 1) {
                player.removeItem(item);
                text.leaveItem();
                text.esperarEntreSecciones();
            } else if (playerOption == 2) {
                playerOption = 1;
            } else {
                text.wrongData();
            }
        } while (playerOption != 1);
    }
}