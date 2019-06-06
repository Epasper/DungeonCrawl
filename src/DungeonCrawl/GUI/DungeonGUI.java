package DungeonCrawl.GUI;

import javafx.geometry.Insets;
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
import DungeonCrawl.*;
import DungeonCrawl.DAO.ItemsDAO;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.Model.*;
import DungeonCrawl.Model.Monster;

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
    private HBox powersHBox = new HBox();
    private VBox portraitsVBox = new VBox();
    private VBox consoleButtons = new VBox();
    BorderPane mapOuterPane = new BorderPane();
    private Text dungeonConsoleText = new Text();
    private GridPane completeConsole = new GridPane();
    private Image wallImage = new Image(getClass().getResourceAsStream("Images\\MapElements\\wall.png"));
    private Image floorImage = new Image(getClass().getResourceAsStream("Images\\MapElements\\floor.png"));
    private Image fogImage = new Image(getClass().getResourceAsStream("Images\\MapElements\\fog.png"));
    private Image wallWestImage = new Image(getClass().getResourceAsStream("Images\\MapElements\\FloorWallW.png"));
    private Image wallEastImage = new Image(getClass().getResourceAsStream("Images\\MapElements\\FloorWallE.png"));
    private Image wallSouthImage = new Image(getClass().getResourceAsStream("Images\\MapElements\\FloorWallS.png"));
    private Image wallNorthImage = new Image(getClass().getResourceAsStream("Images\\MapElements\\FloorWallN.png"));
    private Image wallNEImage = new Image(getClass().getResourceAsStream("Images\\MapElements\\FloorWallNE.png"));
    private Image wallNWImage = new Image(getClass().getResourceAsStream("Images\\MapElements\\FloorWallNW.png"));
    private Image wallSEImage = new Image(getClass().getResourceAsStream("Images\\MapElements\\FloorWallSE.png"));
    private Image wallSWImage = new Image(getClass().getResourceAsStream("Images\\MapElements\\FloorWallSW.png"));
    private Image wallVertical = new Image(getClass().getResourceAsStream("Images\\MapElements\\FloorWallVert.png"));
    private Image wallHorizontal = new Image(getClass().getResourceAsStream("Images\\MapElements\\FloorWallHoriz.png"));
    private Image doorVertical = new Image(getClass().getResourceAsStream("Images\\MapElements\\DoorVertical.png"));
    private Image doorHorizontal = new Image(getClass().getResourceAsStream("Images\\MapElements\\DoorHorizontal.png"));
    private Image openedDoorVertical = new Image(getClass().getResourceAsStream("Images\\MapElements\\OpenedDoorVertical.png"));
    private Image openedDoorHorizontal = new Image(getClass().getResourceAsStream("Images\\MapElements\\OpenedDoorHorizontal.png"));
    private List<Hero> heroList;
    private DungeonMap dungeonMap = new DungeonMap(heroList);
    private int currentlyActiveHeroID;
    private boolean hasTheCharacterBeenSelected = false;
    private int numberOfHeroesThatFinishedMovement;
    private ScrollPane dungeonConsole = new ScrollPane();
    private List<HeroPower> currentPower = new ArrayList<>();
    private ScrollPane mapScrollPane = new ScrollPane();
    private EncounterCalculator encounterCalculator = new EncounterCalculator();
    private List<Monster> possibleMonsterTypes = encounterCalculator.getTheListOfPossibleMonsters();
    private List<Monster> allMonstersList = dungeonMap.getAllMonstersList();
    private List<Button> listOfHeroButtons = new ArrayList<>();


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
        dungeonConsole.setContent(dungeonConsoleText);
        mapOuterPane.setCenter(mapScrollPane);
        mapScrollPane.setContent(mapGridPane);
        Button returnToMainMenu = new Button();
        returnToMainMenu.setText("Return to Main Menu");
        mapGridPane.add(returnToMainMenu, 0, mapHeight + 1, 3, 3);
        returnToMainMenu.setOnAction(event -> returnToMainMenu());
        dungeonMap.setHeroList(heroList);
        getDungeonMap().drawAMap();
        updateGUIAccordingToMap(getDungeonMap());
    }

    //todo lock the possibility of attacking when no power is selected.

    /*todo add messages to console:
     CURRENTLY SELECTED POWER:
    ...
     */

    //todo in future, change the portraits, so that each hero has a bigger portrait on the right and small icon on the field.

    //todo add an initiative tracker for all heroes and monsters (over the console?).

    //todo Add HPBars to portraits

    //todo add a movement animation, so that the movement is more clear.

    //todo a method that identifies a flanking position. ?Maybe in pathfinder class?

    private void manageTheConsoleAdding() {
        powersHBox.setStyle("-fx-background-color:grey;");
        powersHBox.setMinSize(200, 40);
        Button equipmentButton = addViewEquipmentButton();
        Button viewDungeon = new Button();
        viewDungeon.setOnAction(event -> viewMapEvent());
        viewDungeon.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("Images/DungeonView.jpg"))));
        consoleButtons.getChildren().add(viewDungeon);
        consoleButtons.getChildren().add(equipmentButton);
        for (Hero hero : heroList) {
            Button heroButton = new Button();
            heroButton.setId(String.valueOf(hero.getID()));
            heroButton.setGraphic(new ImageView(hero.getHeroIcon()));
            heroButton.setOnAction(event -> buttonEvent(heroButton, hero.getMapXPos(), hero.getMapYPos()));
            listOfHeroButtons.add(heroButton);
        }
        portraitsVBox.getChildren().addAll(listOfHeroButtons);
        mapOuterPane.setRight(portraitsVBox);
        completeConsole.add(dungeonConsole, 0, 0);
        mapOuterPane.setLeft(consoleButtons);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        completeConsole.setMinHeight(120);
        completeConsole.setMinHeight(120);
        dungeonConsole.setPrefWidth(primaryScreenBounds.getWidth());
        dungeonConsole.setMinHeight(60);
        dungeonConsole.setMaxHeight(60);
        dungeonConsole.setFitToWidth(false);
        completeConsole.add(powersHBox, 0, 2);
        mapOuterPane.setBottom(completeConsole);
    }

    private void viewMapEvent() {
        mapOuterPane.setCenter(mapScrollPane);
        for (Button heroButton : listOfHeroButtons) {
            int thisButtonID = Integer.valueOf(heroButton.getId());
            Hero currentHero = getHeroByID(thisButtonID, heroList);
            heroButton.setOnAction(event -> buttonEvent(heroButton, currentHero.getMapXPos(), currentHero.getMapYPos()));
        }
    }

    //todo the left and right panes have to read the stylesheets correctly.

    private Button addViewEquipmentButton() {
        Button equipmentButton = new Button();
        equipmentButton.setOnAction(event -> {
            try {
                showCurrentCharactersEquipment(getCurrentlyActiveHeroID());
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            } finally {
                for (Button heroButton : listOfHeroButtons) {
                    heroButton.setOnAction(innerEvent -> {
                        try {
                            int heroId = Integer.valueOf(heroButton.getId());
                            showCurrentCharactersEquipment(heroId);
                        } catch (IOException | SQLException e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        });
        Image eqIcon = new Image(getClass().getResourceAsStream("Images/Equipment.jpg"));
        ImageView eqIconView = new ImageView(eqIcon);
        equipmentButton.setGraphic(eqIconView);
        return equipmentButton;
    }

    //todo add the character's sheet view

    private void showCurrentCharactersEquipment(int currentlyActiveHeroID) throws IOException, SQLException {
        Hero currentHero = getHeroByID(currentlyActiveHeroID, heroList);
        ItemsDAO itemsDAO = new ItemsDAO();
        currentHero.setHeroEquipment(itemsDAO.getHeroEquipmentByHeroID(currentHero.getID()));
        EquipmentGUI equipmentGUI = new EquipmentGUI();
        mapOuterPane.setCenter(equipmentGUI.displayAChosenHeroEquipment(currentHero));
//        equipmentGUI.aStage = Main.getPrimaryStage();
//        equipmentGUI.aStage.setScene(equipmentGUI.aScene);
//        equipmentGUI.aStage.show();
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
            powersHBox.getChildren().add(powerButton);
            powerButton.setOnAction(event -> eventOnPowerSelect(currentHero, currentPower));

        }
        for (HeroPower currentPower : currentHero.getEncounterPowers()) {
            Button powerButton = new Button(currentPower.getPowerName());
            powerButton.setMinWidth(130);
            powerButton.setStyle("-fx-background-color: #910000;");
            powerButton.setTextFill(Color.WHITE);
            powersHBox.getChildren().add(powerButton);
            powerButton.setOnAction(event -> eventOnPowerSelect(currentHero, currentPower));
        }
        for (HeroPower currentPower : currentHero.getDailyPowers()) {
            Button powerButton = new Button(currentPower.getPowerName());
            powerButton.setMinWidth(130);
            powerButton.setStyle("-fx-background-color: #5c005e;");
            powerButton.setTextFill(Color.WHITE);
            powersHBox.getChildren().add(powerButton);
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

    private Monster getMonsterTypeByID(int ID, List<Monster> listOfMonsters) {
        Monster returnedMonster = new Monster();
        for (Monster aMonster : listOfMonsters) {
            if (aMonster.getID() == ID) {
                return aMonster;
            }
        }
        return returnedMonster;
    }

    private Monster getSingleMonsterByUniqueID(int uniqueID, List<Monster> listOfMonsters) {
        Monster returnedMonster = new Monster();
        for (Monster aMonster : listOfMonsters) {
            if (aMonster.getCurrentMonsterUniqueID() == uniqueID) {
                return aMonster;
            }
        }
        return returnedMonster;
    }

    private void updateGUIAccordingToMap(DungeonMap dungeonMap) {
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {
                Button aButton = new Button();
/*                aButton.setStyle(".button {-fx-padding: 0 0 0 0};");
                aButton.setStyle(".button {-fx-background-radius: 0,0,0;}");
                aButton.setStyle(".button {-fx-background-insets: 0,0,0;}");*/
                aButton.setPadding(new Insets(1));
                aButton.setMaxSize(50, 50);
                aButton.setStyle("-fx-background-radius: 0");
                buttonGrid[i][j] = aButton;
                int finalJ = j;
                int finalI = i;
                aButton.setOnAction(actionEvent -> buttonEvent(aButton, finalI, finalJ));
                mapGridPane.add(aButton, j, i);
            }
        }
        updateMapGraphics(dungeonMap);
    }
    //todo change the monster portrait after it being bloodied and/or killed (try BufferedImages)

    //todo change the visibility checker, so it actually checks for visibility.

    private void updateMapGraphics(DungeonMap dungeonMap) {
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {
                int currentEntityID = dungeonMap.getMapTilesArray()[i][j].getOccupyingCreatureTypeId();
                String typeOfTile;
                typeOfTile = dungeonMap.getMapTilesArray()[i][j].typeOfTile;
                //debug mode only - make the whole dungeonMap alreadyDiscovered:
                //dungeonMap.getMapTilesArray()[i][j].alreadyDiscovered = true;
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
        int currentHeroID = getDungeonMap().getMapTilesArray()[XPos][YPos].getOccupyingCreatureTypeId();
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

    //todo attacking a monster now subtracts HP from all monsters of this type.

    private void eventOnHeroAttackingAMonster(int XPos, int YPos, HeroPower attackingPower) {
        Hero hero = getHeroByID(getCurrentlyActiveHeroID(), heroList);
        System.out.println("Attacking a monster with unique ID: " + getDungeonMap().getMapTilesArray()[XPos][YPos].getOccupyingCreatureUniqueID());
        Monster monster = getSingleMonsterByUniqueID(getDungeonMap().getMapTilesArray()[XPos][YPos].getOccupyingCreatureUniqueID(), allMonstersList);
        System.out.println("LIST OF ALL MONSTERS:");
        for (Monster currentMonster : allMonstersList) {
            System.out.println(currentMonster.getMonsterName());
            System.out.println(currentMonster.getID());
            System.out.println(currentMonster.getCurrentMonsterUniqueID());
        }
        System.out.println("ID From Tile: " + getDungeonMap().getMapTilesArray()[XPos][YPos].getOccupyingCreatureUniqueID());
        Map<String, Integer> attackResults = hero.attackAMonster(monster, attackingPower);
        displayAttackMessage(attackingPower, monster, attackResults);
        if ((attackResults.get("Attribute Bonus") + attackResults.get("Dice Roll")) >
                monster.getDefensesMap().get(attackingPower.getDefenseToBeChecked().toLowerCase())) {
            triggerOnHit(attackingPower, hero, attackResults);
            inflictDamageToMonster(attackResults, monster);
        } else {
            updateTheDungeonConsole("Your attack has missed.");
        }
    }

    private void inflictDamageToMonster(Map<String, Integer> attackResults, Monster monster) {
        int damageDealt = attackResults.get("Damage Inflicted");
        monster.setCurrentHitPoints(monster.getCurrentHitPoints() - damageDealt);
        System.out.println("DEBUG: " + monster.getHitPoints() + " HP");
        System.out.println("DEBUG: " + monster.getCurrentHitPoints() + " HP");
        System.out.println("DEBUG: " + monster.getID() + " ID");
        if (monster.getCurrentHitPoints() < 1) {
            updateTheDungeonConsole("The attacked monster - " + monster.getMonsterName() + " - has fallen!");
        } else if (monster.getCurrentHitPoints() * 2 < monster.getHitPoints()) {
            updateTheDungeonConsole("The attacked monster - " + monster.getMonsterName() + " - is now bloodied.");
        }
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
        updateTheDungeonConsole("It's a hit! Roll for damage: "
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
        updateTheDungeonConsole("Result of damage dice rolls: "
                + diceDealt
                + ". Bonus damage equal to your "
                + attackingPower.getDamageModifier()
                + ": "
                + attackResults.get("Attribute Bonus"));
        updateTheDungeonConsole("You've dealt " + allDamage + " damage");
        attackResults.put("Damage Inflicted", allDamage);
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

    private void eventOnReachableTileClick() {
        getDungeonMap().clearMapReachableProperties(getDungeonMap());
        updateMapGraphics(getDungeonMap());
        setHasTheCharacterBeenSelected(false);
        powersHBox.getChildren().clear();
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
        PathFinder pathFinder = new PathFinder();
        Hero hero = getHeroByID(getCurrentlyActiveHeroID(), heroList);
        getDungeonMap().getMapTilesArray()[hero.getMapXPos()][hero.getMapYPos()].setOccupyingCreatureTypeId(0);
        getDungeonMap().getMapTilesArray()[XPos][YPos].setOccupyingCreatureTypeId(getCurrentlyActiveHeroID());
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
        pathFinder.checkTheVisibilityRange(hero, dungeonMap);
    }

    private void eventOnPowerSelect(Hero currentHero, HeroPower selectedPower) {
        PathFinder pathFinder = new PathFinder();
        currentPower.clear();
        currentPower.add(selectedPower);
        pathFinder.checkTheLineOfSight(dungeonMap, buttonGrid, currentHero);
    }


    private void applyEntityIconToAButton(int heroID, Button aButton) {
        if (heroID < 100) {
            aButton.setGraphic(new ImageView(getHeroByID(heroID, heroList).getHeroIcon()));
        } else {
            aButton.setGraphic(new ImageView(getMonsterTypeByID(heroID, possibleMonsterTypes).getMonsterImage()));
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

    //todo add a button to console that could extend its view range or minimize it.
    //todo visibility checker has to stop on walls


}
