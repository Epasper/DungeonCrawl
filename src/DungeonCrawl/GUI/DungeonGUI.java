package DungeonCrawl.GUI;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import DungeonCrawl.*;
import DungeonCrawl.DAO.ItemsDAO;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.Model.*;
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
    private BorderPane mapOuterPane = new BorderPane();
    private List<HeroPower> currentHeroPowers = new ArrayList<>();
    private ScrollPane mapScrollPane = new ScrollPane();
    private List<Button> listOfHeroButtons = new ArrayList<>();
    private HeroManager heroManager = new HeroManager();
    private GUIUtilities guiUtilities = new GUIUtilities();
    private PathFinder pathFinder = new PathFinder();
    private EncounterManager encounterManager = new EncounterManager(heroManager, buttonGrid, pathFinder);
    private MapManager mapManager = new MapManager(mapWidth, mapHeight, encounterManager);
    private DungeonButtonEvents dungeonButtonEvents = new DungeonButtonEvents(encounterManager, mapManager, powersHBox, currentHeroPowers);

    DungeonGUI(List<Hero> heroList) {

        heroManager.setHeroList(heroList);
        manageTheConsoleAdding();
        pathFinder.dungeonConsoleGUI.getDungeonConsole().setContent(pathFinder.dungeonConsoleGUI.getDungeonConsoleText());
        getMapOuterPane().setCenter(mapScrollPane);
        mapScrollPane.setContent(mapGridPane);
        Button returnToMainMenu = new Button();
        returnToMainMenu.setText("Return to Main Menu");
        mapGridPane.add(returnToMainMenu, 0, mapHeight + 1, 3, 3);
        returnToMainMenu.setOnAction(event -> returnToMainMenu());
        encounterManager.getDungeonMap().setHeroList(heroList);
        encounterManager.getDungeonMap().drawAMap();
        updateGUIAccordingToMap(encounterManager.getDungeonMap());
    }

    //todo lock the portrait buttons' walk function when the hero is locked out of movement.

    //todo lock the possibility of attacking when no power is selected. After the attack, disable the power from currently selected powers.

    //todo lock encounter powers on use until the end of encounter. Lock daily powers on use once every 3 encounters.

    /*todo add messages to console:
     CURRENTLY SELECTED POWER:
    ...
     */

    //todo in future, change the portraits, so that each hero has a bigger portrait on the right and small icon on the field.

    //todo download some bigger portraits from the internet and use JavaFX resize to fit the big ones in the buttons

    //todo Hero portraits to turn red with damage taken.

    //todo a method that identifies a flanking position - in a separate Flanking Finder Class

    private void manageTheConsoleAdding() {
        powersHBox.setStyle("-fx-background-color:grey;");
        powersHBox.setMinSize(200, 60);
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
            heroButton.setOnAction(event -> dungeonButtonEvents.buttonEvent(hero.getMapXPos(), hero.getMapYPos(), currentHeroPowers));
            listOfHeroButtons.add(heroButton);
        }
        portraitsVBox.getChildren().addAll(listOfHeroButtons);
        getMapOuterPane().setRight(portraitsVBox);
        getMapOuterPane().setLeft(controlsButtons);
        pathFinder.dungeonConsoleGUI.getCompleteConsole().add(powersHBox, 0, 2);
        getMapOuterPane().setBottom(pathFinder.dungeonConsoleGUI.getCompleteConsole());
    }

    private void viewMapEvent() {
        getMapOuterPane().setCenter(mapScrollPane);
        for (Button heroButton : listOfHeroButtons) {
            int thisButtonID = Integer.valueOf(heroButton.getId());
            Hero currentHero = guiUtilities.getHeroByID(thisButtonID, heroManager.getHeroList());
            heroButton.setOnAction(event -> dungeonButtonEvents.buttonEvent(currentHero.getMapXPos(), currentHero.getMapYPos(), currentHeroPowers));
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
        getMapOuterPane().setCenter(equipmentGUI.displayAChosenHeroEquipment(currentHero));
    }

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
                aButton.setOnAction(actionEvent -> dungeonButtonEvents.buttonEvent(finalI, finalJ, currentHeroPowers));
                aButton.setOnMouseEntered(event -> changeTheCursorOnHover(finalI, finalJ));
                mapGridPane.add(aButton, j, i);
            }
        }
        mapManager.updateMapGraphics(dungeonMap);
    }

    //todo add a CursorManager class that manages the cursors - refactor these methods onto the new class.

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
            getMapOuterPane().setCursor(Cursor.DEFAULT);
        } else {
            getMapOuterPane().setCursor(new ImageCursor(image));
            //System.out.println("Changing the cursor");
        }
    }
    //todo change the monster portrait after it being bloodied

    private void returnToMainMenu() {
        mainMenuGUI.aStage = Main.getPrimaryStage();
        mainMenuGUI.aStage.setScene(mainMenuGUI.aScene);
        mainMenuGUI.aStage.show();
        System.out.println("Stage is closing");
    }

    public BorderPane getMapOuterPane() {
        return mapOuterPane;
    }

    public void setMapOuterPane(BorderPane mapOuterPane) {
        this.mapOuterPane = mapOuterPane;
    }
//todo add a button to console that could extend its view range or minimize it.


}




