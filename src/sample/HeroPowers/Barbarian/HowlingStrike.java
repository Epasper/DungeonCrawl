package sample.HeroPowers.Barbarian;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class HowlingStrike extends HeroPower {
    public HowlingStrike() {
        powerName = "Howling Strike";
        characterClass = HeroClassInformation.CharacterClasses.Barbarian.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsed = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        bonusDamage = true;
        typeOfBonusDamageDice = 8;
        hitDescription = "1 [W] + 1d6 + Strength modifier damage. When charging, you can use this power in place of a melee basic attack. If you are raging, you can move 2 extra squares as part of the charge.";
    }
}
