package sample.HeroPowers.Fighter;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class SpinningSweep extends HeroPower {
    public SpinningSweep() {
        powerName = "Spinning Sweep";
        characterClass = HeroClassInformation.CharacterClasses.Fighter.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Strength modifier damage, and you knock the target prone.";
    }
}
