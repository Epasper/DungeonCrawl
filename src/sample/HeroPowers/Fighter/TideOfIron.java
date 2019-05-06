package sample.HeroPowers.Fighter;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class TideOfIron extends HeroPower {
    public TideOfIron() {
        powerName = "Tide of Iron";
        characterClass = HeroClassInformation.CharacterClasses.Fighter.toString();
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
        hitDescription = "1[W] + Strength modifier damage, and you push the target 1 square if it is your size, smaller than you, or one size category larger. You can shift into the space that the target occupied.";
    }
}
