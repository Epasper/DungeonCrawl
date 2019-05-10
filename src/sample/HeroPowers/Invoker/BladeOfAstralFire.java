package sample.HeroPowers.Invoker;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class BladeOfAstralFire extends HeroPower {
    public BladeOfAstralFire() {
        powerName = "Blade of Astral Fire";
        characterClass = HeroClassInformation.CharacterClasses.Invoker.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "Close Burst 3";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Will.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = false;
        hitDescription = "1d6 + Wisdom modifier psychic damage, and you push the target 2 squares.";
    }
}