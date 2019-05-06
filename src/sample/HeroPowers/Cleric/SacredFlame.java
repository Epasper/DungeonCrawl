package sample.HeroPowers.Cleric;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class SacredFlame extends HeroPower {
    public SacredFlame() {
        powerName = "Sacred Flame";
        characterClass = HeroClassInformation.CharacterClasses.Cleric.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 5;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        typeOfDamageDice = 6;
        isThisWeaponDamage = false;
        hitDescription = "1d6 + Wisdom modifier radiant damage, and one ally you can see chooses either to make a saving throw or to gain temporary hit points equal to your Charisma modifier + one-half your level.";

    }
}
