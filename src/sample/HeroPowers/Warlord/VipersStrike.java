package sample.HeroPowers.Warlord;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class VipersStrike extends HeroPower {
    public VipersStrike() {
        powerName = "Viper's Strike";
        characterClass = HeroClassInformation.CharacterClasses.Warlord.toString();
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
        hitDescription = "1[W] + Strength modifier damage. If the target shifts before the start of your next turn, it provokes an opportunity attack from an ally of your choice.";
    }
}
