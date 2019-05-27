package sample.GUI;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.DAO.CharacterCreatorDAO;
import sample.DTO.ItemsDTO;
import sample.Items.Item;
import sample.Model.Hero;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EquipmentGUI {

    private ScrollPane partySelectorOuterPlane = new ScrollPane();
    private Label characterIcon = new Label();
    private GridPane innerPane = new GridPane();
    Stage aStage = new Stage();
    Scene aScene = new Scene(new Group());
    private List<Hero> listOfSelectedHeroes = new ArrayList<>();
    private CharacterCreatorDAO characterCreatorDAO = new CharacterCreatorDAO();
    private Hero currentHero;

    public EquipmentGUI() throws SQLException, IOException {
    }

    public List<Hero> getListOfSelectedHeroes() {
        return listOfSelectedHeroes;
    }

    public void setListOfSelectedHeroes(List<Hero> listOfSelectedHeroes) {
        this.listOfSelectedHeroes = listOfSelectedHeroes;
    }

    //todo hero ID 0 is only being read - find out why
    //todo right panel buttons should switch the displayed character

    public GridPane displayAChosenHeroEquipment(Hero chosenHero) throws SQLException, IOException {
        CharacterCreatorDAO characterCreatorDAO = new CharacterCreatorDAO();

        partySelectorOuterPlane.getStylesheets().add("sample/Styling/CharacterCreator.css");
        Map<String, Item> heroEquipmentMap = chosenHero.getHeroEquipment();
        ItemsDTO itemsDTO = new ItemsDTO(chosenHero.getID());
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
        characterIcon.setGraphic(new ImageView(characterCreatorDAO.getHeroIconByID(chosenHero.getID())));
        innerPane.add(characterIcon, 0, 0);
        aScene.setRoot(innerPane);
        return innerPane;
    }


}
