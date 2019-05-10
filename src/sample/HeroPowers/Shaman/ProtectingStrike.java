package sample.HeroPowers.Shaman;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class ProtectingStrike extends HeroPower {
    public ProtectingStrike() {
        powerName = "Protecting Strike";
        characterClass = HeroClassInformation.CharacterClasses.Shaman.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 8;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = false;
        isThisASpiritAttack = true;
        hitDescription = "1d8 + Wisdom modifier damage. Until the end of your next turn, you and your allies gain a +1 power bonus to AC while adjacent to your spirit companion.";
    }
}