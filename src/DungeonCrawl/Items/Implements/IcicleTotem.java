package DungeonCrawl.Items.Implements;

import DungeonCrawl.Items.Item;

public class IcicleTotem extends Item {
    public IcicleTotem() {
        setItemName("Icicle Totem");
        setItemType("Implement");
        setItemSlot("Hand");
        setItemGroup("Totem");
        setProperties("Empowered crit, energized (cold)");
        setItemLevel(1);
        setPrice(15);
        setRange(0);
        setBonusToHit(0);
        setBonusToDamage(0);
        setWeight(3);
    }
}
