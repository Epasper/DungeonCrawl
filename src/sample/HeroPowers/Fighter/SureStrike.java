package sample.HeroPowers.Fighter;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class SureStrike extends HeroPower {
    public SureStrike() {
        powerName = "Sure Strike";
        characterClass = HeroClassInformation.CharacterClasses.Fighter.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsed = HeroClassInformation.Attributes.Strength.toString()+"+2";
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = "None";
        isThisWeaponDamage = true;
        hitDescription = "1[W] damage.";

    }
}
