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
    private String selectedHeroClass;
    ScrollPane characterCreatorOuterPane = new ScrollPane();
    private BorderPane characterCreatorInnerPane = new BorderPane();
    private HBox topBox = new HBox();
    private FlowPane leftBox = new FlowPane();
    private GridPane middleBox = new GridPane();
    private VBox rightBox = new VBox();
    private ComboBox<String> classChoice = new ComboBox<>();
    private ComboBox<String> raceChoice = new ComboBox<>();
    private Button returnToMainMenu = new Button();
    private TextField characterName = new TextField();
    private final ToggleGroup racialToggleGroup = new ToggleGroup();
    private List<RadioButton> racialBonusRadioButtons = new ArrayList<>();
    private List<Text> racialBonusNumbers = new ArrayList<>();
    private List<Spinner<Integer>> statsValueSpinners = new ArrayList<>();
    private List<Text> statNames = new ArrayList<>();
    private Text modifierText = new Text();
    private Text racialBonusText = new Text();
    private List<Text> modifierNumbersTextList = new ArrayList<>();
    private ObservableList<Integer> statPointsOptions = FXCollections.observableArrayList();
    private Text finalScoreText = new Text("  Final  \n  Score  ");
    private List<Text> finalAbilityScores = new ArrayList<>();
    private int[] abilityIntegersArray = new int[6];
    private int availableStatPoints = 20;
    private int numberOfAvailableSkillPoints = 0;
    private int maxHP = 0;
    private int fort = 0;
    private int reflex = 0;
    private int will = 0;
    private int AC = 10;
    private Text skillPointsText = new Text(String.valueOf(numberOfAvailableSkillPoints));
    private ListView<String> selectedSkillsListView = new ListView<>();
    private ListView<String> availableSkillsListView = new ListView<>();
    private TextField pointsToSpend = new TextField(String.valueOf(availableStatPoints));
    private ObservableList<String> availableSkills = FXCollections.observableArrayList();
    private ObservableList<String> selectedSkills = FXCollections.observableArrayList();
    private Text maxHpText = new Text("Max HP: \t\t\t" + maxHP);
    private Text fortitudeSaveText = new Text("Fortitude: \t\t" + fort);
    private Text reflexSaveText = new Text("Reflex: \t\t\t" + reflex);
    private Text willSaveText = new Text("Will: \t\t\t\t" + will);
    private Text armorClassText = new Text("Armor Class: \t\t" + AC);

    public CharacterCreatorGUI() {
        initializeCharacterCreatorGUI();
    }

    //todo finishing the character creation should save it in a database.

    private void initializeCharacterCreatorGUI() {
        manageThePanes();
        addElementsToPanes();
        setStyling();
        addTheAbilityChoices();
        addTheSkillList();
        calculateAllFinalAbilityScores();
        addTheDerivedElements();
        returnToMainMenu.setOnAction(event -> returnToMainMenu());
        updateMaxHP(null);
    }

    enum CharacterSkills {
        Acrobatics, Arcana, Athletics, Bluff, Diplomacy, Dungeoneering, Endurance, Heal, History, Insight, Intimidate, Nature, Perception, Religion, Stealth, Streetwise, Thievery
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

    //todo saving throws are not working with negative values
    //todo add Armor Class and AC calculations
    //todo add starting equipment selection
    //todo add starting powers selection (daily/encounter/at-will)

    private void addTheDerivedElements() {
        Text breakLine = new Text("    ");
        middleBox.add(breakLine, 0, 10);
        middleBox.add(maxHpText, 0, 11);
        Text savingText = new Text("Saving Throws:  ");
        middleBox.add(savingText, 0, 12);
        middleBox.add(fortitudeSaveText, 0, 13);
        middleBox.add(reflexSaveText, 0, 14);
        middleBox.add(willSaveText, 0, 15);
        middleBox.add(armorClassText, 0, 16);
    }

    private void addTheSkillList() {
        Text availableSkillPointsText = new Text("Number of available skill points: ");
        Text skillListText = new Text("List of Skills: ");
        Text selectedSkillsText = new Text("Trained skills: ");
        for (CharacterSkills currentSkill : CharacterSkills.values()) {
            availableSkills.add(currentSkill.toString());
        }
        availableSkillsListView.setItems(availableSkills);
        availableSkillsListView.setMaxHeight(availableSkills.size() * 24);
        availableSkillsListView.setOnMouseClicked(event -> eventOnSkillSelection());
        selectedSkillsListView.setOnMouseClicked(event -> eventOnSkillDeselection());
        rightBox.getChildren().add(availableSkillPointsText);
        rightBox.getChildren().add(skillPointsText);
        rightBox.getChildren().add(skillListText);
        rightBox.getChildren().add(availableSkillsListView);
        rightBox.getChildren().add(selectedSkillsText);
        selectedSkillsListView.setMaxHeight(0);
        availableSkillsListView.setDisable(true);
        rightBox.getChildren().add(selectedSkillsListView);
    }

    private void eventOnSkillSelection() {
        String selection = availableSkillsListView.getSelectionModel().getSelectedItems().toString().replaceAll("[^a-zA-Z]", "");
        availableSkills.removeAll(selection);
        availableSkillsListView.setItems(availableSkills);
        selectedSkills.add(selection);
        selectedSkillsListView.setItems(selectedSkills);
        System.out.println(selection);
        selectedSkillsListView.setMaxHeight(selectedSkills.size() * 24);
        availableSkillsListView.setMaxHeight(availableSkills.size() * 24);
        numberOfAvailableSkillPoints = (numberOfAvailableSkillPoints - 1);
        skillPointsText.setText(String.valueOf(numberOfAvailableSkillPoints));
        if (numberOfAvailableSkillPoints == 0) {
            availableSkillsListView.setDisable(true);
        }
    }

    private void eventOnSkillDeselection() {
        String selection = selectedSkillsListView.getSelectionModel().getSelectedItems().toString().replaceAll("[^a-zA-Z]", "");
        selectedSkills.removeAll(selection);
        selectedSkillsListView.setItems(selectedSkills);
        availableSkills.add(selection);
        availableSkillsListView.setItems(availableSkills);
        System.out.println(selection);
        selectedSkillsListView.setMaxHeight(selectedSkills.size() * 24);
        availableSkillsListView.setMaxHeight(availableSkills.size() * 24);
        numberOfAvailableSkillPoints = (numberOfAvailableSkillPoints + 1);
        skillPointsText.setText(String.valueOf(numberOfAvailableSkillPoints));
        availableSkillsListView.setDisable(false);
    }

    private void addTheAbilityChoices() {

        for (int i = 8; i < 19; i++) {
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
        Text AvailablePointsText = new Text("  Available \n    Points");
        middleBox.add(AvailablePointsText, 0, 9);
        pointsToSpend.setDisable(true);
        middleBox.add(pointsToSpend, 1, 9);
        racialToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            eventOnRadioButtonChange(oldValue, newValue);
            calculateAllFinalAbilityScores();
        });
    }

    private void eventOnRadioButtonChange(Toggle oldValue, Toggle newValue) {
        if (oldValue != null) {
            String oldValueString = oldValue.toString();
            String trimmedString = oldValueString.substring(oldValueString.indexOf('\'')).replaceAll("\\W", "");
            racialBonusNumbers.get(getStatID(trimmedString)).setText("      ");
            System.out.println(trimmedString);
        }
        String radioButtonString;
        try {
            radioButtonString = newValue.toString();
            String trimmedString = radioButtonString.substring(radioButtonString.indexOf('\'')).replaceAll("\\W", "");
            racialBonusNumbers.get(getStatID(trimmedString)).setText(" +2 ");
            System.out.println(trimmedString);
        } catch (NullPointerException ignored) {
        }
        updateMaxHP(selectedHeroClass);
        updateSavingThrows();
    }

    private void updateMaxHP(String selectedClass) {
        int constitution = abilityIntegersArray[1];
        try {
            HeroClassInformation classInfo = new HeroClassInformation();

            int a = classInfo.hitDiceAt1st.get(selectedClass);
            System.out.println(a);
            maxHP = (classInfo.hitDiceAt1st.get(selectedClass) + constitution);
            maxHpText.setText("Max HP: \t\t" + maxHP);
        } catch (NullPointerException e) {
            maxHP = (constitution);
            maxHpText.setText("Max HP: \t\t" + maxHP);

        }
    }

    private void updateSavingThrows() {
        fort = 0;
        reflex = 0;
        will = 0;
        for (int i = 0; i < abilityIntegersArray.length; i++) {
            int currentStat = abilityIntegersArray[i];
            int currentSave = (currentStat - 10) / 2;
            if (i < 2) {
                if (currentSave > fort) {
                    fort = currentSave;
                }
            } else if (i < 4) {
                if (currentSave > reflex) {
                    reflex = currentSave;
                    AC = 10 + reflex;
                }
            } else {
                if (currentSave > will) {
                    will = currentSave;
                }
            }
        }
        fortitudeSaveText.setText("Fortitude: \t\t" + fort);
        reflexSaveText.setText("Reflex: \t\t\t" + reflex);
        willSaveText.setText("Will: \t\t\t\t" + will);
        armorClassText.setText("Armor Class: \t\t" + AC);
    }

    private void prepareASingleAttribute(Stats currentStat) {
        statNames.add(new Text("  " + currentStat.toString() + " "));
        statsValueSpinners.add(new Spinner<>(statPointsOptions));
        modifierNumbersTextList.add(new Text(" "));
        racialBonusNumbers.add(new Text("      "));
        racialBonusRadioButtons.add(new RadioButton(currentStat.toString()));
        finalAbilityScores.add(new Text(" "));
    }

    private void displayASingleAttribute(int i) {
        statsValueSpinners.get(i).getValueFactory().setValue(10);
        statsValueSpinners.get(i).valueProperty().addListener((observable, oldValue, newValue) -> eventOnSpinnerChange(oldValue, newValue));
        racialBonusRadioButtons.get(i).setToggleGroup(racialToggleGroup);
        racialBonusRadioButtons.get(i).setDisable(true);
        middleBox.add(statNames.get(i), 0, i + 2);
        middleBox.add(statsValueSpinners.get(i), 1, i + 2);
        middleBox.add(racialBonusNumbers.get(i), 2, i + 2);
        middleBox.add(racialBonusRadioButtons.get(i), 3, i + 2);
        middleBox.add(finalAbilityScores.get(i), 4, i + 2);
        middleBox.add(modifierNumbersTextList.get(i), 5, i + 2);
    }

    private void eventOnSpinnerChange(Integer oldValue, Integer newValue) {
        availableStatPoints = availableStatPoints + calculateTotalPointsChange(oldValue, newValue);
        pointsToSpend.setText(String.valueOf(availableStatPoints));
        calculateAllFinalAbilityScores();
        updateMaxHP(selectedHeroClass);
        updateSavingThrows();
    }

    private void manageThePanes() {
        characterCreatorOuterPane.setContent(characterCreatorInnerPane);
        characterCreatorInnerPane.setTop(topBox);
        characterCreatorInnerPane.setLeft(leftBox);
        characterCreatorInnerPane.setCenter(middleBox);
        characterCreatorInnerPane.setRight(rightBox);
    }

    private int calculateTotalPointsChange(int oldValue, int newValue) {
        int pointsForSingleStat;
        if (newValue < 12) {
            return (oldValue - newValue);
        } else if (newValue > oldValue) {
            pointsForSingleStat = (newValue - 10) / 2;
        } else {
            pointsForSingleStat = (oldValue - 10) / 2;
        }
        return pointsForSingleStat * (oldValue - newValue);
    }


    private void calculateAllFinalAbilityScores() {
        for (int i = 0; i < finalAbilityScores.size(); i++) {
            int bonusFromChoice = statsValueSpinners.get(i).getValue();
            String textToBeSet = racialBonusNumbers.get(i).getText().replaceAll("\\D", "");
            int racialBonus = 0;
            if (textToBeSet.length() > 0) {
                racialBonus = Integer.parseInt(textToBeSet);
            }
            int sum = racialBonus + bonusFromChoice;
            abilityIntegersArray[i] = sum;
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
        raceChoice.valueProperty().addListener((observable, oldValue, newValue) -> eventOnSelectHeroRace(newValue));
        classChoice.valueProperty().addListener((observable, oldValue, newValue) -> eventOnSelectHeroClass(newValue));
        classChoice.setItems(classOptions);
        raceChoice.setItems(raceOptions);
        middleBox.add(characterName, 0, 0, 10, 1);
        leftBox.getChildren().add(classChoice);
        leftBox.getChildren().add(raceChoice);
        leftBox.getChildren().add(returnToMainMenu);
    }

    private void eventOnSelectHeroRace(String newValue) {
        manageRacialStatBonuses(newValue);
        calculateAllFinalAbilityScores();
        for (int i = 0; i < 6; i++) {
            racialBonusRadioButtons.get(i).setSelected(false);
        }
        updateSavingThrows();
    }

    private void eventOnSelectHeroClass(String newValue) {
        HeroClassInformation heroClassInformation = new HeroClassInformation();
        System.out.println(newValue);
        availableSkills.clear();
        selectedSkills.clear();
        availableSkills.addAll(heroClassInformation.availableSkills.get(newValue));
        availableSkillsListView.setMaxHeight(availableSkills.size() * 24);
        selectedSkillsListView.setMaxHeight(selectedSkills.size() * 24);
        numberOfAvailableSkillPoints = (heroClassInformation.classSkillPoints.get(newValue));
        skillPointsText.setText(String.valueOf(numberOfAvailableSkillPoints));
        availableSkillsListView.setDisable(false);
        updateMaxHP(newValue);
        selectedHeroClass = newValue;
        updateSavingThrows();
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
                racialBonusRadioButtons.get(getStatID("Strength")).setDisable(false);
                racialBonusRadioButtons.get(getStatID("Constitution")).setDisable(false);
                racialBonusRadioButtons.get(getStatID("Dexterity")).setDisable(false);
                racialBonusRadioButtons.get(getStatID("Intelligence")).setDisable(false);
                racialBonusRadioButtons.get(getStatID("Wisdom")).setDisable(false);
                racialBonusRadioButtons.get(getStatID("Charisma")).setDisable(false);
            }
        }
    }

    private void applyStatBonuses(String mainStat, String secondaryStat1, String secondaryStat2) {
        racialBonusNumbers.get(getStatID(mainStat)).setText(" +2 ");
        racialBonusRadioButtons.get(getStatID(secondaryStat1)).setDisable(false);
        racialBonusRadioButtons.get(getStatID(secondaryStat2)).setDisable(false);
    }

    private int getStatID(String name) {
        return Stats.valueOf(name).ordinal();
    }

    private void switchTheRace() {
        for (RadioButton racialBonusesRadioButton : racialBonusRadioButtons) {
            racialBonusesRadioButton.setDisable(true);
        }
        for (Text racialBonusesModifier : racialBonusNumbers) {
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
