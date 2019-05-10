package sample.HeroPowers.Fighter;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class Cleave extends HeroPower {
    public Cleave() {
        powerName = "Cleave";
        characterClass = HeroClassInformation.CharacterClasses.Fighter.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString()+"+2";
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Strength modifier damage, and an enemy adjacent to you other than the target takes damage equal to your Strength modifier.";
    }
}