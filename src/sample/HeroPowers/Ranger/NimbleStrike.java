package sample.HeroPowers.Ranger;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class NimbleStrike extends HeroPower {
    public NimbleStrike() {
        powerName = "Nimble Strike";
        characterClass = HeroClassInformation.CharacterClasses.Ranger.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Dexterity.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Dexterity.toString();
        isThisWeaponDamage = true;
        hitDescription = "Shift 1 square before or after you attack. 1[W] + Dexterity modifier damage.";
    }
}
