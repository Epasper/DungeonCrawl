package sample.HeroPowers.Sorcerer;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class BurningSpray extends HeroPower {
    public BurningSpray() {
        powerName = "Burning Spray";
        characterClass = HeroClassInformation.CharacterClasses.Sorcerer.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "Blast 3";
        attributeUsedToHit = HeroClassInformation.Attributes.Charisma.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 8;
        damageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = false;
        bonusDamageModifier = HeroClassInformation.Attributes.Strength.toString();
        hitDescription = "1d8 + Charisma modifier fire damage. Dragon Magic: The next enemy that hits you with a melee attack before the end of your next turn takes fire damage equal to your Strength modifier.";
    }
}
