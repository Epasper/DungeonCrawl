package sample.HeroPowers.Warlord;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class HammerAndAnvil extends HeroPower {
    public HammerAndAnvil() {
        powerName = "Hammer and Anvil";
        characterClass = HeroClassInformation.CharacterClasses.Warlord.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Strength modifier damage. One ally adjacent to the target can make a melee basic attack against it as a free action, with a bonus to the damage roll equal to your Charisma modifier.";
    }
}
