package sample.HeroPowers.Warden;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class WildbloodFrenzy extends HeroPower {
    public WildbloodFrenzy() {
        powerName = "Wildblood Frenzy";
        characterClass = HeroClassInformation.CharacterClasses.Warden.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        bonusDamageModifier = HeroClassInformation.Attributes.Constitution.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Strength modifier damage.\n" +
                "\n" +
                "Effect: Make the attack one more time against the same target or a different one.";
    }
}