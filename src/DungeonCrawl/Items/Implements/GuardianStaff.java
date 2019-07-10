package DungeonCrawl.Items.Implements;

import DungeonCrawl.Items.Item;

public class GuardianStaff extends Item {
    public GuardianStaff() {
        setItemName("Guardian Staff");
        setItemType("Implement");
        setItemSlot("Hand");
        setItemGroup("Staff");
        setProperties("Shielding");
        setItemLevel(1);
        setPrice(13);
        setRange(0);
        setBonusToHit(0);
        setBonusToDamage(0);
        setWeight(4);
    }
}
