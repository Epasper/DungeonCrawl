package DungeonCrawl.Items.Armor;

import DungeonCrawl.Items.Item;
import javafx.scene.image.Image;

public class RingMail extends Item {

    public RingMail() {
        this.setItemName("Ring Mail");
        this.setItemType("Light Armor");
        this.setItemSlot("Torso");
        this.setItemGroup("Light");
        this.setItemLevel(1);
        this.setPrice(40);
        this.setBonusToAC(3);
        this.setWeight(30);
        this.setItemImage(new Image(getClass().getResourceAsStream("ArmorImages\\StuddedLeatherArmor.png")));
    }
}
