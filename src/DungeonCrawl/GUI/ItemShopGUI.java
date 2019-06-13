package DungeonCrawl.GUI;

import DungeonCrawl.StaticRules.HeroClassInformationFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import DungeonCrawl.DAO.CharacterCreatorDAO;
import DungeonCrawl.DAO.ItemsDAO;
import DungeonCrawl.DTO.CharacterCreatorDTO;
import DungeonCrawl.DTO.ItemsDTO;
import DungeonCrawl.Items.Item;
import DungeonCrawl.Main;
import DungeonCrawl.Model.Hero;
import DungeonCrawl.StaticRules.ItemInformation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemShopGUI {
    BorderPane itemShopOuterPane = new BorderPane();
    private GridPane heroSelectionPane = new GridPane();
    private GridPane currentChoicesGridPane = new GridPane();
    private CharacterCreatorDAO characterCreatorDAO = new CharacterCreatorDAO();
    private MainMenuGUI mainMenuGUI = new MainMenuGUI();
    private ItemInformation itemInformation = new ItemInformation();
    private Hero currentlySelectedHero = new Hero();
    private Accordion itemTypesAccordion = new Accordion();
    private TextArea itemStatsTextArea = new TextArea();
    private Map<String, Item> currentHeroEquipmentMap = new HashMap<>();
    private Button buyThisItemButton = new Button("Buy this Item");
    private Item currentItem = new Item();


    public ItemShopGUI() throws SQLException, IOException {
        itemShopOuterPane.setStyle("-fx-background-color:grey;");
        fillTheHeroesPanes();
        addWeaponList();
        addArmorList();
        addReturnToMainMenu();
        addImplementList();
    }

    private void fillTheHeroesPanes() throws SQLException, IOException {
        heroSelectionPane.getStylesheets().add("DungeonCrawl/Styling/CharacterCreator.css");
        ObservableList<String> heroNames =
                FXCollections.observableArrayList();
        List<String> heroNameList = characterCreatorDAO.getAllHeroNames();
        heroNames.addAll(heroNameList);
        List<CharacterCreatorDTO> listOfAllHeroes = characterCreatorDAO.getAllHeroes();
        for (int i = 0; i < listOfAllHeroes.size(); i++) {
            Button currentButton = new Button();
            int finalI = i;
            currentButton.setOnAction(actionEvent -> {
                try {
                    eventOnHeroClick(listOfAllHeroes.get(finalI).getHeroID());
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
            heroSelectionPane.add(currentButton, 0, i + 1);
        }
        currentChoicesGridPane.add(itemStatsTextArea, 0, 1);
        itemShopOuterPane.setRight(heroSelectionPane);
        itemShopOuterPane.setCenter(currentChoicesGridPane);
        itemShopOuterPane.setLeft(itemTypesAccordion);
        buyThisItemButton.setOnAction(event -> {
            try {
                buyThisItem();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        currentChoicesGridPane.add(buyThisItemButton,0,2);
    }

    private void buyThisItem() throws SQLException {
        ItemsDTO itemShopDTO = new ItemsDTO(currentlySelectedHero.getID());
        ItemsDAO itemShopDAO = new ItemsDAO();
        CharacterCreatorDAO characterCreatorDAO = new CharacterCreatorDAO();
        for (int i = 1; i < 20; i++) {
            String currentBackpackSlot = "Backpack Slot " + i + " Item";
            System.out.println(currentBackpackSlot);
            if (currentHeroEquipmentMap.get(currentBackpackSlot) == null){
                System.out.println("Entered the backpack");
                currentHeroEquipmentMap.put(currentBackpackSlot, currentItem);
                itemShopDTO.setMapOfItems(currentHeroEquipmentMap);
                characterCreatorDAO.updateHeroGold(currentlySelectedHero,-(currentItem.getPrice()));
                currentlySelectedHero.setGold(currentlySelectedHero.getGold() - currentItem.getPrice());
                itemShopDAO.putItemIntoSlotInDatabase(itemShopDTO, currentlySelectedHero, currentBackpackSlot);
                break;
            }
        }
    }

    private void eventOnHeroClick(int heroID) throws SQLException, IOException {
        System.out.println("HERO ID: === " + heroID);
        currentChoicesGridPane.getChildren().removeAll();
        ItemsDAO itemShopDAO = new ItemsDAO();
        currentHeroEquipmentMap = itemShopDAO.getHeroEquipmentByHeroID(heroID);
        CharacterCreatorDAO characterCreatorDAO = new CharacterCreatorDAO();
        currentlySelectedHero = characterCreatorDAO.getAHeroByID(heroID);
        TextArea heroStatsText = new TextArea();
        heroStatsText.setText(currentlySelectedHero.getHeroName() + "\n");
        currentHeroEquipmentMap.forEach((k, v) -> {
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
        ItemInformation itemInformation = new ItemInformation();
        itemShopOuterPane.getStylesheets().add("DungeonCrawl/Styling/CharacterCreator.css");
        TitledPane weaponsTitledPane = new TitledPane("Weapons", new Label("Show available weapons"));
        ObservableList<String> weaponNames =
                FXCollections.observableArrayList();
        ListView<String> weaponsListView = new ListView<>();
        for (Map.Entry<String, Item> entry : itemInformation.weaponsList.entrySet()) {
            weaponNames.add(entry.getValue().getItemName());
        }
        weaponsListView.getItems().addAll(weaponNames);
        weaponsTitledPane.setContent(weaponsListView);
        weaponsListView.setOnMouseClicked(event -> {
            String selection = weaponsListView.getSelectionModel().getSelectedItems().toString().replaceAll("[^a-zA-Z]", "");
            System.out.println(selection);
            currentItem = itemInformation.weaponsList.get(selection);
            String weaponName = currentItem.getItemName();
            int weaponPrice = currentItem.getPrice();
            int weaponDamage = currentItem.getTypeOfDamageDice();
            int numberOfDice = currentItem.getNumberOfDamageDiceDealt();
            int weight = currentItem.getWeight();
            int proficiencyBonus = currentItem.getProficiencyBonus();
            String proficiencyInfo;
            HeroClassInformationFactory heroClassInformationFactory = new HeroClassInformationFactory(currentlySelectedHero.getHeroClass());
            //todo finish the proficiency recognition on buying the items
            //if (heroClassInformationFactory.getClassArmorProficiencies().)
            itemStatsTextArea.setText("Selected: "
                    + weaponName
                    + "\nItem price: "
                    + weaponPrice
                    + "\nWeapon damage: "
                    + numberOfDice
                    + "d"
                    + weaponDamage
                    + "\nProficiency bonus:  "
                    + proficiencyBonus
                    + "\nWeight: "
                    + weight);
        });
        itemTypesAccordion.getPanes().add(weaponsTitledPane);
    }

    //todo add weapon proficiencies to heroclassinformation and to character creator. getters for shop would also be nice.

    private void addImplementList() {
        itemShopOuterPane.getStylesheets().add("DungeonCrawl/Styling/CharacterCreator.css");
        TitledPane implementsTitledPane = new TitledPane("Implements", new Label("Show available implements"));
        ObservableList<String> implementNames =
                FXCollections.observableArrayList();
        ListView<String> implementsListView = new ListView<>();
        for (Map.Entry<String, Item> entry : itemInformation.implementsList.entrySet()) {
            implementNames.add(entry.getValue().getItemName());
        }
        implementsListView.getItems().addAll(implementNames);
        implementsTitledPane.setContent(implementsListView);
        implementsListView.setOnMouseClicked(event -> {
            String selection = implementsListView.getSelectionModel().getSelectedItems().toString().replaceAll("[^a-z A-Z]", "");
            System.out.println(selection);
            currentItem = itemInformation.implementsList.get(selection);
            String implementName = currentItem.getItemName();
            int price = currentItem.getPrice();
            int weight = currentItem.getWeight();
            itemStatsTextArea.setText("Selected: "
                    + implementName
                    + "\nItem price: "
                    + price
                    + "\nWeight: "
                    + weight);
        });
        itemTypesAccordion.getPanes().add(implementsTitledPane);
    }

    private void addArmorList() {
        itemShopOuterPane.getStylesheets().add("DungeonCrawl/Styling/CharacterCreator.css");
        TitledPane armorsTitledPane = new TitledPane("Armors", new Label("Show available armors"));
        ObservableList<String> armorNames =
                FXCollections.observableArrayList();
        ListView<String> armorsListView = new ListView<>();
        for (Map.Entry<String, Item> entry : itemInformation.armorsList.entrySet()) {
            armorNames.add(entry.getValue().getItemName());
        }
        armorsListView.getItems().addAll(armorNames);
        armorsTitledPane.setContent(armorsListView);
        armorsListView.setOnMouseClicked(event -> {
            String selection = armorsListView.getSelectionModel().getSelectedItems().toString().replaceAll("[^a-z A-Z]", "");
            System.out.println(selection);
            currentItem = itemInformation.armorsList.get(selection);
            String armorName = currentItem.getItemName();
            int armorPrice = currentItem.getPrice();
            int acBonus = currentItem.getBonusToAC();
            int weight = currentItem.getWeight();
            itemStatsTextArea.setText("Selected: "
                    + armorName
                    + "\nItem price: "
                    + armorPrice
                    + "\nAC Bonus: "
                    + acBonus
                    + "\nWeight: "
                    + weight);
        });
        itemTypesAccordion.getPanes().add(armorsTitledPane);
    }

    private void returnToMainMenu() {
        mainMenuGUI.aStage = Main.getPrimaryStage();
        mainMenuGUI.aStage.setScene(mainMenuGUI.aScene);
        mainMenuGUI.aStage.show();
        System.out.println("Stage is closing");
    }

}
