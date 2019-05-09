package sample.HeroPowers.Ranger;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class HitAndRun extends HeroPower {
    public HitAndRun() {
        powerName = "Hit and Run";
        characterClass = HeroClassInformation.CharacterClasses.Ranger.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Strength modifier damage. If you move in the same turn after this attack, leaving the first square adjacent to the target does not provoke an opportunity attack from the target.";
    }
}
