package sample.HeroPowers.Sorcerer;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class AcidOrb extends HeroPower {
    public AcidOrb() {
        powerName = "Acid Orb";
        characterClass = HeroClassInformation.CharacterClasses.Sorcerer.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 20;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Charisma.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 10;
        damageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = false;
        hitDescription = "Acid orb can be used as a ranged basic attack. 1d10 + Charisma modifier acid damage.";
    }
}
