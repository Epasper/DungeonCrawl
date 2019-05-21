package sample.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import sample.DAO.CharacterCreatorDAO;
import sample.DAO.ItemShopDAO;
import sample.DTO.CharacterCreatorDTO;
import sample.DTO.ItemShopDTO;
import sample.Items.Item;
import sample.Main;
import sample.Model.Hero;
import sample.StaticRules.ItemInformation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemShopGUI {
    BorderPane itemShopOuterPane = new BorderPane();
    private GridPane heroSelectionPane = new GridPane();
    private GridPane currentChoicesGridPane = new GridPane();
    private Stage aStage = new Stage();
    private Scene aScene = new Scene(new Group());
    private List<Button> listOfHeroButtons = new ArrayList<>();
    private CharacterCreatorDAO characterCreatorDAO = new CharacterCreatorDAO();
    private MainMenuGUI mainMenuGUI = new MainMenuGUI();
    private ItemInformation itemInformation = new ItemInformation();
    private Hero currentlySelectedHero = new Hero();
    private Accordion itemTypesAccordion = new Accordion();

    public ItemShopGUI() throws SQLException, IOException {
        itemShopOuterPane.setStyle("-fx-background-color:grey;");
        fillTheHeroesPanes();
        addWeaponList();
        addArmorList();
        addReturnToMainMenu();
        addImplementList();
    }

    private void fillTheHeroesPanes() throws SQLException, IOException {
        heroSelectionPane.getStylesheets().add("sample/Styling/CharacterCreator.css");
        ObservableList<String> heroNames =
                FXCollections.observableArrayList();
        List<String> heroNameList = characterCreatorDAO.getAllHeroNames();
        heroNames.addAll(heroNameList);
        List<CharacterCreatorDTO> listOfAllHeroes = characterCreatorDAO.getAllHeroes();
        for (int i = 0; i < listOfAllHeroes.size(); i++) {
            Button currentButton = new Button();
            int finalI = i + 1;
            currentButton.setOnAction(actionEvent -> {
                try {
                    eventOnHeroClick(finalI);
                } catch (SQLException | IOException e) {
                    e.printStackTrace();
                }
            });
            currentButton.setMinWidth(350);
            currentButton.setStyle("-fx-alignment: center-left;");
            CharacterCreatorDTO characterCreatorDTO = listOfAllHeroes.get(i);
            Image heroImage = characterCreatorDAO.getHeroIconByID(characterCreatorDTO.getHeroIconId());
            ImageView heroImageView = new ImageView(heroImage);
            currentButton.setGraphic(heroImageView);
            System.out.println("SETTER FOR ID: -->" + characterCreatorDTO.getHeroID());
            currentButton.setId(String.valueOf(characterCreatorDTO.getHeroID()));
            currentButton.setText(characterCreatorDTO.getHeroName() + ", a brave " + characterCreatorDTO.getHeroRace() + " " + characterCreatorDTO.getHeroClass());
            System.out.println("CURRENTLY ADDING:  " + characterCreatorDTO.getHeroName());
            listOfHeroButtons.add(currentButton);
            heroSelectionPane.add(currentButton, 0, i + 1);
        }
        itemShopOuterPane.setRight(heroSelectionPane);
        itemShopOuterPane.setCenter(currentChoicesGridPane);
        itemShopOuterPane.setLeft(itemTypesAccordion);
    }

    //todo getters for hero portraits seem to be wring.
    //todo fill all fields in the middle pane.
    //todo middle pane is not clearing properly upon changing selection.
    private void eventOnHeroClick(int heroID) throws SQLException, IOException {
        currentChoicesGridPane.getChildren().removeAll();
        ItemShopDAO itemShopDAO = new ItemShopDAO();
        Map<String, Item> heroEquipmentMap = itemShopDAO.getHeroEquipmentByHeroID(heroID);
        CharacterCreatorDAO characterCreatorDAO = new CharacterCreatorDAO();
        currentlySelectedHero = characterCreatorDAO.getAHeroByID(heroID);
        TextArea heroStatsText = new TextArea();
        heroStatsText.setText(currentlySelectedHero.getHeroName() + "\n");
        heroEquipmentMap.forEach((k, v) -> {
            if (v != null) {
                heroStatsText.setText(heroStatsText.getText() + k + ": " + v.getItemName() + " \n");
            }
        });
        heroStatsText.setText(heroStatsText.getText() + "Remaining Gold: " + currentlySelectedHero.getGold());
        currentChoicesGridPane.add(heroStatsText, 0, 0);
    }

    private void addReturnToMainMenu() {
        Button returnToMainMenu = new Button();
        returnToMainMenu.setText("Return to Main Menu");
        heroSelectionPane.add(returnToMainMenu, 0, 5);
        returnToMainMenu.setOnAction(event -> returnToMainMenu());
    }

    private void addWeaponList() {
        itemShopOuterPane.getStylesheets().add("sample/Styling/CharacterCreator.css");
        TitledPane weaponsTitledPane = new TitledPane("Weapons", new Label("Show available weapons"));
        ObservableList<String> weaponNames =
                FXCollections.observableArrayList();
        ListView<String> weaponsListView = new ListView<>();
        for (Map.Entry<String, Item> entry : itemInformation.weaponsList.entrySet()) {
            weaponNames.add(entry.getValue().getItemName());
        }
        weaponsListView.getItems().addAll(weaponNames);
        weaponsTitledPane.setContent(weaponsListView);
        itemTypesAccordion.getPanes().add(weaponsTitledPane);
    }

    private void addImplementList() {
        itemShopOuterPane.getStylesheets().add("sample/Styling/CharacterCreator.css");
        TitledPane implementsTitledPane = new TitledPane("Implements", new Label("Show available implements"));
        ObservableList<String> implementNames =
                FXCollections.observableArrayList();
        ListView<String> implementsListView = new ListView<>();
        for (Map.Entry<String, Item> entry : itemInformation.implementsList.entrySet()) {
            implementNames.add(entry.getValue().getItemName());
        }
        implementsListView.getItems().addAll(implementNames);
        implementsTitledPane.setContent(implementsListView);
        itemTypesAccordion.getPanes().add(implementsTitledPane);
    }

    private void addArmorList() {
        itemShopOuterPane.getStylesheets().add("sample/Styling/CharacterCreator.css");
        TitledPane armorsTitledPane = new TitledPane("Armors", new Label("Show available armors"));
        ObservableList<String> armorNames =
                FXCollections.observableArrayList();
        ListView<String> armorsListView = new ListView<>();
        for (Map.Entry<String, Item> entry : itemInformation.armorsList.entrySet()) {
            armorNames.add(entry.getValue().getItemName());
        }
        armorsListView.getItems().addAll(armorNames);
        armorsTitledPane.setContent(armorsListView);
        itemTypesAccordion.getPanes().add(armorsTitledPane);
    }

    private void returnToMainMenu() {
        mainMenuGUI.aStage = Main.getPrimaryStage();
        mainMenuGUI.aStage.setScene(mainMenuGUI.aScene);
        mainMenuGUI.aStage.show();
        System.out.println("Stage is closing");
    }

}
