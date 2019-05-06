package sample.HeroPowers.Druid;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class ChillWind extends HeroPower {
    public ChillWind() {
        powerName = "Chill Wind";
        characterClass = HeroClassInformation.CharacterClasses.Druid.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "Burst 1";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Fortitude.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        damageModifier = "None";
        isThisWeaponDamage = false;
        hitDescription = "1d6 cold damage, and you slide the target 1 square.";
    }
}
