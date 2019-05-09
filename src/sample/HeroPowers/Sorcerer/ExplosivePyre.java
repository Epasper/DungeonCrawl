package sample.HeroPowers.Sorcerer;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class ExplosivePyre extends HeroPower {
    public ExplosivePyre() {
        powerName = "Explosive Pyre";
        characterClass = HeroClassInformation.CharacterClasses.Sorcerer.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "one target";
        attributeUsedToHit = HeroClassInformation.Attributes.Charisma.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Will.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 10;
        damageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = false;
        hitDescription = "2d8 + Charisma modifier damage. Until the start of your next turn, any enemy that enters a square adjacent to the target or starts its turn there takes 1d6 fire damage. An enemy can take this damage only once per turn.";
    }
}
