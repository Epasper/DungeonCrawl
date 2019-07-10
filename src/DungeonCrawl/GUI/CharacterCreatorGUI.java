package DungeonCrawl.GUI;

import DungeonCrawl.GUI.Images.SkillIcons.SkillIcons;
import DungeonCrawl.StaticRules.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import DungeonCrawl.*;
import DungeonCrawl.DAO.HeroDAO;
import DungeonCrawl.DTO.HeroDTO;
import DungeonCrawl.HeroPowers.HeroPower;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.valueOf;

class CharacterCreatorGUI {
    private MainMenuGUI mainMenuGUI = new MainMenuGUI();
    private String selectedHeroClass;
    private ScrollPane characterCreatorOuterPane = new ScrollPane();
    private BorderPane characterCreatorInnerPane = new BorderPane();
    private HBox topBox = new HBox();
    private FlowPane leftBox = new FlowPane();
    private GridPane middleBox = new GridPane();
    private VBox rightBox = new VBox();
    private ComboBox<String> classChoice = new ComboBox<>();
    private ComboBox<String> atWill1Choice = new ComboBox<>();
    private ComboBox<String> atWill2Choice = new ComboBox<>();
    private ComboBox<String> encounterChoice = new ComboBox<>();
    private ComboBox<String> dailyChoice = new ComboBox<>();
    private ComboBox<String> classTraitChoice = new ComboBox<>();
    private ComboBox<String> raceChoice = new ComboBox<>();
    private Button atWill1IconSelect = new Button("Select Icon");
    private Button atWill2IconSelect = new Button("Select Icon");
    private Button encounterIconSelect = new Button("Select Icon");
    private Button dailyIconSelect = new Button("Select Icon");
    private ImageView atWill1MiniatureIcon = new ImageView();
    private ImageView atWill2MiniatureIcon = new ImageView();
    private ImageView encounterMiniatureIcon = new ImageView();
    private ImageView dailyMiniatureIcon = new ImageView();
    private Button returnToMainMenu = new Button();
    private Button saveTheCharacter = new Button();
    private Button addACharacterPortrait = new Button();
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
    private List<Text> finalAttributeScoresTexts = new ArrayList<>();
    private int[] finalAttributeIntegersArray = new int[6];
    private int[] finalSkillPointsArray = new int[17];
    private int availableAttributePoints = 20;
    private int numberOfAvailableSkillPoints = 0;
    private int maxHP = 0;
    private int fort = 0;
    private int reflex = 0;
    private int will = 0;
    private int AC = 10;
    private Text skillPointsText = new Text(String.valueOf(numberOfAvailableSkillPoints));
    private ListView<String> allSkillsListView = new ListView<>();
    private ListView<String> selectedSkillsListView = new ListView<>();
    private ListView<String> availableSkillsListView = new ListView<>();
    private TextField pointsToSpend = new TextField(String.valueOf(availableAttributePoints));
    private ObservableList<String> allSkills = FXCollections.observableArrayList();
    private ObservableList<String> availableSkills = FXCollections.observableArrayList();
    private ObservableList<String> selectedSkills = FXCollections.observableArrayList();
    private Text maxHpText = new Text("Max HP: \t\t\t" + maxHP);
    private Text fortitudeSaveText = new Text("Fortitude: \t\t" + fort);
    private Text reflexSaveText = new Text("Reflex: \t\t\t" + reflex);
    private Text willSaveText = new Text("Will: \t\t\t\t" + will);
    private Text armorClassText = new Text("Armor Class: \t\t" + AC);
    private TextArea powerDescription = new TextArea();
    private int iconID;
    private Popup equipInfoPopup = new Popup();
    private int atWillPower1IconID = -1;
    private int atWillPower2IconID = -1;
    private int encounterPowerIconID = -1;
    private int dailyPowerIconID = -1;

    CharacterCreatorGUI() {
        initializeCharacterCreatorGUI();
    }

    private void initializeCharacterCreatorGUI() {
        getCharacterCreatorOuterPane().getStylesheets().add("DungeonCrawl/Styling/CharacterCreator.css");
        manageThePanes();
        addElementsToPanes();
        setStyling();
        addTheAttributeChoices();
        addTheSkillList();
        calculateAllFinalAbilityScores();
        addTheDerivedElements();
        returnToMainMenu.setOnAction(event -> returnToMainMenu());
        saveTheCharacter.setOnAction((event -> {
            try {
                prepareTheDTOObject();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));

        addACharacterPortrait.setOnAction((event -> {
            try {
                choosePortrait();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }));
        updateMaxHP(null);

    }

    private void choosePortrait() throws SQLException, IOException {
        GridPane gridPane = new GridPane();
        List<Image> listOfIcons = getAllIcons();
        Stage aStage = new Stage();
        Scene aScene = new Scene(new Group());
        aStage.setTitle("Select a Character Icon");
        aScene.getStylesheets().add("DungeonCrawl/Styling/CharacterCreator.css");
        for (int i = 0; i < listOfIcons.size(); i++) {
            ImageView imageView = new ImageView();
            Button aButton = new Button();
            aButton.setId(String.valueOf(i));
            imageView.setImage(listOfIcons.get(i));
            aButton.setGraphic(imageView);
            int x = i % 5;
            int y = i / 5;
            gridPane.add(aButton, y, x);
            aButton.setOnAction(event -> {
                try {
                    updateThePortrait(aButton.getId());
                } catch (SQLException | IOException e) {
                    e.printStackTrace();
                }
                aStage.close();
            });
        }
        aScene.setRoot(gridPane);
        aStage.setScene(aScene);
        aStage.show();
    }

    private void chooseASkillIcon(String typeOfPower) {
        GridPane gridPane = new GridPane();
        SkillIcons skillIcons = new SkillIcons();
        List<Image> listOfIcons = skillIcons.getListOfSkillIcons();
        Stage aStage = new Stage();
        Scene aScene = new Scene(new Group());
        aStage.setTitle("Select a Skill Icon");
        aScene.getStylesheets().add("DungeonCrawl/Styling/CharacterCreator.css");
        for (int i = 0; i < listOfIcons.size(); i++) {
            ImageView imageView = new ImageView();
            Button aButton = new Button();
            aButton.setId(String.valueOf(i));
            imageView.setImage(listOfIcons.get(i));
            aButton.setGraphic(imageView);
            int x = i % 5;
            int y = i / 5;
            gridPane.add(aButton, y, x);
            aButton.setOnAction(event -> {
                updateTheSkillIconID(aButton.getId(), typeOfPower);
                aStage.close();
            });
        }
        aScene.setRoot(gridPane);
        aStage.setScene(aScene);
        aStage.show();
    }

    private void updateThePortrait(String portraitId) throws SQLException, IOException {
        int id = Integer.valueOf(portraitId);
        HeroDAO dao = new HeroDAO();
        System.out.println("CURRENT ID: " + id);
        Image hero1img = dao.getHeroIconByID(id);
        iconID = id;
        ImageView heroImageView = new ImageView(hero1img);
        try {
            leftBox.getChildren().remove(5);
        } catch (IndexOutOfBoundsException ignored) {
        }
        leftBox.getChildren().add(5, heroImageView);
    }

    private void updateTheSkillIconID(String portraitId, String typeOfPower) {
        int id = Integer.valueOf(portraitId);
        SkillIcons skillIcons = new SkillIcons();
        String ok = "Icon Selected";
        System.out.println("CURRENT ID: " + id);
        switch (typeOfPower) {
            case "AtWill1":
                atWillPower1IconID = id;
                atWill1IconSelect.setText(ok);
                atWill1MiniatureIcon.setImage(skillIcons.getSkillIconById(id));
                atWill1MiniatureIcon.setFitHeight(25);
                atWill1MiniatureIcon.setFitWidth(25);
                break;
            case "AtWill2":
                atWillPower2IconID = id;
                atWill2IconSelect.setText(ok);
                atWill2MiniatureIcon.setImage(skillIcons.getSkillIconById(id));
                atWill2MiniatureIcon.setFitHeight(25);
                atWill2MiniatureIcon.setFitWidth(25);
                break;
            case "Encounter":
                encounterPowerIconID = id;
                encounterIconSelect.setText(ok);
                encounterMiniatureIcon.setImage(skillIcons.getSkillIconById(id));
                encounterMiniatureIcon.setFitHeight(25);
                encounterMiniatureIcon.setFitWidth(25);
                break;
            case "Daily":
                dailyPowerIconID = id;
                dailyIconSelect.setText(ok);
                dailyMiniatureIcon.setImage(skillIcons.getSkillIconById(id));
                dailyMiniatureIcon.setFitHeight(25);
                dailyMiniatureIcon.setFitWidth(25);
                break;
        }
    }

    //todo refactor this class in accordance to Single Responsibility

    private List<Image> getAllIcons() {
        HeroDAO dao = new HeroDAO();
        return dao.getAllHeroIcons();
    }

    private void prepareTheDTOObject() throws IOException {
        HeroDTO heroDTO = new HeroDTO();
        heroDTO.setHeroName(characterName.getText());
        heroDTO.setHeroClass(classChoice.getValue());
        heroDTO.setHeroRace(raceChoice.getValue());
        heroDTO.setStrength(finalAttributeIntegersArray[0]);
        heroDTO.setConstitution(finalAttributeIntegersArray[1]);
        heroDTO.setDexterity(finalAttributeIntegersArray[2]);
        heroDTO.setIntelligence(finalAttributeIntegersArray[3]);
        heroDTO.setWisdom(finalAttributeIntegersArray[4]);
        heroDTO.setCharisma(finalAttributeIntegersArray[5]);
        heroDTO.setFortitude(fort);
        heroDTO.setReflex(reflex);
        heroDTO.setWill(will);
        heroDTO.setHitPoints(maxHP);
        heroDTO.setGold(100);
        heroDTO.setHeroIconId(iconID);
        heroDTO.setAtWillPower1(atWill1Choice.getValue());
        heroDTO.setAtWillPower2(atWill2Choice.getValue());
        heroDTO.setEncounterPower1(encounterChoice.getValue());
        heroDTO.setDailyPower1(dailyChoice.getValue());
        heroDTO.setAtWillPower1IconID(String.valueOf(atWillPower1IconID));
        heroDTO.setAtWillPower2IconID(String.valueOf(atWillPower2IconID));
        heroDTO.setEncounterPowerIconID(String.valueOf(encounterPowerIconID));
        heroDTO.setDailyPowerIconID(String.valueOf(dailyPowerIconID));
        heroDTO.setAcrobatics(finalSkillPointsArray[0]);
        heroDTO.setArcana(finalSkillPointsArray[1]);
        heroDTO.setAthletics(finalSkillPointsArray[2]);
        heroDTO.setBluff(finalSkillPointsArray[3]);
        heroDTO.setDiplomacy(finalSkillPointsArray[4]);
        heroDTO.setDungeoneering(finalSkillPointsArray[5]);
        heroDTO.setEndurance(finalSkillPointsArray[6]);
        heroDTO.setHeal(finalSkillPointsArray[7]);
        heroDTO.setHistory(finalSkillPointsArray[8]);
        heroDTO.setInsight(finalSkillPointsArray[9]);
        heroDTO.setIntimidate(finalSkillPointsArray[10]);
        heroDTO.setNature(finalSkillPointsArray[11]);
        heroDTO.setPerception(finalSkillPointsArray[12]);
        heroDTO.setReligion(finalSkillPointsArray[13]);
        heroDTO.setStealth(finalSkillPointsArray[14]);
        heroDTO.setStreetwise(finalSkillPointsArray[15]);
        heroDTO.setThievery(finalSkillPointsArray[16]);
        List<String> errors = validateTheCharacterFields(heroDTO);
        if (errors.size() == 0) {
            HeroDAO characterCreatorDAO = new HeroDAO();
            characterCreatorDAO.addAHeroToDatabase(heroDTO);
        } else {
            StringBuilder errorBuilder = new StringBuilder();
            errorBuilder.append("Character cannot be created. Check the information below for details: \n");
            for (String currentError : errors) {
                errorBuilder.append(currentError).append("\n");
                powerDescription.clear();
                powerDescription.setText(errorBuilder.toString());
            }
        }
    }

    //todo after saving a character successfully, add a confirmation scene and return to main menu (or go to equipment shop)

    private List<String> validateTheCharacterFields(HeroDTO heroDTO) {
        List<String> listOfErrorMessages = new ArrayList<>();
        if (heroDTO.getHeroName().isEmpty())
            listOfErrorMessages.add("Write a name for your character.");
        if (heroDTO.getHeroClass() == null) {
            listOfErrorMessages.add("Select your character's class.");
        }
        if (heroDTO.getHeroRace() == null) {
            listOfErrorMessages.add("Select your character's race.");
        }
        if (availableAttributePoints > 0)
            listOfErrorMessages.add("You still have some attribute points left. Increase some AttributeNames.");
        if (availableAttributePoints < 0)
            listOfErrorMessages.add("Some of your attributes are too high. The number of attribute points has to be 0 for the character to be finished.");
        if (heroDTO.getHeroIconId() == 0)
            listOfErrorMessages.add("Select your character's portrait.");
        if ((heroDTO.getAtWillPower1().contains("Select")) || (heroDTO.getAtWillPower2().contains("Select")))
            listOfErrorMessages.add("Select an at will power.");
        if (heroDTO.getEncounterPower1().contains("Select"))
            listOfErrorMessages.add("Select an encounter power.");
        if (heroDTO.getDailyPower1().contains("Select"))
            listOfErrorMessages.add("Select a daily power.");
        if (Integer.valueOf(heroDTO.getAtWillPower1IconID()) < 0) {
            listOfErrorMessages.add("Select an Icon for one of your at will powers.");
        }
        if (Integer.valueOf(heroDTO.getAtWillPower2IconID()) < 0) {
            listOfErrorMessages.add("Select an Icon for one of your at will powers.");
        }
        if (Integer.valueOf(heroDTO.getEncounterPowerIconID()) < 0) {
            listOfErrorMessages.add("Select an Icon for your encounter power.");
        }
        if (Integer.valueOf(heroDTO.getDailyPowerIconID()) < 0) {
            listOfErrorMessages.add("Select an Icon for your daily power.");
        }
        return listOfErrorMessages;
    }

    private void addTheDerivedElements() {
        manageDerivedElementsStyling();
        disableComboBoxesUntilClassIsSelected();
        addElementsToMiddleBox();
        addEventsToIconSelectButtons();

    }

    private void disableComboBoxesUntilClassIsSelected() {
        atWill1Choice.setDisable(true);
        atWill2Choice.setDisable(true);
        encounterChoice.setDisable(true);
        dailyChoice.setDisable(true);
    }

    private void manageDerivedElementsStyling() {
        atWill1Choice.setMinWidth(200);
        atWill2Choice.setMinWidth(200);
        encounterChoice.setMinWidth(200);
        dailyChoice.setMinWidth(200);
        classTraitChoice.setMinWidth(200);
        atWill1IconSelect.setMaxHeight(atWill1Choice.getMaxHeight());
        atWill2IconSelect.setMaxHeight(atWill2Choice.getMaxHeight());
        encounterIconSelect.setMaxHeight(encounterChoice.getMaxHeight());
        dailyIconSelect.setMaxHeight(dailyChoice.getMaxHeight());
        encounterChoice.setStyle("-fx-background-color: #910000;");
        dailyChoice.setStyle("-fx-background-color: #5c005e;");
        atWill1Choice.setStyle("-fx-background-color: #007200;");
        atWill2Choice.setStyle("-fx-background-color: #007200;");
        atWill1Choice.setValue("Select 1st At Will Power");
        atWill2Choice.setValue("Select 2nd At Will Power");
        encounterChoice.setValue("Select an Encounter Power");
        dailyChoice.setValue("Select a Daily Power");
    }

    private void addElementsToMiddleBox() {
        Text breakLine = new Text("    ");
        middleBox.add(breakLine, 0, 10);
        middleBox.add(maxHpText, 0, 11);
        Text savingText = new Text("Saving Throws:  ");
        savingText.setFill(Color.WHITE);
        middleBox.add(atWill1Choice, 2, 12);
        middleBox.add(atWill1IconSelect, 3, 12);
        middleBox.add(atWill1MiniatureIcon, 4, 12);
        middleBox.add(atWill2Choice, 2, 13);
        middleBox.add(atWill2IconSelect, 3, 13);
        middleBox.add(atWill2MiniatureIcon, 4, 13);
        middleBox.add(encounterChoice, 2, 14);
        middleBox.add(encounterIconSelect, 3, 14);
        middleBox.add(encounterMiniatureIcon, 4, 14);
        middleBox.add(dailyChoice, 2, 15);
        middleBox.add(dailyIconSelect, 3, 15);
        middleBox.add(dailyMiniatureIcon, 4, 15);
        middleBox.add(classTraitChoice, 2, 11);
        middleBox.add(savingText, 0, 12);
        middleBox.add(fortitudeSaveText, 0, 13);
        middleBox.add(reflexSaveText, 0, 14);
        middleBox.add(willSaveText, 0, 15);
        middleBox.add(armorClassText, 0, 16);
        powerDescription.setMinSize(120, 250);
        middleBox.add(powerDescription, 0, 25, 10, 1);
    }

    private void addEventsToIconSelectButtons() {
        String ok = "Power Selected";
        atWill1IconSelect.setOnAction(event -> chooseASkillIcon("AtWill1"));
        atWill2IconSelect.setOnAction(event -> chooseASkillIcon("AtWill2"));
        encounterIconSelect.setOnAction(event -> chooseASkillIcon("Encounter"));
        dailyIconSelect.setOnAction(event -> chooseASkillIcon("Daily"));
    }

    private void addTheSkillList() {
        Text availableSkillPointsText = new Text("Number of available skill points: ");
        availableSkillPointsText.setFill(Color.WHITE);
        Text skillListText = new Text("List of Skills that can be trained: ");
        Text allSkillsListText = new Text("List of all Skills: ");
        skillListText.setFill(Color.WHITE);
        allSkillsListText.setFill(Color.WHITE);
        Text selectedSkillsText = new Text("Trained skills: ");
        selectedSkillsText.setFill(Color.WHITE);
        buildSkillBoxes(true);
        allSkillsListView.setItems(allSkills);
        allSkillsListView.setDisable(true);
        availableSkillsListView.setItems(availableSkills);
        availableSkillsListView.setMaxHeight(availableSkills.size() * 24);
        allSkillsListView.setMaxHeight(allSkills.size() * 24);
        availableSkillsListView.setOnMouseClicked(event -> eventOnSkillSelection());
        selectedSkillsListView.setOnMouseClicked(event -> eventOnSkillDeselection());
        rightBox.getChildren().add(allSkillsListText);
        rightBox.getChildren().add(allSkillsListView);
        rightBox.getChildren().add(availableSkillPointsText);
        rightBox.getChildren().add(skillPointsText);
        rightBox.getChildren().add(skillListText);
        rightBox.getChildren().add(availableSkillsListView);
        rightBox.getChildren().add(selectedSkillsText);
        selectedSkillsListView.setMaxHeight(0);
        availableSkillsListView.setDisable(true);
        rightBox.getChildren().add(selectedSkillsListView);
    }

    private void buildSkillBoxes(boolean isThisTheFirstBuild) {
        allSkills.clear();
        HeroClassInformation heroClassInformation = new HeroClassInformation();
        int i = 0;
        for (HeroSkills currentSkill : HeroSkills.values()) {
            if (isThisTheFirstBuild) {
                availableSkills.add(currentSkill.toString());
            }
            String attribute = heroClassInformation.getSkillsAndCorrespondingAttributes().get(currentSkill).toString();
            String attributeAbbreviation = attribute.substring(0, 3).toUpperCase();
            StringBuilder skillName = uglyWorkaroundForSkillPointsFormatting(currentSkill);
            int skillValue = getFinalAbilityScoreByName(attribute);
            int skillModifier = (skillValue - 10) / 2;
            if (skillValue == 9) skillModifier = -1;
            if (isThisTheFirstBuild) skillModifier = 0;
            for (String skill : selectedSkills) {
                if (currentSkill.toString().equals(skill)) {
                    skillModifier += 5;
                }
            }
            allSkills.add("[" + attributeAbbreviation + "]  \t" + skillName + "\t " + skillModifier);
            allSkillsListView.setItems(allSkills);
            finalSkillPointsArray[i] = skillModifier;
            i++;
        }
    }

    private StringBuilder uglyWorkaroundForSkillPointsFormatting(HeroSkills currentSkill) {
        StringBuilder skillName = new StringBuilder(currentSkill.toString());
        boolean longWord = false;
        boolean shortWord = false;
        for (int i = 0; i < 36; i++) {
            try {
                char aChar = skillName.charAt(i);
                if (i == 12) {
                    longWord = true;
                }
            } catch (IndexOutOfBoundsException e) {
                if (i == 8) {
                    shortWord = true;
                }
                if (!longWord) {
                    skillName.append(" ");
                }
                longWord = false;
            }
        }
        if (shortWord) {
            skillName.append("  ");
        }
        return skillName;
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
        buildSkillBoxes(false);
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
        buildSkillBoxes(false);
    }

    private void addTheAttributeChoices() {

        for (int i = 8; i < 19; i++) {
            statPointsOptions.add(i);
        }
        for (AttributeNames currentStat : AttributeNames.values()) {
            prepareASingleAttribute(currentStat);
        }
        for (int i = 0; i < 6; i++) {
            displayASingleAttribute(i);
        }
        addGUIAttributeElements();
        racialToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            eventOnRadioButtonChange(oldValue, newValue);
            calculateAllFinalAbilityScores();
            updateMaxHP(selectedHeroClass);
        });
    }

    private void addGUIAttributeElements() {
        racialBonusText.setText("  Racial  \n  Bonus: ");
        middleBox.add(racialBonusText, 2, 1);
        middleBox.add(finalScoreText, 4, 1);
        modifierText.setText("  Ability  \n  Modifier: ");
        middleBox.add(modifierText, 5, 1);
        Text AvailablePointsText = new Text("  Available \n    Points");
        AvailablePointsText.setFill(Color.WHITE);
        middleBox.add(AvailablePointsText, 0, 9);
        pointsToSpend.setDisable(true);
        middleBox.add(pointsToSpend, 1, 9);
    }

    private void eventOnRadioButtonChange(Toggle oldValue, Toggle newValue) {
        if (oldValue != null) {
            String oldValueString = oldValue.toString();
            String trimmedString = oldValueString.substring(oldValueString.indexOf('\'')).replaceAll("\\W", "");
            racialBonusNumbers.get(getStatID(trimmedString)).setText("      ");
        }
        String radioButtonString;
        try {
            radioButtonString = newValue.toString();
            String trimmedString = radioButtonString.substring(radioButtonString.indexOf('\'')).replaceAll("\\W", "");
            racialBonusNumbers.get(getStatID(trimmedString)).setText(" +2 ");
        } catch (NullPointerException ignored) {
        }
        updateDefenses();
        buildSkillBoxes(false);
    }

    private void updateMaxHP(String selectedClass) {
        String constitutionString = finalAttributeScoresTexts.get(1).getText().replaceAll("[^\\d]", "");
        System.out.println("Constitution: " + constitutionString);
        int constitution = valueOf(constitutionString);
        try {
            //HeroClassInformation classInfo = new HeroClassInformation();
            HeroClassInformationFactory classInfo = new HeroClassInformationFactory(selectedClass);
            int a = classInfo.getHitDiceAt1st();
            System.out.println(a);
            maxHP = (classInfo.getHitDiceAt1st() + constitution);
            maxHpText.setText("Max HP: \t\t" + maxHP);
        } catch (NullPointerException e) {
            maxHP = (constitution);
            maxHpText.setText("Max HP: \t\t" + maxHP);

        }
    }

    private void updateDefenses() {
        fort = -1;
        reflex = -1;
        will = -1;
        for (int i = 0; i < finalAttributeIntegersArray.length; i++) {
            int currentStat = finalAttributeIntegersArray[i];
            int currentSave = (currentStat - 10) / 2;
            if (currentStat < 10) {
                currentSave = -1;
            }
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
        HeroClassInformationFactory heroClassInformation = new HeroClassInformationFactory(selectedHeroClass);
        List<String> classBonuses = heroClassInformation.manageClassDefenceBonuses();
        for (String currentBonus : classBonuses) {
            switch (currentBonus) {
                case "Fortitude": {
                    fort++;
                    break;
                }
                case "Reflex": {
                    reflex++;
                    break;
                }
                case "Will": {
                    will++;
                    break;
                }
            }
        }
        fortitudeSaveText.setText("Fortitude: \t\t" + fort);
        reflexSaveText.setText("Reflex: \t\t\t" + reflex);
        willSaveText.setText("Will: \t\t\t\t" + will);
        armorClassText.setText("Armor Class: \t\t" + AC);
    }

    private void prepareASingleAttribute(AttributeNames currentStat) {
        Text abilityWord = new Text("  " + currentStat.toString() + " ");
        abilityWord.setFill(Color.WHITE);
        Text finalScore = new Text("  ");
        finalScore.setFill(Color.WHITE);
        Text finalModifier = new Text("  ");
        finalModifier.setFill(Color.WHITE);
        Text racialBonus = new Text("      ");
        racialBonus.setFill(Color.WHITE);
        statNames.add(abilityWord);
        statsValueSpinners.add(new Spinner<>(statPointsOptions));
        modifierNumbersTextList.add(finalModifier);
        racialBonusNumbers.add(racialBonus);
        racialBonusRadioButtons.add(new RadioButton(currentStat.toString()));
        finalAttributeScoresTexts.add(finalScore);
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
        middleBox.add(finalAttributeScoresTexts.get(i), 4, i + 2);
        middleBox.add(modifierNumbersTextList.get(i), 5, i + 2);
    }

    private void eventOnSpinnerChange(Integer oldValue, Integer newValue) {
        availableAttributePoints = availableAttributePoints + calculateTotalPointsChange(oldValue, newValue);
        pointsToSpend.setText(String.valueOf(availableAttributePoints));
        calculateAllFinalAbilityScores();
        updateMaxHP(selectedHeroClass);
        updateDefenses();
        buildSkillBoxes(false);
    }

    private void manageThePanes() {
        getCharacterCreatorOuterPane().setContent(characterCreatorInnerPane);
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
        for (int i = 0; i < finalAttributeScoresTexts.size(); i++) {
            int bonusFromChoice = statsValueSpinners.get(i).getValue();
            String textToBeSet = racialBonusNumbers.get(i).getText().replaceAll("\\D", "");
            int racialBonus = 0;
            if (textToBeSet.length() > 0) {
                racialBonus = Integer.parseInt(textToBeSet);
            }
            int sum = racialBonus + bonusFromChoice;
            finalAttributeIntegersArray[i] = sum;
            textToBeSet = "" + sum;
            finalAttributeScoresTexts.get(i).setText("   " + textToBeSet);
            if (sum < 9) {
                modifierNumbersTextList.get(i).setText("   " + ((sum - 10) / 2) + " ");
            } else if (sum == 9) {
                modifierNumbersTextList.get(i).setText("   " + ((sum - 11) / 2) + " ");
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
        for (HeroClasses currentClass : HeroClasses.values()) {
            classOptions.add(currentClass.toString());
        }
        for (HeroRaces currentRace : HeroRaces.values()) {
            raceOptions.add(currentRace.toString());
        }
        raceChoice.valueProperty().addListener((observable, oldValue, newValue) -> eventOnRaceSelection(newValue));
        classChoice.valueProperty().addListener((observable, oldValue, newValue) -> eventOnClassSelection(newValue));
        classChoice.setItems(classOptions);
        raceChoice.setItems(raceOptions);
        middleBox.add(characterName, 0, 0, 10, 1);
        leftBox.getChildren().add(classChoice);
        leftBox.getChildren().add(raceChoice);
        leftBox.getChildren().add(saveTheCharacter);
        leftBox.getChildren().add(addACharacterPortrait);
        leftBox.getChildren().add(returnToMainMenu);
    }

    private void addPowersToComboBoxes() {
        ObservableList<String> atWill1Options =
                FXCollections.observableArrayList();
        ObservableList<String> atWill2Options =
                FXCollections.observableArrayList();
        ObservableList<String> encounterOptions =
                FXCollections.observableArrayList();
        ObservableList<String> dailyOptions =
                FXCollections.observableArrayList();
        ObservableList<String> classTraitOptions =
                FXCollections.observableArrayList();
        addPowerOptionsToComboBoxes(atWill1Options, atWill2Options, encounterOptions, dailyOptions, classTraitOptions);
        manageHeroPowerComboBoxesViewing(atWill1Options, atWill2Options, encounterOptions, dailyOptions, classTraitOptions);
    }

    private void addPowerOptionsToComboBoxes(ObservableList<String> atWill1Options, ObservableList<String> atWill2Options, ObservableList<String> encounterOptions, ObservableList<String> dailyOptions, ObservableList<String> classTraitOptions) {
        HeroClassInformationFactory heroClassInformation = new HeroClassInformationFactory(selectedHeroClass);
        int numberOfAtWillPowers = heroClassInformation.getAtWillPowersAtLevel1().size();
        int numberOfEncounterPowers = heroClassInformation.getEncounterPowersAtLevel1().size();
        int numberOfDailyPowers = heroClassInformation.getEncounterPowersAtLevel1().size();
        int numberOfClassTraits = heroClassInformation.getClassTraits().size();
        for (int i = 0; i < numberOfAtWillPowers; i++) {
            atWill1Options.add(heroClassInformation.getAtWillPowersAtLevel1().get(i).getPowerName());
        }
        for (int i = 0; i < numberOfAtWillPowers; i++) {
            atWill2Options.add(heroClassInformation.getAtWillPowersAtLevel1().get(i).getPowerName());
        }
        for (int i = 0; i < numberOfEncounterPowers; i++) {
            encounterOptions.add(heroClassInformation.getEncounterPowersAtLevel1().get(i).getPowerName());
        }
        for (int i = 0; i < numberOfDailyPowers; i++) {
            dailyOptions.add(heroClassInformation.getDailyPowersAtLevel1().get(i).getPowerName());
        }
        for (int i = 0; i < numberOfClassTraits; i++) {
            classTraitOptions.add(heroClassInformation.getClassTraits().get(i));
        }
    }

    private void manageHeroPowerComboBoxesViewing(ObservableList<String> atWill1Options, ObservableList<String> atWill2Options, ObservableList<String> encounterOptions, ObservableList<String> dailyOptions, ObservableList<String> classTraitOptions) {
        atWill1Choice.setItems(atWill1Options);
        atWill2Choice.setItems(atWill2Options);
        encounterChoice.setItems(encounterOptions);
        dailyChoice.setItems(dailyOptions);
        classTraitChoice.setItems(classTraitOptions);
        atWill1Choice.setDisable(false);
        atWill2Choice.setDisable(false);
        encounterChoice.setDisable(false);
        dailyChoice.setDisable(false);
        atWill1Choice.valueProperty().addListener((observable, oldValue, newValue) -> showThePowerDescription(newValue, "AtWill"));
        atWill2Choice.valueProperty().addListener((observable, oldValue, newValue) -> showThePowerDescription(newValue, "AtWill"));
        encounterChoice.valueProperty().addListener((observable, oldValue, newValue) -> showThePowerDescription(newValue, "Encounter"));
        dailyChoice.valueProperty().addListener((observable, oldValue, newValue) -> showThePowerDescription(newValue, "Daily"));
        plugTheCellFactoryIntoComboBoxes(atWill1Choice);
        plugTheCellFactoryIntoComboBoxes(atWill2Choice);
        plugTheCellFactoryIntoComboBoxes(encounterChoice);
        plugTheCellFactoryIntoComboBoxes(dailyChoice);
        //plugTheCellFactoryIntoComboBoxes(classTraitChoice);

    }

    private void plugTheCellFactoryIntoComboBoxes(ComboBox<String> comboBoxToBePlugged) {
        comboBoxToBePlugged.setCellFactory(callFactory -> {
            ListCell<String> cell = new ListCell<String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(item);
                }
            };
            cell.hoverProperty().addListener((obs, wasHovered, isNowHovered) -> {
                if (!cell.isEmpty()) {
                    if (isNowHovered) {
                        displayThePowerPopup(selectedHeroClass, cell.getText(), comboBoxToBePlugged.getValue());
                    } else if (wasHovered) {
                        equipInfoPopup.hide();
                    }
                }
            });
            return cell;
        });
    }

    private void showThePowerDescription(String powerName, String typeOfPower) {
        HeroClassInformationFactory heroClassInformation = new HeroClassInformationFactory(selectedHeroClass);
        HeroPower heroPower = heroClassInformation.getHeroPowerByName(powerName, typeOfPower);
        powerDescription.setWrapText(true);
        try {
            powerDescription.setText("Preview of a recently selected power:  \n\n" + "Power Name:  \n" + heroPower.getPowerName() + "\n\n" + "Power Description:  \n" + heroPower.getHitDescription());
        } catch (NullPointerException e) {
            powerDescription.setText("No power selected");
            atWill1Choice.setValue("Select 1st At Will Power");
            atWill2Choice.setValue("Select 2nd At Will Power");
            encounterChoice.setValue("Select an Encounter Power");
            dailyChoice.setValue("Select a Daily Power");
        }
    }

    private int getFinalAbilityScoreByName(String name) {
        {
            switch (name) {
                case "Strength":
                    return finalAttributeIntegersArray[0];
                case "Constitution":
                    return finalAttributeIntegersArray[1];
                case "Dexterity":
                    return finalAttributeIntegersArray[2];
                case "Intelligence":
                    return finalAttributeIntegersArray[3];
                case "Wisdom":
                    return finalAttributeIntegersArray[4];
                case "Charisma":
                    return finalAttributeIntegersArray[5];
            }
        }
        return 0;
    }


    private void displayThePowerPopup(String className, String powerName, String typeOfPower) {

        HeroClassInformationFactory heroClassInformation = new HeroClassInformationFactory(className);
        HeroPower currentPower = heroClassInformation.getHeroPowerByName(powerName, typeOfPower);
        System.out.println("Hover Onto Power Detected. ");
        VBox powerDescription = new VBox();
        powerDescription.setStyle(" -fx-background-color: white;");
        Label currentLabel = new Label();
        currentLabel.setPadding(new Insets(5));
        Text itemText1 = new Text();
        itemText1.setText(currentPower.getPowerName());
        powerDescription.getChildren().add(itemText1);
        Text itemText3 = new Text();
        itemText3.setText(currentPower.getAttributeUsedToHit());
        powerDescription.getChildren().add(itemText3);
        Text itemText4 = new Text();
        itemText4.setText(currentPower.getDefenseToBeChecked());
        powerDescription.getChildren().add(itemText4);
        Text itemText2 = new Text();
        itemText2.setText(currentPower.getHitDescription());
        powerDescription.getChildren().add(itemText2);
        Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
        equipInfoPopup.getContent().add(powerDescription);
        equipInfoPopup.show(Main.getPrimaryStage(), mouseLocation.getX(), mouseLocation.getY());
    }

    private void eventOnRaceSelection(String newValue) {
        manageRadioButtonsAfterSwitchingTheRace();
        manageRacialStatBonuses(newValue);
        calculateAllFinalAbilityScores();
        for (int i = 0; i < 6; i++) {
            racialBonusRadioButtons.get(i).setSelected(false);
        }
        updateDefenses();
        buildSkillBoxes(false);
    }

    private void eventOnClassSelection(String newValue) {
        HeroClassInformationFactory heroClassInformation = new HeroClassInformationFactory(newValue);
        System.out.println(newValue);
        availableSkills.clear();
        selectedSkills.clear();
        availableSkills.addAll(heroClassInformation.getAvailableSkills());
        availableSkillsListView.setMaxHeight(availableSkills.size() * 24);
        selectedSkillsListView.setMaxHeight(selectedSkills.size() * 24);
        numberOfAvailableSkillPoints = (heroClassInformation.getClassSkillPoints());
        skillPointsText.setText(String.valueOf(numberOfAvailableSkillPoints));
        availableSkillsListView.setDisable(false);
        selectedHeroClass = newValue;
        updateMaxHP(newValue);
        updateDefenses();
        addPowersToComboBoxes();
        buildSkillBoxes(false);
    }

    private void manageRacialStatBonuses(String raceName) {
        HeroClassInformation heroClassInformation = new HeroClassInformation();
        if (raceName.equals("Human")) {
            racialBonusRadioButtons.get(getStatID("Strength")).setDisable(false);
            racialBonusRadioButtons.get(getStatID("Constitution")).setDisable(false);
            racialBonusRadioButtons.get(getStatID("Dexterity")).setDisable(false);
            racialBonusRadioButtons.get(getStatID("Intelligence")).setDisable(false);
            racialBonusRadioButtons.get(getStatID("Wisdom")).setDisable(false);
            racialBonusRadioButtons.get(getStatID("Charisma")).setDisable(false);
        } else {
            List<String> listOfBonuses = heroClassInformation.manageRacialStatBonuses(raceName);
            applyStatBonuses(listOfBonuses.get(0), listOfBonuses.get(1), listOfBonuses.get(2));
        }
    }

    private void applyStatBonuses(String mainStat, String secondaryStat1, String secondaryStat2) {
        racialBonusNumbers.get(getStatID(mainStat)).setText(" +2 ");
        racialBonusRadioButtons.get(getStatID(secondaryStat1)).setDisable(false);
        racialBonusRadioButtons.get(getStatID(secondaryStat2)).setDisable(false);
    }

    private int getStatID(String name) {
        return AttributeNames.valueOf(name).ordinal();
    }

    private void manageRadioButtonsAfterSwitchingTheRace() {
        for (RadioButton racialBonusesRadioButton : racialBonusRadioButtons) {
            racialBonusesRadioButton.setDisable(true);
        }
        for (Text racialBonusesModifier : racialBonusNumbers) {
            racialBonusesModifier.setText("      ");
        }
    }

    private void setStyling() {
        modifierText.setFill(Color.WHITE);
        racialBonusText.setFill(Color.WHITE);
        skillPointsText.setFill(Color.WHITE);
        maxHpText.setFill(Color.WHITE);
        fortitudeSaveText.setFill(Color.WHITE);
        reflexSaveText.setFill(Color.WHITE);
        willSaveText.setFill(Color.WHITE);
        armorClassText.setFill(Color.WHITE);
        finalScoreText.setFill(Color.WHITE);
        leftBox.setPadding(new Insets(20, 20, 20, 20));
        middleBox.setPadding(new Insets(20, 20, 20, 20));
        middleBox.setHgap(5);
        middleBox.setVgap(5);
        leftBox.setVgap(4);
        leftBox.setHgap(4);
        leftBox.setPrefWrapLength(170);
        characterName.setMinWidth(170);
        raceChoice.setMinWidth(150);
        classChoice.setMinWidth(150);
        raceChoice.setPromptText("Choose your race");
        classChoice.setPromptText("Choose your class");
        characterName.setPromptText("Insert your character name");
        returnToMainMenu.setText("Return to Main Menu");
        saveTheCharacter.setText("Save this Character");
        addACharacterPortrait.setText("Add a Portrait");
        returnToMainMenu.setMinWidth(150);
        saveTheCharacter.setMinWidth(150);
        addACharacterPortrait.setMinWidth(150);
    }

    private void returnToMainMenu() {
        mainMenuGUI.setaStage(Main.getPrimaryStage());
        mainMenuGUI.getaStage().setScene(mainMenuGUI.aScene);
        mainMenuGUI.getaStage().show();
        System.out.println("Stage is closing");
    }

    public ScrollPane getCharacterCreatorOuterPane() {
        return characterCreatorOuterPane;
    }

    public void setCharacterCreatorOuterPane(ScrollPane characterCreatorOuterPane) {
        this.characterCreatorOuterPane = characterCreatorOuterPane;
    }
}
