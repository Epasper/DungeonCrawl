package sample.HeroPowers.Wizard;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class MagicMissile extends HeroPower {
    public MagicMissile() {
        powerName = "Magic Missile";
        characterClass = HeroClassInformation.CharacterClasses.Wizard.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = "None";
        defenseToBeChecked = "None";
        damageDiceDealt = 0;
        typeOfDamageDice = 0;
        damageModifier = HeroClassInformation.Attributes.Intelligence.toString();
        isThisWeaponDamage = false;
        hitDescription = "2 + Intelligence modifier force damage. Add the enhancement bonus, if any, on the implement used for magic missile to magic missile's damage.";
    }
}
