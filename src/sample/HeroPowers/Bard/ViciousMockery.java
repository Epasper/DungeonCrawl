package sample.HeroPowers.Bard;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class ViciousMockery extends HeroPower {
    public ViciousMockery() {
        powerName = "Vicious Mockery";
        characterClass = HeroClassInformation.CharacterClasses.Bard.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Charisma.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Will.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        damageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = false;
        hitDescription = "1d6 + Charisma modifier psychic damage, and the target takes a -2 penalty to attack rolls until the end of your next turn.";
    }
}
