package sample.HeroPowers.Cleric;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class CauseFear extends HeroPower {
    public CauseFear() {
        powerName = "Cause Fear";
        characterClass = HeroClassInformation.CharacterClasses.Cleric.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Will.toString();
        damageDiceDealt = 0;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        typeOfDamageDice = 0;
        isThisWeaponDamage = false;
        hitDescription = "The target is compelled to take a free action to move as far away from you as it can, moving a number of squares equal to its speed + your Charisma modifier. It avoids hindering terrain and difficult terrain if it can. This movement is not considered forced movement, so it provokes opportunity attacks.";

    }
}
