package sample.HeroPowers.Ranger;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class EvasiveStrike extends HeroPower {
    public EvasiveStrike() {
        powerName = "Evasive Strike";
        characterClass = HeroClassInformation.CharacterClasses.Ranger.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 20;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        hitDescription = "Special: You can shift a number of squares equal to 1+ Wisdom modifier either before or after the attack. \n" +
                "Strength vs. AC(melee) or Dexterity vs. AC(ranged)\n" +
                "\n" +
                "Hit: 2[W] + Dexterity(ranged) modifier damage or 2[W] + Strength(melee) modifier damage.";
    }
}
