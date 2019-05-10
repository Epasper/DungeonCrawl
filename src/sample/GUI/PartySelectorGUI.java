package sample.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.DAO.CharacterCreatorDAO;
import sample.DTO.CharacterCreatorDTO;

import java.sql.SQLException;
import java.util.List;

public class PartySelectorGUI {
    ScrollPane partySelectorOuterPlane = new ScrollPane();
    private GridPane innerPane = new GridPane();
    private Button startADungeonButton = new Button("Start an Adventure! ");
    private Stage aStage = new Stage();
    private Scene aScene = new Scene(new Group());

    public PartySelectorGUI() throws SQLException {
        fillThePanesWithPartyMembers();

    }

    private void fillThePanesWithPartyMembers() throws SQLException {
        ObservableList<String> heroNames =
                FXCollections.observableArrayList();
        partySelectorOuterPlane.getStylesheets().add("sample/Styling/CharacterCreator.css");
        CharacterCreatorDAO characterCreatorDAO = new CharacterCreatorDAO();
        List<String> heroNameList = characterCreatorDAO.getAllHeroNames();
        heroNames.addAll(heroNameList);
        startADungeonButton.setOnAction(event -> openDungeonGui());
        innerPane.getChildren().add(startADungeonButton);
        List<CharacterCreatorDTO> listOfAllHeroes = characterCreatorDAO.getAllHeroes();
        for (int i = 0; i < listOfAllHeroes.size(); i++) {
            CheckBox currentCheckBox = new CheckBox();
            CharacterCreatorDTO characterCreatorDTO = listOfAllHeroes.get(i);
            currentCheckBox.setText(characterCreatorDTO.getHeroName());
            System.out.println("CURRENTLY ADDING:  " + characterCreatorDTO.getHeroName());
            innerPane.add(currentCheckBox, 0, i + 1);
        }
        partySelectorOuterPlane.setContent(innerPane);
    }

    private void openDungeonGui() {
        DungeonGUI dungeonGui = new DungeonGUI();
        aStage.close();
        aScene.getStylesheets().add("sample/Styling/Caspian.css");
        aScene.setRoot(dungeonGui.mapScrollPane);
        aStage.setScene(aScene);
        aStage.show();
    }


}
