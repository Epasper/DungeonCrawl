package sample.GUI;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import sample.*;
import sample.HeroPowers.HeroPower;
import sample.Model.*;
import sample.Model.Monster;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class DungeonGUI {

    private MainMenuGUI mainMenuGUI = new MainMenuGUI();
    private int mapWidth = 40;
    private int mapHeight = 40;
    private Button[][] buttonGrid = new Button[mapWidth][mapHeight];
    private GridPane mapGridPane = new GridPane();
    private VBox skillsVBox = new VBox();
    BorderPane mapOuterPane = new BorderPane();
    private Image wallImage = new Image(getClass().getResourceAsStream("Images\\wall.png"));
    private Image floorImage = new Image(getClass().getResourceAsStream("Images\\floor.png"));
    private Image fogImage = new Image(getClass().getResourceAsStream("Images\\fog.png"));
    private Image wallWestImage = new Image(getClass().getResourceAsStream("Images\\FloorWallW.png"));
    private Image wallEastImage = new Image(getClass().getResourceAsStream("Images\\FloorWallE.png"));
    private Image wallSouthImage = new Image(getClass().getResourceAsStream("Images\\FloorWallS.png"));
    private Image wallNorthImage = new Image(getClass().getResourceAsStream("Images\\FloorWallN.png"));
    private Image wallNEImage = new Image(getClass().getResourceAsStream("Images\\FloorWallNE.png"));
    private Image wallNWImage = new Image(getClass().getResourceAsStream("Images\\FloorWallNW.png"));
    private Image wallSEImage = new Image(getClass().getResourceAsStream("Images\\FloorWallSE.png"));
    private Image wallSWImage = new Image(getClass().getResourceAsStream("Images\\FloorWallSW.png"));
    private Image wallVertical = new Image(getClass().getResourceAsStream("Images\\FloorWallVert.png"));
    private Image wallHorizontal = new Image(getClass().getResourceAsStream("Images\\FloorWallHoriz.png"));
    private Image doorVertical = new Image(getClass().getResourceAsStream("Images\\DoorVertical.png"));
    private Image doorHorizontal = new Image(getClass().getResourceAsStream("Images\\DoorHorizontal.png"));
    private Image openedDoorVertical = new Image(getClass().getResourceAsStream("Images\\OpenedDoorVertical.png"));
    private Image openedDoorHorizontal = new Image(getClass().getResourceAsStream("Images\\OpenedDoorHorizontal.png"));
    private List<Hero> heroList;
    //private List<Monster> monsterList = new ArrayList<>();
    private DungeonMap dungeonMap = new DungeonMap(heroList);
    private int currentlyActiveHeroID;
    private boolean hasTheCharacterBeenSelected = false;
    private int numberOfHeroesThatFinishedMovement;

    private DungeonMap getDungeonMap() {
        return dungeonMap;
    }

    private int getCurrentlyActiveHeroID() {
        return currentlyActiveHeroID;
    }

    private void setCurrentlyActiveHeroID(int currentlyActiveHeroID) {
        this.currentlyActiveHeroID = currentlyActiveHeroID;
    }

    private boolean isHasTheCharacterBeenSelected() {
        return hasTheCharacterBeenSelected;
    }

    private void setHasTheCharacterBeenSelected(boolean hasTheCharacterBeenSelected) {
        this.hasTheCharacterBeenSelected = hasTheCharacterBeenSelected;
    }

    DungeonGUI(List<Hero> heroList) throws IOException, SQLException {
        this.heroList = heroList;
        skillsVBox.setStyle("-fx-background-color:grey;");
        skillsVBox.setMinSize(200, 40);
        ScrollPane mapScrollPane = new ScrollPane();
        mapOuterPane.setCenter(mapScrollPane);
        mapOuterPane.setRight(skillsVBox);
        mapScrollPane.setContent(mapGridPane);
        Button returnToMainMenu = new Button();
        returnToMainMenu.setText("Return to Main Menu");
        mapGridPane.add(returnToMainMenu, 0, mapHeight + 1, 3, 3);
        returnToMainMenu.setOnAction(event -> returnToMainMenu());
        dungeonMap.setHeroList(heroList);
        getDungeonMap().drawAMap();
        updateGUIAccordingToMap(getDungeonMap());
    }

    private void updateButtonsWithHeroSkillNames(Hero currentHero) {
        for (HeroPower currentPower : currentHero.getAtWillPowers()) {
            Button powerButton = new Button(currentPower.getPowerName());
            powerButton.setMinWidth(130);
            powerButton.setStyle("-fx-background-color: #007200;");
            powerButton.setTextFill(Color.WHITE);
            skillsVBox.getChildren().add(powerButton);
            powerButton.setOnAction(event -> checkTheLineOfSight(currentHero));

        }
        for (HeroPower currentPower : currentHero.getEncounterPowers()) {
            Button powerButton = new Button(currentPower.getPowerName());
            powerButton.setMinWidth(130);
            powerButton.setStyle("-fx-background-color: #910000;");
            powerButton.setTextFill(Color.WHITE);
            skillsVBox.getChildren().add(powerButton);
            powerButton.setOnAction(event -> checkTheLineOfSight(currentHero));
        }
        for (HeroPower currentPower : currentHero.getDailyPowers()) {
            Button powerButton = new Button(currentPower.getPowerName());
            powerButton.setMinWidth(130);
            powerButton.setStyle("-fx-background-color: #5c005e;");
            powerButton.setTextFill(Color.WHITE);
            skillsVBox.getChildren().add(powerButton);
            powerButton.setOnAction(event -> checkTheLineOfSight(currentHero));
        }
    }

    private List<Integer> createAnIDList() {
        List<Integer> listOfHeroIDS = new ArrayList<>();
        List<Integer> possibleIDS = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            possibleIDS.add(i);
        }
        Random random = new Random();
        int x;
        x = random.nextInt(possibleIDS.size());
        int randomID1 = possibleIDS.get(x);
        possibleIDS.remove(x);
        x = random.nextInt(possibleIDS.size());
        int randomID2 = possibleIDS.get(x);
        possibleIDS.remove(x);
        x = random.nextInt(possibleIDS.size());
        int randomID3 = possibleIDS.get(x);
        possibleIDS.remove(x);
        listOfHeroIDS.add(randomID1 + 1);
        listOfHeroIDS.add(randomID2 + 1);
        listOfHeroIDS.add(randomID3 + 1);
        return listOfHeroIDS;
    }

    private Hero getHeroByID(int ID, List<Hero> listOfHeroes) {
        Hero heroNotFound = new Hero();
        for (Hero aHero : listOfHeroes) {
            if (aHero.getID() == ID) {
                return aHero;
            }
        }
        return heroNotFound;
    }

    private Monster getMonsterByID(int ID, List<Monster> listOfMonsters) {
        Monster monsterNotFound = new Monster();
        for (Monster aMonster : listOfMonsters) {
            if (aMonster.getID() == ID) {
                return aMonster;
            }
        }
        return monsterNotFound;
    }

    private void updateGUIAccordingToMap(DungeonMap dungeonMap) throws IOException, SQLException {
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {
                Button aButton = new Button();
                aButton.setMaxSize(50, 50);
                buttonGrid[i][j] = aButton;
                int finalJ = j;
                int finalI = i;
                aButton.setOnAction(actionEvent -> {
                    try {
                        buttonEvent(aButton, finalI, finalJ);
                    } catch (IOException | SQLException e) {
                        e.printStackTrace();
                    }
                });
                mapGridPane.add(aButton, j, i);
            }
        }
        updateMapGraphics(dungeonMap);
    }

    private void updateMapGraphics(DungeonMap dungeonMap) throws IOException, SQLException {
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {
                int currentEntityID = dungeonMap.getMapTilesArray()[i][j].getOccupyingCreatureId();
                String typeOfTile;
                typeOfTile = dungeonMap.getMapTilesArray()[i][j].typeOfTile;
                //debug mode only - make the whole dungeonMap alreadyDiscovered:
                dungeonMap.getMapTilesArray()[i][j].alreadyDiscovered = true;
                applyATileImageToAButton(typeOfTile, buttonGrid[i][j]);
                if (currentEntityID > 0) {
                    applyEntityIconToAButton(currentEntityID, buttonGrid[i][j]);
                }
                if (!dungeonMap.getMapTilesArray()[i][j].alreadyDiscovered) {
                    applyATileImageToAButton("Fog", buttonGrid[i][j]);
                }
            }
        }
    }

    private void buttonEvent(Button aButton, int XPos, int YPos) throws IOException, SQLException {
        String currentTypeOfTile = getDungeonMap().getMapTilesArray()[XPos][YPos].getTypeOfTile();
        int currentHeroID = getDungeonMap().getMapTilesArray()[XPos][YPos].getOccupyingCreatureId();
        boolean isTheTileInteractive = getDungeonMap().getMapTilesArray()[XPos][YPos].isWithinInteractionRange();
        if (isHasTheCharacterBeenSelected() && currentHeroID > 0) {
            eventOnReachableTileClick();
        }
        if (currentHeroID > 0 && currentHeroID < 100) {
            eventOnHeroClick(currentHeroID);
            isTheTileInteractive = getDungeonMap().getMapTilesArray()[XPos][YPos].isWithinInteractionRange();
        } else if (getDungeonMap().getMapTilesArray()[XPos][YPos].isInWalkRange()) {
            if (currentTypeOfTile.contains("Closed") && getDungeonMap().getMapTilesArray()[XPos][YPos].isWithinInteractionRange()) {
                getDungeonMap().getMapTilesArray()[XPos][YPos].setTypeOfTile(getDungeonMap().getMapTilesArray()[XPos][YPos].getTypeOfTile().replaceFirst("Closed", "Opened"));
            } else if (!currentTypeOfTile.contains("Closed")) {
                eventOnHeroMovement(aButton, XPos, YPos);
            }
            updateMapGraphics(getDungeonMap());
            getDungeonMap().clearMapReachableProperties(getDungeonMap());
        }
        if (currentHeroID > 100 && isTheTileInteractive) {
            eventOnHeroAttackingAMonster(XPos, YPos);
        }
    }

    private void returnToMainMenu() {
        mainMenuGUI.aStage = Main.getPrimaryStage();
        mainMenuGUI.aStage.setScene(mainMenuGUI.aScene);
        mainMenuGUI.aStage.show();
        System.out.println("Stage is closing");
    }

    private void eventOnHeroAttackingAMonster(int XPos, int YPos) {
        Hero hero = getHeroByID(getCurrentlyActiveHeroID(), heroList);
        EncounterCalculator encounterCalculator = new EncounterCalculator();
        List<Monster> monsterList = encounterCalculator.getTheListOfPossibleMonsters();
        Monster monster = getMonsterByID(getDungeonMap().getMapTilesArray()[XPos][YPos].getOccupyingCreatureId(), monsterList);
        hero.attackAMonster(monster);
    }

    private void eventOnReachableTileClick() throws IOException, SQLException {
        getDungeonMap().clearMapReachableProperties(getDungeonMap());
        updateMapGraphics(getDungeonMap());
        setHasTheCharacterBeenSelected(false);
        skillsVBox.getChildren().clear();
    }

    private void eventOnHeroClick(int currentHeroID) {
        checkTheAvailableDistance(getHeroByID(currentHeroID, heroList));
        System.out.println("Clicked the ID " + currentHeroID + " hero.");
        setCurrentlyActiveHeroID(currentHeroID);
        setHasTheCharacterBeenSelected(true);
        updateButtonsWithHeroSkillNames(getHeroByID(currentHeroID, heroList));
    }

    private void eventOnHeroMovement(Button aButton, int XPos, int YPos) {
        Hero hero = getHeroByID(getCurrentlyActiveHeroID(), heroList);
        getDungeonMap().getMapTilesArray()[hero.getMapXPos()][hero.getMapYPos()].setOccupyingCreatureId(0);
        getDungeonMap().getMapTilesArray()[XPos][YPos].setOccupyingCreatureId(getCurrentlyActiveHeroID());
        int deltaX = Math.abs(hero.getMapXPos() - XPos);
        int deltaY = Math.abs(hero.getMapYPos() - YPos);
        hero.setCurrentSpeed(hero.getCurrentSpeed() - (deltaX + deltaY));
        hero.setMapXPos(XPos);
        hero.setMapYPos(YPos);
        aButton.setGraphic(new ImageView(hero.getHeroIcon()));
        if (hero.getCurrentSpeed() < 1) {
            numberOfHeroesThatFinishedMovement++;
            System.out.println(hero.heroName + " has finished moving. " + numberOfHeroesThatFinishedMovement + " heroes had already finished moving");
            if (numberOfHeroesThatFinishedMovement == heroList.size()) {
                for (Hero currentHero : heroList) {
                    currentHero.setCurrentSpeed(currentHero.getSpeed());
                    System.out.println("Resetting the movement points for " + currentHero.heroName);
                }
                numberOfHeroesThatFinishedMovement = 0;
            }
        }
    }


    private void applyEntityIconToAButton(int heroID, Button aButton) {
        EncounterCalculator encounterCalculator = new EncounterCalculator();
        List<Monster> monsterList = encounterCalculator.getTheListOfPossibleMonsters();
        //System.out.println("Iterating through current monsters: ");
        for (Monster monster : monsterList) {
            //System.out.println("Current monster: " + monster.getMonsterName());
        }
        if (heroID < 100) {
            aButton.setGraphic(new ImageView(getHeroByID(heroID, heroList).getHeroIcon()));
        } else {
            aButton.setGraphic(new ImageView(getMonsterByID(heroID, monsterList).getMonsterImage()));
            //System.out.println("CHECKING FOR MONSTER IMAGE:  " + getMonsterByID(heroID, monsterList).getMonsterImage());
        }
    }

    private void applyATileImageToAButton(String typeOfTile, Button aButton) {
        switch (typeOfTile) {
            case "RoomSeed":
            case "WallWest":
                aButton.setStyle("-fx-color: #000000");
                aButton.setGraphic(new ImageView(wallSouthImage));
                break;
            case "WallCornerNE":
                aButton.setStyle("-fx-color: #000000");
                aButton.setGraphic(new ImageView(wallNEImage));
                break;
            case "WallCornerSE":
                aButton.setStyle("-fx-color: #000000");
                aButton.setGraphic(new ImageView(wallSEImage));
                break;
            case "WallCornerNW":
                aButton.setStyle("-fx-color: #000000");
                aButton.setGraphic(new ImageView(wallNWImage));
                break;
            case "WallCornerSW":
                aButton.setStyle("-fx-color: #000000");
                aButton.setGraphic(new ImageView(wallSWImage));
                break;
            case "WallEast":
                aButton.setStyle("-fx-color: #000000");
                aButton.setGraphic(new ImageView(wallNorthImage));
                break;
            case "WallNorth":
                aButton.setStyle("-fx-color: #000000");
                aButton.setGraphic(new ImageView(wallWestImage));
                break;
            case "WallSouth":
                aButton.setStyle("-fx-color: #000000");
                aButton.setGraphic(new ImageView(wallEastImage));
                break;
            case "Room":
            case "Corridor":
            case "CorridorVertical":
            case "CorridorHorizontal":
                aButton.setStyle("-fx-color: #000000");
                aButton.setGraphic(new ImageView(floorImage));
                break;
            case "Blank":
                aButton.setStyle("-fx-color: #000000");
                aButton.setGraphic(new ImageView(wallImage));
                break;
            case "Fog":
                aButton.setStyle("-fx-color: #808080");
                aButton.setGraphic(new ImageView(fogImage));
                break;
            case "WallNorthSouth":
                aButton.setStyle("-fx-color: #000000");
                aButton.setGraphic(new ImageView(wallVertical));
                break;
            case "WallEastWest":
                aButton.setStyle("-fx-color: #000000");
                aButton.setGraphic(new ImageView(wallHorizontal));
                break;
            case "ClosedDoorVertical":
                aButton.setStyle("-fx-color: #000033");
                aButton.setGraphic(new ImageView(doorVertical));
                break;
            case "ClosedDoorHorizontal":
                aButton.setStyle("-fx-color: #000033");
                aButton.setGraphic(new ImageView(doorHorizontal));
                break;
            case "OpenedDoorHorizontal":
                aButton.setStyle("-fx-color: #000033");
                aButton.setGraphic(new ImageView(openedDoorHorizontal));
                break;
            case "OpenedDoorVertical":
                aButton.setStyle("-fx-color: #000033");
                aButton.setGraphic(new ImageView(openedDoorVertical));
                break;

        }
    }

    //todo add a console in the dungeon view to write output already discovered to players
//todo visibility checker hat to stop on walls
    private void checkTheLineOfSight(Hero hero) {
        int YPos = hero.getMapYPos();
        int XPos = hero.getMapXPos();
        checkTheSightForOneDirection(YPos, XPos, 1, 1);
        checkTheSightForOneDirection(YPos, XPos, 1, -1);
        checkTheSightForOneDirection(YPos, XPos, -1, 1);
        checkTheSightForOneDirection(YPos, XPos, -1, -1);
    }

    private void checkTheSightForOneDirection(int YPos, int XPos, int dir1, int dir2) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0 && j == 0) continue;
                try {
                    int currentXPos = XPos + i * dir1;
                    int currentYPos = YPos + j * dir2;
                    MapTile currentMapTile = dungeonMap.getMapTilesArray()[currentXPos][currentYPos];
                    boolean mapTileIsOccupied = currentMapTile.getOccupyingCreatureId() > 0;
                    if (!currentMapTile.isCurrentlyBehindCover() || !currentMapTile.isCurrentlyInvisible()) {
                        if (mapTileIsOccupied) {
                            for (int k = 0; k < 4; k++) {
                                int deltaX = i + 1;
                                int deltaY = j + 1;
                                double skewingCoefficient;
                                skewingCoefficient = deltaX / deltaY;
                                System.out.println("DeltaX: " + deltaX + " DeltaY: " + deltaY);
                                int valueX = currentXPos + (i * k * dir1);
                                int valueY = currentYPos + (j * k * dir2);
                                markTileAsUnreachable(currentMapTile, valueX, valueY);
                                while (deltaY > 1 || deltaX > 1) {
                                    int modifiedValueX = valueX + dir1;
                                    int modifiedValueY = valueY + dir2;
                                    if (skewingCoefficient == 1) {
                                        markTileAsUnreachable(currentMapTile, modifiedValueX, modifiedValueY);
//                                                System.out.println("Marking Tile: XPos = " + modifiedValueX + " YPos = " + modifiedValueY + " Skewing Coefficient = " + skewingCoefficient);
                                        deltaY--;
                                        deltaX--;
                                        valueX += dir1;
                                        valueY += dir2;
                                        if (deltaY > 0) {
                                            skewingCoefficient = deltaX / deltaY;
                                        }
                                    } else if (skewingCoefficient > 1) {
                                        markTileAsUnreachable(currentMapTile, modifiedValueX, valueY);
//                                                System.out.println("Marking Tile: XPos = " + modifiedValueX + " YPos = " + valueY + " Skewing Coefficient = " + skewingCoefficient)                                                ;
                                        deltaX--;
                                        valueX += dir1;
                                        skewingCoefficient = deltaX / deltaY;
                                    } else if (skewingCoefficient < 1) {
                                        markTileAsUnreachable(currentMapTile, valueX, modifiedValueY);
//                                                System.out.println("Marking Tile: XPos = " + valueX + " YPos = " + modifiedValueY + " Skewing Coefficient = " + skewingCoefficient);
                                        deltaY--;
                                        valueY += dir2;
                                        if (deltaY > 0) {
                                            skewingCoefficient = deltaX / deltaY;
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (IndexOutOfBoundsException ignored) {
                }
            }
        }
    }

    private void markTileAsUnreachable(MapTile currentMapTile, int valueX, int modifiedValueY) {
        dungeonMap.getMapTilesArray()[valueX][modifiedValueY].setCurrentlyInvisible(true);
        buttonGrid[valueX][modifiedValueY].setStyle("-fx-color: #ff6600");

    }


    private void checkTheAvailableDistance(Hero hero) {
        int YPos = hero.getMapYPos();
        int XPos = hero.getMapXPos();
        double heroSteps = hero.getCurrentSpeed();
        double heroInteractionSteps;
        if (hero.getCurrentSpeed() > 0.9) {
            heroInteractionSteps = 1.1;
        } else {
            heroInteractionSteps = 0;
        }
        recursiveCheckDistance("Start", YPos, XPos, heroSteps, "Walk Range");
        recursiveCheckDistance("Start", YPos, XPos, heroInteractionSteps, "Interaction Range");
        System.out.println("X: " + XPos + " Y: " + YPos + " Speed: " + hero.getSpeed());
    }

    private void recursiveCheckDistance(String previousDirection, int YPos, int XPos, double range, String reasonForChecking) {
        if (previousDirection.contains("North")) previousDirection = "North";
        else if (previousDirection.contains("East")) previousDirection = "East";
        else if (previousDirection.contains("West")) previousDirection = "West";
        else if (previousDirection.contains("South")) previousDirection = "South";
        String currentTileTypeNorth = "North";
        String currentTileTypeEast = "East";
        String currentTileTypeWest = "West";
        String currentTileTypeSouth = "South";
        try {
            currentTileTypeNorth += dungeonMap.getMapTilesArray()[XPos][YPos + 1].typeOfTile;
            if (dungeonMap.getMapTilesArray()[XPos][YPos + 1].getOccupyingCreatureId() > 0) {
                currentTileTypeNorth += "Occupied";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            currentTileTypeEast += dungeonMap.getMapTilesArray()[XPos + 1][YPos].typeOfTile;
            if (dungeonMap.getMapTilesArray()[XPos + 1][YPos].getOccupyingCreatureId() > 0) {
                currentTileTypeEast += "Occupied";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            currentTileTypeWest += dungeonMap.getMapTilesArray()[XPos - 1][YPos].typeOfTile;
            if (dungeonMap.getMapTilesArray()[XPos - 1][YPos].getOccupyingCreatureId() > 0) {
                currentTileTypeWest += "Occupied";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            currentTileTypeSouth += dungeonMap.getMapTilesArray()[XPos][YPos - 1].typeOfTile;
            if (dungeonMap.getMapTilesArray()[XPos][YPos - 1].getOccupyingCreatureId() > 0) {
                currentTileTypeSouth += "Occupied";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        if (range > 0) {
            setDistanceOnSingleTile(previousDirection, currentTileTypeNorth, XPos, YPos, range, reasonForChecking);
            setDistanceOnSingleTile(previousDirection, currentTileTypeEast, XPos, YPos, range, reasonForChecking);
            setDistanceOnSingleTile(previousDirection, currentTileTypeWest, XPos, YPos, range, reasonForChecking);
            setDistanceOnSingleTile(previousDirection, currentTileTypeSouth, XPos, YPos, range, reasonForChecking);
        }
    }

    //todo characters (both monsters and heroes) should be an impassable terrain. At the spawn and after moving, add impassable" property to the occupied tiles

    private void setDistanceOnSingleTile(String previousDirection, String currentDirection, int XPos, int YPos, double iterations, String reasonForChecking) {
        double stepDecrement;
        stepDecrement = calculateTheStepDecrement(previousDirection, currentDirection);
        MapTile mapTile;
        Button gridButton;
        int temporaryX = XPos;
        int temporaryY = YPos;
        if (currentDirection.contains("North")) {
            temporaryY++;
        } else if (currentDirection.contains("East")) {
            temporaryX++;
        } else if (currentDirection.contains("West")) {
            temporaryX--;
        } else if (currentDirection.contains("South")) {
            temporaryY--;
        }
        if (reasonForChecking.contains("Interact") && currentDirection.contains(previousDirection)) {
            temporaryX = XPos;
            temporaryY = YPos;
        }
        mapTile = dungeonMap.getMapTilesArray()[temporaryX][temporaryY];
        gridButton = buttonGrid[temporaryX][temporaryY];
        if (currentDirection.contains("Room") || currentDirection.contains("Corridor") || currentDirection.contains("Opened")) {
            if (!currentDirection.contains("Occupied") || (reasonForChecking.contains("Interaction"))) {
                markTheTileAsAccessible(reasonForChecking, mapTile, gridButton);
                recursiveCheckDistance(currentDirection, temporaryY, temporaryX, iterations - stepDecrement, reasonForChecking);
            }
        } else if (currentDirection.contains("Wall")) {
            mapTile.alreadyDiscovered = true;
        } else if (currentDirection.contains("Closed")) {
            mapTile.alreadyDiscovered = true;
            mapTile.inWalkRange = true;
            gridButton.setStyle("-fx-color: #333399");
            if (reasonForChecking.contains("Interact")) {
                mapTile.withinInteractionRange = true;
            }
        }
        getDungeonMap().getMapTilesArray()[temporaryX][temporaryY] = mapTile;
        buttonGrid[temporaryX][temporaryY] = gridButton;
    }

    private void markTheTileAsAccessible(String reasonForChecking, MapTile mapTile, Button gridButton) {
        mapTile.alreadyDiscovered = true;
        mapTile.inWalkRange = true;
        if (reasonForChecking.contains("Walk")) {
            gridButton.setStyle("-fx-color: #00ff00");
        } else if (reasonForChecking.contains("Interact")) {
            mapTile.withinInteractionRange = true;
            gridButton.setStyle("-fx-color: #ffff00");
            if (mapTile.getOccupyingCreatureId() > 100) {
                gridButton.setStyle("-fx-color: #ff0000");
            }
        }
    }

    private double calculateTheStepDecrement(String previousDirection, String currentDirection) {
        double stepDecrement;
        if ((previousDirection.contains("South") || previousDirection.contains("North"))
                &&
                (currentDirection.contains("West") || (currentDirection.contains("East")))) {
            stepDecrement = 0.8;
        } else if ((previousDirection.contains("West") || previousDirection.contains("East"))
                &&
                (currentDirection.contains("South") || (currentDirection.contains("North")))) {
            stepDecrement = 0.8;
        } else {
            stepDecrement = 1;
        }
        return stepDecrement;
    }
}
