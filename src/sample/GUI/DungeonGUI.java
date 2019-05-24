package sample.GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import sample.*;
import sample.DAO.ItemsDAO;
import sample.HeroPowers.HeroPower;
import sample.Model.*;
import sample.Model.Monster;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

class DungeonGUI {

    private MainMenuGUI mainMenuGUI = new MainMenuGUI();
    private int mapWidth = 40;
    private int mapHeight = 40;
    private Button[][] buttonGrid = new Button[mapWidth][mapHeight];
    private GridPane mapGridPane = new GridPane();
    private VBox powersVBox = new VBox();
    BorderPane mapOuterPane = new BorderPane();
    private Text dungeonConsoleText = new Text();
    private HBox consoleButtons = new HBox();
    private GridPane completeConsole = new GridPane();
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
    private DungeonMap dungeonMap = new DungeonMap(heroList);
    private int currentlyActiveHeroID;
    private boolean hasTheCharacterBeenSelected = false;
    private int numberOfHeroesThatFinishedMovement;
    private ScrollPane dungeonConsole = new ScrollPane();
    private List<HeroPower> currentPower = new ArrayList<>();

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

    DungeonGUI(List<Hero> heroList) {
        this.heroList = heroList;
        manageTheConsoleAdding();
        //todo rewrite dummy buttons with real ones
        dungeonConsole.setContent(dungeonConsoleText);
        ScrollPane mapScrollPane = new ScrollPane();
        mapOuterPane.setCenter(mapScrollPane);
        mapOuterPane.setRight(powersVBox);
        mapScrollPane.setContent(mapGridPane);
        Button returnToMainMenu = new Button();
        returnToMainMenu.setText("Return to Main Menu");
        mapGridPane.add(returnToMainMenu, 0, mapHeight + 1, 3, 3);
        returnToMainMenu.setOnAction(event -> returnToMainMenu());
        dungeonMap.setHeroList(heroList);
        getDungeonMap().drawAMap();
        updateGUIAccordingToMap(getDungeonMap());
    }

    private void manageTheConsoleAdding() {
        powersVBox.setStyle("-fx-background-color:grey;");
        powersVBox.setMinSize(200, 40);
        Button equipmentButton = addViewEquipmentButton();
        consoleButtons.getChildren().add(equipmentButton);
        for (int i = 0; i < 8; i++) {
            Button dummyButton = new Button("Button " + i);
            dummyButton.setMinSize(50, 50);
            consoleButtons.getChildren().add(dummyButton);
        }
        completeConsole.add(dungeonConsole, 0, 0);
        completeConsole.add(consoleButtons, 0, 1);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        completeConsole.setMinHeight(120);
        completeConsole.setMinHeight(120);
        dungeonConsole.setPrefWidth(primaryScreenBounds.getWidth());
        dungeonConsole.setMinHeight(60);
        dungeonConsole.setMaxHeight(60);
        dungeonConsole.setFitToWidth(false);
        mapOuterPane.setBottom(completeConsole);
    }

    private Button addViewEquipmentButton() {
        Button equipmentButton = new Button();
        equipmentButton.setOnAction(event -> {
            try {
                showCurrentCharactersEquipment(getCurrentlyActiveHeroID());
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        });
        Image eqIcon = new Image(getClass().getResourceAsStream("Images/Equipment.jpg"));
        ImageView eqIconView = new ImageView(eqIcon);
        equipmentButton.setGraphic(eqIconView);
        return equipmentButton;
    }
    //todo add the equipment view
    //todo add the character's sheet view

    private void showCurrentCharactersEquipment(int currentlyActiveHeroID) throws IOException, SQLException {
        Hero currentHero = getHeroByID(currentlyActiveHeroID, heroList);
        ItemsDAO itemsDAO = new ItemsDAO();
        currentHero.setHeroEquipment(itemsDAO.getHeroEquipmentByHeroID(currentHero.getID()));
        EquipmentGUI equipmentGUI = new EquipmentGUI(currentHero);
        equipmentGUI.aStage = Main.getPrimaryStage();
        equipmentGUI.aStage.setScene(equipmentGUI.aScene);
        equipmentGUI.aStage.show();
    }

    private void updateTheDungeonConsole(String messageToUpdate) {
        dungeonConsoleText.setText(dungeonConsoleText.getText() + "\n" + messageToUpdate);
        dungeonConsole.setVvalue(1.0);
    }

    private void updateButtonsWithHeroSkillNames(Hero currentHero) {
        for (HeroPower currentPower : currentHero.getAtWillPowers()) {
            Button powerButton = new Button(currentPower.getPowerName());
            powerButton.setMinWidth(130);
            powerButton.setStyle("-fx-background-color: #007200;");
            powerButton.setTextFill(Color.WHITE);
            powersVBox.getChildren().add(powerButton);
            powerButton.setOnAction(event -> eventOnPowerSelect(currentHero, currentPower));

        }
        for (HeroPower currentPower : currentHero.getEncounterPowers()) {
            Button powerButton = new Button(currentPower.getPowerName());
            powerButton.setMinWidth(130);
            powerButton.setStyle("-fx-background-color: #910000;");
            powerButton.setTextFill(Color.WHITE);
            powersVBox.getChildren().add(powerButton);
            powerButton.setOnAction(event -> eventOnPowerSelect(currentHero, currentPower));
        }
        for (HeroPower currentPower : currentHero.getDailyPowers()) {
            Button powerButton = new Button(currentPower.getPowerName());
            powerButton.setMinWidth(130);
            powerButton.setStyle("-fx-background-color: #5c005e;");
            powerButton.setTextFill(Color.WHITE);
            powersVBox.getChildren().add(powerButton);
            powerButton.setOnAction(event -> eventOnPowerSelect(currentHero, currentPower));
        }
    }

    private Hero getHeroByID(int ID, List<Hero> listOfHeroes) {
        Hero returnedHero = new Hero();
        for (Hero aHero : listOfHeroes) {
            if (aHero.getID() == ID) {
                return aHero;
            }
        }
        return returnedHero;
    }

    private Monster getMonsterByID(int ID, List<Monster> listOfMonsters) {
        Monster returnedMonster = new Monster();
        for (Monster aMonster : listOfMonsters) {
            if (aMonster.getID() == ID) {
                return aMonster;
            }
        }
        return returnedMonster;
    }

    private void updateGUIAccordingToMap(DungeonMap dungeonMap) {
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
        updateMapGraphics(dungeonMap);
    }
    //todo add an "Equipment management" window in Dungeon GUI

    private void updateMapGraphics(DungeonMap dungeonMap) {
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

    private void buttonEvent(Button aButton, int XPos, int YPos) {
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
            eventOnHeroAttackingAMonster(XPos, YPos, currentPower.get(currentPower.size() - 1));
        }
    }

    private void returnToMainMenu() {
        mainMenuGUI.aStage = Main.getPrimaryStage();
        mainMenuGUI.aStage.setScene(mainMenuGUI.aScene);
        mainMenuGUI.aStage.show();
        System.out.println("Stage is closing");
    }

    private void eventOnHeroAttackingAMonster(int XPos, int YPos, HeroPower attackingPower) {
        Hero hero = getHeroByID(getCurrentlyActiveHeroID(), heroList);
        EncounterCalculator encounterCalculator = new EncounterCalculator();
        List<Monster> monsterList = encounterCalculator.getTheListOfPossibleMonsters();
        Monster monster = getMonsterByID(getDungeonMap().getMapTilesArray()[XPos][YPos].getOccupyingCreatureId(), monsterList);
        Map attackResults = hero.attackAMonster(monster, attackingPower);
        displayAttackMessage(attackingPower, monster, attackResults);
        if (((int) attackResults.get("Attribute Bonus") + (int) attackResults.get("Dice Roll")) >
                monster.getDefensesMap().get(attackingPower.getDefenseToBeChecked().toLowerCase())) {
            triggerOnHit(attackingPower, hero, attackResults);
        } else {
            updateTheDungeonConsole("Your attack has missed.");
        }
    }

    private void triggerOnHit(HeroPower attackingPower, Hero hero, Map attackResults) {
        updateTheDungeonConsole("It's a hit! Roll for damage: "
                + attackingPower.getDamageDiceDealt()
                + "d"
                + attackingPower.getTypeOfDamageDice());
        StringBuilder diceDealt = new StringBuilder();
        int allDamage = 0;
        Random random = new Random();

        for (int i = 0; i < attackingPower.getDamageDiceDealt(); i++) {
            int damageRoll = random.nextInt(attackingPower.getTypeOfDamageDice());
            System.out.println("--->" + damageRoll);
            diceDealt.append(" ").append(damageRoll).append(" ");
            allDamage += damageRoll;
        }
        int bonusDamage = hero.getHeroAttributesMap().get(attackingPower.getDamageModifier().toLowerCase());
        allDamage += bonusDamage;
        updateTheDungeonConsole("Result of damage dice rolls: "
                + diceDealt
                + ". Bonus damage equal to your "
                + attackingPower.getDamageModifier()
                + ": "
                + attackResults.get("Attribute Bonus"));
        updateTheDungeonConsole("You've dealt " + allDamage + " damage");
    }

    private void displayAttackMessage(HeroPower attackingPower, Monster monster, Map attackResults) {
        updateTheDungeonConsole("You have attacked a " +
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

    //todo repair the damage dice - allow buying weapons and default the non-weapon damage to 1d4
    private void eventOnReachableTileClick() {
        getDungeonMap().clearMapReachableProperties(getDungeonMap());
        updateMapGraphics(getDungeonMap());
        setHasTheCharacterBeenSelected(false);
        powersVBox.getChildren().clear();
    }

    private void eventOnHeroClick(int currentHeroID) {
        PathFinder pathFinder = new PathFinder();
        pathFinder.checkTheAvailableDistance(getHeroByID(currentHeroID, heroList), dungeonMap, buttonGrid);
        System.out.println("Clicked the ID " + currentHeroID + " hero.");
        setCurrentlyActiveHeroID(currentHeroID);
        setHasTheCharacterBeenSelected(true);
        updateButtonsWithHeroSkillNames(getHeroByID(currentHeroID, heroList));
        updateTheDungeonConsole("You have selected " + getHeroByID(currentHeroID, heroList).getHeroName());
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

    private void eventOnPowerSelect(Hero currentHero, HeroPower selectedPower) {
        PathFinder pathFinder = new PathFinder();
        currentPower.clear();
        currentPower.add(selectedPower);
        pathFinder.checkTheLineOfSight(dungeonMap, buttonGrid, currentHero);
    }


    private void applyEntityIconToAButton(int heroID, Button aButton) {
        EncounterCalculator encounterCalculator = new EncounterCalculator();
        List<Monster> monsterList = encounterCalculator.getTheListOfPossibleMonsters();
        if (heroID < 100) {
            aButton.setGraphic(new ImageView(getHeroByID(heroID, heroList).getHeroIcon()));
        } else {
            aButton.setGraphic(new ImageView(getMonsterByID(heroID, monsterList).getMonsterImage()));
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
    //todo visibility checker has to stop on walls


}
