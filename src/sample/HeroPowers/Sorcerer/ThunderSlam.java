package sample.HeroPowers.Sorcerer;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class ThunderSlam extends HeroPower {
    public ThunderSlam() {
        powerName = "Thunder Slam";
        characterClass = HeroClassInformation.CharacterClasses.Sorcerer.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "one target";
        attributeUsedToHit = HeroClassInformation.Attributes.Charisma.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Fortitude.toString();
        damageDiceDealt = 2;
        typeOfDamageDice = 10;
        damageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = false;
        hitDescription = "2d10 + Charisma modifier thunder damage, and you push the target 3 squares.";
    }
}
