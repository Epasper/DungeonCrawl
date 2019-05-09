package sample.HeroPowers.Bard;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class GuidingStrike extends HeroPower {
    public GuidingStrike() {
        powerName = "Guiding Strike";
        characterClass = HeroClassInformation.CharacterClasses.Bard.toString();
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
        hitDescription = "1[W] + Charisma modifier damage, and the target takes a -2 penalty to the defense of your choice until the end of your next turn.";
    }
}
