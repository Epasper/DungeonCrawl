package sample.HeroPowers.Cleric;

import sample.HeroPowers.HeroPower;
import sample.StaticRules.HeroClassInformation;

public class AvengingFlame extends HeroPower {
    public AvengingFlame() {
        powerName = "Avenging Flame";
        characterClass = HeroClassInformation.CharacterClasses.Cleric.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 2;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        hitDescription = "2[W] + Strength modifier damage, and ongoing 5 fire damage (save ends). If the target attacks on its turn, it can’t make a saving throw against the ongoing damage on that turn.[PH:64][Dr399:Cleric]\n" +
                "\n" +
                "Miss: Half damage";
    }
}
