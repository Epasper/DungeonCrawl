package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class CharacterCreatorGUI {
    private MainMenuGUI mainMenuGUI = new MainMenuGUI();
    ScrollPane characterCreatorOuterPane = new ScrollPane();
    private BorderPane characterCreatorInnerPane = new BorderPane();
    private HBox topBox = new HBox();
    private FlowPane leftBox = new FlowPane();
    private GridPane middleBox = new GridPane();
    private ComboBox<String> classChoice = new ComboBox<>();
    private ComboBox<String> raceChoice = new ComboBox<>();
    private Button returnToMainMenu = new Button();
    private TextField characterName = new TextField();
    private final ToggleGroup racialToggleGroup = new ToggleGroup();
    private List<RadioButton> racialBonusesRadioButtons = new ArrayList<>();
    private List<Text> racialBonusesModifiers = new ArrayList<>();
    private List<Spinner<Integer>> valueSpinnerList = new ArrayList<>();
    private List<Text> abilityTextsList = new ArrayList<>();
    private Text modifierText = new Text();
    private Text racialBonusText = new Text();
    private List<Text> modifierNumbersTextList = new ArrayList<>();
    private ObservableList<Integer> statPointsOptions = FXCollections.observableArrayList();
    private Text finalScoreText = new Text("  Final  \n  Score  ");
    private List<Text> finalAbilityScores = new ArrayList<>();


    public CharacterCreatorGUI() {
        initializeCharacterCreatorGUI();
    }

    //todo finishing the character creation should save it in a database.

    private void initializeCharacterCreatorGUI() {
        manageThePanes();
        addElementsToPanes();
        setStyling();
        addTheAbilityChoices();
        calculateAllFinalAbilityScores();
        returnToMainMenu.setOnAction(event -> returnToMainMenu());
    }


    enum CharacterClasses {
        Avenger, Barbarian, Bard, Cleric, Druid, Fighter, Invoker, Paladin, Ranger, Rogue, Shaman, Sorcerer, Warden, Warlock, Warlord, Wizard
    }

    enum CharacterRaces {
        Deva, Dragonborn, Dwarf, Eladrin, Elf, Gnome, Goliath, Halfelf, Halforc, Halfling, Human, Shifter, Tiefling
    }

    enum Stats {
        Strength, Constitution, Dexterity, Intelligence, Wisdom, Charisma
    }

    private void addTheAbilityChoices() {

        for (int i = 3; i < 19; i++) {
            statPointsOptions.add(i);
        }
        for (Stats currentStat : Stats.values()) {
            prepareASingleAttribute(currentStat);
        }
        for (int i = 0; i < 6; i++) {
            displayASingleAttribute(i);
        }
        racialBonusText.setText("  Racial  \n  Bonus: ");
        middleBox.add(racialBonusText, 2, 1);
        middleBox.add(finalScoreText, 4, 1);
        modifierText.setText("  Ability  \n  Modifier: ");
        middleBox.add(modifierText, 5, 1);
        racialToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            eventOnRadioButtonChange(oldValue, newValue);
            calculateAllFinalAbilityScores();
        });
    }

    private void eventOnRadioButtonChange(Toggle oldValue, Toggle newValue) {
        if (oldValue != null) {
            String oldValueString = oldValue.toString();
            String trimmedString = oldValueString.substring(oldValueString.indexOf('\'')).replaceAll("\\W", "");
            racialBonusesModifiers.get(getStatID(trimmedString)).setText("      ");
            System.out.println(trimmedString);
        }
        String radioButtonString = newValue.toString();
        String trimmedString = radioButtonString.substring(radioButtonString.indexOf('\'')).replaceAll("\\W", "");
        racialBonusesModifiers.get(getStatID(trimmedString)).setText(" +2 ");
        System.out.println(trimmedString);
    }

    private void prepareASingleAttribute(Stats currentStat) {
        abilityTextsList.add(new Text("  " + currentStat.toString() + " "));
        valueSpinnerList.add(new Spinner<>(statPointsOptions));
        modifierNumbersTextList.add(new Text(" "));
        racialBonusesModifiers.add(new Text("      "));
        racialBonusesRadioButtons.add(new RadioButton(currentStat.toString()));
        finalAbilityScores.add(new Text(" "));
    }

    private void displayASingleAttribute(int i) {
        valueSpinnerList.get(i).valueProperty().addListener((observable, oldValue, newValue) -> {
            calculateAllFinalAbilityScores();
        });
        valueSpinnerList.get(i).getValueFactory().setValue(10);
        racialBonusesRadioButtons.get(i).setToggleGroup(racialToggleGroup);
        racialBonusesRadioButtons.get(i).setDisable(true);
        middleBox.add(abilityTextsList.get(i), 0, i + 2);
        middleBox.add(valueSpinnerList.get(i), 1, i + 2);
        middleBox.add(racialBonusesModifiers.get(i), 2, i + 2);
        middleBox.add(racialBonusesRadioButtons.get(i), 3, i + 2);
        middleBox.add(finalAbilityScores.get(i), 4, i + 2);
        middleBox.add(modifierNumbersTextList.get(i), 5, i + 2);
    }

    private void manageThePanes() {
        characterCreatorOuterPane.setContent(characterCreatorInnerPane);
        characterCreatorInnerPane.setTop(topBox);
        characterCreatorInnerPane.setLeft(leftBox);
        characterCreatorInnerPane.setCenter(middleBox);
    }

    //todo create a "total points available" and "points spent" fields

    private void calculateAllFinalAbilityScores() {
        for (int i = 0; i < finalAbilityScores.size(); i++) {
            int bonusFromChoice = valueSpinnerList.get(i).getValue();
            String textToBeSet = racialBonusesModifiers.get(i).getText().replaceAll("\\D", "");
            int racialBonus = 0;
            if (textToBeSet.length() > 0) {
                racialBonus = Integer.parseInt(textToBeSet);
            }
            int sum = racialBonus + bonusFromChoice;
            textToBeSet = "" + sum;
            finalAbilityScores.get(i).setText("   " + textToBeSet);
            if (sum < 9) {
                modifierNumbersTextList.get(i).setText("   " + ((sum - 10) / 2) + " ");
            } else {
                modifierNumbersTextList.get(i).setText("  +" + ((sum - 10) / 2) + " ");
            }
        }
    }

    private void addElementsToPanes() {
        ObservableList<String> classOptions =
                FXCollections.observableArrayList();
        ObservableList<String> raceOptions =
                FXCollections.observableArrayList();
        for (CharacterClasses currentClass : CharacterClasses.values()) {
            classOptions.add(currentClass.toString());
        }
        for (CharacterRaces currentRace : CharacterRaces.values()) {
            raceOptions.add(currentRace.toString());
        }
        raceChoice.valueProperty().addListener((observable, oldValue, newValue) -> {
            manageRacialStatBonuses(newValue);
            calculateAllFinalAbilityScores();
        });
        classChoice.setItems(classOptions);
        raceChoice.setItems(raceOptions);
        middleBox.add(characterName, 0, 0, 10, 1);
        leftBox.getChildren().add(classChoice);
        leftBox.getChildren().add(raceChoice);
        leftBox.getChildren().add(returnToMainMenu);
    }

    private void manageRacialStatBonuses(String raceName) {
        switchTheRace();
        switch (raceName) {
            case "Deva": {
                applyStatBonuses("Charisma", "Intelligence", "Wisdom");
                break;
            }
            case "Dragonborn": {
                applyStatBonuses("Charisma", "Strength", "Constitution");
                break;
            }
            case "Dwarf": {
                applyStatBonuses("Constitution", "Strength", "Wisdom");
                break;
            }
            case "Eladrin":
            case "Gnome": {
                applyStatBonuses("Intelligence", "Dexterity", "Charisma");
                break;
            }
            case "Elf": {
                applyStatBonuses("Dexterity", "Intelligence", "Wisdom");
                break;
            }
            case "Goliath": {
                applyStatBonuses("Strength", "Constitution", "Wisdom");
                break;
            }
            case "Halfelf": {
                applyStatBonuses("Constitution", "Wisdom", "Charisma");
                break;
            }
            case "Halforc": {
                applyStatBonuses("Dexterity", "Strength", "Constitution");
                break;
            }
            case "Halfling": {
                applyStatBonuses("Dexterity", "Charisma", "Constitution");
                break;
            }
            case "Shifter": {
                applyStatBonuses("Wisdom", "Strength", "Dexterity");
                break;
            }
            case "Tiefling": {
                applyStatBonuses("Charisma", "Constitution", "Intelligence");
                break;
            }
            case "Human": {
                racialBonusesRadioButtons.get(getStatID("Strength")).setDisable(false);
                racialBonusesRadioButtons.get(getStatID("Constitution")).setDisable(false);
                racialBonusesRadioButtons.get(getStatID("Dexterity")).setDisable(false);
                racialBonusesRadioButtons.get(getStatID("Intelligence")).setDisable(false);
                racialBonusesRadioButtons.get(getStatID("Wisdom")).setDisable(false);
                racialBonusesRadioButtons.get(getStatID("Charisma")).setDisable(false);
            }
        }
    }

    private void applyStatBonuses(String mainStat, String secondaryStat1, String secondaryStat2) {
        racialBonusesModifiers.get(getStatID(mainStat)).setText(" +2 ");
        racialBonusesRadioButtons.get(getStatID(secondaryStat1)).setDisable(false);
        racialBonusesRadioButtons.get(getStatID(secondaryStat2)).setDisable(false);
    }

    private int getStatID(String name) {
        return Stats.valueOf(name).ordinal();
    }

    private void switchTheRace() {
        for (RadioButton racialBonusesRadioButton : racialBonusesRadioButtons) {
            racialBonusesRadioButton.setDisable(true);
        }
        for (Text racialBonusesModifier : racialBonusesModifiers) {
            racialBonusesModifier.setText("      ");
        }
    }

    private void setStyling() {
        leftBox.setPadding(new Insets(5, 5, 5, 5));
        leftBox.setVgap(4);
        leftBox.setHgap(4);
        leftBox.setPrefWrapLength(170);
        characterName.setMinWidth(170);
        raceChoice.setMinWidth(150);
        classChoice.setMinWidth(150);
        middleBox.setStyle("-fx-background-color: DAE6F3;");
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
