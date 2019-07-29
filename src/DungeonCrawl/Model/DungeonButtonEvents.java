package DungeonCrawl.Model;

import DungeonCrawl.GUI.DungeonGUI;
import DungeonCrawl.GUI.FieldColors;
import DungeonCrawl.GUI.GUIAnimations;
import DungeonCrawl.GUI.GUIUtilities;
import DungeonCrawl.GUI.Images.SkillIcons.SkillIcons;
import DungeonCrawl.HeroPowers.HeroPower;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.List;

public class DungeonButtonEvents {

    private HeroManager heroManager;
    private PathFinder pathFinder;
    private GUIUtilities guiUtilities = new GUIUtilities();
    private GUIAnimations guiAnimations = new GUIAnimations();
    private MapManager mapManager;
    private EncounterManager encounterManager;
    private HBox powersHBox;
    private List<HeroPower> currentHeroPowers;
    private DungeonGUI dungeonGUI;

    public DungeonButtonEvents(EncounterManager encounterManager, MapManager mapManager, HBox powersHBox, List<HeroPower> currentHeroPowers, DungeonGUI dungeonGUI) {
        this.encounterManager = encounterManager;
        this.mapManager = mapManager;
        this.powersHBox = powersHBox;
        this.currentHeroPowers = currentHeroPowers;
        pathFinder = encounterManager.getPathFinder();
        heroManager = encounterManager.getHeroManager();
        this.dungeonGUI = dungeonGUI;
    }

    //todo centering algorithm.

   /* public void centerTheGUIOnCurrentCharacter(int ID, ScrollPane mapScrollPane) {
        Creature currentCreature;
        if (ID < 100) {
            currentCreature = guiUtilities.getHeroByID(ID, heroManager.getHeroList());
        } else {
            currentCreature = guiUtilities.getSingleMonsterByUniqueID(ID, encounterManager.getAllMonstersList());
        }
        System.out.println("CENTERING:----------------------------------------");
        System.out.println("Current ID " + ID);
        System.out.println("XPos of current hero: " + currentCreature.getMapXPos());
        System.out.println("YPos of current hero: " + currentCreature.getMapYPos());
        System.out.println("Map Tiles X: " + mapManager.getDungeonMap().getNumberOfTilesX());
        System.out.println("Map Tiles Y: " + mapManager.getDungeonMap().getNumberOfTilesY());
        System.out.println("VMax: " + mapScrollPane.getVmax() + " VMin: " + mapScrollPane.getVmin());
        System.out.println("HMax: " + mapScrollPane.getHmax() + " HMin: " + mapScrollPane.getHmin());
        double newHValue = (double) currentCreature.getMapYPos() / (double) mapManager.getDungeonMap().getNumberOfTilesY();
        double rescaledHValue = rescaleScrollerValue((double) mapManager.getDungeonMap().getNumberOfTilesY(), newHValue, 0.2, 2.5);
        double newVValue = (double) currentCreature.getMapXPos() / (double) mapManager.getDungeonMap().getNumberOfTilesX();
        double rescaledVValue = rescaleScrollerValue((double) mapManager.getDungeonMap().getNumberOfTilesX(), newVValue, 0.03, 1.2);
        System.out.println("Values: " + newHValue + "  " + newVValue);
        mapScrollPane.setHvalue(rescaledHValue);
        mapScrollPane.setVvalue(rescaledVValue);
        System.out.println("VValue: " + mapScrollPane.getVvalue() + " VValue: " + mapScrollPane.getVvalue());
        System.out.println("HValue: " + mapScrollPane.getHvalue() + " HValue: " + mapScrollPane.getHvalue());
        System.out.println("CENTERING ENDED-----------------------------------");
    }

    private double rescaleScrollerValue(double max, double inputValue, double border, double slope) {
        //* maxValue;
        double derivedSlope = (max - 2 * border) / max;
        System.out.println("DERIVED SLOPE: " + derivedSlope);
        if (inputValue < border) {
            return 0;
        } else if (inputValue > (1 - border)) {
            return 1;
        } else return (inputValue - border) * derivedSlope;
    }*/

    public void buttonEvent(int XPos, int YPos, List<HeroPower> currentHeroPowers) {
        String currentTypeOfTile = encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].getTypeOfTile();
        int currentHeroID = encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].getOccupyingCreatureTypeId();
        /*if (currentHeroID > 0) {
            centerTheGUIOnCurrentCharacter(currentHeroID, dungeonGUI.getMapScrollPane());
        }*/
        boolean isTheTileInteractive = encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].isWithinInteractionRange();
        boolean isTheTileWithinReach = encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].isInRangedAttackRange();
        if (encounterManager.isHasTheCharacterBeenSelected() && currentHeroID > 0) {
            eventOnReachableTileClick();
        }
        if (currentHeroID > 0 && currentHeroID < 100) {
            isTheTileInteractive = eventOnHeroClick(XPos, YPos, currentHeroID);
        } else if (encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].isInWalkRange()) {
            boolean isThisMonsterRound = currentHeroID > 100;
            eventOnHeroMapInteraction(XPos, YPos, currentTypeOfTile);
        }
        if (currentHeroID > 100 && isTheTileWithinReach) {
            eventOnAttackingAMonster(XPos, YPos, currentHeroPowers);
        }
        currentHeroPowers.clear();

    }

    private void eventOnHeroMapInteraction(int XPos, int YPos, String currentTypeOfTile) {
        if (currentTypeOfTile.contains("Closed") && encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].isWithinInteractionRange()) {
            encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].setTypeOfTile(encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].getTypeOfTile().replaceFirst("Closed", "Opened"));
        } else if (!currentTypeOfTile.contains("Closed")) {
            eventOnHeroMovement(XPos, YPos);
        }
        mapManager.updateMapGraphics();
        encounterManager.getDungeonMap().clearMapReachableProperties();
    }

    private boolean eventOnHeroClick(int XPos, int YPos, int currentHeroID) {

        boolean isTheTileInteractive;
        clearHoverEvents();
        mapManager.getDungeonMap().clearMapReachableProperties();
        encounterManager.manageHeroClicking(currentHeroID);
        guiAnimations.heroClickAnimation(encounterManager.getButtonGrid()[XPos][YPos]);
        updateButtonsWithSkillIcons(guiUtilities.getHeroByID(currentHeroID, heroManager.getHeroList()));
        isTheTileInteractive = encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].isWithinInteractionRange();
        return isTheTileInteractive;
    }

    private void eventOnAttackingAMonster(int XPos, int YPos, List<HeroPower> currentHeroPowers) {
        boolean wasTheAttackFinished = true;
        HeroPower currentPower = currentHeroPowers.get(currentHeroPowers.size() - 1);
        try {
            List<Creature> listOfAttackedCreatures = currentPower.determineTheNumberOfCreaturesAttacked(XPos,
                    YPos,
                    encounterManager.getDungeonMap(),
                    encounterManager.getDiscoveredMonsters(),
                    encounterManager.getHeroManager().getHeroList());
            for (Creature creature : listOfAttackedCreatures) {
                wasTheAttackFinished = checkIfTheAttackIsFinished(XPos, YPos, wasTheAttackFinished, currentPower, creature);
            }
        } catch (IndexOutOfBoundsException e) {
            encounterManager.getPathFinder().getDungeonConsoleGUI().updateTheDungeonConsole("Please select a power before attacking");
        }
        if (wasTheAttackFinished) {
            mapManager.updateMapGraphics();
        }
        if (currentPower.getTypeOfPower().contains("encounter")) {
            currentPower.setNumberOfLockedEncounters(1);
        } else if (currentPower.getTypeOfPower().contains("daily")) {
            currentPower.setNumberOfLockedEncounters(3);
        }
    }

    private boolean checkIfTheAttackIsFinished(int XPos, int YPos, boolean wasTheAttackFinished, HeroPower currentPower, Creature creature) {
        String hitResult = encounterManager.attackASingleCreature(XPos, YPos, currentPower, creature);
        System.out.println(ConsoleColors.ANSI_PURPLE + "Hit Results: " + hitResult + ConsoleColors.ANSI_RESET);
        if (hitResult.contains("Hit")) {
            System.out.println(ConsoleColors.ANSI_GREEN + creature.getHeroName() + "  " + creature.getHitPoints() + " Was Hit" + ConsoleColors.ANSI_RESET);
            wasTheAttackFinished = false;
            guiAnimations.visualsOnHit(encounterManager.getButtonGrid()[creature.getMapXPos()][creature.getMapYPos()], hitResult, mapManager, encounterManager);
/*            if (hitResult.contains("Bloodied")) {
                buttonGrid[creature.getMapXPos()][creature.getMapYPos()].setGraphic(mapManager.addBloodDropImageToCreatureImage(creature));
            }*/
        } else if (hitResult.contains("Miss")) {
            System.out.println(ConsoleColors.ANSI_BLUE + creature.getHeroName() + "  " + creature.getHitPoints() + " Was Missed" + ConsoleColors.ANSI_RESET);
            wasTheAttackFinished = false;
            guiAnimations.creatureWasMissedAnimation(encounterManager.getButtonGrid()[creature.getMapXPos()][creature.getMapYPos()], mapManager, encounterManager);
        } else if (hitResult.contains("Dead")) {
            System.out.println(ConsoleColors.ANSI_RED + creature.getHeroName() + "  " + creature.getHitPoints() + " Is Dead" + ConsoleColors.ANSI_RESET);
            wasTheAttackFinished = false;
            guiAnimations.visualsOnHit(encounterManager.getButtonGrid()[creature.getMapXPos()][creature.getMapYPos()], hitResult, mapManager, encounterManager);
            //mapManager.addDeathImageToCreatureImage(creature);
            encounterManager.getButtonGrid()[creature.getMapXPos()][creature.getMapYPos()].setGraphic(mapManager.addDeathImageToCreatureImage(creature));
        }
        clearHoverEvents();
        return wasTheAttackFinished;
    }


    private void eventOnHeroMovement(int XPos, int YPos) {
        boolean shouldEncounterGetTriggered = false;
        Hero hero = guiUtilities.getHeroByID(heroManager.getCurrentlyActiveHeroID(), heroManager.getHeroList());
        encounterManager.getDungeonMap().getMapTilesArray()[hero.getMapXPos()][hero.getMapYPos()].setOccupyingCreatureTypeId(0);
        encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].setOccupyingCreatureTypeId(heroManager.getCurrentlyActiveHeroID());
        int deltaX = Math.abs(hero.getMapXPos() - XPos);
        int deltaY = Math.abs(hero.getMapYPos() - YPos);
        hero.setCurrentSpeed(hero.getCurrentSpeed() - (deltaX + deltaY));
//        int oldHeroXPos = hero.getMapXPos();
//        int oldHeroYPos = hero.getMapYPos();
        hero.setMapXPos(XPos);
        hero.setMapYPos(YPos);
        if (hero.getCurrentSpeed() < 1) {
            encounterManager.endTheCurrentHeroMovement(hero);
        }
        if (!encounterManager.isEncounterOnline()) {
            encounterManager.setGlobalInitiative(0);
            encounterManager.resetAllHeroesSpeedToMax();
            shouldEncounterGetTriggered = pathFinder.checkIfTheEncounterShouldStart
                    (encounterManager.getAllMonstersList(), heroManager.getHeroList(), hero, encounterManager.getDungeonMap(), encounterManager.isEncounterOnline());
            System.out.println("Should Encounter Be Triggered = " + shouldEncounterGetTriggered);
            encounterManager.setEncounterOnline(shouldEncounterGetTriggered);
        }
        encounterManager.getPathFinder().getDungeonConsoleGUI().getInitiativeTracker().setContent(encounterManager.getPathFinder().getDungeonConsoleGUI().getInitiativeTilePane());
        if (shouldEncounterGetTriggered) {
            encounterManager.setTheEncounter();
        }
        //guiAnimations.walkingAnimation(oldHeroXPos, oldHeroYPos, XPos, YPos);
    }


    private void eventOnReachableTileClick() {
        encounterManager.getDungeonMap().clearMapReachableProperties();
        mapManager.updateMapGraphics();
        encounterManager.setHasTheCharacterBeenSelected(false);
        powersHBox.getChildren().clear();
    }

    private void updateButtonsWithSkillIcons(Hero currentHero) {
        SkillIcons skillIcons = new SkillIcons();
        for (HeroPower currentPower : currentHero.getAtWillPowers()) {
            addAPowerButton(currentHero, skillIcons, currentPower, FieldColors.AT_WILL_POWER);

        }
        for (HeroPower currentPower : currentHero.getEncounterPowers()) {
            Button powerButton = addAPowerButton(currentHero, skillIcons, currentPower, FieldColors.ENCOUNTER_POWER);
            if (currentPower.getNumberOfLockedEncounters() > 0) {
                System.out.println("DISABLING THE ENCOUNTER POWER");
                powerButton.setDisable(true);
            }
        }
        for (HeroPower currentPower : currentHero.getDailyPowers()) {
            Button powerButton = addAPowerButton(currentHero, skillIcons, currentPower, FieldColors.DAILY_POWER);
            if (currentPower.getNumberOfLockedEncounters() > 0) {
                System.out.println(ConsoleColors.ANSI_CYAN + "Rounds Locked: " + currentPower.getNumberOfLockedEncounters() + ConsoleColors.ANSI_RESET);
                System.out.println(ConsoleColors.ANSI_BLUE + "DISABLING THE DAILY POWER" + ConsoleColors.ANSI_RESET);
                powerButton.setDisable(true);
            }
        }
    }

    private Button addAPowerButton(Hero currentHero, SkillIcons skillIcons, HeroPower currentPower, String s) {
        Button powerButton = new Button();
        int powerIconID = Integer.valueOf(currentPower.getPowerIconId());
        ImageView powerImageView = new ImageView(skillIcons.getSkillIconById(powerIconID));
        powerImageView.setFitWidth(50);
        powerImageView.setFitHeight(50);
        powerButton.setGraphic(powerImageView);
        powerButton.setStyle(s);
        powerButton.setTextFill(Color.WHITE);
        powerButton.setMaxHeight(50);
        powerButton.setMaxWidth(50);
        powersHBox.getChildren().add(powerButton);
        powerButton.setOnAction(event -> eventOnPowerSelect(currentHero, currentPower));
        return powerButton;
    }

    private void eventOnPowerSelect(Hero currentHero, HeroPower selectedPower) {
        encounterManager.getDungeonMap().clearMapReachableProperties();
        System.out.println("Updating Map Graphics after Power Selection");
        mapManager.updateMapGraphics();
        System.out.println("Map Graphics Updated");
        System.out.println(ConsoleColors.ANSI_PURPLE +
                "SELECTED A POWER " + selectedPower.getTypeOfPower() + "  " + selectedPower.getPowerName()
                + ConsoleColors.ANSI_RESET);
        PathFinder pathFinder = new PathFinder();
        System.out.println("Setting Attack Range");
        currentHero.setAttackRange(selectedPower.getRange());
        System.out.println("Range Set");
        pathFinder.checkTheLineOfSight(encounterManager.getDungeonMap(), encounterManager.getButtonGrid(), currentHero);
        System.out.println("Marking Attack Distance");
        pathFinder.checkTheAttacksRange(currentHero, encounterManager.getDungeonMap(), encounterManager.getButtonGrid(), selectedPower);
        System.out.println("Attack Range Marked");
        currentHeroPowers.clear();
        currentHeroPowers.add(selectedPower);
        if (selectedPower.getBurstValue() > 0) {
            markTilesAsAoEDamage(selectedPower.getBurstValue());
        } else {
            clearHoverEvents();
        }
    }

    private void clearHoverEvents() {
        DungeonMap dungeonMap = encounterManager.getDungeonMap();
        for (int i = 0; i < dungeonMap.getNumberOfTilesX(); i++) {
            for (int j = 0; j < dungeonMap.getNumberOfTilesY(); j++) {
                int finalJ = j;
                int finalI = i;
                encounterManager.getButtonGrid()[i][j].setOnAction(event -> buttonEvent(finalI, finalJ, currentHeroPowers));
                encounterManager.getButtonGrid()[i][j].setOnMouseEntered(null);
                encounterManager.getButtonGrid()[i][j].setOnMouseExited(null);
            }
        }
        System.out.println("Hover Events Cleared");
    }

    private void markTilesAsAoEDamage(int burstValue) {
        DungeonMap dungeonMap = encounterManager.getDungeonMap();
        for (int i = 0; i < dungeonMap.getNumberOfTilesX(); i++) {
            for (int j = 0; j < dungeonMap.getNumberOfTilesY(); j++) {
                if (dungeonMap.getMapTilesArray()[i][j].isInRangedAttackRange()) {
                    int finalI = i;
                    int finalJ = j;
                    encounterManager.getButtonGrid()[i][j].setOnAction(event -> eventOnAttackingAMonster(finalI, finalJ, currentHeroPowers));
                    encounterManager.getButtonGrid()[i][j].setOnMouseEntered(event -> paintTheTilesInRange(encounterManager.getButtonGrid(), finalI, finalJ, burstValue));
                    encounterManager.getButtonGrid()[i][j].setOnMouseExited(event -> mapManager.updateMapGraphics(true));
                } else {
                    encounterManager.getButtonGrid()[i][j].setOnMouseExited(event -> mapManager.updateMapGraphics(true));
                }
            }
        }
    }

    private void paintTheTilesInRange(Button[][] buttonGrid, int XCoord, int YCoord, int burstValue) {
        for (int i = XCoord - burstValue; i < XCoord + burstValue + 1; i++) {
            for (int j = YCoord - burstValue; j < YCoord + burstValue + 1; j++) {
                try {
                    buttonGrid[i][j].setStyle(FieldColors.AOE_DAMAGE);
                } catch (IndexOutOfBoundsException ignored) {

                }
            }
        }
    }
}
