package DungeonCrawl.Items.Armor;

import DungeonCrawl.Items.Item;
import javafx.scene.image.Image;

public class SpikedPlate extends Item {

    public SpikedPlate() {
        this.setItemName("Spiked Plate Armor");
        this.setItemType("Heavy Armor");
        this.setItemSlot("Torso");
        this.setItemGroup("Heavy");
        this.setItemLevel(1);
        this.setPrice(55);
        this.setBonusToAC(8);
        this.setWeight(60);
        this.setItemImage(new Image(getClass().getResourceAsStream("ArmorImages\\SpikedPlate.png")));
    }
}
