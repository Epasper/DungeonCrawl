package sample.HeroPowers.Avenger;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class OverwhelmingStrike extends HeroPower {
    public OverwhelmingStrike() {
        powerName = "Overwhelming Strike";
        characterClass = HeroClassInformation.CharacterClasses.Avenger.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsed = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Wisdom modifier damage. Then, the user shifts up to 1 square and slides the target up to 1 square into the space the user occupied before the shift.";
    }
}