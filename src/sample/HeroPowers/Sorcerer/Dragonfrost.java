package sample.HeroPowers.Sorcerer;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class Dragonfrost extends HeroPower {
    public Dragonfrost() {
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
        typeOfDamageDice = 10;
        damageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = false;
        hitDescription = "Dragonfrost can be used as a ranged basic attack. 1d8 + Charisma modifier cold damage, and you push the target 1 square.";
    }
}
