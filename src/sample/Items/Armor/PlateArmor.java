package sample.Items.Armor;

import javafx.scene.image.Image;
import sample.Items.Item;

public class PlateArmor extends Item {

    public PlateArmor() {
        this.setItemName("Plate Armor");
        this.setItemType("Heavy Armor");
        this.setItemSlot("Torso");
        this.setItemGroup("Heavy");
        this.setItemLevel(1);
        this.setPrice(50);
        this.setBonusToAC(8);
        this.setWeight(50);
        setItemImage(new Image(getClass().getResourceAsStream("ArmorImages\\PlateArmor.png")));
    }

}
