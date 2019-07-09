package DungeonCrawl.GUI;

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
import DungeonCrawl.DAO.CharacterCreatorDAO;
import DungeonCrawl.DAO.ItemsDAO;
import DungeonCrawl.DTO.CharacterCreatorDTO;
import DungeonCrawl.Main;
import DungeonCrawl.Model.Hero;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartySelectorGUI {
    ScrollPane partySelectorOuterPlane = new ScrollPane();
    private GridPane innerPane = new GridPane();
    private Button startADungeonButton = new Button("Start an Adventure! ");
    private Stage aStage = Main.getPrimaryStage();
    private Scene aScene = new Scene(new Group());
    private List<CheckBox> listOfCheckBoxes = new ArrayList<>();
    private List<Hero> listOfSelectedHeroes = new ArrayList<>();
    private CharacterCreatorDAO characterCreatorDAO = new CharacterCreatorDAO();


    public PartySelectorGUI() throws SQLException, IOException {
        fillThePanesWithPartyMembers();
    }

    private void fillThePanesWithPartyMembers() throws SQLException, IOException {
        ObservableList<String> heroNames =
                FXCollections.observableArrayList();
        partySelectorOuterPlane.getStylesheets().add("DungeonCrawl/Styling/CharacterCreator.css");
        List<String> heroNameList = characterCreatorDAO.getAllHeroNames();
        heroNames.addAll(heroNameList);
        startADungeonButton.setOnAction(event -> {
            try {
                openDungeonGui();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        });
        innerPane.getChildren().add(startADungeonButton);
        List<Hero> listOfAllHeroes = characterCreatorDAO.getAllHeroes();
        for (int i = 0; i < listOfAllHeroes.size(); i++) {
            CheckBox currentCheckBox = new CheckBox();
            Hero hero = listOfAllHeroes.get(i);
            Image heroImage = characterCreatorDAO.getHeroIconByID(hero.getHeroIconId());
            ImageView heroImageView = new ImageView(heroImage);
            currentCheckBox.setGraphic(heroImageView);
            System.out.println("SETTER FOR ID: -->" + hero.getID());
            currentCheckBox.setId(String.valueOf(hero.getID()));
            currentCheckBox.setText(hero.getHeroName() + ", a brave " + hero.getHeroRace() + " " + hero.getHeroClass());
            System.out.println("CURRENTLY ADDING:  " + hero.getHeroName());
            listOfCheckBoxes.add(currentCheckBox);
            innerPane.add(currentCheckBox, 0, i + 1);
        }
        partySelectorOuterPlane.setContent(innerPane);
    }

    private void openDungeonGui() throws SQLException, IOException {
        listOfSelectedHeroes.clear();
        for (CheckBox currentCheckBox : listOfCheckBoxes) {
            if (currentCheckBox.isSelected()) {
                int id = Integer.valueOf(currentCheckBox.getId());
                Hero newHero = characterCreatorDAO.getAHeroByID(id);
                ItemsDAO itemsDAO = new ItemsDAO();
                newHero.setHeroEquipment(itemsDAO.getHeroEquipmentByHeroID(newHero.getID()));
                System.out.println("Hero: " + newHero.getMonsterName() + " will be fighting in this dungeon.");
                listOfSelectedHeroes.add(newHero);
            }
        }
        DungeonGUI dungeonGui = new DungeonGUI(listOfSelectedHeroes);
        aStage.close();
        //aScene.getStylesheets().add("DungeonCrawl/Styling/Caspian.css");
        aStage.setTitle("Dungeon");
        aScene.setRoot(dungeonGui.getMapOuterPane());
        aStage.getIcons().add(new Image("DungeonCrawl/GUI/Images/WindowsIcons/dungeonIcon.jpg"));
        aStage.setMaximized(true);
        aStage.setScene(aScene);
        aStage.show();
    }


}
