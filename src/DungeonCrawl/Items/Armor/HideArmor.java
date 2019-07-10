package DungeonCrawl.Items.Armor;

import DungeonCrawl.Items.Item;

public class HideArmor extends Item {

    public HideArmor() {
        setItemName("Hide Armor");
        setItemType("Light Armor");
        setItemSlot("Torso");
        setItemGroup("Light");
        setItemLevel(1);
        setPrice(30);
        setBonusToAC(3);
        setWeight(25);
    }

}
