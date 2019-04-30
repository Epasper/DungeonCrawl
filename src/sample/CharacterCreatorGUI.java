package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class CharacterCreatorGUI {
    private MainMenuGUI mainMenuGUI = new MainMenuGUI();
    ScrollPane characterCreatorOuterPane = new ScrollPane();
    private BorderPane characterCreatorInnerPane = new BorderPane();
    private HBox topBox = new HBox();
    private FlowPane leftBox = new FlowPane();
    private GridPane middleBox = new GridPane();
    private ObservableList<String> classOptions =
            FXCollections.observableArrayList(
                    "Avenger",
                    "Barbarian",
                    "Bard",
                    "Cleric",
                    "Druid",
                    "Fighter",
                    "Invoker",
                    "Paladin",
                    "Ranger",
                    "Rogue",
                    "Shaman",
                    "Sorcerer",
                    "Warden",
                    "Warlock",
                    "Warlord",
                    "Wizard");
    private ObservableList<String> raceOptions =
            FXCollections.observableArrayList(
                    "Deva",
                    "Dragonborn",
                    "Dwarf",
                    "Eladrin",
                    "Elf",
                    "Gnome",
                    "Goliath",
                    "Half-Elf",
                    "Half-Orc",
                    "Halfling",
                    "Human",
                    "Shifter",
                    "Tiefling");
    private ComboBox<String> classChoice = new ComboBox<>(classOptions);
    private ComboBox<String> raceChoice = new ComboBox<>(raceOptions);
    private Button returnToMainMenu = new Button();
    private TextField characterName = new TextField();

    public CharacterCreatorGUI() {
        initializeCardForgeGUI();
    }

    private void initializeCardForgeGUI() {
        characterCreatorOuterPane.setContent(characterCreatorInnerPane);
        characterCreatorInnerPane.setTop(topBox);
        characterCreatorInnerPane.setLeft(leftBox);
        characterCreatorInnerPane.setCenter(middleBox);
        characterName.setPromptText("Insert your character name");
        middleBox.add(characterName, 0, 0, 1, 10);
        leftBox.setPadding(new Insets(5, 5, 5, 5));
        leftBox.setVgap(4);
        leftBox.setHgap(4);
        leftBox.setPrefWrapLength(170);
        leftBox.setStyle("-fx-background-color: DAE6F3;");
        leftBox.getChildren().add(classChoice);
        leftBox.getChildren().add(raceChoice);
        raceChoice.setPromptText("Choose your race");
        classChoice.setPromptText("Choose your class");
        characterName.setMinWidth(150);
        raceChoice.setMinWidth(150);
        classChoice.setMinWidth(150);
        leftBox.getChildren().add(returnToMainMenu);
        returnToMainMenu.setText("Return to Main Menu");

        returnToMainMenu.setOnAction(event -> returnToMainMenu());
    }

    private void returnToMainMenu() {
        mainMenuGUI.aStage = Main.getPrimaryStage();
        mainMenuGUI.aStage.setScene(mainMenuGUI.aScene);
        mainMenuGUI.aStage.show();
        System.out.println("Stage is closing");
    }
}
