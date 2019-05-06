package sample.HeroPowers.Bard;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class MisdirectedMark extends HeroPower {
    public MisdirectedMark() {
        powerName = "Misdirected Mark";
        characterClass = HeroClassInformation.CharacterClasses.Bard.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Charisma.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 8;
        damageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = false;
        hitDescription = "1d8 + Charisma modifier damage, and the target is marked by an ally within 5 squares of you until the end of your next turn.";
    }
}
