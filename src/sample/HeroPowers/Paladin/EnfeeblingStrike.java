package sample.HeroPowers.Paladin;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class EnfeeblingStrike extends HeroPower {
    public EnfeeblingStrike() {
        powerName = "Enfeebling Strike";
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
        hitDescription = "1[W] + Charisma modifier damage. If you marked the target, it takes a −2 penalty to attack rolls until the end of your next turn.";
    }
}
