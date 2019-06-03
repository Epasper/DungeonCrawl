package DungeonCrawl.HeroPowers.Cleric;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class PriestsShield extends HeroPower {
    public PriestsShield() {
        powerName = "Priest's Shield";
        characterClass = HeroClassInformation.CharacterClasses.Cleric.toString();
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
        hitDescription = "1[W] + Strength modifier damage, and you and one ally adjacent to you gains a +1 power bonus to AC until the end of your next turn.";
    }
}
