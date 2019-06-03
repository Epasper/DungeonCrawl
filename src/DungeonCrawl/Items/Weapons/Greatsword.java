package DungeonCrawl.Items.Weapons;

import javafx.scene.image.Image;
import DungeonCrawl.Items.Item;

public class Greatsword extends Item {
    public Greatsword() {
        this.setItemName("Greatsword");
        this.setItemType("Military Melee Weapon");
        this.setItemSlot("Two Hands");
        this.setItemGroup("Heavy Blade");
        this.setItemLevel(1);
        this.setPrice(30);
        this.setRange(0);
        this.setBonusToHit(0);
        this.setProficiencyBonus(3);
        this.setBonusToDamage(0);
        this.setNumberOfDamageDiceDealt(1);
        this.setTypeOfDamageDice(10);
        this.setWeight(8);
        setItemImage(new Image(getClass().getResourceAsStream("WeaponImages\\Greatsword.png")));
    }
}
