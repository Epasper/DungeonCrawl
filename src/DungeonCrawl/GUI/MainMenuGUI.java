package DungeonCrawl.GUI;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import DungeonCrawl.Main;

import java.io.IOException;
import java.sql.SQLException;

public class MainMenuGUI {

    private ScrollPane mainMenuScrollPane = new ScrollPane();
    private BorderPane mainMenuBorderPane = new BorderPane();
    private HBox topBox = new HBox();
    private VBox leftBox = new VBox();
    private FlowPane middlePane = new FlowPane();
    private Button newDungeonButton = new Button();
    private Button characterCreatorGUIButton = new Button();
    private Button itemShopButton = new Button();
    private Button manageEquipmentButton = new Button("Manage Hero Equipment");
    public Scene aScene = new Scene(new Group());
    private Stage aStage = new Stage();

    public MainMenuGUI() {
        buildTheMainMenu();
    }


    private void buildTheMainMenu() {
        aScene.getStylesheets().add("DungeonCrawl/Styling/CharacterCreator.css");
        setaStage(Main.getPrimaryStage());
        mainMenuScrollPane.setContent(mainMenuBorderPane);
        mainMenuBorderPane.setTop(topBox);
        mainMenuBorderPane.setLeft(leftBox);
        mainMenuBorderPane.setCenter(middlePane);
        middlePane.setPadding(new Insets(5, 5, 5, 5));
        middlePane.setVgap(4);
        middlePane.setHgap(4);
        middlePane.setPrefWrapLength(170);
        middlePane.getChildren().add(newDungeonButton);
        middlePane.getChildren().add(characterCreatorGUIButton);
        middlePane.getChildren().add(itemShopButton);
        middlePane.getChildren().add(manageEquipmentButton);
        getaStage().getIcons().add(new Image("DungeonCrawl/GUI/Images/WindowsIcons/MainMenuIcon.jpg"));
        newDungeonButton.setText("Generate a New Dungeon");
        newDungeonButton.setOnAction(event -> {
            try {
                openDungeonGUI();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        });
        manageEquipmentButton.setOnAction(event -> {
            PartySelectorGUI partySelectorGUI = null;
            try {
                partySelectorGUI = new PartySelectorGUI();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
            //DungeonGUI dungeonGui = new DungeonGUI();
            getaStage().close();
            assert partySelectorGUI != null;
            aScene.setRoot(partySelectorGUI.partySelectorOuterPlane);
            //aScene.getStylesheets().add("DungeonCrawl/Styling/Caspian.css");
            getaStage().setMaximized(true);
            //aScene.setRoot(dungeonGui.mapScrollPane);
            getaStage().setScene(aScene);
            getaStage().show();
        });
        characterCreatorGUIButton.setText("Character Creator");
        characterCreatorGUIButton.setOnAction(event -> openCharacterCreationGUI());
        itemShopButton.setText("Item Shop");
        itemShopButton.setOnAction(event -> {
            try {
                openItemShop();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        });
        aScene.setRoot(mainMenuScrollPane);
        getaStage().show();
    }

    private void openDungeonGUI() throws SQLException, IOException {
        PartySelectorGUI partySelectorGUI = new PartySelectorGUI();
        //DungeonGUI dungeonGui = new DungeonGUI();
        getaStage().close();
        aScene.setRoot(partySelectorGUI.partySelectorOuterPlane);
        //aScene.getStylesheets().add("DungeonCrawl/Styling/Caspian.css");
        getaStage().setMaximized(true);
        //aScene.setRoot(dungeonGui.mapScrollPane);
        getaStage().setScene(aScene);
        getaStage().show();
    }

    private void openItemShop() throws SQLException, IOException {
        ItemShopGUI itemShopGUI = new ItemShopGUI();
        getaStage().close();
        aScene.setRoot(itemShopGUI.getItemShopOuterPane());
        //aScene.getStylesheets().add("DungeonCrawl/Styling/Caspian.css");
        getaStage().setMaximized(true);
        getaStage().setScene(aScene);
        getaStage().show();
    }

    private void openCharacterCreationGUI() {
        CharacterCreatorGUI characterCreatorGUI = new CharacterCreatorGUI();
        getaStage().close();
        getaStage().getIcons().clear();
        getaStage().getIcons().add(new Image("DungeonCrawl/GUI/Images/WindowsIcons/CharacterCreatorIcon.jpg"));
        aScene.setRoot(characterCreatorGUI.getCharacterCreatorOuterPane());
        getaStage().setMaximized(true);
        getaStage().setScene(aScene);
        getaStage().show();
    }


    public Stage getaStage() {
        return aStage;
    }

    public void setaStage(Stage aStage) {
        this.aStage = aStage;
    }
}
