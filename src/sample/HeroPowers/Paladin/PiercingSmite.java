package sample.HeroPowers.Paladin;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class PiercingSmite extends HeroPower {
    public PiercingSmite() {
        powerName = "Piercing Smite";
        characterClass = HeroClassInformation.CharacterClasses.Paladin.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Charisma.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 2;
        damageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = true;
        hitDescription = "2[W] + Strength modifier damage, and the target and a number of enemies adjacent to you equal to your Wisdom modifier are marked until the end of your next turn.";
    }
}
