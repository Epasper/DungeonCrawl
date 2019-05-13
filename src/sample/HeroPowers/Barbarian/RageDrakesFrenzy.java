package sample.HeroPowers.Barbarian;

import sample.HeroPowers.HeroPower;
import sample.StaticRules.HeroClassInformation;

public class RageDrakesFrenzy extends HeroPower {
    public RageDrakesFrenzy() {
        powerName = "Rage Drake's Frenzy";
        characterClass = HeroClassInformation.CharacterClasses.Barbarian.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 3;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        bonusDamage = true;
        hitDescription = "You enter the rage of the rage drake. Until the rage ends, once per round when you reduce an enemy to 0 hit points, you can make a melee basic attack as a free action.";
    }
}
