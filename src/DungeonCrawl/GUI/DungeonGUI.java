package DungeonCrawl.GUI;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.CacheHint;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import DungeonCrawl.*;
import DungeonCrawl.DAO.ItemsDAO;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.Model.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class DungeonGUI {

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

    public GridPane getMapGridPane() {
        return mapGridPane;
    }

    public void setMapGridPane(GridPane mapGridPane) {
        this.mapGridPane = mapGridPane;
    }

    public ScrollPane getMapScrollPane() {
        return mapScrollPane;
    }

    public void setMapScrollPane(ScrollPane mapScrollPane) {
        this.mapScrollPane = mapScrollPane;
    }

    public BorderPane getMapOuterPane() {
        return mapOuterPane;
    }

    public void setMapOuterPane(BorderPane mapOuterPane) {
        this.mapOuterPane = mapOuterPane;
    }

    DungeonGUI(List<Hero> heroList) {
        mapOuterPane.getStylesheets().add("DungeonCrawl/Styling/CharacterCreator.css");
        //mapScrollPane.getStylesheets().add("DungeonCrawl/Styling/CharacterCreator.css");
        heroManager.setHeroList(heroList);
        manageTheConsoleAdding();
        pathFinder.getDungeonConsoleGUI().getDungeonConsole().setContent(pathFinder.getDungeonConsoleGUI().getDungeonConsoleText());
        getMapOuterPane().setCenter(mapScrollPane);
        mapScrollPane.setContent(mapGridPane);
        mapGridPane.setPadding(new Insets(80));
        Button returnToMainMenu = new Button();
        returnToMainMenu.setText("Return to Main Menu");
        mapGridPane.add(returnToMainMenu, 0, mapHeight + 1, 3, 3);
        returnToMainMenu.setOnAction(event -> returnToMainMenu());
        encounterManager.getDungeonMap().setHeroList(heroList);
        encounterManager.getDungeonMap().drawAMap();
        updateGUIAccordingToMap();
    }

    //todo lock the portrait buttons' walk function when the hero is locked out of movement.

    //todo add experience gain from killing a monster.
    // Exp should be added to a field on slaying event,
    // and hero experience should be updated on end of encounter.

    //todo while monsters are moving, all hero buttons should be locked.

    /*todo add messages to console:
     CURRENTLY SELECTED POWER:
     DAMAGE DEALT:
     ATTACK MISSED!
     ENCOUNTER BEGINS

    ...
     */

    //todo a method that identifies a flanking position - in a separate Flanking Finder Class

    private void manageTheConsoleAdding() {

        //powersHBox.setStyle("-fx-background-color:grey;");
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
            ImageView redPaintedPortrait = encounterManager.paintTheCharactersPortraitRed(hero);
            hero.setCurrentHeroPortrait(redPaintedPortrait);
            heroButton.setGraphic(redPaintedPortrait);
            heroButton.setOnAction(event -> dungeonButtonEvents.buttonEvent(hero.getMapXPos(), hero.getMapYPos(), currentHeroPowers));
            listOfHeroButtons.add(heroButton);
            System.out.println(hero.toString());
        }
        portraitsVBox.getChildren().addAll(listOfHeroButtons);
        encounterManager.setListOfHeroButtons(this.listOfHeroButtons);
        getMapOuterPane().setRight(portraitsVBox);
        getMapOuterPane().setLeft(controlsButtons);
        pathFinder.getDungeonConsoleGUI().getCompleteConsole().add(powersHBox, 0, 2);
        getMapOuterPane().setBottom(pathFinder.getDungeonConsoleGUI().getCompleteConsole());
    }


    private void viewMapEvent() {
        getMapOuterPane().setCenter(mapScrollPane);
        for (Button heroButton : listOfHeroButtons) {
            int thisButtonID = Integer.valueOf(heroButton.getId());
            Hero currentHero = guiUtilities.getHeroByID(thisButtonID, heroManager.getHeroList());
            heroButton.setOnAction(event -> dungeonButtonEvents.buttonEvent(currentHero.getMapXPos(), currentHero.getMapYPos(), currentHeroPowers));
        }
    }

    private Button addViewEquipmentButton() {
        Button equipmentButton = new Button();
        equipmentButton.setOnAction(event -> {
            showCurrentCharactersEquipment(heroManager.getCurrentlyActiveHeroID());
            for (Button heroButton : listOfHeroButtons) {
                heroButton.setOnAction(innerEvent -> {
                    int heroId = Integer.valueOf(heroButton.getId());
                    showCurrentCharactersEquipment(heroId);
                });
            }
        });
        Image eqIcon = new Image(getClass().getResourceAsStream("Images/Equipment.jpg"));
        ImageView eqIconView = new ImageView(eqIcon);
        equipmentButton.setGraphic(eqIconView);
        return equipmentButton;
    }


    //todo add the character's sheet view

    private void showCurrentCharactersEquipment(int currentlyActiveHeroID) {
        Hero currentHero = guiUtilities.getHeroByID(currentlyActiveHeroID, heroManager.getHeroList());
        ItemsDAO itemsDAO = new ItemsDAO();
        currentHero.setHeroEquipment(itemsDAO.getHeroEquipmentByHeroID(currentHero.getID()));
        EquipmentGUI equipmentGUI = new EquipmentGUI();
        getMapOuterPane().setCenter(equipmentGUI.displayAChosenHeroEquipment(currentHero));
    }

    //todo change the "extend the console" button from white background to transparent, so it looks better with current CSS

    //todo add a scene, that would show the progress bar of a map being built

    //todo player's turn should be finished when his powers are used up or when he chooses it to be finished

    //todo add the control buttons for minor, main and move actions.

    //todo add map elements to the rooms - tables, trees, altars, barrels, carpets and so forth.

    //todo add a difficult terrain feature to some of the tiles

    //todo make the dead monsters lootable

    //todo create some treasure hoards for some of the rooms - chests, closets, crates or gold piles.

    //todo some rooms could have other shapes from just being plain rectangular.

    //todo add some additional monsters other than plain goblins

    //todo monsters should not be able to cross wall tiles.

    //todo change the monster icons, so they better fit the dark and smooth style of current design.

    //todo after running away from monster, the attack monster algorithm checks for old coordinates, it seems.

    private void updateGUIAccordingToMap() {
        CursorManager cursorManager = new CursorManager(mapOuterPane, encounterManager);
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
                aButton.setOnMouseEntered(event -> cursorManager.changeTheCursorOnHover(finalI, finalJ));
                mapGridPane.add(aButton, j, i);
            }
        }
        mapManager.updateMapGraphics();
    }

    private void returnToMainMenu() {
        mainMenuGUI.setaStage(Main.getPrimaryStage());
        mainMenuGUI.getaStage().setScene(mainMenuGUI.aScene);
        mainMenuGUI.getaStage().show();
        System.out.println("Stage is closing");
    }


}




