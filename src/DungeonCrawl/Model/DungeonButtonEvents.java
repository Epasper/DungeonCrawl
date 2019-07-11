package DungeonCrawl.Model;

import DungeonCrawl.GUI.FieldColors;
import DungeonCrawl.GUI.GUIAnimations;
import DungeonCrawl.GUI.GUIUtilities;
import DungeonCrawl.GUI.Images.SkillIcons.SkillIcons;
import DungeonCrawl.HeroPowers.HeroPower;
import javafx.scene.control.Button;
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
    private Button[][] buttonGrid;
    private List<HeroPower> currentHeroPowers;


    public DungeonButtonEvents(EncounterManager encounterManager, MapManager mapManager, HBox powersHBox, List<HeroPower> currentHeroPowers) {
        this.encounterManager = encounterManager;
        this.mapManager = mapManager;
        this.powersHBox = powersHBox;
        this.currentHeroPowers = currentHeroPowers;
        pathFinder = encounterManager.getPathFinder();
        buttonGrid = mapManager.getButtonGrid();
        heroManager = encounterManager.getHeroManager();
    }

    public void buttonEvent(int XPos, int YPos, List<HeroPower> currentHeroPowers) {
        String currentTypeOfTile = encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].getTypeOfTile();
        int currentHeroID = encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].getOccupyingCreatureTypeId();
        boolean isTheTileInteractive = encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].isWithinInteractionRange();
        boolean isTheTileWithinReach = encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].isInRangedAttackRange();
        if (encounterManager.isHasTheCharacterBeenSelected() && currentHeroID > 0) {
            eventOnReachableTileClick();
        }
        if (currentHeroID > 0 && currentHeroID < 100) {
            isTheTileInteractive = eventOnHeroClick(XPos, YPos, currentHeroID);
        } else if (encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].isInWalkRange()) {
            eventOnHeroMapInteraction(XPos, YPos, currentTypeOfTile);
        }
        if (currentHeroID > 100 && isTheTileWithinReach) {
            eventOnAttackingAMonster(XPos, YPos, currentHeroPowers);
        }
    }

    private void eventOnHeroMapInteraction(int XPos, int YPos, String currentTypeOfTile) {
        if (currentTypeOfTile.contains("Closed") && encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].isWithinInteractionRange()) {
            encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].setTypeOfTile(encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].getTypeOfTile().replaceFirst("Closed", "Opened"));
        } else if (!currentTypeOfTile.contains("Closed")) {
            eventOnHeroMovement(XPos, YPos);
        }
        //debug animation tinkering
        mapManager.updateMapGraphics();
        encounterManager.getDungeonMap().clearMapReachableProperties();
    }

    private boolean eventOnHeroClick(int XPos, int YPos, int currentHeroID) {

        boolean isTheTileInteractive;
        clearHoverEvents();
        mapManager.getDungeonMap().clearMapReachableProperties();
        encounterManager.manageHeroClicking(currentHeroID);
        guiAnimations.heroClickAnimation(buttonGrid[XPos][YPos]);
        updateButtonsWithSkillIcons(guiUtilities.getHeroByID(currentHeroID, heroManager.getHeroList()));
        isTheTileInteractive = encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].isWithinInteractionRange();
        return isTheTileInteractive;
    }

    private void eventOnAttackingAMonster(int XPos, int YPos, List<HeroPower> currentHeroPowers) {
        boolean wasTheAttackFinished = true;
        try {
            HeroPower currentPower = currentHeroPowers.get(currentHeroPowers.size() - 1);
            List<Creature> listOfAttackedCreatures = currentPower.determineTheNumberOfCreaturesAttacked(XPos,
                    YPos,
                    encounterManager.getDungeonMap(),
                    encounterManager.getDiscoveredMonsters(),
                    encounterManager.getHeroManager().getHeroList());
            for (Creature creature : listOfAttackedCreatures) {
                wasTheAttackFinished = checkIfTheAttackIsFinished(XPos, YPos, wasTheAttackFinished, currentPower, creature);
            }
        } catch (IndexOutOfBoundsException e) {
            pathFinder.dungeonConsoleGUI.updateTheDungeonConsole("Please select a power before attacking");
        }
        if (wasTheAttackFinished) {
            mapManager.updateMapGraphics();
        }
    }

    private boolean checkIfTheAttackIsFinished(int XPos, int YPos, boolean wasTheAttackFinished, HeroPower currentPower, Creature creature) {
        String hitResult = encounterManager.attackASingleCreature(XPos, YPos, currentPower, creature);
        System.out.println(ConsoleColors.ANSI_PURPLE + "Hit Results: " + hitResult + ConsoleColors.ANSI_RESET);
        if (hitResult.contains("Hit")) {
            System.out.println(ConsoleColors.ANSI_GREEN + creature.getHeroName() + "  " + creature.getHitPoints() + " Was Hit" + ConsoleColors.ANSI_RESET);
            wasTheAttackFinished = false;
            guiAnimations.visualsOnHit(buttonGrid[creature.getMapXPos()][creature.getMapYPos()], hitResult, mapManager, encounterManager);
/*            if (hitResult.contains("Bloodied")) {
                buttonGrid[creature.getMapXPos()][creature.getMapYPos()].setGraphic(mapManager.addBloodDropImageToCreatureImage(creature));
            }*/
        } else if (hitResult.contains("Miss")) {
            System.out.println(ConsoleColors.ANSI_BLUE + creature.getHeroName() + "  " + creature.getHitPoints() + " Was Missed" + ConsoleColors.ANSI_RESET);
            wasTheAttackFinished = false;
            guiAnimations.creatureWasMissedAnimation(buttonGrid[creature.getMapXPos()][creature.getMapYPos()], mapManager, encounterManager);
        } else if (hitResult.contains("Dead")) {
            System.out.println(ConsoleColors.ANSI_RED + creature.getHeroName() + "  " + creature.getHitPoints() + " Is Dead" + ConsoleColors.ANSI_RESET);
            wasTheAttackFinished = false;
            guiAnimations.visualsOnHit(buttonGrid[creature.getMapXPos()][creature.getMapYPos()], hitResult, mapManager, encounterManager);
            //mapManager.addDeathImageToCreatureImage(creature);
            buttonGrid[creature.getMapXPos()][creature.getMapYPos()].setGraphic(mapManager.addDeathImageToCreatureImage(creature));
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
            encounterManager.resetAllHeroesSpeedToMax();
            shouldEncounterGetTriggered = pathFinder.checkIfTheEncounterShouldStart
                    (encounterManager.getAllMonstersList(), heroManager.getHeroList(), hero, encounterManager.getDungeonMap(), encounterManager.isEncounterOnline());
            System.out.println("Should Encounter Be Triggered = " + shouldEncounterGetTriggered);
            encounterManager.setEncounterOnline(shouldEncounterGetTriggered);
        }
        pathFinder.dungeonConsoleGUI.getInitiativeTracker().setContent(pathFinder.dungeonConsoleGUI.getInitiativeTilePane());
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
        pathFinder.checkTheLineOfSight(encounterManager.getDungeonMap(), buttonGrid, currentHero);
        System.out.println("Marking Attack Distance");
        pathFinder.checkTheAttacksRange(currentHero, encounterManager.getDungeonMap(), buttonGrid, selectedPower);
        System.out.println("Attack Range Marked");
        currentHeroPowers.clear();
        currentHeroPowers.add(selectedPower);
        if (selectedPower.getTypeOfPower().contains("encounter")) {
            selectedPower.setNumberOfLockedEncounters(1);
        } else if (selectedPower.getTypeOfPower().contains("daily")) {
            selectedPower.setNumberOfLockedEncounters(3);
        }
        if (selectedPower.getBurstValue() > 0) {
            markTilesAsAoEDamage(selectedPower.getBurstValue());
        } else {
            clearHoverEvents();
        }
    }

    private void clearHoverEvents() {
        DungeonMap dungeonMap = mapManager.getDungeonMap();
        for (int i = 0; i < dungeonMap.getNumberOfTilesX(); i++) {
            for (int j = 0; j < dungeonMap.getNumberOfTilesY(); j++) {
                int finalJ = j;
                int finalI = i;
                buttonGrid[i][j].setOnAction(event -> buttonEvent(finalI, finalJ, currentHeroPowers));
                buttonGrid[i][j].setOnMouseEntered(null);
                buttonGrid[i][j].setOnMouseExited(null);
            }
        }
        System.out.println("Hover Events Cleared");
    }

    private void markTilesAsAoEDamage(int burstValue) {
        DungeonMap dungeonMap = mapManager.getDungeonMap();
        for (int i = 0; i < dungeonMap.getNumberOfTilesX(); i++) {
            for (int j = 0; j < dungeonMap.getNumberOfTilesY(); j++) {
                if (dungeonMap.getMapTilesArray()[i][j].isInRangedAttackRange()) {
                    int finalI = i;
                    int finalJ = j;
                    buttonGrid[i][j].setOnAction(event -> eventOnAttackingAMonster(finalI, finalJ, currentHeroPowers));
                    buttonGrid[i][j].setOnMouseEntered(event -> paintTheTilesInRange(buttonGrid, finalI, finalJ, burstValue));
                    buttonGrid[i][j].setOnMouseExited(event -> mapManager.updateMapGraphics(true));
                } else {
                    buttonGrid[i][j].setOnMouseExited(event -> mapManager.updateMapGraphics(true));
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
