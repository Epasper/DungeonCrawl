package sample.Items.Weapons;

import javafx.scene.image.Image;
import sample.Items.Item;

public class Battleaxe extends Item {
    public Battleaxe() {
        this.setItemName("Battleaxe");
        this.setItemType("Military Melee Weapon");
        this.setItemSlot("Hand");
        this.setProperties("Versatile");
        this.setItemGroup("Axe");
        this.setItemLevel(1);
        this.setPrice(15);
        this.setRange(0);
        this.setBonusToHit(0);
        this.setProficiencyBonus(2);
        this.setBonusToDamage(0);
        this.setNumberOfDamageDiceDealt(1);
        this.setTypeOfDamageDice(10);
        this.setWeight(5);
        setItemImage(new Image(getClass().getResourceAsStream("WeaponImages\\Battleaxe.png")));
    }
}
