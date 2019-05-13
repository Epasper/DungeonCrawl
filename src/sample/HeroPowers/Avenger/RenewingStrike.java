package sample.HeroPowers.Avenger;

import sample.HeroPowers.HeroPower;
import sample.StaticRules.HeroClassInformation;

public class RenewingStrike extends HeroPower {
    public RenewingStrike() {
        powerName = "Renewing Strike";
        characterClass = HeroClassInformation.CharacterClasses.Avenger.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 2;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = false;
        damageDiceDealt = 10;
        hitDescription = "2d10 + Wisdom modifier lightning damage\n" +
                "\n" +
                "Miss: Half damage\n" +
                "\n" +
                "Effect: You can spend a healing surge";
    }
}
