package DungeonCrawl.GUI;

import DungeonCrawl.GUI.Images.SkillIcons.SkillIcons;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import DungeonCrawl.*;
import DungeonCrawl.DAO.ItemsDAO;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.Model.*;
import DungeonCrawl.Model.Monster;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class DungeonGUI {

    private MainMenuGUI mainMenuGUI = new MainMenuGUI();
    private int mapWidth = 40;
    private int mapHeight = 40;
    private Button[][] buttonGrid = new Button[mapWidth][mapHeight];
    private GridPane mapGridPane = new GridPane();
    private HBox powersHBox = new HBox();
    private VBox portraitsVBox = new VBox();
    private VBox controlsButtons = new VBox();
    BorderPane mapOuterPane = new BorderPane();
    private DungeonImageLibraryGUI dungeonImageLibraryGUI = new DungeonImageLibraryGUI();
    private List<HeroPower> currentPower = new ArrayList<>();
    private ScrollPane mapScrollPane = new ScrollPane();
    private List<Button> listOfHeroButtons = new ArrayList<>();
    private HeroManager heroManager = new HeroManager();
    private GUIUtilities guiUtilities = new GUIUtilities();
    private PathFinder pathFinder = new PathFinder();
    private EncounterManager encounterManager = new EncounterManager(heroManager, buttonGrid, pathFinder);
    private int currentCreatureInitiative = 0;


    DungeonGUI(List<Hero> heroList) {

        heroManager.setHeroList(heroList);
        manageTheConsoleAdding();
        pathFinder.dungeonConsoleGUI.getDungeonConsole().setContent(pathFinder.dungeonConsoleGUI.getDungeonConsoleText());
        mapOuterPane.setCenter(mapScrollPane);
        mapScrollPane.setContent(mapGridPane);
        Button returnToMainMenu = new Button();
        returnToMainMenu.setText("Return to Main Menu");
        mapGridPane.add(returnToMainMenu, 0, mapHeight + 1, 3, 3);
        returnToMainMenu.setOnAction(event -> returnToMainMenu());
        encounterManager.getDungeonMap().setHeroList(heroList);
        encounterManager.getDungeonMap().drawAMap();
        updateGUIAccordingToMap(encounterManager.getDungeonMap());
    }

    //todo lock the possibility of attacking when no power is selected.

    //todo lock encounter powers on use until the end of encounter. Lock daily powers on use once every 3 encounters.

    /*todo add messages to console:
     CURRENTLY SELECTED POWER:
    ...
     */

    //todo in future, change the portraits, so that each hero has a bigger portrait on the right and small icon on the field.

    //todo Hero portraits to turn red with damage taken.

    //todo add a movement animation, so that the movement is more clear.

    //todo a method that identifies a flanking position. ?Maybe in pathfinder class?

    private void manageTheConsoleAdding() {
        powersHBox.setStyle("-fx-background-color:grey;");
        powersHBox.setMinSize(200, 110);
        Button equipmentButton = addViewEquipmentButton();
        Button viewDungeon = new Button();
        viewDungeon.setOnAction(event -> viewMapEvent());
        viewDungeon.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("Images/DungeonView.jpg"))));
        controlsButtons.getChildren().add(viewDungeon);
        controlsButtons.getChildren().add(equipmentButton);
        for (Hero hero : heroManager.getHeroList()) {
            Button heroButton = new Button();
            heroButton.setId(String.valueOf(hero.getID()));
            heroButton.setGraphic(new ImageView(hero.getCreatureImage()));
            heroButton.setOnAction(event -> buttonEvent(hero.getMapXPos(), hero.getMapYPos()));
            listOfHeroButtons.add(heroButton);
        }
        portraitsVBox.getChildren().addAll(listOfHeroButtons);
        mapOuterPane.setRight(portraitsVBox);
        mapOuterPane.setLeft(controlsButtons);
        pathFinder.dungeonConsoleGUI.getCompleteConsole().add(powersHBox, 0, 2);
        mapOuterPane.setBottom(pathFinder.dungeonConsoleGUI.getCompleteConsole());
    }

    private void viewMapEvent() {
        mapOuterPane.setCenter(mapScrollPane);
        for (Button heroButton : listOfHeroButtons) {
            int thisButtonID = Integer.valueOf(heroButton.getId());
            Hero currentHero = guiUtilities.getHeroByID(thisButtonID, heroManager.getHeroList());
            heroButton.setOnAction(event -> buttonEvent(currentHero.getMapXPos(), currentHero.getMapYPos()));
        }
    }

    //todo the left and right panes have to read the stylesheets correctly.

    private Button addViewEquipmentButton() {
        Button equipmentButton = new Button();
        equipmentButton.setOnAction(event -> {
            try {
                showCurrentCharactersEquipment(heroManager.getCurrentlyActiveHeroID());
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
        Hero currentHero = guiUtilities.getHeroByID(currentlyActiveHeroID, heroManager.getHeroList());
        ItemsDAO itemsDAO = new ItemsDAO();
        currentHero.setHeroEquipment(itemsDAO.getHeroEquipmentByHeroID(currentHero.getID()));
        EquipmentGUI equipmentGUI = new EquipmentGUI();
        mapOuterPane.setCenter(equipmentGUI.displayAChosenHeroEquipment(currentHero));
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

    //todo change the updating so that it doesn't do anything for tiles with walls and/or pillars
    private void updateGUIAccordingToMap(DungeonMap dungeonMap) {
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {
                Button aButton = new Button();
                aButton.setPadding(new Insets(2));
                aButton.setMaxSize(50, 50);
                aButton.setStyle("-fx-background-radius: 0");
                buttonGrid[i][j] = aButton;
                int finalJ = j;
                int finalI = i;
                aButton.setOnAction(actionEvent -> buttonEvent(finalI, finalJ));
                aButton.setOnMouseEntered(event -> changeTheCursorOnHover(finalI, finalJ));
                mapGridPane.add(aButton, j, i);
            }
        }
        updateMapGraphics(dungeonMap);
    }

    private void changeTheCursorOnHover(int XPos, int YPos) {
        Image mapCursor = new Image("DungeonCrawl/GUI/Images/Cursors/WalkingCursor.png");
        Image lockCursor = new Image("DungeonCrawl/GUI/Images/Cursors/Lock.png");
        Image swordCursor = new Image("DungeonCrawl/GUI/Images/Cursors/Sword.png");
        //Image Cursor = new Image("DungeonCrawl/GUI/Images/Cursors/WalkingCursor.png");
        String currentTypeOfTile = encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].getTypeOfTile();
        boolean inWalkRange = encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].isInWalkRange();
        int occupyingMonsterID = encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].getOccupyingCreatureTypeId();
        boolean isTheTileInteractive = encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].isWithinInteractionRange();
        if (isTheTileInteractive && occupyingMonsterID > 100) {
            changeTheCursor(swordCursor, false);
        } else if (inWalkRange) {
            changeTheCursor(mapCursor, false);
        } else {
            changeTheCursor(null, true);
        }
        if (currentTypeOfTile.contains("Door")) {
            changeTheCursor(lockCursor, false);
        }
    }


    private void changeTheCursor(Image image, boolean backToDefault) {
        if (backToDefault) {
            mapOuterPane.setCursor(Cursor.DEFAULT);
        } else {
            mapOuterPane.setCursor(new ImageCursor(image));
            System.out.println("Changing the cursor");
        }
    }
    //todo change the monster portrait after it being bloodied


    private void updateMapGraphics(DungeonMap dungeonMap) {
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {
                int currentEntityID = dungeonMap.getMapTilesArray()[i][j].getOccupyingCreatureTypeId();
                String typeOfTile;
                typeOfTile = dungeonMap.getMapTilesArray()[i][j].typeOfTile;
                //debug mode only - make the whole dungeonMap alreadyDiscovered:
                //dungeonMap.getMapTilesArray()[i][j].alreadyDiscovered = true;
                dungeonImageLibraryGUI.applyATileImageToAButton(typeOfTile, buttonGrid[i][j]);
                if (currentEntityID > 0) {
                    applyEntityIconToAButton(currentEntityID, buttonGrid[i][j], dungeonMap.getMapTilesArray()[i][j].getOccupyingCreatureUniqueID());
                }
                if (!dungeonMap.getMapTilesArray()[i][j].alreadyDiscovered) {
                    dungeonImageLibraryGUI.applyATileImageToAButton("Fog", buttonGrid[i][j]);
                }
            }
        }
    }


    private void returnToMainMenu() {
        mainMenuGUI.aStage = Main.getPrimaryStage();
        mainMenuGUI.aStage.setScene(mainMenuGUI.aScene);
        mainMenuGUI.aStage.show();
        System.out.println("Stage is closing");
    }

    //todo animated popup with damage value and fadeout

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

    private ImageView addDeathImageToCreatureImage(Creature creature) {
        Image skull = new Image(
                "DungeonCrawl/GUI/Images/MapElements/Skull.jpg"
        );
        Image monsterImage = creature.getCreatureImage();
        ImageInput backImageView = new ImageInput(monsterImage);
        ImageInput frontImageView = new ImageInput(skull);
        Blend imagesBlend = new Blend();
        imagesBlend.setBottomInput(backImageView);
        imagesBlend.setTopInput(frontImageView);
        imagesBlend.setMode(BlendMode.ADD);
        ImageView finalImageView = new ImageView(monsterImage);
        finalImageView.setEffect(imagesBlend);
        return finalImageView;
    }

    private void buttonEvent(int XPos, int YPos) {
        String currentTypeOfTile = encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].getTypeOfTile();
        int currentHeroID = encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].getOccupyingCreatureTypeId();
        boolean isTheTileInteractive = encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].isWithinInteractionRange();
        if (encounterManager.isHasTheCharacterBeenSelected() && currentHeroID > 0) {
            eventOnReachableTileClick();
        }
        if (currentHeroID > 0 && currentHeroID < 100) {
            encounterManager.eventOnHeroClick(currentHeroID);
            heroClickAnimation(buttonGrid[XPos][YPos]);
            updateButtonsWithSkillIcons(guiUtilities.getHeroByID(currentHeroID, heroManager.getHeroList()));
            isTheTileInteractive = encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].isWithinInteractionRange();
        } else if (encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].isInWalkRange()) {
            if (currentTypeOfTile.contains("Closed") && encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].isWithinInteractionRange()) {
                encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].setTypeOfTile(encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].getTypeOfTile().replaceFirst("Closed", "Opened"));
            } else if (!currentTypeOfTile.contains("Closed")) {
                eventOnHeroMovement(XPos, YPos);
            }
            //debug animation tinkering
            updateMapGraphics(encounterManager.getDungeonMap());
            encounterManager.getDungeonMap().clearMapReachableProperties(encounterManager.getDungeonMap());
        }
        if (currentHeroID > 100 && isTheTileInteractive) {
            try {
                Monster monster = guiUtilities.getSingleMonsterByUniqueID(encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].getOccupyingCreatureUniqueID(), encounterManager.getAllMonstersList());
                String hitResult = encounterManager.eventOnHeroAttackingAMonster(XPos, YPos, currentPower.get(currentPower.size() - 1));
                if (hitResult.contains("Hit")) {
                    creatureWasHitAnimation(buttonGrid[XPos][YPos]);
                } else if (hitResult.contains("Miss")) {
                    creatureWasMissedAnimation(buttonGrid[XPos][YPos]);
                } else if (hitResult.contains("Dead")) {
                    addDeathImageToCreatureImage(monster);
                    buttonGrid[monster.getMapXPos()][monster.getMapYPos()].setGraphic(addDeathImageToCreatureImage(monster));
                }
            } catch (IndexOutOfBoundsException e) {
                pathFinder.dungeonConsoleGUI.updateTheDungeonConsole("Please select a power before attacking");
            }
        }
    }

    private void heroClickAnimation(Button button) {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(180), button.getGraphic());
        scaleTransition.setByX(-0.1f);
        scaleTransition.setByY(-0.1f);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);
        System.out.println("heroClickAnimation Triggered");
        scaleTransition.play();
    }

    private void creatureWasHitAnimation(Button button) {
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(180), button.getGraphic());
        rotateTransition.setByAngle(30);
        rotateTransition.setCycleCount(2);
        rotateTransition.setAutoReverse(true);

        rotateTransition.play();
    }

    private void creatureWasMissedAnimation(Button button) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(180), button.getGraphic());
        translateTransition.setByX(10);
        translateTransition.setCycleCount(2);
        translateTransition.setAutoReverse(true);
        translateTransition.play();
    }

/*    private void walkingAnimation(int startingXPosition, int startingYPosition, int endXPosition, int endYPosition) {
        Button button = buttonGrid[startingXPosition][startingYPosition];
        button.toFront();
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(300), button.getGraphic());
        System.out.println("Walking Animation Triggered. " + (endXPosition - startingXPosition) + "   " + (endYPosition - startingYPosition));
        int yMovement = (endXPosition - startingXPosition) * 50;
        int xMovement = (endYPosition - startingYPosition) * 50;
        translateTransition.setByX(xMovement);
        translateTransition.setByY(yMovement);
        System.out.println("Animation transition values: " + xMovement + " " + yMovement);
        System.out.println("Animation graphic: " + button.getGraphic());
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(false);
        translateTransition.setOnFinished(e -> updateMapGraphics(getDungeonMap()));
        translateTransition.play();
    }*/

    private void eventOnReachableTileClick() {
        encounterManager.getDungeonMap().clearMapReachableProperties(encounterManager.getDungeonMap());
        updateMapGraphics(encounterManager.getDungeonMap());
        encounterManager.setHasTheCharacterBeenSelected(false);
        powersHBox.getChildren().clear();
    }


    //todo change the logic of the buttons, so that Hero class has a Button field with the ready methods and the button objects are placed after moving

    private void eventOnHeroMovement(int XPos, int YPos) {

        Hero hero = guiUtilities.getHeroByID(heroManager.getCurrentlyActiveHeroID(), heroManager.getHeroList());
        encounterManager.getDungeonMap().getMapTilesArray()[hero.getMapXPos()][hero.getMapYPos()].setOccupyingCreatureTypeId(0);
        encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].setOccupyingCreatureTypeId(heroManager.getCurrentlyActiveHeroID());
        int deltaX = Math.abs(hero.getMapXPos() - XPos);
        int deltaY = Math.abs(hero.getMapYPos() - YPos);
        hero.setCurrentSpeed(hero.getCurrentSpeed() - (deltaX + deltaY));
        hero.setMapXPos(XPos);
        hero.setMapYPos(YPos);
        if (hero.getCurrentSpeed() < 1) {
            heroManager.setNumberOfHeroesThatFinishedMovement(heroManager.getNumberOfHeroesThatFinishedMovement() + 1);
            System.out.println(hero.heroName + " has finished moving. " + heroManager.getNumberOfHeroesThatFinishedMovement() + " heroes had already finished moving");
            if (encounterManager.isFightAlreadyTakingPlace()) {
                currentCreatureInitiative++;
                lockAllInactiveHeroButtons();
            }
            if (heroManager.getNumberOfHeroesThatFinishedMovement() == heroManager.getHeroList().size()) {
                for (Hero currentHero : heroManager.getHeroList()) {
                    currentHero.setCurrentSpeed(currentHero.getSpeed());
                    System.out.println("Resetting the movement points for " + currentHero.heroName);
                    currentCreatureInitiative = 0;
                }
                heroManager.setNumberOfHeroesThatFinishedMovement(0);
            }
        }
        if (!encounterManager.isFightAlreadyTakingPlace()) {
            resetAllHeroesSpeedToMax();
            encounterManager.setFightAlreadyTakingPlace(pathFinder.checkTheVisibilityRange(encounterManager.getAllMonstersList(), heroManager.getHeroList(), hero, encounterManager.getDungeonMap(), encounterManager.isFightAlreadyTakingPlace()));
        }
        pathFinder.dungeonConsoleGUI.getInitiativeTracker().setContent(pathFinder.dungeonConsoleGUI.getInitiativeTilePane());
        if (encounterManager.isFightAlreadyTakingPlace()) {
            lockAllInactiveHeroButtons();
        }
        //walkingAnimation(oldHeroXPos, oldHeroYPos, XPos, YPos);
    }

    private void resetAllHeroesSpeedToMax() {
        for (Hero hero : heroManager.getHeroList()) {
            hero.setCurrentSpeed(hero.getSpeed());
        }
    }

    private void eventOnPowerSelect(Hero currentHero, HeroPower selectedPower) {
        PathFinder pathFinder = new PathFinder();
        currentHero.setAttackRange(selectedPower.getRange());
        currentPower.clear();
        currentPower.add(selectedPower);
        pathFinder.checkTheLineOfSight(encounterManager.getDungeonMap(), buttonGrid, currentHero);
        pathFinder.checkTheAvailableDistance(currentHero, encounterManager.getDungeonMap(), buttonGrid, "Attack Range");
    }


    private void applyEntityIconToAButton(int heroID, Button aButton, int uniqueMonsterID) {
        if (heroID < 100) {
            aButton.setGraphic(new ImageView(guiUtilities.getHeroByID(heroID, heroManager.getHeroList()).getCreatureImage()));
        } else {
            Monster monster = guiUtilities.getSingleMonsterByUniqueID(uniqueMonsterID, encounterManager.getAllMonstersList());
            if (!monster.isThisCreatureDead()) {
                aButton.setGraphic(new ImageView(monster.getCreatureImage()));
            } else {
                aButton.setGraphic(addDeathImageToCreatureImage(monster));
            }
        }
    }
//todo add a button to console that could extend its view range or minimize it.


}




