package DungeonCrawl.HeroPowers.Paladin;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class EnfeeblingStrike extends HeroPower {
    public EnfeeblingStrike() {
        powerName = "Enfeebling Strike";
        characterClass = HeroClasses.Paladin.toString();
        typeOfPower = TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Charisma.toString();
        defenseToBeChecked = CreatureDefenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = AttributeNames.Charisma.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Charisma modifier damage. If you marked the target, it takes a −2 penalty to attack rolls until the end of your next turn.";
    }
}
