package DungeonCrawl.Items.Weapons;

import javafx.scene.image.Image;
import DungeonCrawl.Items.Item;

public class Handaxe extends Item {
    public Handaxe() {
        this.setItemName("Handaxe");
        this.setItemType("Military Melee Weapon");
        this.setItemSlot("Hand, Belt");
        this.setProperties("Off-Hand, Heavy Thrown");
        this.setItemGroup("Axe");
        this.setItemLevel(1);
        this.setPrice(5);
        this.setRange(5);
        this.setBonusToHit(0);
        this.setProficiencyBonus(2);
        this.setBonusToDamage(0);
        this.setNumberOfDamageDiceDealt(1);
        this.setTypeOfDamageDice(6);
        this.setWeight(3);
        setItemImage(new Image(getClass().getResourceAsStream("WeaponImages\\Axe.png")));
    }
}
