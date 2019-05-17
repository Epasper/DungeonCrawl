package sample.Items.Weapons;

import sample.Items.Item;

public class Flail extends Item {
    public Flail() {
        itemName = "Flail";
        itemType = "Military Melee Weapon";
        itemSlot = "Hand";
        properties = "Versatile";
        itemGroup = "Flail";
        itemLevel = 1;
        price = 10;
        range = 0;
        bonusToHit = 0;
        proficiencyBonus = 2;
        bonusToDamage = 0;
        numberOfDamageDiceDealt = 1;
        typeOfDamageDice = 10;
        weight=5;
    }
}
