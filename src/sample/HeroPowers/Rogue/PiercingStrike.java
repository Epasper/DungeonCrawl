package sample.HeroPowers.Rogue;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class PiercingStrike extends HeroPower {
    public PiercingStrike() {
        powerName = "Piercing Strike";
        characterClass = HeroClassInformation.CharacterClasses.Rogue.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Dexterity.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Dexterity.toString();
        isThisWeaponDamage = true;
        canThisAttackAlsoBeRanged = true;
        hitDescription = "1[W] + Dexterity modifier damage.";
    }
}
