package sample.HeroPowers.Sorcerer;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class Frostbind extends HeroPower {
    public Frostbind() {
        powerName = "Frostbind";
        characterClass = HeroClassInformation.CharacterClasses.Sorcerer.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "one target";
        attributeUsedToHit = HeroClassInformation.Attributes.Charisma.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Fortitude.toString();
        damageDiceDealt = 3;
        typeOfDamageDice = 6;
        damageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = false;
        hitDescription = "3d6 + Charisma modifier cold damage, and the target takes a –2 penalty to Reflex until the end of your next turn.";
    }
}
