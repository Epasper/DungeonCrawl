package sample.GUI;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import sample.DAO.CharacterCreatorDAO;
import sample.DTO.ItemsDTO;
import sample.Items.Item;
import sample.Main;
import sample.Model.Hero;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EquipmentGUI {

    private ScrollPane partySelectorOuterPlane = new ScrollPane();
    private Label characterIcon = new Label();
    private GridPane innerPane = new GridPane();
    private Scene aScene = new Scene(new Group());
    private List<Hero> listOfSelectedHeroes = new ArrayList<>();
    private Popup equipInfoPopup = new Popup();
    private CharacterCreatorDAO characterCreatorDAO = new CharacterCreatorDAO();
    private Hero currentHero;
    private Map<String, Label> equipmentLabels = new HashMap<>();
    private Item draggedItem = new Item();

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
        System.out.println("Chosen hero: " + chosenHero.getHeroName());
        List<String> slotNames = itemsDTO.getListOfItemNames();
        for (String slotName : slotNames) {
            String filledSlot;
            Label currentLabel = new Label();
            equipmentLabels.put(slotName, currentLabel);
            try {
                filledSlot = heroEquipmentMap.get(slotName).getItemName();
                System.out.println("FOUND AND ITEM: " + filledSlot);
                Image itemImage = heroEquipmentMap.get(slotName).getItemImage();
                currentLabel.setGraphic(new ImageView(itemImage));
                currentLabel.setOnMouseEntered(event -> viewItemDetails(heroEquipmentMap.get(slotName)));
                currentLabel.setOnMouseExited(event -> equipInfoPopup.hide());
            } catch (NullPointerException e) {
                filledSlot = " ";
                currentLabel.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("Images\\EquipmentGUI\\EmptyEquipmentSlot.jpg"))));
            }
            currentLabel.setOnDragDetected(event -> {
                System.out.println("Dragging Detected");
                this.draggedItem = heroEquipmentMap.get((equipmentLabels.get(slotName).getText()));
                Dragboard db = currentLabel.startDragAndDrop(TransferMode.ANY);
                /* put a string on dragboard */
                ClipboardContent content = new ClipboardContent();
                ImageView currentImageView = (ImageView) currentLabel.getGraphic();
                Image currentImage = currentImageView.getImage();
                content.putImage(currentImage);
                db.setContent(content);

                event.consume();
            });
            currentLabel.setOnDragEntered(event -> {
                System.out.println("Drag Entered detected");
            });
            currentLabel.setOnDragOver(event -> {
                System.out.println("Drag Over detected");
            });

            currentLabel.setOnDragDropped(event -> {
                System.out.println("Dropping Detected");
            });
            currentLabel.setOnDragDone(event -> {
                System.out.println("Dropping Done");
            });
        }
        manageEquipmentSlotsPositions();
        characterIcon.setGraphic(new ImageView(characterCreatorDAO.getHeroIconByID(chosenHero.getHeroIconId())));
        innerPane.add(characterIcon, 0, 0);
        innerPane.setPadding(new Insets(10, 10, 10, 10));
        innerPane.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("Images\\EquipmentGUI\\Background.jpg")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        aScene.setRoot(innerPane);
        return innerPane;
    }

    private void dragCurrentItem(Item currentItem) {

    }

    private void viewItemDetails(Item currentItem) {
        System.out.println("MOUSE HOVER DETECTED");
        VBox itemDetails = new VBox();
        itemDetails.setStyle(" -fx-background-color: white;");
        Label currentLabel = new Label();
        currentLabel.setPadding(new Insets(5));
        Text itemText1 = new Text();
        itemText1.setText(currentItem.getItemName());
        itemDetails.getChildren().add(itemText1);
        Text itemText2 = new Text();
        itemText2.setText("Item Group: " + currentItem.getItemGroup());
        itemDetails.getChildren().add(itemText2);
        Text itemText3 = new Text();
        itemText3.setText("Item Type: " + currentItem.getItemType());
        itemDetails.getChildren().add(itemText3);
        Text itemText4 = new Text();
        itemText4.setText("Price: " + currentItem.getPrice());
        itemDetails.getChildren().add(itemText4);
        Text itemText5 = new Text();
        itemText5.setText("Item Level: " + currentItem.getItemLevel());
        itemDetails.getChildren().add(itemText5);
        Text itemText6 = new Text();
        itemText6.setText("Weight: " + currentItem.getWeight());
        itemDetails.getChildren().add(itemText6);
        Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
        equipInfoPopup.getContent().add(itemDetails);
        //innerPane.add(equipmentLabels.get(slotNames.get(i)), 1, i + 1);
        /*Stage detailsStage = new Stage();
        Scene itemDetailsScene = new Scene(itemDetails);
        detailsStage.setScene(itemDetailsScene);
        detailsStage.show();*/
        equipInfoPopup.show(Main.getPrimaryStage(), mouseLocation.getX(), mouseLocation.getY());
    }

    private void manageEquipmentSlotsPositions() {
        Label silhouetteLabel = new Label();
        silhouetteLabel.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("Images\\EquipmentGUI\\Silhouette.png"))));
        silhouetteLabel.setPadding(new Insets(5));
        innerPane.add(silhouetteLabel, 4, 1, 3, 3);
        equipmentLabels.get("Head Slot Item").setGraphic(new ImageView(new Image(getClass().getResourceAsStream("Images\\EquipmentGUI\\HeadSlot.jpg"))));
        innerPane.add(equipmentLabels.get("Head Slot Item"), 6, 1);
        equipmentLabels.get("Right Hand Slot Item").setGraphic(new ImageView(new Image(getClass().getResourceAsStream("Images\\EquipmentGUI\\RightHandSlot.jpg"))));
        innerPane.add(equipmentLabels.get("Right Hand Slot Item"), 3, 2);
        equipmentLabels.get("Left Hand Slot Item").setGraphic(new ImageView(new Image(getClass().getResourceAsStream("Images\\EquipmentGUI\\LeftHandSlot.jpg"))));
        innerPane.add(equipmentLabels.get("Left Hand Slot Item"), 6, 2);
        equipmentLabels.get("Arms Slot Item").setGraphic(new ImageView(new Image(getClass().getResourceAsStream("Images\\EquipmentGUI\\ArmsSlot.jpg"))));
        innerPane.add(equipmentLabels.get("Arms Slot Item"), 3, 1);
        equipmentLabels.get("Torso Slot Item").setGraphic(new ImageView(new Image(getClass().getResourceAsStream("Images\\EquipmentGUI\\TorsoSlot.jpg"))));
        innerPane.add(equipmentLabels.get("Torso Slot Item"), 6, 3);
        equipmentLabels.get("Feet Slot Item").setGraphic(new ImageView(new Image(getClass().getResourceAsStream("Images\\EquipmentGUI\\FeetSlot.jpg"))));
        innerPane.add(equipmentLabels.get("Feet Slot Item"), 3, 3);
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 10; j++) {
                String slotNumber = "Backpack Slot " + (i * 10 + j) + " Item";
                System.out.println("Inserting " + slotNumber + " Coordinates: " + i + " --- " + j);
                innerPane.add(equipmentLabels.get(slotNumber), j + 2, 10 + i);
            }
        }

    }


}
