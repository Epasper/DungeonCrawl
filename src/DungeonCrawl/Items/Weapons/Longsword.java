package DungeonCrawl.Items.Weapons;

import javafx.scene.image.Image;
import DungeonCrawl.Items.Item;

public class Longsword extends Item {
    public Longsword() {
        this.setItemName("Longsword");
        this.setItemType("Military Melee Weapon");
        this.setItemSlot("Hand");
        this.setProperties("Versatile");
        this.setItemGroup("Heavy Blade");
        this.setItemLevel(1);
        this.setPrice(15);
        this.setRange(0);
        this.setBonusToHit(0);
        this.setProficiencyBonus(3);
        this.setBonusToDamage(0);
        this.setNumberOfDamageDiceDealt(1);
        this.setTypeOfDamageDice(8);
        this.setWeight(4);
        setItemImage(new Image(getClass().getResourceAsStream("WeaponImages\\Sword.png")));
    }
}
