package DungeonCrawl.Items.Armor;

import DungeonCrawl.Items.Item;
import javafx.scene.image.Image;

public class StuddedLeather extends Item {

    public StuddedLeather() {
        this.setItemName("Studded Leather Armor");
        this.setItemType("Light Armor");
        this.setItemSlot("Torso");
        this.setItemGroup("Light");
        this.setItemLevel(1);
        this.setPrice(35);
        this.setBonusToAC(3);
        this.setWeight(28);
        this.setItemImage(new Image(getClass().getResourceAsStream("ArmorImages\\StuddedLeatherArmor.png")));
    }
}
