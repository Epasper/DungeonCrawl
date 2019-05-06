package sample.HeroPowers.Paladin;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class BolsteringStrike extends HeroPower {
    public BolsteringStrike() {
        powerName = "Bolstering Strike";
        characterClass = HeroClassInformation.CharacterClasses.Paladin.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Charisma.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Charisma modifier damage, and you gain temporary hit points equal to your Wisdom modifier.";
    }
}
