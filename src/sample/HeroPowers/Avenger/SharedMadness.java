package sample.HeroPowers.Avenger;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class SharedMadness extends HeroPower {
    public SharedMadness() {
        powerName = "Shared Madness";
        characterClass = HeroClassInformation.CharacterClasses.Avenger.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Will.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 10;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = false;
        hitDescription = "1d10 + Wisdom modifier psychic damage, and a second creature you can see takes the same damage.";
    }
}
