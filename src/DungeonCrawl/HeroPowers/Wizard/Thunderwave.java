package DungeonCrawl.HeroPowers.Wizard;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;

public class Thunderwave extends HeroPower {
    public Thunderwave() {
        powerName = "Thunderwave";
        characterClass = HeroClasses.Wizard.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "Blast 3";
        attributeUsedToHit = HeroClassInformation.Attributes.Intelligence.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Fortitude.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        damageModifier = HeroClassInformation.Attributes.Intelligence.toString();
        isThisWeaponDamage = false;
        hitDescription = "1d6 + Intelligence modifier thunder damage, and you push the target a number of squares up to your Wisdom modifier.";
    }
}
