package DungeonCrawl.Items.Weapons;

import DungeonCrawl.Items.Item;

public class Falchion extends Item {
    public Falchion() {
        setItemName("Falchion");
        setItemType("Military Melee Weapon");
        setItemSlot("Two Hands");
        setProperties("High Crit");
        setItemGroup("Heavy Blade");
        setItemLevel(1);
        setPrice(25);
        setRange(0);
        setBonusToHit(0);
        setProficiencyBonus(2);
        setBonusToDamage(0);
        setNumberOfDamageDiceDealt(2);
        setTypeOfDamageDice(4);
        setWeight(7);
    }
}
