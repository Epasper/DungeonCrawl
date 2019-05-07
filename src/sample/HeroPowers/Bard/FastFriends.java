package sample.HeroPowers.Bard;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class FastFriends extends HeroPower {
    public FastFriends() {
        powerName = "Fast Friends";
        characterClass = HeroClassInformation.CharacterClasses.Bard.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 5;
        typeOfDamageDice = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Charisma.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Will.toString();
        damageDiceDealt = 0;
        damageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = false;
        hitDescription = "Hit: Choose yourself or an ally. The target cannot attack that character until the end of your next turn or until you or one of your allies attacks the target.";
    }
}
