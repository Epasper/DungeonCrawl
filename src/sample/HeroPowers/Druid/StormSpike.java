package sample.HeroPowers.Druid;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class StormSpike extends HeroPower {
    public StormSpike() {
        powerName = "Storm Spike";
        characterClass = HeroClassInformation.CharacterClasses.Druid.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 8;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = false;
        hitDescription = "1d8 + Wisdom modifier lightning damage. If the target doesn't move at least 2 squares on its next turn, it takes lightning damage equal to your Wisdom modifier.";
    }
}
