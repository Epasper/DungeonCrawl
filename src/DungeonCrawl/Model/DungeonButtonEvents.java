package DungeonCrawl.Model;

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
        if (encounterManager.isHasTheCharacterBeenSelected() && currentHeroID > 0) {
            eventOnReachableTileClick();
        }
        if (currentHeroID > 0 && currentHeroID < 100) {
            encounterManager.eventOnHeroClick(currentHeroID);
            guiAnimations.heroClickAnimation(buttonGrid[XPos][YPos]);
            updateButtonsWithSkillIcons(guiUtilities.getHeroByID(currentHeroID, heroManager.getHeroList()));
            isTheTileInteractive = encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].isWithinInteractionRange();
        } else if (encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].isInWalkRange()) {
            if (currentTypeOfTile.contains("Closed") && encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].isWithinInteractionRange()) {
                encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].setTypeOfTile(encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].getTypeOfTile().replaceFirst("Closed", "Opened"));
            } else if (!currentTypeOfTile.contains("Closed")) {
                eventOnHeroMovement(XPos, YPos);
            }
            //debug animation tinkering
            mapManager.updateMapGraphics(encounterManager.getDungeonMap());
            encounterManager.getDungeonMap().clearMapReachableProperties(encounterManager.getDungeonMap());
        }
        if (currentHeroID > 100 && isTheTileInteractive) {
            attackAMonsterEvent(XPos, YPos, currentHeroPowers);
        }
    }

    private void attackAMonsterEvent(int XPos, int YPos, List<HeroPower> currentHeroPowers) {
        boolean updateTheGraphics = true;
        try {
            Monster monster = guiUtilities.getSingleMonsterByUniqueID(encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].getOccupyingCreatureUniqueID(), encounterManager.getAllMonstersList());
            String hitResult = encounterManager.eventOnHeroAttackingAMonster(XPos, YPos, currentHeroPowers.get(currentHeroPowers.size() - 1));
            if (hitResult.contains("Hit")) {
                updateTheGraphics = false;
                guiAnimations.visualsOnHit(buttonGrid[XPos][YPos], hitResult, mapManager, encounterManager);
            } else if (hitResult.contains("Miss")) {
                updateTheGraphics = false;
                guiAnimations.creatureWasMissedAnimation(buttonGrid[XPos][YPos], mapManager, encounterManager);
            } else if (hitResult.contains("Dead")) {
                updateTheGraphics = false;
                guiAnimations.visualsOnHit(buttonGrid[XPos][YPos], hitResult, mapManager, encounterManager);
                mapManager.addDeathImageToCreatureImage(monster);
                buttonGrid[monster.getMapXPos()][monster.getMapYPos()].setGraphic(mapManager.addDeathImageToCreatureImage(monster));
            }
        } catch (IndexOutOfBoundsException e) {
            pathFinder.dungeonConsoleGUI.updateTheDungeonConsole("Please select a power before attacking");
        }
        if (updateTheGraphics) {
            mapManager.updateMapGraphics(encounterManager.getDungeonMap());
        }
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
            encounterManager.setEncounterOnline(shouldEncounterGetTriggered);
        }
        pathFinder.dungeonConsoleGUI.getInitiativeTracker().setContent(pathFinder.dungeonConsoleGUI.getInitiativeTilePane());
        if (shouldEncounterGetTriggered) {
            encounterManager.setTheEncounter();
        }
        //guiAnimations.walkingAnimation(oldHeroXPos, oldHeroYPos, XPos, YPos);
    }


    private void eventOnReachableTileClick() {
        encounterManager.getDungeonMap().clearMapReachableProperties(encounterManager.getDungeonMap());
        mapManager.updateMapGraphics(encounterManager.getDungeonMap());
        encounterManager.setHasTheCharacterBeenSelected(false);
        powersHBox.getChildren().clear();
    }

    private void updateButtonsWithSkillIcons(Hero currentHero) {
        SkillIcons skillIcons = new SkillIcons();
        for (HeroPower currentPower : currentHero.getAtWillPowers()) {
            Button powerButton = new Button();
            int powerIconID = Integer.valueOf(currentPower.getPowerIconId());
            ImageView powerImageView = new ImageView(skillIcons.getSkillIconById(powerIconID));
            powerButton.setGraphic(powerImageView);
            powerButton.setStyle("-fx-background-color: #007200;");
            powerButton.setTextFill(Color.WHITE);
            powersHBox.getChildren().add(powerButton);
            powerButton.setOnAction(event -> eventOnPowerSelect(currentHero, currentPower));

        }
        for (HeroPower currentPower : currentHero.getEncounterPowers()) {
            Button powerButton = new Button();
            int powerIconID = Integer.valueOf(currentPower.getPowerIconId());
            ImageView powerImageView = new ImageView(skillIcons.getSkillIconById(powerIconID));
            powerButton.setGraphic(powerImageView);
            powerButton.setStyle("-fx-background-color: #910000;");
            powerButton.setTextFill(Color.WHITE);
            powersHBox.getChildren().add(powerButton);
            powerButton.setOnAction(event -> eventOnPowerSelect(currentHero, currentPower));
            if (currentPower.getNumberOfLockedEncounters() > 0) {
                System.out.println("DISABLING THE ENCOUNTER POWER");
                powerButton.setDisable(true);
            }
        }
        for (HeroPower currentPower : currentHero.getDailyPowers()) {
            Button powerButton = new Button();
            int powerIconID = Integer.valueOf(currentPower.getPowerIconId());
            ImageView powerImageView = new ImageView(skillIcons.getSkillIconById(powerIconID));
            powerButton.setGraphic(powerImageView);
            powerButton.setStyle("-fx-background-color: #5c005e;");
            powerButton.setTextFill(Color.WHITE);
            powersHBox.getChildren().add(powerButton);
            powerButton.setOnAction(event -> eventOnPowerSelect(currentHero, currentPower));
            if (currentPower.getNumberOfLockedEncounters() > 0) {
                System.out.println(ConsoleColors.ANSI_CYAN + "Rounds Locked: " + currentPower.getNumberOfLockedEncounters() + ConsoleColors.ANSI_RESET);
                System.out.println(ConsoleColors.ANSI_BLUE + "DISABLING THE DAILY POWER" + ConsoleColors.ANSI_RESET);
                powerButton.setDisable(true);
            }
        }
    }

    private void eventOnPowerSelect(Hero currentHero, HeroPower selectedPower) {
        System.out.println(ConsoleColors.ANSI_PURPLE +
                "SELECTED A POWER " + selectedPower.getTypeOfPower() + "  " + selectedPower.getPowerName()
                + ConsoleColors.ANSI_RESET);
        PathFinder pathFinder = new PathFinder();
        currentHero.setAttackRange(selectedPower.getRange());
        pathFinder.checkTheLineOfSight(encounterManager.getDungeonMap(), buttonGrid, currentHero);
        pathFinder.checkTheAvailableDistance(currentHero, encounterManager.getDungeonMap(), buttonGrid, "Attack Range");
        currentHeroPowers.clear();
        currentHeroPowers.add(selectedPower);
        if (selectedPower.getTypeOfPower().contains("encounter")) {
            selectedPower.setNumberOfLockedEncounters(1);
        } else if (selectedPower.getTypeOfPower().contains("daily")) {
            selectedPower.setNumberOfLockedEncounters(3);
        }
    }
}
