package sample.Items.Weapons;

import sample.Items.Item;

public class Broadsword extends Item {
    public Broadsword() {
        itemName = "Broadsword";
        itemType = "Military Melee Weapon";
        itemSlot = "Hand";
        properties = "Versatile";
        itemGroup = "Heavy Blade";
        itemLevel = 1;
        price = 20;
        range = 0;
        bonusToHit = 0;
        proficiencyBonus = 2;
        bonusToDamage = 0;
        numberOfDamageDiceDealt = 1;
        typeOfDamageDice = 10;
        weight=5;
    }
}
