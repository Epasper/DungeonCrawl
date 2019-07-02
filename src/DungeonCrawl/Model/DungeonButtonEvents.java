package DungeonCrawl.Model;

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
    private int currentCreatureInitiative = 0;
    private HBox powersHBox;
    private List<HeroPower> currentHeroPowers;
    private Button[][] buttonGrid;


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
            try {
                Monster monster = guiUtilities.getSingleMonsterByUniqueID(encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].getOccupyingCreatureUniqueID(), encounterManager.getAllMonstersList());
                String hitResult = encounterManager.eventOnHeroAttackingAMonster(XPos, YPos, currentHeroPowers.get(currentHeroPowers.size() - 1));
                if (hitResult.contains("Hit")) {
                    guiAnimations.visualsOnHit(buttonGrid[XPos][YPos], hitResult);
                } else if (hitResult.contains("Miss")) {
                    guiAnimations.creatureWasMissedAnimation(buttonGrid[XPos][YPos]);
                } else if (hitResult.contains("Dead")) {
                    mapManager.addDeathImageToCreatureImage(monster);
                    guiAnimations.visualsOnHit(buttonGrid[XPos][YPos], hitResult);
                    buttonGrid[monster.getMapXPos()][monster.getMapYPos()].setGraphic(mapManager.addDeathImageToCreatureImage(monster));
                }
            } catch (IndexOutOfBoundsException e) {
                pathFinder.dungeonConsoleGUI.updateTheDungeonConsole("Please select a power before attacking");
            }
            mapManager.updateMapGraphics(encounterManager.getDungeonMap());
        }
    }

    private void eventOnHeroMovement(int XPos, int YPos) {

        Hero hero = guiUtilities.getHeroByID(heroManager.getCurrentlyActiveHeroID(), heroManager.getHeroList());
        encounterManager.getDungeonMap().getMapTilesArray()[hero.getMapXPos()][hero.getMapYPos()].setOccupyingCreatureTypeId(0);
        encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].setOccupyingCreatureTypeId(heroManager.getCurrentlyActiveHeroID());
        int deltaX = Math.abs(hero.getMapXPos() - XPos);
        int deltaY = Math.abs(hero.getMapYPos() - YPos);
        hero.setCurrentSpeed(hero.getCurrentSpeed() - (deltaX + deltaY));
        int oldHeroXPos = hero.getMapXPos();
        int oldHeroYPos = hero.getMapYPos();
        hero.setMapXPos(XPos);
        hero.setMapYPos(YPos);
        if (hero.getCurrentSpeed() < 1) {
            endTheCurrentHeroMovement(hero);
        }
        if (!encounterManager.isEncounterOnline()) {
            resetAllHeroesSpeedToMax();
            encounterManager.setEncounterOnline
                    (pathFinder.checkIfTheEncounterShouldStart
                            (encounterManager.getAllMonstersList(), heroManager.getHeroList(), hero, encounterManager.getDungeonMap(), encounterManager.isEncounterOnline())
                    );
        }
        pathFinder.dungeonConsoleGUI.getInitiativeTracker().setContent(pathFinder.dungeonConsoleGUI.getInitiativeTilePane());
        if (encounterManager.isEncounterOnline()) {
            lockAllInactiveHeroButtons();
            encounterManager.startTheMonsterAI();
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
        }
    }

    private void endTheCurrentHeroMovement(Hero hero) {
        heroManager.setNumberOfHeroesThatFinishedMovement(heroManager.getNumberOfHeroesThatFinishedMovement() + 1);
        System.out.println(hero.heroName + " has finished moving. " + heroManager.getNumberOfHeroesThatFinishedMovement() + " heroes had already finished moving");
        if (encounterManager.isEncounterOnline()) {
            currentCreatureInitiative++;
            lockAllInactiveHeroButtons();
        }
        if (heroManager.getNumberOfHeroesThatFinishedMovement() == heroManager.getHeroList().size()) {
            for (Hero currentHero : heroManager.getHeroList()) {
                currentHero.setCurrentSpeed(currentHero.getSpeed());
                System.out.println("Resetting the movement points for " + currentHero.heroName);
            }
            currentCreatureInitiative = 0;
            heroManager.setNumberOfHeroesThatFinishedMovement(0);
        }
    }

    private void resetAllHeroesSpeedToMax() {
        for (Hero hero : heroManager.getHeroList()) {
            hero.setCurrentSpeed(hero.getSpeed());
        }
    }

    private void eventOnPowerSelect(Hero currentHero, HeroPower selectedPower) {
        PathFinder pathFinder = new PathFinder();
        currentHero.setAttackRange(selectedPower.getRange());
        currentHeroPowers.clear();
        currentHeroPowers.add(selectedPower);
        pathFinder.checkTheLineOfSight(encounterManager.getDungeonMap(), buttonGrid, currentHero);
        pathFinder.checkTheAvailableDistance(currentHero, encounterManager.getDungeonMap(), buttonGrid, "Attack Range");
    }

    private void lockAllInactiveHeroButtons() {
        for (Hero hero : heroManager.getHeroList()) {
            int heroIdFromInitiativeArray = pathFinder.dungeonConsoleGUI.getNextCharacterID(currentCreatureInitiative);
            System.out.println("NEXT CHAR ID: " +
                    heroIdFromInitiativeArray
                    + " Hero name: " +
                    hero.getHeroName());
            if (hero.getID() == heroIdFromInitiativeArray) {
                System.out.println("Found a creature with ID " +
                        heroIdFromInitiativeArray +
                        " hero name: " +
                        hero.getHeroName() +
                        "ID: " + hero.getID() +
                        " Init: " +
                        hero.getCurrentInitiative());
                System.out.println("Unlocking");
                buttonGrid[hero.getMapXPos()][hero.getMapYPos()].setDisable(false);
                System.out.println("THIS Creature Init: " + hero.getCurrentInitiative());
                currentCreatureInitiative = hero.getCurrentInitiative();
                System.out.println("GLOBAL INITIATIVE SET TO: " + currentCreatureInitiative);
            } else {
                buttonGrid[hero.getMapXPos()][hero.getMapYPos()].setDisable(true);
                System.out.println("Locking.");
            }
        }
    }
}
