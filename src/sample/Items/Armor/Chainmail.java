package sample.Items.Armor;

import sample.Items.Item;

public class Chainmail extends Item {

    public Chainmail() {
        itemName = "Chainmail";
        itemType = "Heavy Armor";
        itemSlot = "Torso";
        itemGroup = "Heavy";
        itemLevel = 1;
        price = 40;
        bonusToAC = 6;
        weight = 40;
    }

}
