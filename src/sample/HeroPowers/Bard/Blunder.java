package sample.HeroPowers.Bard;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class Blunder extends HeroPower {
    public Blunder() {
        powerName = "Blunder";
        characterClass = HeroClassInformation.CharacterClasses.Bard.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 5;
        typeOfDamageDice = 6;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Charisma.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Will.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = false;
        powersAdditionalOptions = "Virtue of Cunning";
        hitDescription = "Hit: 1d6 + Charisma modifier damage, and you slide the target 2 squares. During the slide, you or one of your allies can make a melee basic attack against the target as a free action, with a +2 power bonus to the attack roll. Virtue of Cunning: The power bonus to the attack roll equals 1 + your Intelligence modifier.";
    }
}
