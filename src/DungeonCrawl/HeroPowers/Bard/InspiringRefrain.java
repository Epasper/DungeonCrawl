package DungeonCrawl.HeroPowers.Bard;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class InspiringRefrain extends HeroPower {
    public InspiringRefrain() {
        powerName = "Inspiring Refrain";
        characterClass = HeroClasses.Bard.toString();
        typeOfPower = TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Charisma.toString();
        defenseToBeChecked = CreatureDefenses.AC.toString();
        damageDiceDealt = 2;
        damageModifier = AttributeNames.Charisma.toString();
        isThisWeaponDamage = true;
        hitDescription = "2[W] + Charisma modifier damage, and each ally within 5 squares of you gains a +1 power bonus to attack rolls until the end of your next turn.";
    }
}
