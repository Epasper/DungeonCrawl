package sample.HeroPowers.Avenger;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class AngelicAlacrity extends HeroPower {
    public AngelicAlacrity() {
        powerName = "Angelic Alacrity";
        characterClass = HeroClassInformation.CharacterClasses.Avenger.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 2;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = true;
        secondAttributeUsed = HeroClassInformation.Attributes.Dexterity.toString();
        powersAdditionalOptions = "Censure of Pursuit";
        hitDescription = "Effect: Before the attack, you shift 2 squares. Censure of Pursuit: The number of squares you shift equals 1 + your Dexterity modifier.";
    }
}
