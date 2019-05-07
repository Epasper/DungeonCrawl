package sample.HeroPowers.Cleric;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class WrathfulThunder extends HeroPower {
    public WrathfulThunder() {
        powerName = "Wrathful Thunder";
        characterClass = HeroClassInformation.CharacterClasses.Cleric.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Strength modifier thunder damage, an the target is dazed until the end of your next turn.";
    }
}
