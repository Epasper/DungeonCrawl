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

public class CardForgeGUI {
    ScrollPane cardForgeScrollPane = new ScrollPane();
    private BorderPane cardForgeBorderPane = new BorderPane();
    private HBox topBox = new HBox();
    private VBox leftBox = new VBox();
    private FlowPane middlePane = new FlowPane();
    private Button newDungeonButton = new Button();
    private Button exitToMainMenu = new Button();
    private Scene aScene = new Scene(new Group());
    Stage aStage = Main.getPrimaryStage();

    public CardForgeGUI() {
    }

    void initializeCardForgeGUI() {
//        cardForgeScrollPane.setContent(cardForgeBorderPane);
//        cardForgeBorderPane.setTop(topBox);
//        cardForgeBorderPane.setLeft(leftBox);
//        cardForgeBorderPane.setCenter(middlePane);
//        middlePane.setPadding(new Insets(5, 0, 5, 0));
//        middlePane.setVgap(4);
//        middlePane.setHgap(4);
//        middlePane.setPrefWrapLength(170);
//        middlePane.setStyle("-fx-background-color: DAE6F3;");
        middlePane.getChildren().add(newDungeonButton);
        middlePane.getChildren().add(exitToMainMenu);
        aScene.setRoot(middlePane);
        aStage.setScene(aScene);
        aStage.show();

    }
}
