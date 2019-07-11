package DungeonCrawl.GUI;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import DungeonCrawl.DAO.HeroDAO;
import DungeonCrawl.DAO.ItemsDAO;
import DungeonCrawl.DTO.ItemsDTO;
import DungeonCrawl.Items.Item;
import DungeonCrawl.Main;
import DungeonCrawl.Model.Hero;

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
    private Popup equipInfoPopup = new Popup();
    private Hero currentHero;
    private Map<String, Label> equipmentLabels = new HashMap<>();
    private Map<String, Item> heroEquipmentMap;
    private ItemsDTO itemsDTO;
    private String currentSlotBeingDraggedOver;


    public GridPane displayAChosenHeroEquipment(Hero chosenHero) {
        innerPane.getChildren().removeAll();
        characterIcon.setGraphic(null);
        HeroDAO characterCreatorDAO = new HeroDAO();
        this.currentHero = chosenHero;
        partySelectorOuterPlane.getStylesheets().add("DungeonCrawl/Styling/CharacterCreator.css");
        Map<String, Item> heroEquipmentMap = currentHero.getHeroEquipment();
        ItemsDTO itemsDTO = new ItemsDTO(currentHero.getID());
        System.out.println("Chosen hero: " + chosenHero.getHeroName());
        List<String> slotNames = itemsDTO.getListOfItemNames();
        for (String slotName : slotNames) {
            String filledSlot;
            Label currentLabel = new Label(slotName);
            equipmentLabels.put(slotName, currentLabel);
            try {
                filledSlot = heroEquipmentMap.get(slotName).getItemName();
                System.out.println("FOUND AND ITEM: " + filledSlot);
                Image itemImage = heroEquipmentMap.get(slotName).getItemImage();
                currentLabel.setGraphic(new ImageView(itemImage));
                currentLabel.setOnMouseEntered(event -> viewItemDetails(heroEquipmentMap.get(slotName)));
                currentLabel.setOnMouseExited(event -> equipInfoPopup.hide());
            } catch (NullPointerException e) {
                filledSlot = "Empty";
                currentLabel.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("Images\\EquipmentGUI\\EmptyEquipmentSlot.jpg"))));
            }
            String finalFilledSlot = filledSlot;
            currentLabel.setOnDragDetected(event -> eventOnDragDetected(slotName, currentLabel, finalFilledSlot, event));
            currentLabel.setOnDragEntered(event -> eventOnDragEnter(slotName, currentLabel, event));
            currentLabel.setOnDragOver(this::eventOnDragOver);
            currentLabel.setOnDragDropped(this::eventOnDragDropped);
            currentLabel.setOnDragDone(event -> eventOnDragDone(slotName, event));
        }
        this.heroEquipmentMap = heroEquipmentMap;
        this.itemsDTO = itemsDTO;
        manageEquipmentSlotsPositions();
        characterIcon.setGraphic(new ImageView(characterCreatorDAO.getHeroIconByID(chosenHero.getHeroIconId())));
        try {
            innerPane.add(characterIcon, 0, 0);
        } catch (IllegalArgumentException ignored) {
        }
        innerPane.setPadding(new Insets(10, 10, 10, 10));
        innerPane.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("Images\\EquipmentGUI\\Background.jpg")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        aScene.setRoot(innerPane);
        return innerPane;
    }

    //todo reverse the item putting when the slot is already occupied

    private void eventOnDragDetected(String slotName, Label currentLabel, String finalFilledSlot, MouseEvent event) {
        //System.out.println("Dragging Detected");
        //System.out.println("Slot Name: " + slotName);
        //System.out.println("Item Name: " + finalFilledSlot);
        Dragboard dragboard = currentLabel.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        ImageView currentImageView = (ImageView) currentLabel.getGraphic();
        Image currentImage = currentImageView.getImage();
        content.putImage(currentImage);
        if (!finalFilledSlot.contains("Empty")) {
            content.putString(slotName);
        }
        dragboard.setContent(content);
        event.consume();
    }

    private void eventOnDragEnter(String slotName, Label currentLabel, DragEvent event) {
        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        //System.out.println("Drag Entered detected on: " + slotName);
        currentSlotBeingDraggedOver = currentLabel.getText();
        event.consume();
    }

    private void eventOnDragOver(DragEvent event) {
        System.out.println("onDragOver");

        if (event.getGestureSource() != event.getGestureTarget() &&
                event.getDragboard().hasString()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }

        event.consume();
    }

    private void eventOnDragDropped(DragEvent event) {
        System.out.println("onDragDropped");
        event.setDropCompleted(true);
        event.consume();
    }

    private void eventOnDragDone(String slotName, DragEvent event) {
        System.out.println("Dropping Done");
        Dragboard dragboard = event.getDragboard();
        String sourceSlotName = dragboard.getString();
        String targetSlotName = currentSlotBeingDraggedOver;
        if (currentHero.getHeroEquipment().get(targetSlotName) != null) {
            event.consume();
            updateTheGUI();
            return;
        }
        Item currentItem = heroEquipmentMap.get(sourceSlotName);
        heroEquipmentMap.remove(sourceSlotName);
        heroEquipmentMap.put(targetSlotName, currentItem);
        itemsDTO.setMapOfItems(heroEquipmentMap);
        try {
            ItemsDAO itemsDAO = new ItemsDAO();
            System.out.println("Source slot name: " + sourceSlotName);
            System.out.println("Target slot name: " + targetSlotName);
            System.out.println("Item Name: " + currentItem.getItemName());
            itemsDAO.removeItemFromSlotInDatabase(currentHero, sourceSlotName);
            itemsDAO.putItemIntoSlotInDatabase(itemsDTO, currentHero, targetSlotName);
        } catch (NullPointerException | IOException ignored) {
        }
        event.consume();
        updateTheGUI();
        innerPane = displayAChosenHeroEquipment(currentHero);
    }

    private void updateTheGUI() {
        equipmentLabels.forEach((k, v) -> {
            try {
                v.setGraphic(new ImageView(heroEquipmentMap.get(k).getItemImage()));
            } catch (NullPointerException ignored) {
            }
        });
    }

    private void viewItemDetails(Item currentItem) {
//        System.out.println("MOUSE HOVER DETECTED");
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
        equipInfoPopup.show(Main.getPrimaryStage(), mouseLocation.getX(), mouseLocation.getY());
    }

    private void manageEquipmentSlotsPositions() {
        Label silhouetteLabel = new Label();
        silhouetteLabel.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("Images\\EquipmentGUI\\Silhouette.png"))));
        silhouetteLabel.setPadding(new Insets(5));
        innerPane.add(silhouetteLabel, 4, 1, 3, 3);
        manageBodySlotImage("Head Slot Item", "Images\\EquipmentGUI\\HeadSlot.jpg", 6, 1);
        manageBodySlotImage("Right Hand Slot Item", "Images\\EquipmentGUI\\RightHandSlot.jpg", 3, 2);
        manageBodySlotImage("Left Hand Slot Item", "Images\\EquipmentGUI\\LeftHandSlot.jpg", 6, 2);
        manageBodySlotImage("Arms Slot Item", "Images\\EquipmentGUI\\ArmsSlot.jpg", 3, 1);
        manageBodySlotImage("Torso Slot Item", "Images\\EquipmentGUI\\TorsoSlot.jpg", 6, 3);
        manageBodySlotImage("Feet Slot Item", "Images\\EquipmentGUI\\FeetSlot.jpg", 3, 3);
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 10; j++) {
                String slotNumber = "Backpack Slot " + (i * 10 + j) + " Item";
                System.out.println("Inserting " + slotNumber + " Coordinates: " + i + " --- " + j);
                innerPane.add(equipmentLabels.get(slotNumber), j + 2, 10 + i);
            }
        }

    }

    private void manageBodySlotImage(String slotName, String defaultImagePath, int gridColumnPos, int gridRowPos) {
        if (heroEquipmentMap.get(slotName) != null) {
            equipmentLabels.get(slotName).setGraphic(new ImageView(heroEquipmentMap.get(slotName).getItemImage()));
        } else {
            equipmentLabels.get(slotName).setGraphic(new ImageView(new Image(getClass().getResourceAsStream(defaultImagePath))));
        }
        innerPane.add(equipmentLabels.get(slotName), gridColumnPos, gridRowPos);
    }


}
