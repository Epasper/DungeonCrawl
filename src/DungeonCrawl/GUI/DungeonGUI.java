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
    private VBox controlsButtons = new VBox();
    BorderPane mapOuterPane = new BorderPane();
    private DungeonImageLibraryGUI dungeonImageLibraryGUI = new DungeonImageLibraryGUI();
    private DungeonMap dungeonMap = new DungeonMap(null);
    private boolean hasTheCharacterBeenSelected = false;
    private List<HeroPower> currentPower = new ArrayList<>();
    private ScrollPane mapScrollPane = new ScrollPane();
    private EncounterCalculator encounterCalculator = new EncounterCalculator();
    private List<Monster> possibleMonsterTypes = encounterCalculator.getTheListOfPossibleMonsters();
    private List<Monster> allMonstersList = dungeonMap.getAllMonstersList();
    private List<Button> listOfHeroButtons = new ArrayList<>();
    private HeroManager heroManager = new HeroManager();
    private GUIUtilities guiUtilities = new GUIUtilities();
    private PathFinder pathFinder = new PathFinder();
    private EncounterManager encounterManager = new EncounterManager(heroManager, buttonGrid, pathFinder);
    private int currentCreatureInitiative = 0;

    private DungeonMap getDungeonMap() {
        return dungeonMap;
    }

    private boolean isHasTheCharacterBeenSelected() {
        return hasTheCharacterBeenSelected;
    }

    private void setHasTheCharacterBeenSelected(boolean hasTheCharacterBeenSelected) {
        this.hasTheCharacterBeenSelected = hasTheCharacterBeenSelected;
    }

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
        dungeonMap.setHeroList(heroList);
        getDungeonMap().drawAMap();
        updateGUIAccordingToMap(getDungeonMap());
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
            //powerButton.setMinWidth(130);
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
            //powerButton.setMinWidth(130);
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
            //powerButton.setMinWidth(130);
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
        String currentTypeOfTile = getDungeonMap().getMapTilesArray()[XPos][YPos].getTypeOfTile();
        boolean inWalkRange = getDungeonMap().getMapTilesArray()[XPos][YPos].isInWalkRange();
        int occupyingMonsterID = getDungeonMap().getMapTilesArray()[XPos][YPos].getOccupyingCreatureTypeId();
        boolean isTheTileInteractive = getDungeonMap().getMapTilesArray()[XPos][YPos].isWithinInteractionRange();
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

    private void buttonEvent(int XPos, int YPos) {
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
                eventOnHeroMovement(XPos, YPos);
            }
            //debug animation tinkering
            updateMapGraphics(getDungeonMap());
            getDungeonMap().clearMapReachableProperties(getDungeonMap());
        }
        if (currentHeroID > 100 && isTheTileInteractive) {
            try {
                eventOnHeroAttackingAMonster(XPos, YPos, currentPower.get(currentPower.size() - 1));
            } catch (IndexOutOfBoundsException e) {
                pathFinder.dungeonConsoleGUI.updateTheDungeonConsole("Please select a power before attacking");
            }
        }
    }

    private void returnToMainMenu() {
        mainMenuGUI.aStage = Main.getPrimaryStage();
        mainMenuGUI.aStage.setScene(mainMenuGUI.aScene);
        mainMenuGUI.aStage.show();
        System.out.println("Stage is closing");
    }

    private void eventOnHeroAttackingAMonster(int XPos, int YPos, HeroPower attackingPower) {
        Hero hero = guiUtilities.getHeroByID(heroManager.getCurrentlyActiveHeroID(), heroManager.getHeroList());
        System.out.println("Attacking a monster with unique ID: " + getDungeonMap().getMapTilesArray()[XPos][YPos].getOccupyingCreatureUniqueID());
        Monster monster = guiUtilities.getSingleMonsterByUniqueID(getDungeonMap().getMapTilesArray()[XPos][YPos].getOccupyingCreatureUniqueID(), allMonstersList);
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
            creatureWasHitAnimation(buttonGrid[monster.getMapXPos()][monster.getMapYPos()]);
        } else {
            pathFinder.dungeonConsoleGUI.updateTheDungeonConsole("Your attack has missed.");
            creatureWasMissedAnimation(buttonGrid[monster.getMapXPos()][monster.getMapYPos()]);
        }
    }

    private void inflictDamageToMonster(Map<String, Integer> attackResults, Monster monster) {
        int damageDealt = attackResults.get("Damage Inflicted");
        monster.setCurrentHitPoints(monster.getCurrentHitPoints() - damageDealt);
        System.out.println("DEBUG: " + monster.getHitPoints() + " HP");
        System.out.println("DEBUG: " + monster.getCurrentHitPoints() + " HP");
        System.out.println("DEBUG: " + monster.getID() + " ID");
        if (monster.getCurrentHitPoints() < 1) {
            pathFinder.dungeonConsoleGUI.updateTheDungeonConsole("The attacked monster - " + monster.getMonsterName() + " - has fallen!");
            eventOnMonsterDeath(monster);
        } else if (monster.getCurrentHitPoints() * 2 < monster.getHitPoints()) {
            pathFinder.dungeonConsoleGUI.updateTheDungeonConsole("The attacked monster - " + monster.getMonsterName() + " - is now bloodied.");
        }
    }

    private void eventOnMonsterDeath(Monster monster) {
        buttonGrid[monster.getMapXPos()][monster.getMapYPos()].setGraphic(addDeathImageToCreatureImage(monster));
        addDeathImageToCreatureImage(monster);
        monster.setThisCreatureDead(true);
        System.out.println("Image has been modified");
        encounterManager.checkIfAllCreaturesInRoomAreDead();
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
        pathFinder.dungeonConsoleGUI.updateTheDungeonConsole("It's a hit! Roll for damage: "
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
        pathFinder.dungeonConsoleGUI.updateTheDungeonConsole("Result of damage dice rolls: "
                + diceDealt
                + ". Bonus damage equal to your "
                + attackingPower.getDamageModifier()
                + ": "
                + attackResults.get("Attribute Bonus"));
        pathFinder.dungeonConsoleGUI.updateTheDungeonConsole("You've dealt " + allDamage + " damage");
        attackResults.put("Damage Inflicted", allDamage);
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

    private void displayAttackMessage(HeroPower attackingPower, Monster monster, Map attackResults) {
        pathFinder.dungeonConsoleGUI.updateTheDungeonConsole("You have attacked a " +
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
        //PathFinder pathFinder = new PathFinder();
        Hero currentHero = guiUtilities.getHeroByID(currentHeroID, heroManager.getHeroList());
        pathFinder.checkTheAvailableDistance(currentHero, dungeonMap, buttonGrid, "Available Distance");
        heroClickAnimation(buttonGrid[currentHero.getMapXPos()][currentHero.getMapYPos()]);
        System.out.println("Clicked the ID " + currentHeroID + " hero.");
        heroManager.setCurrentlyActiveHeroID(currentHeroID);
        setHasTheCharacterBeenSelected(true);
        updateButtonsWithSkillIcons(guiUtilities.getHeroByID(currentHeroID, heroManager.getHeroList()));
        pathFinder.dungeonConsoleGUI.updateTheDungeonConsole("You have selected " + currentHero.getHeroName());
    }

    //todo change the logic of the buttons, so that Hero class has a Button field with the ready methods and the button objects are placed after moving

    private void eventOnHeroMovement(int XPos, int YPos) {

        Hero hero = guiUtilities.getHeroByID(heroManager.getCurrentlyActiveHeroID(), heroManager.getHeroList());
        getDungeonMap().getMapTilesArray()[hero.getMapXPos()][hero.getMapYPos()].setOccupyingCreatureTypeId(0);
        getDungeonMap().getMapTilesArray()[XPos][YPos].setOccupyingCreatureTypeId(heroManager.getCurrentlyActiveHeroID());
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
            encounterManager.setFightAlreadyTakingPlace(pathFinder.checkTheVisibilityRange(allMonstersList, heroManager.getHeroList(), hero, dungeonMap, encounterManager.isFightAlreadyTakingPlace()));
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
        pathFinder.checkTheLineOfSight(dungeonMap, buttonGrid, currentHero);
        pathFinder.checkTheAvailableDistance(currentHero, dungeonMap, buttonGrid, "Attack Range");
    }


    private void applyEntityIconToAButton(int heroID, Button aButton, int uniqueMonsterID) {
        if (heroID < 100) {
            aButton.setGraphic(new ImageView(guiUtilities.getHeroByID(heroID, heroManager.getHeroList()).getCreatureImage()));
        } else {
            Monster monster = guiUtilities.getSingleMonsterByUniqueID(uniqueMonsterID, allMonstersList);
            if (!monster.isThisCreatureDead()) {
                aButton.setGraphic(new ImageView(monster.getCreatureImage()));
            } else {
                aButton.setGraphic(addDeathImageToCreatureImage(monster));
            }
        }
    }
//todo add a button to console that could extend its view range or minimize it.


}




