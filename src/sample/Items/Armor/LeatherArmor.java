package sample.Items.Armor;

import sample.Items.Item;

public class LeatherArmor extends Item {

    public LeatherArmor() {
        itemName = "Leather Armor";
        itemType = "Light Armor";
        itemSlot = "Torso";
        itemGroup = "Light";
        itemLevel = 1;
        price = 25;
        bonusToAC = 2;
        weight = 15;
    }

}
