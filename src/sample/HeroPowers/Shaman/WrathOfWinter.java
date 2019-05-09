package sample.HeroPowers.Shaman;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class WrathOfWinter extends HeroPower {
    public WrathOfWinter() {
        powerName = "Wrath of Winter";
        characterClass = HeroClassInformation.CharacterClasses.Shaman.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 5;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Fortitude.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 10;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = false;
        hitDescription = "1d10 + Wisdom modifier cold damage. You can teleport your spirit companion to a space adjacent to the target.";
    }
}
