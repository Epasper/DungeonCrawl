package sample.HeroPowers.Bard;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class InspiringRefrain extends HeroPower {
    public InspiringRefrain() {
        powerName = "Inspiring Refrain";
        characterClass = HeroClassInformation.CharacterClasses.Bard.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Charisma.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 2;
        damageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = true;
        hitDescription = "2[W] + Charisma modifier damage, and each ally within 5 squares of you gains a +1 power bonus to attack rolls until the end of your next turn.";
    }
}
