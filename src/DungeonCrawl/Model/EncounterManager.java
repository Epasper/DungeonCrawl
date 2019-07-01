package DungeonCrawl.Model;

import DungeonCrawl.GUI.GUIUtilities;
import DungeonCrawl.HeroPowers.HeroPower;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class EncounterManager {

    private boolean fightAlreadyTakingPlace;
    private HeroManager heroManager;
    private Button[][] buttonGrid;
    private PathFinder pathFinder;
    private GUIUtilities guiUtilities = new GUIUtilities();
    private DungeonMap dungeonMap = new DungeonMap(null);
    private List<Monster> allMonstersList = dungeonMap.getAllMonstersList();
    private boolean hasTheCharacterBeenSelected = false;

    public List<Monster> getAllMonstersList() {
        return allMonstersList;
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

    public boolean isFightAlreadyTakingPlace() {
        return fightAlreadyTakingPlace;
    }

    public void setFightAlreadyTakingPlace(boolean fightAlreadyTakingPlace) {
        this.fightAlreadyTakingPlace = fightAlreadyTakingPlace;
    }

    public void eventOnHeroClick(int currentHeroID) {
        //PathFinder pathFinder = new PathFinder();
        Hero currentHero = guiUtilities.getHeroByID(currentHeroID, heroManager.getHeroList());
        pathFinder.checkTheAvailableDistance(currentHero, dungeonMap, buttonGrid, "Available Distance");
        System.out.println("Clicked the ID " + currentHeroID + " hero.");
        heroManager.setCurrentlyActiveHeroID(currentHeroID);
        setHasTheCharacterBeenSelected(true);
        pathFinder.dungeonConsoleGUI.updateTheDungeonConsole("You have selected " + currentHero.getHeroName());
    }

    private void checkIfAllCreaturesInRoomAreDead() {
        for (Monster monster : pathFinder.getDiscoveredMonsters()) {
            if (!monster.isThisCreatureDead()) {
                System.out.println("Found a creature that's alive");
                fightAlreadyTakingPlace = true;
                return;
            }
        }
        System.out.println("All monsters are dead!");
        enableAllHeroButtons();
        List<Monster> emptyListOfMonsters = new ArrayList<>();
        pathFinder.setDiscoveredMonsters(emptyListOfMonsters);
        pathFinder.dungeonConsoleGUI.clearInitiativeTracker();
        fightAlreadyTakingPlace = false;
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
            return "Hit";
        } else {
            pathFinder.dungeonConsoleGUI.updateTheDungeonConsole("Your attack has missed.");
            return "Missed";
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
}
