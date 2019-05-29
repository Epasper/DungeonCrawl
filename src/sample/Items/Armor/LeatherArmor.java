package sample.Items.Armor;

import javafx.scene.image.Image;
import sample.Items.Item;

public class LeatherArmor extends Item {

    public LeatherArmor() {
        this.setItemName("Leather Armor");
        this.setItemType("Light Armor");
        this.setItemSlot("Torso");
        this.setItemGroup("Light");
        this.setItemLevel(1);
        this.setPrice(25);
        this.setBonusToAC(2);
        this.setWeight(15);
        setItemImage(new Image(getClass().getResourceAsStream("ArmorImages\\LeatherArmor.png")));
    }

}
