package sample.Items.Weapons;

import sample.Items.Item;

public class Khopesh extends Item {
    public Khopesh() {
        itemName = "Khopesh";
        itemType = "Military Melee Weapon";
        itemSlot = "Hand";
        properties = "Brutal 1, Versatile";
        itemGroup = "Axe, Heavy Blade";
        itemLevel = 1;
        price = 20;
        range = 0;
        bonusToHit = 0;
        proficiencyBonus = 2;
        bonusToDamage = 0;
        numberOfDamageDiceDealt = 1;
        typeOfDamageDice = 8;
        weight = 8;
    }
}
