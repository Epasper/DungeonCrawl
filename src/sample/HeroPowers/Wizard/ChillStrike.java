package sample.HeroPowers.Wizard;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class ChillStrike extends HeroPower {
    public ChillStrike() {
        powerName = "Chill Strike";
        characterClass = HeroClassInformation.CharacterClasses.Wizard.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Intelligence.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Fortitude.toString();
        damageDiceDealt = 2;
        typeOfDamageDice = 8;
        damageModifier = HeroClassInformation.Attributes.Intelligence.toString();
        isThisWeaponDamage = false;
        hitDescription = "2d8 + Intelligence modifier cold damage, and the target is dazed until the end of your next turn.\"[PH:159]\n" +
                "\n" +
                "Miss: \"The target is slowed until the end of your next turn.";
    }
}
