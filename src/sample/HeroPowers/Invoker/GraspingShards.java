package sample.HeroPowers.Invoker;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class GraspingShards extends HeroPower {
    public GraspingShards() {
        powerName = "Grasping Shards";
        characterClass = HeroClassInformation.CharacterClasses.Invoker.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "Burst 1";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Fortitude.toString();
        damageDiceDealt = 0;
        typeOfDamageDice = 0;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = false;
        hitDescription = "Wisdom modifier radiant damage, and the target is slowed until the end of your next turn.";
    }
}
