package sample.HeroPowers.Invoker;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class SpearOfTheInquisitor extends HeroPower {
    public SpearOfTheInquisitor() {
        powerName = "Spear of the Inquisitor";
        characterClass = HeroClassInformation.CharacterClasses.Invoker.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One Target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 10;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = false;
        hitDescription = "d10 + Wisdom modifier radiant damage, and the target is immobilized until the end of your next turn. ";
    }
}
