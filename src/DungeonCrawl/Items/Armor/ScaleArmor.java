package DungeonCrawl.Items.Armor;

import DungeonCrawl.Items.Item;

public class ScaleArmor extends Item {

    public ScaleArmor() {
        setItemName("Scale Armor");
        setItemType("Heavy Armor");
        setItemSlot("Torso");
        setItemGroup("Heavy");
        setItemLevel(1);
        setPrice(45);
        setBonusToAC(7);
        setWeight(45);
    }

}
