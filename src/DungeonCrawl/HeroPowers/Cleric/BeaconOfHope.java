package DungeonCrawl.HeroPowers.Cleric;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class BeaconOfHope extends HeroPower {
    public BeaconOfHope() {
        setPowerName("Beacon of Hope");
        setCharacterClass(HeroClasses.Cleric.toString());
        setTypeOfPower(TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(10);
        setNumberOfTargets("Close Burst 3");
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.Will.toString());
        setDamageDiceDealt(0);
        setDamageModifier(AttributeNames.Wisdom.toString());
        setTypeOfDamageDice(0);
        setThisWeaponDamage(false);
        setHitDescription("You and each ally in the burst regain 5 hit points. Until the end of the encounter, whenever you restore hit points with a healing power, the recipient regains 5 additional hit points.");

    }
}
