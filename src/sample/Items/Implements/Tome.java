package sample.Items.Implements;

import sample.Items.Item;

public class Tome extends Item {
    public Tome() {
        itemName = "Forbidden Tome";
        itemType = "Implement";
        itemSlot = "Hand";
        properties = "Deadly, Unstoppable";
        itemLevel = 1;
        price = 15;
        range = 0;
        bonusToHit = 0;
        bonusToDamage = 0;
        weight = 3;
    }
}
