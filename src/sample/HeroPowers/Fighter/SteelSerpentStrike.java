package sample.HeroPowers.Fighter;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class SteelSerpentStrike extends HeroPower {
    public SteelSerpentStrike() {
        powerName = "Steel Serpent Strike";
        characterClass = HeroClassInformation.CharacterClasses.Fighter.toString();
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
        hitDescription = "2[W] + Strength modifier damage, and the target is slowed and cannot shift until the end of your next turn.";
    }
}
