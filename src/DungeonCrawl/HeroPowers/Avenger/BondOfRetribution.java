package DungeonCrawl.HeroPowers.Avenger;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class BondOfRetribution extends HeroPower {
    public BondOfRetribution() {
        setPowerName("Bond of Retribution");
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
        setHitDescription("1[W] + Wisdom modifier damage. Before the end of the user's next turn, the first time an enemy other than the target hits or misses the user, the target takes radiant damage equal to the user's Intelligence modifier.");
    }
}
