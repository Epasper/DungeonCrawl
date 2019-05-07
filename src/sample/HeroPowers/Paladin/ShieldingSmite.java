package sample.HeroPowers.Paladin;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class ShieldingSmite extends HeroPower {
    public ShieldingSmite() {
        powerName = "Shielding Smite";
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
        hitDescription = "Until the end of your next turn, one ally within 5 squares of you gains a power bonus to AC equal to your Wisdom modifier.";
    }
}
