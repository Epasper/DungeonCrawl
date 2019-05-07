package sample.HeroPowers.Warlord;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class LeafOnTheWind extends HeroPower {
    public LeafOnTheWind() {
        powerName = "Leaf on the Wind";
        characterClass = HeroClassInformation.CharacterClasses.Warlord.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 2;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        hitDescription = "2[W] + Strength modifier damage. You (only if you are adjacent to the target) or one ally adjacent to the target can take a free action to swap places with it, sliding it 1 square and shifting 1 square.";
    }
}
