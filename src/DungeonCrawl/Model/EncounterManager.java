package DungeonCrawl.Model;

import DungeonCrawl.GUI.GUIUtilities;
import DungeonCrawl.HeroPowers.HeroPower;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class EncounterManager {

    private boolean encounterOnline;
    private HeroManager heroManager;
    private Button[][] buttonGrid;
    private PathFinder pathFinder;
    private GUIUtilities guiUtilities = new GUIUtilities();
    private DungeonMap dungeonMap = new DungeonMap(null);
    private List<Monster> allMonstersList = dungeonMap.getAllMonstersList();
    private List<Monster> discoveredMonsters;
    private boolean hasTheCharacterBeenSelected = false;
    private int globalInitiative = 0;

    public int getGlobalInitiative() {
        return globalInitiative;
    }

    public void setGlobalInitiative(int globalInitiative) {
        this.globalInitiative = globalInitiative;
    }

    public PathFinder getPathFinder() {
        return pathFinder;
    }

    public List<Monster> getAllMonstersList() {
        return allMonstersList;
    }

    public Button[][] getButtonGrid() {
        return buttonGrid;
    }

    public HeroManager getHeroManager() {
        return heroManager;
    }

    public EncounterManager(HeroManager heroManager, Button[][] buttonGrid, PathFinder pathFinder) {
        this.heroManager = heroManager;
        this.buttonGrid = buttonGrid;
        this.pathFinder = pathFinder;
    }

    public boolean isHasTheCharacterBeenSelected() {
        return hasTheCharacterBeenSelected;
    }

    public void setHasTheCharacterBeenSelected(boolean hasTheCharacterBeenSelected) {
        this.hasTheCharacterBeenSelected = hasTheCharacterBeenSelected;
    }

    public DungeonMap getDungeonMap() {
        return dungeonMap;
    }

    public boolean isEncounterOnline() {
        return encounterOnline;
    }

    public void setEncounterOnline(boolean encounterOnline) {
        this.encounterOnline = encounterOnline;
    }

    public void eventOnHeroClick(int currentHeroID) {
        Hero currentHero = guiUtilities.getHeroByID(currentHeroID, heroManager.getHeroList());
        pathFinder.checkTheAvailableDistance(currentHero, dungeonMap, buttonGrid, "Available Distance");
        System.out.println(ConsoleColors.ANSI_GREEN + "Clicked the ID " + currentHeroID + " hero." + ConsoleColors.ANSI_RESET);
        heroManager.setCurrentlyActiveHeroID(currentHeroID);
        System.out.println("Currently Active Hero ID: " + currentHeroID + " || " + currentHero.getID());
        System.out.println("Current Hero Speed: " + ConsoleColors.ANSI_BLUE + currentHero.getCurrentSpeed() + ConsoleColors.ANSI_RESET);
        setHasTheCharacterBeenSelected(true);
        pathFinder.dungeonConsoleGUI.updateTheDungeonConsole("You have selected " + currentHero.getHeroName());
    }

    private void checkIfAllCreaturesInRoomAreDead() {
        this.discoveredMonsters = pathFinder.getDiscoveredMonsters();
        for (Monster monster : discoveredMonsters) {
            if (!monster.isThisCreatureDead()) {
                System.out.println("Found a creature that's alive");
                encounterOnline = true;
                return;
            }
        }
        System.out.println("All monsters are dead!");
        enableAllHeroButtons();
        List<Monster> emptyListOfMonsters = new ArrayList<>();
        pathFinder.setDiscoveredMonsters(emptyListOfMonsters);
        pathFinder.dungeonConsoleGUI.clearInitiativeTracker();
        for (Hero currentHero : heroManager.getHeroList()) {
            for (HeroPower power : currentHero.getEncounterPowers()) {
                power.setNumberOfLockedEncounters(0);
            }
            for (HeroPower power : currentHero.getDailyPowers()) {
                power.setNumberOfLockedEncounters(power.getNumberOfLockedEncounters() - 1);
            }
        }
        encounterOnline = false;
        pathFinder.setAlarmedMonsterVisible(false);
    }

    private void triggerOnHit(HeroPower attackingPower, Hero hero, Map<String, Integer> attackResults) {
        int weaponDamage;
        int numberOfDice;
        if (attackingPower.isThisWeaponDamage()) {
            try {
                weaponDamage = hero.getHeroEquipment().get("Right Hand Slot").getTypeOfDamageDice();
                numberOfDice = hero.getHeroEquipment().get("Right Hand Slot").getNumberOfDamageDiceDealt();
            } catch (NullPointerException e) {
                weaponDamage = 4;
                numberOfDice = 1;
            }
        } else {
            weaponDamage = attackingPower.getTypeOfDamageDice();
            numberOfDice = attackingPower.getDamageDiceDealt();
        }
        pathFinder.dungeonConsoleGUI.updateTheDungeonConsole("It's a hit! Roll for damage: "
                + numberOfDice
                + "d"
                + weaponDamage);
        StringBuilder diceDealt = new StringBuilder();
        int allDamage = 0;
        Random random = new Random();
        for (int i = 0; i < numberOfDice; i++) {
            int damageRoll = random.nextInt(weaponDamage);
            System.out.println("--->" + damageRoll);
            diceDealt.append(" ").append(damageRoll).append(" ");
            allDamage += damageRoll;
        }
        int bonusDamage = hero.getHeroAttributesMap().get(attackingPower.getDamageModifier().toLowerCase());
        allDamage += bonusDamage;
        pathFinder.dungeonConsoleGUI.updateTheDungeonConsole("Result of damage dice rolls: "
                + diceDealt
                + ". Bonus damage equal to your "
                + attackingPower.getDamageModifier()
                + ": "
                + attackResults.get("Attribute Bonus"));
        pathFinder.dungeonConsoleGUI.updateTheDungeonConsole("You've dealt " + allDamage + " damage");
        attackResults.put("Damage Inflicted", allDamage);
    }

    private void prepareTheAttackMessage(HeroPower attackingPower, Monster monster, Map attackResults) {
        pathFinder.dungeonConsoleGUI.updateTheDungeonConsole("You have attacked a " +
                monster.getMonsterName()
                + " with "
                + attackingPower.getPowerName()
                + " attack \n"
                + "Your current "
                + attackingPower.getAttributeUsedToHit()
                + " bonus equals to "
                + attackResults.get("Attribute Bonus")
                + "\n"
                + "The dice roll: "
                + attackResults.get("Dice Roll")
                + " plus the modifier of "
                + attackResults.get("Attribute Bonus")
                + " equals "
                + ((int) attackResults.get("Attribute Bonus")
                + (int) attackResults.get("Dice Roll"))
                + " against "
                + monster.getMonsterName()
                + "'s "
                + attackingPower.getDefenseToBeChecked()
                + " of "
                + monster.getDefensesMap().get(attackingPower.getDefenseToBeChecked().toLowerCase()));
    }

    public void endTheCurrentHeroMovement(Hero hero) {
        heroManager.setNumberOfHeroesThatFinishedMovement(heroManager.getNumberOfHeroesThatFinishedMovement() + 1);
        hero.setFinishedMovement(true);
        System.out.println(hero.heroName + " has finished moving. " + heroManager.getNumberOfHeroesThatFinishedMovement() + " heroes had already finished moving");
        if (isEncounterOnline()) {
            globalInitiative++;
            unlockTheNextCreatureInTheInitiativeOrder();
        }
        if (checkIfAllHeroesHaveMoved() && checkIfAllOfMonstersHaveMoved()) {
            restartInitiative();
        }
    }

    private void restartInitiative() {
        setGlobalInitiative(0);
        for (Hero currentHero : heroManager.getHeroList()) {
            currentHero.setCurrentSpeed(currentHero.getSpeed());
            currentHero.setFinishedMovement(false);
            System.out.println("Resetting the movement points for " + currentHero.heroName);
        }
        for (Monster currentMonster : discoveredMonsters) {
            currentMonster.setFinishedMovement(false);
        }
        unlockTheNextCreatureInTheInitiativeOrder();
    }

    private boolean checkIfAllOfMonstersHaveMoved() {
        this.discoveredMonsters = pathFinder.getDiscoveredMonsters();
        for (Monster monster : discoveredMonsters) {
            if (!monster.isFinishedMovement()) {
                return false;
            }
        }
        return true;
    }

    private boolean checkIfAllHeroesHaveMoved() {
        for (Hero hero : heroManager.getHeroList()) {
            if (!hero.isFinishedMovement()) {
                return false;
            }
        }
        return true;
    }

    public void resetAllHeroesSpeedToMax() {
        for (Hero hero : heroManager.getHeroList()) {
            hero.setCurrentSpeed(hero.getSpeed());
            hero.setFinishedMovement(false);
        }
    }

    public String eventOnHeroAttackingAMonster(int XPos, int YPos, HeroPower attackingPower) {
        Hero hero = guiUtilities.getHeroByID(heroManager.getCurrentlyActiveHeroID(), heroManager.getHeroList());
        System.out.println("Attacking a monster with unique ID: " + getDungeonMap().getMapTilesArray()[XPos][YPos].getOccupyingCreatureUniqueID());
        Monster monster = guiUtilities.getSingleMonsterByUniqueID(getDungeonMap().getMapTilesArray()[XPos][YPos].getOccupyingCreatureUniqueID(), allMonstersList);
        System.out.println("LIST OF ALL MONSTERS:");
        for (Monster currentMonster : allMonstersList) {
            System.out.println(currentMonster.getMonsterName());
            System.out.println(currentMonster.getID());
            System.out.println(currentMonster.getCurrentMonsterUniqueID());
        }
        System.out.println("ID From Tile: " + getDungeonMap().getMapTilesArray()[XPos][YPos].getOccupyingCreatureUniqueID());
        Map<String, Integer> attackResults = hero.attackAMonster(monster, attackingPower);
        prepareTheAttackMessage(attackingPower, monster, attackResults);
        if ((attackResults.get("Attribute Bonus") + attackResults.get("Dice Roll")) >
                monster.getDefensesMap().get(attackingPower.getDefenseToBeChecked().toLowerCase())) {
            triggerOnHit(attackingPower, hero, attackResults);
            if (inflictDamageToMonster(attackResults, monster)) {
                return "Dead";
            }
            return "Hit - " + attackResults.get("Damage Inflicted");
        } else {
            pathFinder.dungeonConsoleGUI.updateTheDungeonConsole("Your attack has missed.");
            return "Missed";
        }
    }

    public void setTheEncounter() {
        System.out.println(ConsoleColors.ANSI_YELLOW + "Setting the Encounter" + ConsoleColors.ANSI_RESET);
        resetAllHeroesSpeedToMax();
        unlockTheNextCreatureInTheInitiativeOrder();
    }

    public int getNextMonsterUniqueID(int currentInitiativeValue) {
        for (int i = currentInitiativeValue; i < pathFinder.dungeonConsoleGUI.getInitiativeArray().length; i++) {
            if (pathFinder.dungeonConsoleGUI.getInitiativeArray()[i] != null) {
                System.out.println("Found monster Unique ID: " + pathFinder.dungeonConsoleGUI.getInitiativeArray()[i].getCurrentMonsterUniqueID());
                return pathFinder.dungeonConsoleGUI.getInitiativeArray()[i].getCurrentMonsterUniqueID();
            }
        }
        return -1;
    }

    public int getNextCharacterID(int currentInitiativeValue) {
        for (int i = currentInitiativeValue; i < pathFinder.dungeonConsoleGUI.getInitiativeArray().length; i++) {
            if (pathFinder.dungeonConsoleGUI.getInitiativeArray()[i] != null) {
                return pathFinder.dungeonConsoleGUI.getInitiativeArray()[i].getID();
            }
        }
        return -1;
    }


    private void enterTheCurrentMonstersRound(Monster monster) {
        System.out.println(ConsoleColors.ANSI_PURPLE + "MONSTER ROUND" + ConsoleColors.ANSI_RESET);
        startTheMonsterAI(monster);
        globalInitiative = monster.getCurrentInitiative();
        globalInitiative++;
        System.out.println("GLOBAL INITIATIVE SET TO: " + globalInitiative);
        monster.setFinishedMovement(true);
        unlockTheNextCreatureInTheInitiativeOrder();
    }

    private void lockTheInactiveHeroButton(Button button) {
        button.setDisable(true);
        System.out.println("Locking a hero button.");
    }

    private void allowNextHeroToMakeTheMove(Hero hero, int heroID) {
        System.out.println("Found a creature with ID " +
                heroID +
                " hero name: " +
                hero.getHeroName() +
                "ID: " + hero.getID() +
                " Init: " +
                hero.getCurrentInitiative());
        System.out.println("Unlocking");
        buttonGrid[hero.getMapXPos()][hero.getMapYPos()].setDisable(false);
        System.out.println("THIS Creature Init: " + hero.getCurrentInitiative());
        globalInitiative = hero.getCurrentInitiative();
        System.out.println("GLOBAL INITIATIVE SET TO: " + globalInitiative);
    }

    public void unlockTheNextCreatureInTheInitiativeOrder() {
        this.discoveredMonsters = pathFinder.getDiscoveredMonsters();
        int creatureIdFromInitiativeArray = getNextCharacterID(globalInitiative);
        if (creatureIdFromInitiativeArray < 0) {
            setGlobalInitiative(0);
            unlockTheNextCreatureInTheInitiativeOrder();
            return;
        }
        System.out.println("NEXT INITIATIVE CHECK for number: " + creatureIdFromInitiativeArray);
        if (creatureIdFromInitiativeArray < 100) {
            for (Hero hero : heroManager.getHeroList()) {
                System.out.println(ConsoleColors.ANSI_GREEN + "NEXT CHAR ID: " +
                        hero.getID()
                        + " Hero name: " +
                        hero.getHeroName() + ConsoleColors.ANSI_RESET);
                if (hero.getID() == creatureIdFromInitiativeArray) {
                    System.out.println("Initiative matches that of a hero. Unlocking the button.");
                    allowNextHeroToMakeTheMove(hero, creatureIdFromInitiativeArray);
                } else {
                    lockTheInactiveHeroButton(buttonGrid[hero.getMapXPos()][hero.getMapYPos()]);
                }
            }
        } else {
            int monsterUniqueID = getNextMonsterUniqueID(globalInitiative);
            for (Monster monster : discoveredMonsters) {
                if (monster.getCurrentMonsterUniqueID() == monsterUniqueID)
                    if (monster.isThisCreatureDead()) {
                        monster.setFinishedMovement(true);
                        System.out.println("Found a dead monster in the initiative order. Proceeding.");
                        setGlobalInitiative(monster.getCurrentInitiative() + 1);
                        unlockTheNextCreatureInTheInitiativeOrder();
                        break;
                    } else {
                        System.out.println(ConsoleColors.ANSI_RED + "NEXT MONSTER ID: " +
                                creatureIdFromInitiativeArray +
                                " Monster UUID: " + monster.getCurrentMonsterUniqueID() + " || " + monsterUniqueID
                                + " Monster name: " +
                                monster.getMonsterName()
                                + " Init: " + monster.getCurrentInitiative()
                                + ConsoleColors.ANSI_RESET);
                        enterTheCurrentMonstersRound(monster);
                        break;
                    }
            }
        }
    }


    private boolean inflictDamageToMonster(Map<String, Integer> attackResults, Monster monster) {
        boolean isTheCreatureDead = false;
        int damageDealt = attackResults.get("Damage Inflicted");
        monster.setCurrentHitPoints(monster.getCurrentHitPoints() - damageDealt);
        System.out.println("DEBUG: " + monster.getHitPoints() + " HP");
        System.out.println("DEBUG: " + monster.getCurrentHitPoints() + " HP");
        System.out.println("DEBUG: " + monster.getID() + " ID");
        if (monster.getCurrentHitPoints() < 1) {
            pathFinder.dungeonConsoleGUI.updateTheDungeonConsole("The attacked monster - " + monster.getMonsterName() + " - has fallen!");
            eventOnMonsterDeath(monster);
            isTheCreatureDead = true;
        } else if (monster.getCurrentHitPoints() * 2 < monster.getHitPoints()) {
            pathFinder.dungeonConsoleGUI.updateTheDungeonConsole("The attacked monster - " + monster.getMonsterName() + " - is now bloodied.");
            isTheCreatureDead = false;
        }
        return isTheCreatureDead;
    }

    private void eventOnMonsterDeath(Monster monster) {
        monster.setThisCreatureDead(true);
        System.out.println("Image has been modified");
        checkIfAllCreaturesInRoomAreDead();
    }

    private void enableAllHeroButtons() {
        for (Hero hero : heroManager.getHeroList()) {
            buttonGrid[hero.getMapXPos()][hero.getMapYPos()].setDisable(false);
        }
    }

    public void startTheMonsterAI(Monster monster) {
        //todo set the aggression level for each hero in regards to their class and raise aggression after using some powers.
        MonsterAI monsterAI = new MonsterAI();
        int attackedHeroId = monsterAI.makeAnAggressionRoll(heroManager.getHeroList(), monster);
        Hero attackedHero = guiUtilities.getHeroByID(attackedHeroId, heroManager.getHeroList());
        System.out.println(
                ConsoleColors.ANSI_PURPLE + "Monster: " + monster.getMonsterName()
                        + " is attacking a hero: " + attackedHero.getHeroName()
                        + ConsoleColors.ANSI_RESET);
    }
}
