package DungeonCrawl.Items.Armor;

import DungeonCrawl.Items.Item;
import javafx.scene.image.Image;

public class ScaleArmor extends Item {

    public ScaleArmor() {
        this.setItemName("Scale Armor");
        this.setItemType("Heavy Armor");
        this.setItemSlot("Torso");
        this.setItemGroup("Heavy");
        this.setItemLevel(1);
        this.setPrice(45);
        this.setBonusToAC(7);
        this.setWeight(45);
        this.setItemImage(new Image(getClass().getResourceAsStream("ArmorImages\\ScaleArmor.png")));
    }
}
