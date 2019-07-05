package DungeonCrawl.HeroPowers.Invoker;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class GraspingShards extends HeroPower {
    public GraspingShards() {
        powerName = "Grasping Shards";
        characterClass = HeroClasses.Invoker.toString();
        typeOfPower = TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "Burst";
        burstValue = 1;
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.Fortitude.toString();
        damageDiceDealt = 0;
        typeOfDamageDice = 0;
        damageModifier = AttributeNames.Wisdom.toString();
        isThisWeaponDamage = false;
        hitDescription = "Wisdom modifier radiant damage, and the target is slowed until the end of your next turn.";
    }
}
