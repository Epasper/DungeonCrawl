package sample.HeroPowers.Cleric;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class DivineGlow extends HeroPower {
    public DivineGlow() {
        powerName = "Divine Glow";
        characterClass = HeroClassInformation.CharacterClasses.Cleric.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "Close Blast 3";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        typeOfDamageDice = 8;
        isThisWeaponDamage = false;
        hitDescription = "1d8 + Wisdom modifier radiant damage. Effect: Allies in the blast gain a +2 power bonus to attack rolls until the end of your next turn.";

    }
}
