package sample.Items.Weapons;

import sample.Items.Item;

public class Greataxe extends Item {
    public Greataxe() {
        itemName = "Greataxe";
        itemType = "Military Melee Weapon";
        itemSlot = "Two Hands";
        properties = "High Crit";
        itemGroup = "Axe";
        itemLevel = 1;
        price = 30;
        range = 0;
        bonusToHit = 0;
        proficiencyBonus = 2;
        bonusToDamage = 0;
        numberOfDamageDiceDealt = 1;
        typeOfDamageDice = 12;
        weight = 12;
    }
}
