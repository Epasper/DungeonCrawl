package sample.HeroPowers.Invoker;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class SunStrike extends HeroPower {
    public SunStrike() {
        powerName = "Sun Strike";
        characterClass = HeroClassInformation.CharacterClasses.Invoker.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 8;
        numberOfTargets = "Burst 1";
        attributeUsed = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 8;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = false;
        hitDescription = "1d8 + Wisdom modifier radiant damage, and you slide the target 1 square.";
    }
}
