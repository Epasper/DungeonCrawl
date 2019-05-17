package sample.Items.Implements;

import sample.Items.Item;

public class GuardianStaff extends Item {
    public GuardianStaff() {
        itemName = "Guardian Staff";
        itemType = "Implement";
        itemSlot = "Hand";
        properties = "Shielding";
        itemLevel = 1;
        price = 13;
        range = 0;
        bonusToHit = 0;
        bonusToDamage = 0;
        weight = 4;
    }
}
