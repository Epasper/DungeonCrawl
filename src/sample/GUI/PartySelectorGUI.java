package sample.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.DAO.CharacterCreatorDAO;

import java.sql.SQLException;
import java.util.List;

public class PartySelectorGUI {
    ScrollPane partySelectorOuterPlane = new ScrollPane();
    private FlowPane innerPane = new FlowPane();
    Button startADungeonButton = new Button("Start an Adventure! ");
    Stage aStage = new Stage();
    Scene aScene = new Scene(new Group());

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
        for (String heroName : heroNames) {
            Text heroText = new Text(heroName);
            innerPane.getChildren().add(heroText);
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
