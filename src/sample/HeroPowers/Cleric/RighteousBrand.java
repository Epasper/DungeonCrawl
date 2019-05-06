package sample.HeroPowers.Cleric;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class RighteousBrand extends HeroPower {
    public RighteousBrand() {
        powerName = "Righteous Brand";
        characterClass = HeroClassInformation.CharacterClasses.Cleric.toString();
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
        hitDescription = "1[W] + Strength modifier damage, and one ally within 5 squares of you gains a +3 power bonus to melee attack rolls against the target until the end of your next turn.";
    }
}
