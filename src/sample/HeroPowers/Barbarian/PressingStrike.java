package sample.HeroPowers.Barbarian;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class PressingStrike extends HeroPower {
    public PressingStrike() {
        powerName = "Pressing Strike";
        characterClass = HeroClassInformation.CharacterClasses.Barbarian.toString();
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
        hitDescription = "1 [W] + Strength modifier damage, and you push the target 1 square. If you are raging, the attack deals 1d6 extra damage.";
    }
}
