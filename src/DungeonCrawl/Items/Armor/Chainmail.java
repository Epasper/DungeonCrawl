package DungeonCrawl.Items.Armor;

import javafx.scene.image.Image;
import DungeonCrawl.Items.Item;

public class Chainmail extends Item {

    public Chainmail() {
        this.setItemName("Chainmail");
        this.setItemType("Heavy Armor");
        this.setItemSlot("Torso");
        this.setItemGroup("Heavy");
        this.setItemLevel(1);
        this.setPrice(40);
        this.setBonusToAC(6);
        this.setWeight(40);
        setItemImage(new Image(getClass().getResourceAsStream("ArmorImages\\Chainmail.png")));
    }

}
