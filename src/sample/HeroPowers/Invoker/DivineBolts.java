package sample.HeroPowers.Invoker;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class DivineBolts extends HeroPower {
    public DivineBolts() {
        powerName = "Divine Bolts";
        characterClass = HeroClassInformation.CharacterClasses.Invoker.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One or Two targets";
        attributeUsed = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = false;
        hitDescription = "1d6 + Wisdom modifier lightning damage.";
    }
}
