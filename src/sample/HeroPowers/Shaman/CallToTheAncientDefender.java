package sample.HeroPowers.Shaman;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class CallToTheAncientDefender extends HeroPower {
    public CallToTheAncientDefender() {
        powerName = "Call to the Ancient Defender";
        characterClass = HeroClassInformation.CharacterClasses.Shaman.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Fortitude.toString();
        damageDiceDealt = 2;
        typeOfDamageDice = 8;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = false;
        isThisASpiritAttack = true;
        hitDescription = "Hit: 2d8 + Wisdom modifier damage. Until the end of your next turn, you and your allies gain a +5 bonus to all defenses against opportunity attacks while adjacent to your spirit companion.";
    }
}
