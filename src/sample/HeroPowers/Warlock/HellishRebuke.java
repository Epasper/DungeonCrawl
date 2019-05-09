package sample.HeroPowers.Warlock;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class HellishRebuke extends HeroPower {
    public HellishRebuke() {
        powerName = "Hellish Rebuke";
        characterClass = HeroClassInformation.CharacterClasses.Warlock.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Charisma.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        damageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = false;
        hitDescription = "1d6 + Constitution modifier fire damage. The first time you take damage before the end of your next turn, the target takes 1d6 + Constitution modifier fire damage.";
    }
}
