package DungeonCrawl.HeroPowers.Avenger;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.StaticRules.HeroClasses;

public class AspectOfMight extends HeroPower {
    public AspectOfMight() {
        powerName = "Aspect of Might";
        characterClass = HeroClasses.Avenger.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 3;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = true;
        hitDescription = "Until the end of the encounter, you gain a +5 power bonus to Athletics checks, a +2 power bonus to speed, and a +2 power bonus to the damage rolls of melee attacks.";
    }
}
