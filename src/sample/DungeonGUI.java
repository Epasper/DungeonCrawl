package sample;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DungeonGUI {

    //todo Create a pane on top of the map grid, that will show the available cards.

    private int mapWidth = 40;
    private int mapHeight = 40;
    private Button[][] buttonGrid = new Button[mapWidth][mapHeight];
    private GridPane mapGridPane = new GridPane();
    ScrollPane mapScrollPane = new ScrollPane();
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
    private List<Hero> heroList = new ArrayList<>();
    private List<Monster> monsterList = new ArrayList<>();
    private FakeDatabase database = new FakeDatabase();
    private Map map = new Map(generateAHeroList(createAnIDList()), generateAMonsterList(createAnIDList()));
    private int currentlyActiveHeroID;
    private boolean hasTheCharacterBeenSelected = false;
    int numberOfHeroesThatFinishedMovement;

    public int getNumberOfHeroesThatFinishedMovement() {
        return numberOfHeroesThatFinishedMovement;
    }

    public void setNumberOfHeroesThatFinishedMovement(int numberOfHeroesThatFinishedMovement) {
        this.numberOfHeroesThatFinishedMovement = numberOfHeroesThatFinishedMovement;
    }

    private Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int getCurrentlyActiveHeroID() {
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

    public DungeonGUI() {
        mapScrollPane.setContent(mapGridPane);
        getMap().drawAMap();
        updateGUIAccordingToMap(getMap());
    }

    //todo create a database and relink these to it

    private List<Hero> generateAHeroList(List<Integer> heroIdList) {
        database.populateDatabaseWithHeroes();
        for (Integer heroID : heroIdList) {
            for (Hero hero : database.listOfHeroes) {
                if (hero.ID == heroID) {
                    heroList.add(hero);
                }
            }
        }
        return heroList;
    }

    private List<Monster> generateAMonsterList(List<Integer> monsterIDList) {
        database.populateDatabaseWithMonsters();
        for (Integer monsterID : monsterIDList) {
            for (Monster monster : database.listOfMonsters) {
                if (monster.ID == monsterID + 100) {
                    monsterList.add(monster);
                }
            }
        }
        return monsterList;
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
            if (aHero.ID == ID) {
                return aHero;
            }
        }
        return heroNotFound;
    }

    private Monster getMonsterByID(int ID, List<Monster> listOfMonsters) {
        Monster monsterNotFound = new Monster();
        for (Monster aMonster : listOfMonsters) {
            if (aMonster.ID == ID) {
                return aMonster;
            }
        }
        return monsterNotFound;
    }

    private void updateGUIAccordingToMap(Map map) {
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {
                Button aButton = new Button();
                aButton.setMaxSize(50, 50);
                buttonGrid[i][j] = aButton;
                int finalJ = j;
                int finalI = i;
                aButton.setOnAction(actionEvent -> buttonEvent(aButton, finalI, finalJ));
                mapGridPane.add(aButton, j, i);
            }
        }
        updateMapGraphics(map);
    }

    private void updateMapGraphics(Map map) {
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {
                int currentEntityID = map.getMapTilesArray()[i][j].occupyingCreatureId;
                String typeOfTile;
                typeOfTile = map.getMapTilesArray()[i][j].typeOfTile;
                //debug mode only - make the whole map visible:
                map.getMapTilesArray()[i][j].visible = true;
                applyATileImageToAButton(typeOfTile, buttonGrid[i][j]);
                if (currentEntityID > 0) {
                    applyEntityIconToAButton(currentEntityID, buttonGrid[i][j]);
                }
                if (!map.getMapTilesArray()[i][j].visible) {
                    applyATileImageToAButton("Fog", buttonGrid[i][j]);
                }
            }
        }
    }

    private void buttonEvent(Button aButton, int XPos, int YPos) {
        String currentTypeOfTile = getMap().getMapTilesArray()[XPos][YPos].getTypeOfTile();
        int currentHeroID = getMap().getMapTilesArray()[XPos][YPos].getOccupyingCreatureId();
        boolean isTheTileInteractive = getMap().getMapTilesArray()[XPos][YPos].isWithinInteractionRange();
        if (isHasTheCharacterBeenSelected() && currentHeroID > 0) {
            eventOnReachableTileClick();
        }
        if (currentHeroID > 0 && currentHeroID < 100) {
            eventOnHeroClick(currentHeroID);
            isTheTileInteractive = getMap().getMapTilesArray()[XPos][YPos].isWithinInteractionRange();
        } else if (getMap().getMapTilesArray()[XPos][YPos].isInWalkRange()) {
            if (currentTypeOfTile.contains("Closed") && getMap().getMapTilesArray()[XPos][YPos].isWithinInteractionRange()) {
                getMap().getMapTilesArray()[XPos][YPos].setTypeOfTile(getMap().getMapTilesArray()[XPos][YPos].getTypeOfTile().replaceFirst("Closed", "Opened"));
            } else if (!currentTypeOfTile.contains("Closed")) {
                eventOnHeroMovement(aButton, XPos, YPos);
            }
            updateMapGraphics(getMap());
            getMap().clearMapReachableProperties(getMap());
        }
        if (currentHeroID > 100 && isTheTileInteractive) {
            eventOnHeroAttackingAMonster(XPos, YPos);
        }
    }

    private void eventOnHeroAttackingAMonster(int XPos, int YPos) {
        Hero hero = getHeroByID(getCurrentlyActiveHeroID(), heroList);
        Monster monster = getMonsterByID(getMap().getMapTilesArray()[XPos][YPos].occupyingCreatureId, monsterList);
        hero.attackAMonster(monster);
    }

    private void eventOnReachableTileClick() {
        getMap().clearMapReachableProperties(getMap());
        updateMapGraphics(getMap());
        setHasTheCharacterBeenSelected(false);
    }

    private void eventOnHeroClick(int currentHeroID) {
        checkTheAvailableDistance(getHeroByID(currentHeroID, heroList));
        setCurrentlyActiveHeroID(currentHeroID);
        setHasTheCharacterBeenSelected(true);
    }

    private void eventOnHeroMovement(Button aButton, int XPos, int YPos) {
        Hero hero = getHeroByID(getCurrentlyActiveHeroID(), heroList);
        getMap().getMapTilesArray()[hero.mapXPos][hero.mapYPos].setOccupyingCreatureId(0);
        getMap().getMapTilesArray()[XPos][YPos].setOccupyingCreatureId(getCurrentlyActiveHeroID());
        int deltaX = Math.abs(hero.getMapXPos() - XPos);
        int deltaY = Math.abs(hero.getMapYPos() - YPos);
        hero.setCurrentSpeed(hero.getCurrentSpeed() - (deltaX + deltaY));
        hero.setMapXPos(XPos);
        hero.setMapYPos(YPos);
        aButton.setGraphic(new ImageView(hero.heroImage));
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
        if (heroID < 100) {
            aButton.setGraphic(new ImageView(getHeroByID(heroID, heroList).heroImage));
        } else {
            aButton.setGraphic(new ImageView(getMonsterByID(heroID, monsterList).monsterImage));
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
                aButton.setStyle("-fx-color: #000000");
                aButton.setGraphic(new ImageView(floorImage));
                break;
            case "Corridor":
                aButton.setStyle("-fx-color: #000000");
                aButton.setGraphic(new ImageView(floorImage));
                break;
            case "CorridorVertical":
                aButton.setStyle("-fx-color: #000000");
                aButton.setGraphic(new ImageView(floorImage));
                break;
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

    //todo change the range calculator so that the range is a circle, not a diamond.

    private void checkTheAvailableDistance(Hero hero) {
        int YPos = hero.mapYPos;
        int XPos = hero.mapXPos;
        double heroSteps = hero.getCurrentSpeed();
        double heroInteractionSteps;
        if (hero.getCurrentSpeed() > 0.9) {
            heroInteractionSteps = 1;
        } else {
            heroInteractionSteps = 0;
        }
        recursiveCheckDistance(YPos, XPos, heroSteps, "Walk Range");
        recursiveCheckDistance(YPos, XPos, heroInteractionSteps, "Interaction Range");
        System.out.println("X: " + XPos + " Y: " + YPos + " Speed: " + hero.speed);
    }

    private void recursiveCheckDistance(int YPos, int XPos, double range, String reasonForChecking) {

        int iterations = (int) range;
        String currentTileTypeNorth = "North";
        String currentTileTypeEast = "East";
        String currentTileTypeWest = "West";
        String currentTileTypeSouth = "South";
        try {
            currentTileTypeNorth += map.getMapTilesArray()[XPos][YPos + 1].typeOfTile;
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            currentTileTypeEast += map.getMapTilesArray()[XPos + 1][YPos].typeOfTile;
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            currentTileTypeWest += map.getMapTilesArray()[XPos - 1][YPos].typeOfTile;
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            currentTileTypeSouth += map.getMapTilesArray()[XPos][YPos - 1].typeOfTile;
        } catch (IndexOutOfBoundsException ignored) {
        }

        if (iterations > 0) {
            setDistanceOnSingleTile(currentTileTypeNorth, XPos, YPos, iterations, reasonForChecking);
            setDistanceOnSingleTile(currentTileTypeEast, XPos, YPos, iterations, reasonForChecking);
            setDistanceOnSingleTile(currentTileTypeWest, XPos, YPos, iterations, reasonForChecking);
            setDistanceOnSingleTile(currentTileTypeSouth, XPos, YPos, iterations, reasonForChecking);
        }
    }

    private void setDistanceOnSingleTile(String currentDirection, int XPos, int YPos, double iterations, String reasonForChecking) {
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
        mapTile = map.getMapTilesArray()[temporaryX][temporaryY];
        gridButton = buttonGrid[temporaryX][temporaryY];
        if (currentDirection.contains("Room") || currentDirection.contains("Corridor") || currentDirection.contains("Opened")) {
            mapTile.inWalkRange = true;
            mapTile.visible = true;
            if (reasonForChecking.contains("Walk")) {
                gridButton.setStyle("-fx-color: #00ff00");
            } else if (reasonForChecking.contains("Interact")) {
                mapTile.withinInteractionRange = true;
                gridButton.setStyle("-fx-color: #ffff00");
                if (mapTile.getOccupyingCreatureId() > 100) {
                    gridButton.setStyle("-fx-color: #ff0000");
                }
            }
            recursiveCheckDistance(temporaryY, temporaryX, iterations - 1, reasonForChecking);
        } else if (currentDirection.contains("Wall")) {
            mapTile.visible = true;
        } else if (currentDirection.contains("Closed")) {
            mapTile.visible = true;
            mapTile.inWalkRange = true;
            gridButton.setStyle("-fx-color: #333399");
            if (reasonForChecking.contains("Interact")) {
                mapTile.withinInteractionRange = true;
            }
        }
        getMap().getMapTilesArray()[temporaryX][temporaryY] = mapTile;
        buttonGrid[temporaryX][temporaryY] = gridButton;
    }
}
