package DungeonCrawl.HeroPowers.Fighter;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class PassingAttack extends HeroPower {
    public PassingAttack() {
        powerName = "Passing Attack";
        characterClass = HeroClassInformation.CharacterClasses.Fighter.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Strength modifier damage, and you can shift 1 square. Make the secondary attack. \n" +
                "Secondary Attack:\n" +
                "\n" +
                "Target: One creature other than the primary target.\n" +
                "Attack: Strength +2 vs AC\n" +
                "Hit: 1[W] + Strength modifier damage.";
    }
}
