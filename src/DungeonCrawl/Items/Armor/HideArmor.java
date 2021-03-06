package DungeonCrawl.Items.Armor;

import DungeonCrawl.Items.Item;
import javafx.scene.image.Image;

public class HideArmor extends Item {

    public HideArmor() {
        this.setItemName("Hide Armor");
        this.setItemType("Light Armor");
        this.setItemSlot("Torso");
        this.setItemGroup("Light");
        this.setItemLevel(1);
        this.setPrice(30);
        this.setBonusToAC(3);
        this.setWeight(25);
        this.setItemImage(new Image(getClass().getResourceAsStream("ArmorImages\\HideArmor.png")));

    }

}
