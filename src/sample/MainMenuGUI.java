package sample;

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

public class MainMenuGUI {

    //todo create a Card Forge GUI and separate methods for skill card forging

    private ScrollPane mainMenuScrollPane = new ScrollPane();
    private BorderPane mainMenuBorderPane = new BorderPane();
    private HBox topBox = new HBox();
    private VBox leftBox = new VBox();
    private FlowPane middlePane = new FlowPane();
    private Button newDungeonButton = new Button();
    Scene freshScene = new Scene(new Group());
    private Stage freshStage = new Stage();

    public MainMenuGUI() {
        initializeMainMenu();
    }

    private void initializeMainMenu() {
        mainMenuScrollPane.setContent(mainMenuBorderPane);
        mainMenuBorderPane.setTop(topBox);
        mainMenuBorderPane.setLeft(leftBox);
        mainMenuBorderPane.setCenter(middlePane);
        middlePane.setPadding(new Insets(5, 0, 5, 0));
        middlePane.setVgap(4);
        middlePane.setHgap(4);
        middlePane.setPrefWrapLength(170);
        middlePane.setStyle("-fx-background-color: DAE6F3;");
        middlePane.getChildren().add(newDungeonButton);
        freshScene.setRoot(mainMenuScrollPane);
        newDungeonButton.setText("Generate a New Dungeon");
        newDungeonButton.setOnAction(event -> openDungeonGUI());
    }

    private void openDungeonGUI() {
        DungeonGUI dungeonGui = new DungeonGUI();
        freshStage.close();
        freshScene.setRoot(dungeonGui.mapScrollPane);
        freshStage.setScene(freshScene);
        freshStage.show();
        freshStage.setOnCloseRequest(event -> {
            freshScene.setRoot(mainMenuScrollPane);
            freshStage.setScene(freshScene);
            freshStage.show();
            System.out.println("Stage is closing");
        });
    }
}
