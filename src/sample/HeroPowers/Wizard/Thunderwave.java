package sample.HeroPowers.Wizard;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class Thunderwave extends HeroPower {
    public Thunderwave() {
        powerName = "Thunderwave";
        characterClass = HeroClassInformation.CharacterClasses.Wizard.toString();
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
