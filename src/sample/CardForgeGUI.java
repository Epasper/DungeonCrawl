package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class CardForgeGUI {
    private MainMenuGUI mainMenuGUI = new MainMenuGUI();
    ScrollPane cardForgeScrollPane = new ScrollPane();
    private BorderPane cardForgeBorderPane = new BorderPane();
    private HBox topBox = new HBox();
    private FlowPane leftBox = new FlowPane();
    private GridPane middlePane = new GridPane();
    private Button forgeANewCard = new Button();
    private Button returnToMainMenu = new Button();
    private TextField cardTitle = new TextField();

    public CardForgeGUI() {
        initializeCardForgeGUI();
    }

    private void initializeCardForgeGUI() {
        cardForgeScrollPane.setContent(cardForgeBorderPane);
        cardForgeBorderPane.setTop(topBox);
        cardForgeBorderPane.setLeft(leftBox);
        cardForgeBorderPane.setCenter(middlePane);
        cardTitle.setText("Insert a Card Name");
        middlePane.add(cardTitle, 0, 0, 1, 10);
        leftBox.setPadding(new Insets(5, 5, 5, 5));
        leftBox.setVgap(4);
        leftBox.setHgap(4);
        leftBox.setPrefWrapLength(170);
        leftBox.setStyle("-fx-background-color: DAE6F3;");
        leftBox.getChildren().add(returnToMainMenu);
        leftBox.getChildren().add(forgeANewCard);
        returnToMainMenu.setText("Return to Main Menu");
        forgeANewCard.setText("Forge a new Card");
        returnToMainMenu.setOnAction(event -> returnToMainMenu());
    }
    private void returnToMainMenu() {
        mainMenuGUI.aStage = Main.getPrimaryStage();
        mainMenuGUI.aStage.setScene(mainMenuGUI.aScene);
        mainMenuGUI.aStage.show();
        System.out.println("Stage is closing");
    }
}
