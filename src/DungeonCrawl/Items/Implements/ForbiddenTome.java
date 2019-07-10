package DungeonCrawl.Items.Implements;

import DungeonCrawl.Items.Item;

public class ForbiddenTome extends Item {
    public ForbiddenTome() {
        setItemName("Forbidden Tome");
        setItemType("Implement");
        setItemSlot("Hand");
        setItemGroup("Tome");
        setProperties("Deadly, Unstoppable");
        setItemLevel(1);
        setPrice(15);
        setRange(0);
        setBonusToHit(0);
        setBonusToDamage(0);
        setWeight(3);
    }
}
