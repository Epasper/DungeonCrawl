package DungeonCrawl.HeroPowers.Ranger;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class CarefulAttack extends HeroPower {
    public CarefulAttack() {
        powerName = "Careful Attack";
        characterClass = HeroClassInformation.CharacterClasses.Ranger.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        bonusToHit = 2;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        canThisAttackAlsoBeRanged = true;
        hitDescription = "1[W] + Strength modifier damage (melee) or 1[W] + Dexterity modifier damage (ranged).";
    }
}
