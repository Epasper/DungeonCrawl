package sample.HeroPowers.Fighter;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class ReapingStrike extends HeroPower {
    public ReapingStrike() {
        powerName = "Reaping Strike";
        characterClass = HeroClassInformation.CharacterClasses.Fighter.toString();
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
        hitDescription = "1[W] + Strength modifier damage. MISS: Half Strength modifier damage. If you're wielding a two-handed weapon, you deal damage equal to your Strength modifier";
    }
}
