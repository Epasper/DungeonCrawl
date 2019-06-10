package DungeonCrawl.GUI;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
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

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
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
    private DungeonConsoleGUI dungeonConsoleGUI = new DungeonConsoleGUI();
    private DungeonImageLibraryGUI dungeonImageLibraryGUI = new DungeonImageLibraryGUI();
    private DungeonMap dungeonMap = new DungeonMap(null);
    private boolean hasTheCharacterBeenSelected = false;
    private List<HeroPower> currentPower = new ArrayList<>();
    private ScrollPane mapScrollPane = new ScrollPane();
    private EncounterCalculator encounterCalculator = new EncounterCalculator();
    private List<Monster> possibleMonsterTypes = encounterCalculator.getTheListOfPossibleMonsters();
    private List<Monster> allMonstersList = dungeonMap.getAllMonstersList();
    private List<Button> listOfHeroButtons = new ArrayList<>();
    private DungeonGUIHeroManager dungeonGUIHeroManager = new DungeonGUIHeroManager();
    private GUIUtilities guiUtilities = new GUIUtilities();
    private boolean fightAlreadyTakingPlace;
    private PathFinder pathFinder = new PathFinder();

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

        dungeonGUIHeroManager.setHeroList(heroList);
        manageTheConsoleAdding();
        dungeonConsoleGUI.getDungeonConsole().setContent(dungeonConsoleGUI.getDungeonConsoleText());
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

    //todo change the power buttons to icons with images. Add image selection to powers on character creation.

    //todo in future, change the portraits, so that each hero has a bigger portrait on the right and small icon on the field.

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
        controlsButtons.getChildren().add(viewDungeon);
        controlsButtons.getChildren().add(equipmentButton);
        for (Hero hero : dungeonGUIHeroManager.getHeroList()) {
            Button heroButton = new Button();
            heroButton.setId(String.valueOf(hero.getID()));
            heroButton.setGraphic(new ImageView(hero.getCreatureImage()));
            heroButton.setOnAction(event -> buttonEvent(heroButton, hero.getMapXPos(), hero.getMapYPos()));
            listOfHeroButtons.add(heroButton);
        }
        portraitsVBox.getChildren().addAll(listOfHeroButtons);
        mapOuterPane.setRight(portraitsVBox);
        mapOuterPane.setLeft(controlsButtons);
        dungeonConsoleGUI.getCompleteConsole().add(powersHBox, 0, 2);
        mapOuterPane.setBottom(dungeonConsoleGUI.getCompleteConsole());
    }

    private void viewMapEvent() {
        mapOuterPane.setCenter(mapScrollPane);
        for (Button heroButton : listOfHeroButtons) {
            int thisButtonID = Integer.valueOf(heroButton.getId());
            Hero currentHero = guiUtilities.getHeroByID(thisButtonID, dungeonGUIHeroManager.getHeroList());
            heroButton.setOnAction(event -> buttonEvent(heroButton, currentHero.getMapXPos(), currentHero.getMapYPos()));
        }
    }

    //todo the left and right panes have to read the stylesheets correctly.

    private Button addViewEquipmentButton() {
        Button equipmentButton = new Button();
        equipmentButton.setOnAction(event -> {
            try {
                showCurrentCharactersEquipment(dungeonGUIHeroManager.getCurrentlyActiveHeroID());
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
        Hero currentHero = guiUtilities.getHeroByID(currentlyActiveHeroID, dungeonGUIHeroManager.getHeroList());
        ItemsDAO itemsDAO = new ItemsDAO();
        currentHero.setHeroEquipment(itemsDAO.getHeroEquipmentByHeroID(currentHero.getID()));
        EquipmentGUI equipmentGUI = new EquipmentGUI();
        mapOuterPane.setCenter(equipmentGUI.displayAChosenHeroEquipment(currentHero));
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


    private void updateGUIAccordingToMap(DungeonMap dungeonMap) {
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {
                Button aButton = new Button();
/*                aButton.setStyle(".button {-fx-padding: 0 0 0 0};");
                aButton.setStyle(".button {-fx-background-radius: 0,0,0;}");
                aButton.setStyle(".button {-fx-background-insets: 0,0,0;}");*/
                aButton.setPadding(new Insets(2));
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
    //todo change the monster portrait after it being bloodied and/or killed (Java Canvas)


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
                    applyEntityIconToAButton(currentEntityID, buttonGrid[i][j]);
                }
                if (!dungeonMap.getMapTilesArray()[i][j].alreadyDiscovered) {
                    dungeonImageLibraryGUI.applyATileImageToAButton("Fog", buttonGrid[i][j]);
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

    private void eventOnHeroAttackingAMonster(int XPos, int YPos, HeroPower attackingPower) {
        Hero hero = guiUtilities.getHeroByID(dungeonGUIHeroManager.getCurrentlyActiveHeroID(), dungeonGUIHeroManager.getHeroList());
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
            try {
                inflictDamageToMonster(attackResults, monster);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            dungeonConsoleGUI.updateTheDungeonConsole("Your attack has missed.");
        }
    }

    private void inflictDamageToMonster(Map<String, Integer> attackResults, Monster monster) throws IOException {
        int damageDealt = attackResults.get("Damage Inflicted");
        monster.setCurrentHitPoints(monster.getCurrentHitPoints() - damageDealt);
        System.out.println("DEBUG: " + monster.getHitPoints() + " HP");
        System.out.println("DEBUG: " + monster.getCurrentHitPoints() + " HP");
        System.out.println("DEBUG: " + monster.getID() + " ID");
        if (monster.getCurrentHitPoints() < 1) {
            dungeonConsoleGUI.updateTheDungeonConsole("The attacked monster - " + monster.getMonsterName() + " - has fallen!");
            eventOnMonsterDeath(monster);
        } else if (monster.getCurrentHitPoints() * 2 < monster.getHitPoints()) {
            dungeonConsoleGUI.updateTheDungeonConsole("The attacked monster - " + monster.getMonsterName() + " - is now bloodied.");
        }
    }

    private void eventOnMonsterDeath(Monster monster) throws IOException {
        File path = new File("C:\\Users\\A753403\\IdeaProjects\\DungeonCrawl\\src\\DungeonCrawl\\GUI\\Images\\MapElements\\Skull.jpg");
        Image img = monster.getCreatureImage();
        BufferedImage bimage = new BufferedImage((int) img.getWidth(), (int) img.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(bimage, 0, 0, null);
        BufferedImage overlay = ImageIO.read(new File(path, "Skull.jpg"));
        int w = Math.max(bimage.getWidth(), overlay.getWidth());
        int h = Math.max(bimage.getHeight(), overlay.getHeight());
        BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics g = combined.getGraphics();
        g.drawImage(bimage, 0, 0, null);
        g.drawImage(overlay, 0, 0, null);
//        Image convertedImage = new Image(g);
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
        dungeonConsoleGUI.updateTheDungeonConsole("It's a hit! Roll for damage: "
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
        dungeonConsoleGUI.updateTheDungeonConsole("Result of damage dice rolls: "
                + diceDealt
                + ". Bonus damage equal to your "
                + attackingPower.getDamageModifier()
                + ": "
                + attackResults.get("Attribute Bonus"));
        dungeonConsoleGUI.updateTheDungeonConsole("You've dealt " + allDamage + " damage");
        attackResults.put("Damage Inflicted", allDamage);
    }

    private void displayAttackMessage(HeroPower attackingPower, Monster monster, Map attackResults) {
        dungeonConsoleGUI.updateTheDungeonConsole("You have attacked a " +
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
        pathFinder.checkTheAvailableDistance(guiUtilities.getHeroByID(currentHeroID, dungeonGUIHeroManager.getHeroList()), dungeonMap, buttonGrid);
        System.out.println("Clicked the ID " + currentHeroID + " hero.");
        dungeonGUIHeroManager.setCurrentlyActiveHeroID(currentHeroID);
        setHasTheCharacterBeenSelected(true);
        updateButtonsWithHeroSkillNames(guiUtilities.getHeroByID(currentHeroID, dungeonGUIHeroManager.getHeroList()));
        dungeonConsoleGUI.updateTheDungeonConsole("You have selected " + guiUtilities.getHeroByID(currentHeroID, dungeonGUIHeroManager.getHeroList()).getHeroName());
    }

    private void eventOnHeroMovement(Button aButton, int XPos, int YPos) {

        Hero hero = guiUtilities.getHeroByID(dungeonGUIHeroManager.getCurrentlyActiveHeroID(), dungeonGUIHeroManager.getHeroList());
        getDungeonMap().getMapTilesArray()[hero.getMapXPos()][hero.getMapYPos()].setOccupyingCreatureTypeId(0);
        getDungeonMap().getMapTilesArray()[XPos][YPos].setOccupyingCreatureTypeId(dungeonGUIHeroManager.getCurrentlyActiveHeroID());
        int deltaX = Math.abs(hero.getMapXPos() - XPos);
        int deltaY = Math.abs(hero.getMapYPos() - YPos);
        hero.setCurrentSpeed(hero.getCurrentSpeed() - (deltaX + deltaY));
        hero.setMapXPos(XPos);
        hero.setMapYPos(YPos);
        aButton.setGraphic(new ImageView(hero.getCreatureImage()));
        if (hero.getCurrentSpeed() < 1) {
            dungeonGUIHeroManager.setNumberOfHeroesThatFinishedMovement(dungeonGUIHeroManager.getNumberOfHeroesThatFinishedMovement() + 1);
            System.out.println(hero.heroName + " has finished moving. " + dungeonGUIHeroManager.getNumberOfHeroesThatFinishedMovement() + " heroes had already finished moving");
            if (dungeonGUIHeroManager.getNumberOfHeroesThatFinishedMovement() == dungeonGUIHeroManager.getHeroList().size()) {
                for (Hero currentHero : dungeonGUIHeroManager.getHeroList()) {
                    currentHero.setCurrentSpeed(currentHero.getSpeed());
                    System.out.println("Resetting the movement points for " + currentHero.heroName);
                }
                dungeonGUIHeroManager.setNumberOfHeroesThatFinishedMovement(0);
            }
        }
        fightAlreadyTakingPlace = pathFinder.checkTheVisibilityRange(allMonstersList, dungeonGUIHeroManager.getHeroList(), hero, dungeonMap, fightAlreadyTakingPlace);
        dungeonConsoleGUI.getInitiativeTracker().setContent(pathFinder.dungeonConsoleGUI.getInitiativeTilePane());
    }

    private void eventOnPowerSelect(Hero currentHero, HeroPower selectedPower) {
        PathFinder pathFinder = new PathFinder();
        currentPower.clear();
        currentPower.add(selectedPower);
        pathFinder.checkTheLineOfSight(dungeonMap, buttonGrid, currentHero);
    }


    private void applyEntityIconToAButton(int heroID, Button aButton) {
        if (heroID < 100) {
            aButton.setGraphic(new ImageView(guiUtilities.getHeroByID(heroID, dungeonGUIHeroManager.getHeroList()).getCreatureImage()));
        } else {
            aButton.setGraphic(new ImageView(guiUtilities.getMonsterTypeByID(heroID, possibleMonsterTypes).getCreatureImage()));
        }
    }
//todo add a button to console that could extend its view range or minimize it.


}




