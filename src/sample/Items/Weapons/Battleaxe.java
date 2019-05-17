package sample.Items.Weapons;

import sample.Items.Item;

public class Battleaxe extends Item {
    public Battleaxe() {
        itemName = "Battleaxe";
        itemType = "Military Melee Weapon";
        itemSlot = "Hand";
        properties = "Versatile";
        itemGroup = "Axe";
        itemLevel = 1;
        price = 15;
        range = 0;
        bonusToHit = 0;
        proficiencyBonus = 2;
        bonusToDamage = 0;
        numberOfDamageDiceDealt = 1;
        typeOfDamageDice = 10;
        weight=6;
    }
}
