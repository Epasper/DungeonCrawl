package DungeonCrawl.Items.Weapons;

import javafx.scene.image.Image;
import DungeonCrawl.Items.Item;

public class Flail extends Item {
    public Flail() {
        this.setItemName("Flail");
        this.setItemType("Military Melee Weapon");
        this.setItemSlot("Hand");
        this.setProperties("Versatile");
        this.setItemGroup("Flail");
        this.setItemLevel(1);
        this.setPrice(10);
        this.setRange(0);
        this.setBonusToHit(0);
        this.setProficiencyBonus(2);
        this.setBonusToDamage(0);
        this.setNumberOfDamageDiceDealt(1);
        this.setTypeOfDamageDice(10);
        this.setWeight(5);
        setItemImage(new Image(getClass().getResourceAsStream("WeaponImages\\Flail.png")));
    }
}
