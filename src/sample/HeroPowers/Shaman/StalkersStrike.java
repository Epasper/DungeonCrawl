package sample.HeroPowers.Shaman;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class StalkersStrike extends HeroPower {
    public StalkersStrike() {
        powerName = "Watcher's Strike";
        characterClass = HeroClassInformation.CharacterClasses.Shaman.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Fortitude.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 10;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = false;
        isThisASpiritAttack = true;
        hitDescription = "1d10 + Wisdom modifier damage. Until the end of your next turn, your spirit companion can flank with you and your allies.";
    }
}