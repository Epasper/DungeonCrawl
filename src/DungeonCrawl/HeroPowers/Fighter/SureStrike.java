package DungeonCrawl.HeroPowers.Fighter;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;

public class SureStrike extends HeroPower {
    public SureStrike() {
        powerName = "Sure Strike";
        characterClass = HeroClasses.Fighter.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        bonusToHit = 2;
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = "None";
        isThisWeaponDamage = true;
        hitDescription = "1[W] damage.";

    }
}
