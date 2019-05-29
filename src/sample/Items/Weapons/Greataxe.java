package sample.Items.Weapons;

import javafx.scene.image.Image;
import sample.Items.Item;

public class Greataxe extends Item {
    public Greataxe() {
        this.setItemName("Greataxe");
        this.setItemType("Military Melee Weapon");
        this.setItemSlot("Two Hands");
        this.setProperties("High Crit");
        this.setItemGroup("Axe");
        this.setItemLevel(1);
        this.setPrice(30);
        this.setRange(0);
        this.setBonusToHit(0);
        this.setProficiencyBonus(2);
        this.setBonusToDamage(0);
        this.setNumberOfDamageDiceDealt(1);
        this.setTypeOfDamageDice(12);
        this.setWeight(12);
        setItemImage(new Image(getClass().getResourceAsStream("WeaponImages\\Greataxe.png")));
    }
}
