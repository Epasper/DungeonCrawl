package sample.HeroPowers.Paladin;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class ValiantStrike extends HeroPower {
    public ValiantStrike() {
        powerName = "Valiant Strike";
        characterClass = HeroClassInformation.CharacterClasses.Paladin.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        bonusToHit = 0;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Strength modifier damage.";
    }
}
