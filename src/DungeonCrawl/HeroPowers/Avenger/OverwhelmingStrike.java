package DungeonCrawl.HeroPowers.Avenger;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class OverwhelmingStrike extends HeroPower {
    public OverwhelmingStrike() {
        setPowerName("Overwhelming Strike");
        setCharacterClass(HeroClasses.Avenger.toString());
        setTypeOfPower(TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.AC.toString());
        setDamageDiceDealt(1);
        setDamageModifier(AttributeNames.Wisdom.toString());
        setThisWeaponDamage(true);
        setHitDescription("1[W] + Wisdom modifier damage. Then, the user shifts up to 1 square and slides the target up to 1 square into the space the user occupied before the shift.");
    }
}
