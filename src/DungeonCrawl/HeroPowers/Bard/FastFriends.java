package DungeonCrawl.HeroPowers.Bard;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class FastFriends extends HeroPower {
    public FastFriends() {
        powerName = "Fast Friends";
        characterClass = HeroClasses.Bard.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 5;
        typeOfDamageDice = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Charisma.toString();
        defenseToBeChecked = CreatureDefenses.Will.toString();
        damageDiceDealt = 0;
        damageModifier = AttributeNames.Charisma.toString();
        isThisWeaponDamage = false;
        hitDescription = "Hit: Choose yourself or an ally. The target cannot attack that character until the end of your next turn or until you or one of your allies attacks the target.";
    }
}
