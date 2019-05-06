package sample.HeroPowers.Avenger;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class BondOfRetribution extends HeroPower {
    public BondOfRetribution() {
        powerName = "Bond of Retribution";
        characterClass = HeroClassInformation.CharacterClasses.Avenger.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsed = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Wisdom modifier damage. Before the end of the user's next turn, the first time an enemy other than the target hits or misses the user, the target takes radiant damage equal to the user's Intelligence modifier.";
    }
}
