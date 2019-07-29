package DungeonCrawl.Model;

import DungeonCrawl.GUI.GUIAnimations;
import DungeonCrawl.GUI.GUIUtilities;
import DungeonCrawl.HeroPowers.HeroPower;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EncounterManager extends MapManager {

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
    private boolean isThisTheMonstersTurn;
    private boolean hasThisMonsterFinishedMoving;

    public EncounterManager() {
    }

    public EncounterManager(HeroManager heroManager, Button[][] buttonGrid, PathFinder pathFinder) {
        this.heroManager = heroManager;
        this.buttonGrid = buttonGrid;
        this.pathFinder = pathFinder;
    }

    public void setButtonGrid(Button[][] buttonGrid) {
        this.buttonGrid = buttonGrid;
    }

    List<Monster> getDiscoveredMonsters() {
        return discoveredMonsters;
    }

    public boolean isHasThisMonsterFinishedMoving() {
        return hasThisMonsterFinishedMoving;
    }

    public void setHasThisMonsterFinishedMoving(boolean hasThisMonsterFinishedMoving) {
        this.hasThisMonsterFinishedMoving = hasThisMonsterFinishedMoving;
    }

    public void setDiscoveredMonsters(List<Monster> discoveredMonsters) {
        this.discoveredMonsters = discoveredMonsters;
    }

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

    public boolean isHasTheCharacterBeenSelected() {
        return hasTheCharacterBeenSelected;
    }

    public void setHasTheCharacterBeenSelected(boolean hasTheCharacterBeenSelected) {
        this.hasTheCharacterBeenSelected = hasTheCharacterBeenSelected;
    }

    public DungeonMap getDungeonMap() {
        return dungeonMap;
    }

    public boolean isThisTheMonstersTurn() {
        return isThisTheMonstersTurn;
    }

    public void setThisTheMonstersTurn(boolean thisTheMonstersTurn) {
        isThisTheMonstersTurn = thisTheMonstersTurn;
    }

    public boolean isEncounterOnline() {
        return encounterOnline;
    }

    public void setEncounterOnline(boolean encounterOnline) {
        this.encounterOnline = encounterOnline;
    }

    public void manageHeroClicking(int currentHeroID) {
        Hero currentHero = guiUtilities.getHeroByID(currentHeroID, heroManager.getHeroList());
        if (currentHero.getSpeed() < 1) {
            endTheCurrentHeroMovement(currentHero);
        }
        pathFinder.checkTheAvailableDistance(currentHero, dungeonMap, buttonGrid, "Available Distance");
        System.out.println(ConsoleColors.ANSI_GREEN + "Clicked the ID " + currentHeroID + " hero." + ConsoleColors.ANSI_RESET);
        heroManager.setCurrentlyActiveHeroID(currentHeroID);
        System.out.println("Currently Active Hero ID: " + currentHeroID + " || " + currentHero.getID());
        System.out.println("Current Hero Speed: " + ConsoleColors.ANSI_BLUE + currentHero.getCurrentSpeed() + ConsoleColors.ANSI_RESET);
        setHasTheCharacterBeenSelected(true);
        getPathFinder().getDungeonConsoleGUI().updateTheDungeonConsole("You have selected " + currentHero.getHeroName());
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
        resetAllHeroesSpeedToMax();
        List<Monster> emptyListOfMonsters = new ArrayList<>();
        pathFinder.setDiscoveredMonsters(emptyListOfMonsters);
        getPathFinder().getDungeonConsoleGUI().clearInitiativeTracker();
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

    private void triggerOnHit(HeroPower attackingPower, Hero hero, AttackResults attackResults) {
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
        getPathFinder().getDungeonConsoleGUI().updateTheDungeonConsole("It's a hit! Roll for damage: "
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
        getPathFinder().getDungeonConsoleGUI().updateTheDungeonConsole("Result of damage dice rolls: "
                + diceDealt
                + ". Bonus damage equal to your "
                + attackingPower.getDamageModifier()
                + ": "
                + attackResults.getAttributeBonus());
        getPathFinder().getDungeonConsoleGUI().updateTheDungeonConsole("You've dealt " + allDamage + " damage");
        attackResults.setDamage(allDamage);
    }

    private void prepareTheAttackMessage(HeroPower attackingPower, Creature attackedCreature, AttackResults attackResults) {
        getPathFinder().getDungeonConsoleGUI().updateTheDungeonConsole("You have attacked a " +
                attackedCreature.getMonsterName()
                + " with "
                + attackingPower.getPowerName()
                + " attack \n"
                + "Your current "
                + attackingPower.getAttributeUsedToHit()
                + " bonus equals to "
                + attackResults.getAttributeBonus()
                + "\n"
                + "The dice roll: "
                + attackResults.getDiceRollValue()
                + " plus the modifier of "
                + attackResults.getAttributeBonus()
                + " equals "
                + (attackResults.getAttributeBonus()
                + attackResults.getDiceRollValue()
                + " against "
                + attackedCreature.getMonsterName()
                + "'s "
                + attackingPower.getDefenseToBeChecked()
                + " of "
                + attackedCreature.getDefensesMap().get(attackingPower.getDefenseToBeChecked().toLowerCase())));
    }


    public void endTheCurrentHeroMovement(Hero hero) {
        heroManager.setNumberOfHeroesThatFinishedMovement(heroManager.getNumberOfHeroesThatFinishedMovement() + 1);
        hero.setFinishedMovement(true);
        System.out.println(hero.getHeroName() + " has finished moving. " + heroManager.getNumberOfHeroesThatFinishedMovement() + " heroes had already finished moving");
        System.out.println(ConsoleColors.ANSI_PURPLE + "Encounter online = " + encounterOnline + ConsoleColors.ANSI_RESET);
        System.out.println(ConsoleColors.ANSI_RED
                + "Verifying AllHeroMoved = " + checkIfAllHeroesHaveMoved()
                + " Verifying AllMonstersMoved = " + checkIfAllOfMonstersHaveMoved()
                + ConsoleColors.ANSI_RESET);
        if (isEncounterOnline()) {
            globalInitiative++;
            unlockTheNextCreatureInTheInitiativeOrder();
        }
        if (checkIfAllHeroesHaveMoved() && checkIfAllOfMonstersHaveMoved()) {
            restartInitiative();
        }
    }

    public void endTheMonstersRound(Monster monster) {
        monster.setFinishedMovement(true);
        if (isEncounterOnline()) {
            globalInitiative = monster.getCurrentInitiative();
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
            System.out.println("Resetting the movement points for " + currentHero.getHeroName());
        }
        for (Monster currentMonster : discoveredMonsters) {
            currentMonster.setFinishedMovement(false);
        }
        unlockTheNextCreatureInTheInitiativeOrder();
    }

    private boolean checkIfAllOfMonstersHaveMoved() {
        this.discoveredMonsters = pathFinder.getDiscoveredMonsters();
        if (discoveredMonsters.size() == 0) {
            return false;
        }
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

    public String attackASingleCreature(int XPos, int YPos, HeroPower attackingPower, Creature attackedCreature) {
        Hero hero = guiUtilities.getHeroByID(heroManager.getCurrentlyActiveHeroID(), heroManager.getHeroList());
        System.out.println("Attacking a monster with unique ID: " + getDungeonMap().getMapTilesArray()[XPos][YPos].getOccupyingCreatureUniqueID());
        System.out.println("ID From Tile: " + getDungeonMap().getMapTilesArray()[XPos][YPos].getOccupyingCreatureUniqueID());
        AttackResults attackResults = hero.attackAMonster(attackedCreature, attackingPower);
        prepareTheAttackMessage(attackingPower, attackedCreature, attackResults);
        if ((attackResults.getAttributeBonus() + attackResults.getDiceRollValue()) >
                attackedCreature.getDefensesMap().get(attackingPower.getDefenseToBeChecked().toLowerCase())) {
            triggerOnHit(attackingPower, hero, attackResults);
            if (inflictDamageToCreatureAndCheckIfItsDead(attackResults, attackedCreature)) {
                return "Dead";
            /*}
            if ((attackedCreature.getCurrentHitPoints() - attackResults.getDamage() * 2) < attackedCreature.getHitPoints()) {
                return "Hit - " + attackResults.getDamage() + " - Bloodied";*/
            } else {
                return "Hit - " + attackResults.getDamage();
            }
        } else {
            getPathFinder().getDungeonConsoleGUI().updateTheDungeonConsole("Your attack has missed.");
            return "Missed";
        }
    }

    public void setTheEncounter() {
        System.out.println(ConsoleColors.ANSI_YELLOW + "Setting the Encounter" + ConsoleColors.ANSI_RESET);
        resetAllHeroesSpeedToMax();
        unlockTheNextCreatureInTheInitiativeOrder();
    }

    public int getNextMonsterUniqueID(int currentInitiativeValue) {
        for (int i = currentInitiativeValue; i < pathFinder.getDungeonConsoleGUI().getInitiativeArray().length; i++) {
            if (pathFinder.getDungeonConsoleGUI().getInitiativeArray()[i] != null) {
                System.out.println("Found monster Unique ID: " + pathFinder.getDungeonConsoleGUI().getInitiativeArray()[i].getCurrentMonsterUniqueID());
                return pathFinder.getDungeonConsoleGUI().getInitiativeArray()[i].getCurrentMonsterUniqueID();
            }
        }
        return -1;
    }

    private int getNextCharacterID(int currentInitiativeValue) {
        for (int i = currentInitiativeValue; i < pathFinder.getDungeonConsoleGUI().getInitiativeArray().length; i++) {
            if (pathFinder.getDungeonConsoleGUI().getInitiativeArray()[i] != null) {
                //System.out.println("FOUND" + i);
                return pathFinder.getDungeonConsoleGUI().getInitiativeArray()[i].getID();
            } else {
                //System.out.println("Not Found: " + i);
            }
        }
        return -1;
    }


    private void enterTheCurrentMonstersRound(Monster monster) {
        setThisTheMonstersTurn(true);
        System.out.println(ConsoleColors.ANSI_PURPLE + "MONSTER ROUND" + ConsoleColors.ANSI_RESET);
        startTheMonsterAI(monster);
        if (isHasThisMonsterFinishedMoving()) {
            setHasThisMonsterFinishedMoving(false);
            enterTheCurrentMonstersRound(monster);
        }
        globalInitiative = monster.getCurrentInitiative();
        globalInitiative++;
        System.out.println("GLOBAL INITIATIVE SET TO: " + globalInitiative);
        monster.setFinishedMovement(true);
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

    private void unlockTheNextCreatureInTheInitiativeOrder() {
        this.discoveredMonsters = pathFinder.getDiscoveredMonsters();
        int creatureIdFromInitiativeArray = getNextCharacterID(globalInitiative);
        System.out.println(creatureIdFromInitiativeArray);
        if (creatureIdFromInitiativeArray < 0) {
            setGlobalInitiative(0);
            unlockTheNextCreatureInTheInitiativeOrder();
            return;
        }
        System.out.println("NEXT INITIATIVE CHECK for number: " + creatureIdFromInitiativeArray);
        if (creatureIdFromInitiativeArray < 100) {
            initiativeTrackerHasFoundAHero(creatureIdFromInitiativeArray);
        } else {
            setThisTheMonstersTurn(true);
            GUIAnimations animations = new GUIAnimations();
            GUIUtilities utilities = new GUIUtilities();
            Monster monster = utilities.getMonsterTypeByID(creatureIdFromInitiativeArray, getAllMonstersList());
            initiativeTrackerHasFoundAMonster(creatureIdFromInitiativeArray);
        }
    }

    private void initiativeTrackerHasFoundAMonster(int creatureIdFromInitiativeArray) {
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

    private void initiativeTrackerHasFoundAHero(int creatureIdFromInitiativeArray) {
        setThisTheMonstersTurn(false);
        setThisTheMonstersTurn(false);
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
    }


    private boolean inflictDamageToCreatureAndCheckIfItsDead(AttackResults attackResults, Creature creature) {
        boolean isTheCreatureDead = false;
        int damageDealt = attackResults.getDamage();
        creature.setCurrentHitPoints(creature.getCurrentHitPoints() - damageDealt);
        System.out.println("DEBUG: " + creature.getHitPoints() + " HP");
        System.out.println("DEBUG: " + creature.getCurrentHitPoints() + " HP");
        System.out.println("DEBUG: " + creature.getID() + " ID");
        if (creature.getCurrentHitPoints() < 1) {
            pathFinder.getDungeonConsoleGUI().updateTheDungeonConsole("The attacked monster - " + creature.getMonsterName() + " - has fallen!");
            eventOnCreatureDeath(creature);
            isTheCreatureDead = true;
        } else if (creature.getCurrentHitPoints() * 2 < creature.getHitPoints()) {
            pathFinder.getDungeonConsoleGUI().updateTheDungeonConsole("The attacked monster - " + creature.getMonsterName() + " - is now bloodied.");
            isTheCreatureDead = false;
            creature.setThisCreatureBloodied(true);
        }
        return isTheCreatureDead;
    }

    private void eventOnCreatureDeath(Creature creature) {
        creature.setThisCreatureDead(true);
        System.out.println("Image has been modified");
        checkIfAllCreaturesInRoomAreDead();
    }

    private void enableAllHeroButtons() {
        for (Hero hero : heroManager.getHeroList()) {
            buttonGrid[hero.getMapXPos()][hero.getMapYPos()].setDisable(false);
        }
    }

    private void startTheMonsterAI(Monster monster) {
        //todo set the aggression level for each hero in regards to their class and raise aggression after using some powers.
        MonsterAI monsterAI = new MonsterAI();
        GUIAnimations animations = new GUIAnimations();
        System.out.println(ConsoleColors.ANSI_RED + "Calling Animation from Monster: " + ConsoleColors.ANSI_RESET);
        animations.heroClickAnimation(buttonGrid[monster.getMapXPos()][monster.getMapYPos()]);
        int attackedHeroId = monsterAI.makeAnAggressionRoll(heroManager.getHeroList(), monster);
        Hero attackedHero = guiUtilities.getHeroByID(attackedHeroId, heroManager.getHeroList());
        verifyIfTheMonsterShouldAttack(this, monster, attackedHero);
    }

    public void verifyIfTheMonsterShouldAttack(EncounterManager encounterManager, Monster monster, Hero attackedHero) {
        MonsterAI monsterAI = new MonsterAI();
        if (monsterAI.checkIfTheHeroIsWithinMeleeRange(encounterManager, monster, attackedHero.getID())) {
            foundAHeroToAttack(encounterManager, monster, monsterAI, attackedHero);
        } else {
            double distance = monsterAI.determineTheDistanceToAttackedHero(monster, attackedHero);
            monsterAI.moveIntoMeleeRange(this, monster, attackedHero, monster.getCurrentSpeed(), 0, 0);
        }
    }

    //todo after killing a monster, hero should be able to step onto its tile

    //todo consider centering the screen on the active hero

    //todo Hero turn should end when all of the actions are used up, not when his movement points are depleted.

    //todo add treasure lists to dead creatures


    private void foundAHeroToAttack(EncounterManager encounterManager, Monster monster, MonsterAI monsterAI, Hero attackedHero) {
        GUIAnimations animations = new GUIAnimations();
        System.out.println(ConsoleColors.ANSI_GREEN + "Hero found in melee range. Attacking!" + ConsoleColors.ANSI_RESET);
        AttackResults results = monsterAI.attackAHero(monster, attackedHero);
        System.out.println(ConsoleColors.ANSI_PURPLE + "Hit: " + results.isHitSuccess() +
                " for " + results.getDamage() + " damage." + ConsoleColors.ANSI_RESET);
        attackedHero.setHitPoints(attackedHero.getHitPoints() - results.getDamage());
        animations.creatureWasHitAnimation(
                encounterManager.getButtonGrid()[attackedHero.getMapXPos()][attackedHero.getMapYPos()]);
        System.out.println(
                ConsoleColors.ANSI_PURPLE + "Monster: " + monster.getMonsterName()
                        + " is attacking a hero: " + attackedHero.getHeroName()
                        + ConsoleColors.ANSI_RESET);
    }
}
