package DungeonCrawl.Items.Weapons;

import javafx.scene.image.Image;
import DungeonCrawl.Items.Item;

public class Khopesh extends Item {
    public Khopesh() {
        this.setItemName("Khopesh");
        this.setItemType("Military Melee Weapon");
        this.setItemSlot("Hand");
        this.setProperties("Brutal 1, Versatile");
        this.setItemGroup("Axe, Heavy Blade");
        this.setItemLevel(1);
        this.setPrice(20);
        this.setRange(0);
        this.setBonusToHit(0);
        this.setProficiencyBonus(2);
        this.setBonusToDamage(0);
        this.setNumberOfDamageDiceDealt(1);
        this.setTypeOfDamageDice(8);
        this.setWeight(8);
        setItemImage(new Image(getClass().getResourceAsStream("WeaponImages\\Sword.png")));
    }
}
