package DungeonCrawl.Items.Implements;

import DungeonCrawl.Items.Item;

public class IcicleTotem extends Item {
    public IcicleTotem() {
        itemName = "Icicle Totem";
        itemType = "Implement";
        itemSlot = "Hand";
        itemGroup = "Totem";
        properties = "Empowered crit, energized (cold)";
        itemLevel = 1;
        price = 15;
        range = 0;
        bonusToHit = 0;
        bonusToDamage = 0;
        weight = 3;
    }
}
