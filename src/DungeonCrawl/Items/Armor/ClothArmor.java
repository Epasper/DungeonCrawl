package DungeonCrawl.Items.Armor;

import DungeonCrawl.Items.Item;
import javafx.scene.image.Image;

public class ClothArmor extends Item {

    public ClothArmor() {
        this.setItemName("Chainmail");
        this.setItemType("Light Armor");
        this.setItemSlot("Torso");
        this.setItemGroup("Light");
        this.setItemLevel(1);
        this.setPrice(1);
        this.setBonusToAC(0);
        this.setWeight(4);
        this.setItemImage(new Image(getClass().getResourceAsStream("ArmorImages\\ClothArmor.png")));
    }
}
