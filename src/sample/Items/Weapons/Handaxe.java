package sample.Items.Weapons;

import sample.Items.Item;

public class Handaxe extends Item {
    public Handaxe() {
        itemName = "Handaxe";
        itemType = "Military Melee Weapon";
        itemSlot = "Hand, Belt";
        properties = "Off-Hand, Heavy Thrown";
        itemGroup = "Axe";
        itemLevel = 1;
        price = 5;
        range = 5;
        bonusToHit = 0;
        proficiencyBonus = 2;
        bonusToDamage = 0;
        numberOfDamageDiceDealt = 1;
        typeOfDamageDice = 6;
        weight=3;
    }
}
