package DungeonCrawl.GUI;

import DungeonCrawl.StaticRules.HeroClassInformationFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import DungeonCrawl.DAO.HeroDAO;
import DungeonCrawl.DAO.ItemsDAO;
import DungeonCrawl.DTO.ItemsDTO;
import DungeonCrawl.Items.Item;
import DungeonCrawl.Main;
import DungeonCrawl.Model.Hero;
import DungeonCrawl.Items.ItemFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemShopGUI {
    BorderPane itemShopOuterPane = new BorderPane();
    private GridPane heroSelectionPane = new GridPane();
    private GridPane currentChoicesGridPane = new GridPane();
    private HeroDAO characterCreatorDAO = new HeroDAO();
    private MainMenuGUI mainMenuGUI = new MainMenuGUI();
    private ItemFactory itemInformation = new ItemFactory();
    private Hero currentlySelectedHero = new Hero();
    private Accordion itemTypesAccordion = new Accordion();
    private TextArea itemStatsTextArea = new TextArea();
    private Map<String, Item> currentHeroEquipmentMap = new HashMap<>();
    private Button buyThisItemButton = new Button("Buy this Item");
    private Item currentItem = new Item();


    public ItemShopGUI() {
        itemShopOuterPane.setStyle("-fx-background-color:grey;");
        fillTheHeroesPanes();
        addWeaponList();
        addArmorList();
        addReturnToMainMenu();
        addImplementList();
    }

    private void fillTheHeroesPanes() {
        heroSelectionPane.getStylesheets().add("DungeonCrawl/Styling/CharacterCreator.css");
        ObservableList<String> heroNames =
                FXCollections.observableArrayList();
        List<String> heroNameList = characterCreatorDAO.getAllHeroNames();
        heroNames.addAll(heroNameList);
        List<Hero> listOfAllHeroes = characterCreatorDAO.getAllHeroes();
        for (int i = 0; i < listOfAllHeroes.size(); i++) {
            Button currentButton = new Button();
            int finalI = i;
            currentButton.setOnAction(actionEvent -> eventOnHeroClick(listOfAllHeroes.get(finalI).getID()));
            currentButton.setMinWidth(350);
            currentButton.setStyle("-fx-alignment: center-left;");
            Hero hero = listOfAllHeroes.get(i);
            Image heroImage = characterCreatorDAO.getHeroIconByID(hero.getHeroIconId());
            ImageView heroImageView = new ImageView(heroImage);
            currentButton.setGraphic(heroImageView);
            System.out.println("SETTER FOR ID: -->" + hero.getID());
            currentButton.setId(String.valueOf(hero.getID()));
            currentButton.setText(hero.getHeroName() + ", a brave " + hero.getHeroRace() + " " + hero.getHeroClass());
            System.out.println("CURRENTLY ADDING:  " + hero.getHeroName());
            heroSelectionPane.add(currentButton, 0, i + 1);
        }
        currentChoicesGridPane.add(itemStatsTextArea, 0, 1);
        itemShopOuterPane.setRight(heroSelectionPane);
        itemShopOuterPane.setCenter(currentChoicesGridPane);
        itemShopOuterPane.setLeft(itemTypesAccordion);
        buyThisItemButton.setOnAction(event -> {

            buyThisItem();

        });
        currentChoicesGridPane.add(buyThisItemButton, 0, 2);
    }

    private void buyThisItem() {
        ItemsDTO itemShopDTO = new ItemsDTO(currentlySelectedHero.getID());
        ItemsDAO itemShopDAO = new ItemsDAO();
        HeroDAO characterCreatorDAO = new HeroDAO();
        for (int i = 1; i < 20; i++) {
            String currentBackpackSlot = "Backpack Slot " + i + " Item";
            System.out.println(currentBackpackSlot);
            if (currentHeroEquipmentMap.get(currentBackpackSlot) == null) {
                System.out.println("Entered the backpack");
                currentHeroEquipmentMap.put(currentBackpackSlot, currentItem);
                itemShopDTO.setMapOfItems(currentHeroEquipmentMap);
                try {
                    characterCreatorDAO.updateHeroGold(currentlySelectedHero, -(currentItem.getPrice()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                currentlySelectedHero.setGold(currentlySelectedHero.getGold() - currentItem.getPrice());
                try {
                    itemShopDAO.putItemIntoSlotInDatabase(itemShopDTO, currentlySelectedHero, currentBackpackSlot);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    private void eventOnHeroClick(int heroID) {
        System.out.println("HERO ID: === " + heroID);
        currentChoicesGridPane.getChildren().removeAll();
        ItemsDAO itemShopDAO = new ItemsDAO();
        currentHeroEquipmentMap = itemShopDAO.getHeroEquipmentByHeroID(heroID);
        HeroDAO characterCreatorDAO = new HeroDAO();
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
        ItemFactory itemInformation = new ItemFactory();
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
            String proficiencyInfo = manageProficiencyBonus("Weapon");
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
                    + weight + "\n" +
                    proficiencyInfo);
        });
        itemTypesAccordion.getPanes().add(weaponsTitledPane);
    }

    private String manageProficiencyBonus(String typeOfProficiency) {
        String proficiencyInfo = currentlySelectedHero.getHeroName() + " is not proficient with " + currentItem.getItemName()
                + ".\n It is not recommended to use a weapon that a hero is not proficient with.";
        HeroClassInformationFactory heroClassInformationFactory = new HeroClassInformationFactory(currentlySelectedHero.getHeroClass());
        List<String> inspectedListOfProficiencies;
        if (typeOfProficiency.equals("Weapon")) {
            inspectedListOfProficiencies = heroClassInformationFactory.getClassWeaponProficiencies();
        } else {
            inspectedListOfProficiencies = heroClassInformationFactory.getClassArmorProficiencies();
        }
        for (String prof : inspectedListOfProficiencies) {
            if (currentItem.getItemName().contains(prof)
                    || currentItem.getItemType().contains(prof)
                    || currentItem.getItemGroup().contains(prof)) {
                proficiencyInfo = currentlySelectedHero.getHeroName() + " is proficient with " + currentItem.getItemName();
                break;
            }
        }
        return proficiencyInfo;
    }

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
                    + weight + "\n" +
                    manageProficiencyBonus("Weapon"));
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
                    + weight + "\n"
                    + manageProficiencyBonus("Armor"));
        });
        itemTypesAccordion.getPanes().add(armorsTitledPane);
    }

    private void returnToMainMenu() {
        mainMenuGUI.setaStage(Main.getPrimaryStage());
        mainMenuGUI.getaStage().setScene(mainMenuGUI.aScene);
        mainMenuGUI.getaStage().show();
        System.out.println("Stage is closing");
    }

}
