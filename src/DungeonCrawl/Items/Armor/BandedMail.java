package DungeonCrawl.Items.Armor;

import DungeonCrawl.Items.Item;
import javafx.scene.image.Image;

public class BandedMail extends Item {

    public BandedMail() {
        this.setItemName("Banded Mail");
        this.setItemType("Heavy Armor");
        this.setItemSlot("Torso");
        this.setItemGroup("Heavy");
        this.setItemLevel(1);
        this.setPrice(55);
        this.setBonusToAC(6);
        this.setWeight(35);
        this.setItemImage(new Image(getClass().getResourceAsStream("ArmorImages\\StuddedLeatherArmor.png")));
    }
}
