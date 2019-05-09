package sample.GUI;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Main;

public class MainMenuGUI {

    private ScrollPane mainMenuScrollPane = new ScrollPane();
    private BorderPane mainMenuBorderPane = new BorderPane();
    private HBox topBox = new HBox();
    private VBox leftBox = new VBox();
    private FlowPane middlePane = new FlowPane();
    private Button newDungeonButton = new Button();
    private Button cardForgeGUIButton = new Button();
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
        middlePane.getChildren().add(cardForgeGUIButton);
        newDungeonButton.setText("Generate a New Dungeon");
        newDungeonButton.setOnAction(event -> openDungeonGUI());
        cardForgeGUIButton.setText("Character Creator");
        cardForgeGUIButton.setOnAction(event -> openCardForgeGUI());
        aScene.setRoot(mainMenuScrollPane);
        aStage.show();
    }


    private void openDungeonGUI() {
        DungeonGUI dungeonGui = new DungeonGUI();
        aScene.getStylesheets().add("sample/Styling/Caspian.css");
        aStage.close();
        aScene.setRoot(dungeonGui.mapScrollPane);
        aStage.setScene(aScene);
        aStage.show();
    }

    private void openCardForgeGUI() {
        CharacterCreatorGUI characterCreatorGUI = new CharacterCreatorGUI();
        aStage.close();
        aScene.setRoot(characterCreatorGUI.characterCreatorOuterPane);
        aStage.setScene(aScene);
        aStage.show();
    }


}
