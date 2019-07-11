package DungeonCrawl.Items.Armor;

import DungeonCrawl.Items.Item;
import javafx.scene.image.Image;

public class FullPlate extends Item {

    public FullPlate() {
        this.setItemName("Full Plate Armor");
        this.setItemType("Heavy Armor");
        this.setItemSlot("Torso");
        this.setItemGroup("Heavy");
        this.setItemLevel(1);
        this.setPrice(65);
        this.setBonusToAC(8);
        this.setWeight(60);
        this.setItemImage(new Image(getClass().getResourceAsStream("ArmorImages\\FullPlate.png")));
    }
}
