package DungeonCrawl.HeroPowers.Barbarian;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class MacetailsRage extends HeroPower {
    public MacetailsRage() {
        setPowerName("Macetail's Rage");
        setCharacterClass(HeroClasses.Barbarian.toString());
        setTypeOfPower(TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("Close Burst 1");
        setAttributeUsedToHit(AttributeNames.Strength.toString());
        setDefenseToBeChecked(CreatureDefenses.Reflex.toString());
        setDamageDiceDealt(1);
        setDamageModifier(AttributeNames.Strength.toString());
        setThisWeaponDamage(true);
        setHitDescription("You enter the rage of the Macetail Behemoth. Until the rage ends, whenever you hit, gain temporary hit points equal to your Str mod");
    }
}
