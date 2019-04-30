package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

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

    //todo finishing the character creation should save it in a database.

    private void initializeCardForgeGUI() {
        manageThePanes();
        addElementsToPanes();
        setStyling();
        addTheAbilityChoices();
        returnToMainMenu.setOnAction(event -> returnToMainMenu());
    }

    enum characterClasses {

    }

    enum Stats {
        Strength, Constitution, Dexterity, Intelligence, Wisdom, Charisma
    }

    private void addTheAbilityChoices() {
        List<ComboBox<Integer>> comboBoxList = new ArrayList<>();
        List<Text> abilityTextsList = new ArrayList<>();
        ObservableList<Integer> statPointsOptions = FXCollections.observableArrayList();
        for (int i = 3; i < 20; i++) {
            statPointsOptions.add(i);
        }
        for (Stats currentStat : Stats.values()) {
            abilityTextsList.add(new Text(currentStat.toString()));
            comboBoxList.add(new ComboBox<>(statPointsOptions));
        }
        for (int i = 0; i < 6; i++) {
            middleBox.add(comboBoxList.get(i), 1, i + 1);
            middleBox.add(abilityTextsList.get(i), 0, i + 1);
        }
    }

    private void manageThePanes() {
        characterCreatorOuterPane.setContent(characterCreatorInnerPane);
        characterCreatorInnerPane.setTop(topBox);
        characterCreatorInnerPane.setLeft(leftBox);
        characterCreatorInnerPane.setCenter(middleBox);
    }

    private void addElementsToPanes() {
        middleBox.add(characterName, 0, 0, 10, 1);
        leftBox.getChildren().add(classChoice);
        leftBox.getChildren().add(raceChoice);
        leftBox.getChildren().add(returnToMainMenu);
    }

    private void setStyling() {
        leftBox.setPadding(new Insets(5, 5, 5, 5));
        leftBox.setVgap(4);
        leftBox.setHgap(4);
        leftBox.setPrefWrapLength(170);
        characterName.setMinWidth(170);
        raceChoice.setMinWidth(150);
        classChoice.setMinWidth(150);
        leftBox.setStyle("-fx-background-color: DAE6F3;");
        raceChoice.setPromptText("Choose your race");
        classChoice.setPromptText("Choose your class");
        characterName.setPromptText("Insert your character name");
        returnToMainMenu.setText("Return to Main Menu");
    }

    private void returnToMainMenu() {
        mainMenuGUI.aStage = Main.getPrimaryStage();
        mainMenuGUI.aStage.setScene(mainMenuGUI.aScene);
        mainMenuGUI.aStage.show();
        System.out.println("Stage is closing");
    }
}
