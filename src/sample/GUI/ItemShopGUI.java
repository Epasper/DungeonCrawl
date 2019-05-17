package sample.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.DAO.CharacterCreatorDAO;
import sample.DTO.CharacterCreatorDTO;
import sample.Main;
import sample.Model.Hero;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemShopGUI {
    ScrollPane itemShopOuterPlane = new ScrollPane();
    private GridPane innerPane = new GridPane();
    private Stage aStage = new Stage();
    private Scene aScene = new Scene(new Group());
    private List<CheckBox> listOfCheckBoxes = new ArrayList<>();
    private List<Hero> listOfSelectedHeroes = new ArrayList<>();
    private CharacterCreatorDAO characterCreatorDAO = new CharacterCreatorDAO();
    private MainMenuGUI mainMenuGUI = new MainMenuGUI();


    public ItemShopGUI() throws SQLException, IOException {
        fillThePanesWithPartyMembers();

    }

    private void fillThePanesWithPartyMembers() throws SQLException, IOException {
        ObservableList<String> heroNames =
                FXCollections.observableArrayList();
        itemShopOuterPlane.getStylesheets().add("sample/Styling/CharacterCreator.css");
        List<String> heroNameList = characterCreatorDAO.getAllHeroNames();
        heroNames.addAll(heroNameList);
        List<CharacterCreatorDTO> listOfAllHeroes = characterCreatorDAO.getAllHeroes();
        Button returnToMainMenu = new Button();
        returnToMainMenu.setText("Return to Main Menu");
        innerPane.add(returnToMainMenu, 0, 5);
        returnToMainMenu.setOnAction(event -> returnToMainMenu());
        for (int i = 0; i < listOfAllHeroes.size(); i++) {
            CheckBox currentCheckBox = new CheckBox();
            CharacterCreatorDTO characterCreatorDTO = listOfAllHeroes.get(i);
            Image heroImage = characterCreatorDAO.getHeroIconByID(characterCreatorDTO.getHeroIconId());
            ImageView heroImageView = new ImageView(heroImage);
            currentCheckBox.setGraphic(heroImageView);
            System.out.println("SETTER FOR ID: -->" + characterCreatorDTO.getHeroID());
            currentCheckBox.setId(String.valueOf(characterCreatorDTO.getHeroID()));
            currentCheckBox.setText(characterCreatorDTO.getHeroName() + ", a brave " + characterCreatorDTO.getHeroRace() + " " + characterCreatorDTO.getHeroClass());
            System.out.println("CURRENTLY ADDING:  " + characterCreatorDTO.getHeroName());
            listOfCheckBoxes.add(currentCheckBox);
            innerPane.add(currentCheckBox, 0, i + 1);
        }
        itemShopOuterPlane.setContent(innerPane);
    }

    private void returnToMainMenu() {
        mainMenuGUI.aStage = Main.getPrimaryStage();
        mainMenuGUI.aStage.setScene(mainMenuGUI.aScene);
        mainMenuGUI.aStage.show();
        System.out.println("Stage is closing");
    }

}
