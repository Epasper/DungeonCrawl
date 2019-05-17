package sample.Items.Weapons;

import sample.Items.Item;

public class Greatsword extends Item {
    public Greatsword() {
        itemName = "Greatsword";
        itemType = "Military Melee Weapon";
        itemSlot = "Two Hands";
        itemGroup = "Heavy Blade";
        itemLevel = 1;
        price = 30;
        range = 0;
        bonusToHit = 0;
        proficiencyBonus = 3;
        bonusToDamage = 0;
        numberOfDamageDiceDealt = 1;
        typeOfDamageDice = 10;
        weight = 8;
    }
}
