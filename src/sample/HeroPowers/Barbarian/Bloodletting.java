package sample.HeroPowers.Barbarian;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class Bloodletting extends HeroPower {
    public Bloodletting() {
        powerName = "Bloodletting";
        characterClass = HeroClassInformation.CharacterClasses.Barbarian.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 2;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        bonusDamage = true;
        hitDescription = "2[W] + Strength modifier damage. If the target is bloodied, the attack deals extra damage equal to your Constitution modifier.";
    }
}
