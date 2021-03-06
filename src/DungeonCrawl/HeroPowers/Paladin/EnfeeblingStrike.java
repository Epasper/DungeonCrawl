package DungeonCrawl.HeroPowers.Paladin;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class EnfeeblingStrike extends HeroPower {
    public EnfeeblingStrike() {
        setPowerName("Enfeebling Strike");
        setCharacterClass(HeroClasses.Paladin.toString());
        setTypeOfPower(TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Charisma.toString());
        setDefenseToBeChecked(CreatureDefenses.AC.toString());
        setDamageDiceDealt(1);
        setDamageModifier(AttributeNames.Charisma.toString());
        setThisWeaponDamage(true);
        setHitDescription("1[W] + Charisma modifier damage. If you marked the target, it takes a −2 penalty to attack rolls until the end of your next turn.");
    }
}
