package DungeonCrawl.HeroPowers.Sorcerer;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class StormWalk extends HeroPower {
    public StormWalk() {
        powerName = "Chaos Bolt";
        characterClass = HeroClasses.Sorcerer.toString();
        typeOfPower = TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "one target";
        attributeUsedToHit = AttributeNames.Charisma.toString();
        defenseToBeChecked = CreatureDefenses.Fortitude.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 8;
        damageModifier = AttributeNames.Charisma.toString();
        isThisWeaponDamage = false;
        hitDescription = "Effect: Before or after the attack, you shift 1 square. 1d8 + Charisma modifier thunder damage.";
    }
}
