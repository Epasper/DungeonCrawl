package sample.GUI;

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
import sample.Main;

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
    public Stage aStage = new Stage();

    public MainMenuGUI() {
        buildTheMainMenu();
    }


    private void buildTheMainMenu() {
        aScene.getStylesheets().add("sample/Styling/CharacterCreator.css");
        aStage = Main.getPrimaryStage();
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
        aStage.getIcons().add(new Image("sample/GUI/Images/MainMenuIcon.jpg"));
        newDungeonButton.setText("Generate a New Dungeon");
        newDungeonButton.setOnAction(event -> {
            try {
                openDungeonGUI();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        });
        //todo add hero selector to manage equipment properly
        manageEquipmentButton.setOnAction(event -> {

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
        aStage.show();
    }

    private void openDungeonGUI() throws SQLException, IOException {
        PartySelectorGUI partySelectorGUI = new PartySelectorGUI();
        //DungeonGUI dungeonGui = new DungeonGUI();
        aStage.close();
        aScene.setRoot(partySelectorGUI.partySelectorOuterPlane);
        aScene.getStylesheets().add("sample/Styling/Caspian.css");
        aStage.setMaximized(true);
        //aScene.setRoot(dungeonGui.mapScrollPane);
        aStage.setScene(aScene);
        aStage.show();
    }

    private void openItemShop() throws SQLException, IOException {
        ItemShopGUI itemShopGUI = new ItemShopGUI();
        aStage.close();
        aScene.setRoot(itemShopGUI.itemShopOuterPane);
        aScene.getStylesheets().add("sample/Styling/Caspian.css");
        aStage.setMaximized(true);
        aStage.setScene(aScene);
        aStage.show();
    }

    private void openCharacterCreationGUI() {
        CharacterCreatorGUI characterCreatorGUI = new CharacterCreatorGUI();
        aStage.close();
        aStage.getIcons().clear();
        aStage.getIcons().add(new Image("sample/GUI/Images/CharacterCreatorIcon.jpg"));
        aScene.setRoot(characterCreatorGUI.characterCreatorOuterPane);
        aStage.setMaximized(true);
        aStage.setScene(aScene);
        aStage.show();
    }


}
