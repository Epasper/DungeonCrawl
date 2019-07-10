package DungeonCrawl.Items.Implements;

import DungeonCrawl.Items.Item;

public class DragontoothWand extends Item {
    public DragontoothWand() {
        setItemName("Dragontooth Wand");
        setItemType("Implement");
        setItemSlot("Hand");
        setItemGroup("Wand");
        setProperties("Deadly, unerring");
        setItemLevel(1);
        setPrice(18);
        setRange(0);
        setBonusToHit(0);
        setBonusToDamage(0);
        setWeight(1);
    }
}
