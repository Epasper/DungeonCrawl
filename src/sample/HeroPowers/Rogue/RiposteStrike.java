package sample.HeroPowers.Rogue;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class RiposteStrike extends HeroPower {
    public RiposteStrike() {
        powerName = "Riposte Strike";
        characterClass = HeroClassInformation.CharacterClasses.Rogue.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Dexterity.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Dexterity.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Dexterity modifier damage. If the target attacks you before the start of your next turn, you make your riposte against the target as an immediate interrupt: a Strength vs. AC attack that deals 1[W] + Strength modifier damage.";
    }
}
