package sample.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.DAO.CharacterCreatorDAO;
import sample.DAO.ItemsDAO;
import sample.DTO.CharacterCreatorDTO;
import sample.DTO.ItemsDTO;
import sample.Items.Item;
import sample.Model.Hero;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EquipmentGUI {

    private ScrollPane partySelectorOuterPlane = new ScrollPane();
    private Label characterIcon = new Label();
    private GridPane innerPane = new GridPane();
    Stage aStage = new Stage();
    Scene aScene = new Scene(new Group());
    private List<Hero> listOfSelectedHeroes = new ArrayList<>();
    private CharacterCreatorDAO characterCreatorDAO = new CharacterCreatorDAO();
    private Hero currentHero;

    public EquipmentGUI(Hero currentHero) throws SQLException, IOException {
        this.currentHero = currentHero;
        setANewScene();
        fillThePanesWithPartyMembers();
    }

    private void setANewScene() {
    }

    private void fillThePanesWithPartyMembers() throws SQLException, IOException {
        CharacterCreatorDAO characterCreatorDAO = new CharacterCreatorDAO();

        partySelectorOuterPlane.getStylesheets().add("sample/Styling/CharacterCreator.css");
        Map<String, Item> heroEquipmentMap = currentHero.getHeroEquipment();
        ItemsDTO itemsDTO = new ItemsDTO(currentHero.getID());
        List<String> slotNames = itemsDTO.getListOfItemNames();
        for (int i = 0; i < slotNames.size(); i++) {
            String filledSlot;
            try {
                filledSlot = heroEquipmentMap.get(slotNames.get(i)).getItemName();
            } catch (NullPointerException e) {
                filledSlot = " ";
            }
            Text itemText = new Text(slotNames.get(i) + ": " +
                    filledSlot
            );
            innerPane.add(itemText, 0, i + 1);
        }
        characterIcon.setGraphic(new ImageView(characterCreatorDAO.getHeroIconByID(currentHero.getID())));
        innerPane.add(characterIcon, 0, 0);
        aScene.setRoot(innerPane);
    }


}
