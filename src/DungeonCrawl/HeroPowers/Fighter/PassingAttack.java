package DungeonCrawl.HeroPowers.Fighter;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class PassingAttack extends HeroPower {
    public PassingAttack() {
        powerName = "Passing Attack";
        characterClass = HeroClasses.Fighter.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Strength.toString();
        defenseToBeChecked = CreatureDefenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = AttributeNames.Strength.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Strength modifier damage, and you can shift 1 square. Make the secondary attack. \n" +
                "Secondary Attack:\n" +
                "\n" +
                "Target: One creature other than the primary target.\n" +
                "Attack: Strength +2 vs AC\n" +
                "Hit: 1[W] + Strength modifier damage.";
    }
}
