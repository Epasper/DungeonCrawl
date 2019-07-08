package DungeonCrawl.HeroPowers.Invoker;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class GraspingShards extends HeroPower {
    public GraspingShards() {
        setPowerName("Grasping Shards");
        setCharacterClass(HeroClasses.Invoker.toString());
        setTypeOfPower(TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(10);
        setNumberOfTargets("Burst");
        setBurstValue(1);
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.Fortitude.toString());
        setDamageDiceDealt(0);
        setTypeOfDamageDice(0);
        setDamageModifier(AttributeNames.Wisdom.toString());
        setThisWeaponDamage(false);
        setHitDescription("Wisdom modifier radiant damage, and the target is slowed until the end of your next turn.");
    }
}
