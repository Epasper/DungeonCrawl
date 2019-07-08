package DungeonCrawl.HeroPowers.Cleric;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class CascadeOfLight extends HeroPower {
    public CascadeOfLight() {
        setPowerName("Cascade of Light");
        setCharacterClass(HeroClasses.Cleric.toString());
        setTypeOfPower(TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(10);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.Will.toString());
        setDamageDiceDealt(3);
        setDamageModifier(AttributeNames.Wisdom.toString());
        setTypeOfDamageDice(8);
        setThisWeaponDamage(false);
        setHitDescription("3d8 + Wisdom modifier radiant damage, and the target gains vulnerable 5 to all damage from your attacks (save ends).\n" +
                "\n" +
                "Miss: Half damage.");

    }
}
