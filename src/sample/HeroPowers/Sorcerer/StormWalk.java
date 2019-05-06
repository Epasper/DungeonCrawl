package sample.HeroPowers.Sorcerer;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class StormWalk extends HeroPower {
    public StormWalk() {
        powerName = "Chaos Bolt";
        characterClass = HeroClassInformation.CharacterClasses.Sorcerer.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "one target";
        attributeUsedToHit = HeroClassInformation.Attributes.Charisma.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Fortitude.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 8;
        damageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = false;
        hitDescription = "Effect: Before or after the attack, you shift 1 square. 1d8 + Charisma modifier thunder damage.";
    }
}
