package sample.HeroPowers.Druid;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class GraspingClaws extends HeroPower {
    public GraspingClaws() {
        powerName = "Grasping Claws";
        characterClass = HeroClassInformation.CharacterClasses.Druid.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsed = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 8;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = false;
        hitDescription = "1d8 + Wisdom modifier damage, and the target is slowed until the end of your next turn. Grasping claws can be used as a melee basic attack.";
    }
}
