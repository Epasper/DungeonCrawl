package DungeonCrawl.HeroPowers.Avenger;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class AspectOfMight extends HeroPower {
    public AspectOfMight() {
        setPowerName("Aspect of Might");
        setCharacterClass(HeroClasses.Avenger.toString());
        setTypeOfPower(TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.AC.toString());
        setDamageDiceDealt(3);
        setDamageModifier(AttributeNames.Wisdom.toString());
        setThisWeaponDamage(true);
        setHitDescription("Until the end of the encounter, you gain a +5 power bonus to Athletics checks, a +2 power bonus to speed, and a +2 power bonus to the damage rolls of melee attacks.");
    }
}
