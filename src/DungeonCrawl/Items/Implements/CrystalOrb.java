package DungeonCrawl.Items.Implements;

import DungeonCrawl.Items.Item;

public class CrystalOrb extends Item {
    public CrystalOrb() {
        setItemName("Crystal Orb");
        setItemType("Implement");
        setItemSlot("Hand");
        setItemGroup("Orb");
        setProperties("Undeniable");
        setItemLevel(1);
        setPrice(27);
        setRange(0);
        setBonusToHit(0);
        setBonusToDamage(0);
        setWeight(2);
    }
}
