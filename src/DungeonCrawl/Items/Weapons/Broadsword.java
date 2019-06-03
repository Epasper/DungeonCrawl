package DungeonCrawl.Items.Weapons;

import javafx.scene.image.Image;
import DungeonCrawl.Items.Item;

public class Broadsword extends Item {
    public Broadsword() {
        this.setItemName("Broadsword");
        this.setItemType("Military Melee Weapon");
        this.setItemSlot("Hand");
        this.setProperties("Versatile");
        this.setItemGroup("Heavy Blade");
        this.setItemLevel(1);
        this.setPrice(20);
        this.setRange(0);
        this.setBonusToHit(0);
        this.setProficiencyBonus(2);
        this.setBonusToDamage(0);
        this.setNumberOfDamageDiceDealt(1);
        this.setTypeOfDamageDice(10);
        this.setWeight(5);
        setItemImage(new Image(getClass().getResourceAsStream("WeaponImages\\Broadsword.png")));

    }
}
