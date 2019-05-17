package sample.Items.Weapons;

import sample.Items.Item;

public class Longsword extends Item {
    public Longsword() {
        itemName = "Longsword";
        itemType = "Military Melee Weapon";
        itemSlot = "Hand";
        properties = "Versatile";
        itemGroup = "Heavy Blade";
        itemLevel = 1;
        price = 15;
        range = 0;
        bonusToHit = 0;
        proficiencyBonus = 3;
        bonusToDamage = 0;
        numberOfDamageDiceDealt = 1;
        typeOfDamageDice = 8;
        weight=4;
    }
}
