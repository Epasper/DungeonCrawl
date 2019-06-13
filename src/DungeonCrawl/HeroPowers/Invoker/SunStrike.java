package DungeonCrawl.HeroPowers.Invoker;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class SunStrike extends HeroPower {
    public SunStrike() {
        powerName = "Sun Strike";
        characterClass = HeroClasses.Invoker.toString();
        typeOfPower = TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 8;
        numberOfTargets = "One Target";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 8;
        damageModifier = AttributeNames.Wisdom.toString();
        isThisWeaponDamage = false;
        hitDescription = "1d8 + Wisdom modifier radiant damage, and you slide the target 1 square.";
    }
}
