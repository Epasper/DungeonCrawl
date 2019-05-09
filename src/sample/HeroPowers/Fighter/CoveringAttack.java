package sample.HeroPowers.Fighter;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class CoveringAttack extends HeroPower {
    public CoveringAttack() {
        powerName = "Covering Attack";
        characterClass = HeroClassInformation.CharacterClasses.Fighter.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 2;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        hitDescription = "2[W] + Strength modifier damage, and an ally adjacent to the target can shift 2 square as a free action. ";

    }
}
