package sample.HeroPowers.Barbarian;

import sample.HeroPowers.HeroPower;
import sample.StaticRules.HeroClassInformation;

public class MacetailsRage extends HeroPower {
    public MacetailsRage() {
        powerName = "Macetail's Rage";
        characterClass = HeroClassInformation.CharacterClasses.Barbarian.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "Close Burst 1";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        hitDescription = "You enter the rage of the Macetail Behemoth. Until the rage ends, whenever you hit, gain temporary hit points equal to your Str mod";
    }
}
