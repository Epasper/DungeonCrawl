package DungeonCrawl.Items.Implements;

import DungeonCrawl.Items.Item;

public class ForbiddenTome extends Item {
    public ForbiddenTome() {
        itemName = "Forbidden Tome";
        itemType = "Implement";
        itemSlot = "Hand";
        itemGroup = "Tome";
        properties = "Deadly, Unstoppable";
        itemLevel = 1;
        price = 15;
        range = 0;
        bonusToHit = 0;
        bonusToDamage = 0;
        weight = 3;
    }
}
