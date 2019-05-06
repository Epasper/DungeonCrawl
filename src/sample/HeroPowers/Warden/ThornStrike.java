package sample.HeroPowers.Warden;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class ThornStrike extends HeroPower {
    public ThornStrike() {
        powerName = "Earth Shield Strike";
        characterClass = HeroClassInformation.CharacterClasses.Warden.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Strength modifier damage. The target is pulled 1 square.";
    }
}
