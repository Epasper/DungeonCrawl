package DungeonCrawl.Items.Weapons;

import DungeonCrawl.Items.Item;

public class Falchion extends Item {
    public Falchion() {
        itemName = "Falchion";
        itemType = "Military Melee Weapon";
        itemSlot = "Two Hands";
        properties = "High Crit";
        itemGroup = "Heavy Blade";
        itemLevel = 1;
        price = 25;
        range = 0;
        bonusToHit = 0;
        proficiencyBonus = 2;
        bonusToDamage = 0;
        numberOfDamageDiceDealt = 2;
        typeOfDamageDice = 4;
        weight = 7;
    }
}
