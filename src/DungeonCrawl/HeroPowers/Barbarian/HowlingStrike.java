package DungeonCrawl.HeroPowers.Barbarian;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class HowlingStrike extends HeroPower {
    public HowlingStrike() {
        setPowerName("Howling Strike");
        setCharacterClass(HeroClasses.Barbarian.toString());
        setTypeOfPower(TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Strength.toString());
        setDefenseToBeChecked(CreatureDefenses.AC.toString());
        setDamageDiceDealt(1);
        setDamageModifier(AttributeNames.Strength.toString());
        setThisWeaponDamage(true);
        setBonusDamage(true);
        setTypeOfBonusDamageDice(8);
        setHitDescription("1 [W] + 1d6 + Strength modifier damage. When charging, you can use this power in place of a melee basic attack. If you are raging, you can move 2 extra squares as part of the charge.");
    }
}
