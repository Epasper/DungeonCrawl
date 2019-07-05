package DungeonCrawl.Model;

import DungeonCrawl.GUI.GUIAnimations;
import DungeonCrawl.GUI.GUIUtilities;
import DungeonCrawl.GUI.Images.SkillIcons.SkillIcons;
import DungeonCrawl.HeroPowers.HeroPower;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
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

    public List<Creature> determineTheNumberOfCreaturesAttacked(int XPos, int YPos, HeroPower heroPower, DungeonMap dungeonMap, List<Monster> allDiscoveredMonsters, List<Hero> allDiscoveredHeroes) {
        List<Creature> listOfCreaturesAttacked = new ArrayList<>();
        System.out.println("---" + XPos + "---" + YPos + "---");
        if (heroPower.getNumberOfTargets().contains("Burst")) {
            //todo after selecting a burst power, all tiles should be clickable as a target of the power
            //todo add a GUI element that shows the range of AoE attack to be made.
            manageBurstAttack(XPos, YPos, heroPower, dungeonMap, allDiscoveredMonsters, allDiscoveredHeroes, listOfCreaturesAttacked);
        } else {
            listOfCreaturesAttacked.add(guiUtilities.getSingleMonsterByUniqueID(dungeonMap.getMapTilesArray()[XPos][YPos].getOccupyingCreatureUniqueID(), allDiscoveredMonsters));
        }
        return listOfCreaturesAttacked;
    }

    private void manageBurstAttack(int XPos, int YPos, HeroPower heroPower, DungeonMap dungeonMap, List<Monster> allDiscoveredMonsters, List<Hero> allDiscoveredHeroes, List<Creature> listOfCreaturesAttacked) {
        int burstValue = heroPower.getBurstValue();
        for (int i = -burstValue; i < burstValue; i++) {
            for (int j = -burstValue; j < burstValue; j++) {
                try {
                    int creatureId = dungeonMap.getMapTilesArray()[XPos + i][YPos + j].getOccupyingCreatureTypeId();
                    if (creatureId > 100) {
                        creatureId = dungeonMap.getMapTilesArray()[XPos + i][YPos + j].getOccupyingCreatureUniqueID();
                        for (Monster monster : allDiscoveredMonsters) {
                            if (monster.getCurrentMonsterUniqueID() == creatureId) {
                                listOfCreaturesAttacked.add(monster);
                            }
                        }
                    } else {
                        for (Hero hero : allDiscoveredHeroes) {
                            if (hero.getID() == creatureId) {
                                listOfCreaturesAttacked.add(hero);
                            }
                        }
                    }
                } catch (NullPointerException ignored) {
                }
            }
        }
    }

    private void attackAMonsterEvent(int XPos, int YPos, List<HeroPower> currentHeroPowers) {
        boolean updateTheGraphics = true;
        try {
            HeroPower currentPower = currentHeroPowers.get(currentHeroPowers.size() - 1);
            List<Creature> listOfAttackedCreatures = determineTheNumberOfCreaturesAttacked(XPos,
                    YPos,
                    currentPower,
                    encounterManager.getDungeonMap(),
                    encounterManager.getDiscoveredMonsters(),
                    encounterManager.getHeroManager().getHeroList());
            for (Creature creature : listOfAttackedCreatures) {
                String hitResult = encounterManager.eventOnHeroAttackingASingleCreature(XPos, YPos, currentPower, creature);
                System.out.println(ConsoleColors.ANSI_PURPLE + "Hit Results: " + hitResult + ConsoleColors.ANSI_RESET);
                if (hitResult.contains("Hit")) {
                    System.out.println(ConsoleColors.ANSI_GREEN + creature.getHeroName() + "  " + creature.getHitPoints() + " Was Hit" + ConsoleColors.ANSI_RESET);
                    updateTheGraphics = false;
                    guiAnimations.visualsOnHit(buttonGrid[creature.getMapXPos()][creature.getMapYPos()], hitResult, mapManager, encounterManager);
                } else if (hitResult.contains("Miss")) {
                    System.out.println(ConsoleColors.ANSI_BLUE + creature.getHeroName() + "  " + creature.getHitPoints() + " Was Missed" + ConsoleColors.ANSI_RESET);
                    updateTheGraphics = false;
                    guiAnimations.creatureWasMissedAnimation(buttonGrid[creature.getMapXPos()][creature.getMapYPos()], mapManager, encounterManager);
                } else if (hitResult.contains("Dead")) {
                    System.out.println(ConsoleColors.ANSI_RED + creature.getHeroName() + "  " + creature.getHitPoints() + " Is Dead" + ConsoleColors.ANSI_RESET);
                    updateTheGraphics = false;
                    guiAnimations.visualsOnHit(buttonGrid[creature.getMapXPos()][creature.getMapYPos()], hitResult, mapManager, encounterManager);
                    //mapManager.addDeathImageToCreatureImage(creature);
                    buttonGrid[creature.getMapXPos()][creature.getMapYPos()].setGraphic(mapManager.addDeathImageToCreatureImage(creature));
                }
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
            addAPowerButton(currentHero, skillIcons, currentPower, "-fx-background-color: #007200;");

        }
        for (HeroPower currentPower : currentHero.getEncounterPowers()) {
            Button powerButton = addAPowerButton(currentHero, skillIcons, currentPower, "-fx-background-color: #910000;");
            if (currentPower.getNumberOfLockedEncounters() > 0) {
                System.out.println("DISABLING THE ENCOUNTER POWER");
                powerButton.setDisable(true);
            }
        }
        for (HeroPower currentPower : currentHero.getDailyPowers()) {
            Button powerButton = addAPowerButton(currentHero, skillIcons, currentPower, "-fx-background-color: #5c005e;");
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
