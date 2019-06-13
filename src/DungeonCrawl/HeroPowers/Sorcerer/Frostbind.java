package DungeonCrawl.HeroPowers.Sorcerer;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class Frostbind extends HeroPower {
    public Frostbind() {
        powerName = "Frostbind";
        characterClass = HeroClasses.Sorcerer.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "one target";
        attributeUsedToHit = AttributeNames.Charisma.toString();
        defenseToBeChecked = CreatureDefenses.Fortitude.toString();
        damageDiceDealt = 3;
        typeOfDamageDice = 6;
        damageModifier = AttributeNames.Charisma.toString();
        isThisWeaponDamage = false;
        hitDescription = "3d6 + Charisma modifier cold damage, and the target takes a –2 penalty to Reflex until the end of your next turn.";
    }
}
