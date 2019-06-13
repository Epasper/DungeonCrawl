package DungeonCrawl.HeroPowers.Avenger;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class AspectOfMight extends HeroPower {
    public AspectOfMight() {
        powerName = "Aspect of Might";
        characterClass = HeroClasses.Avenger.toString();
        typeOfPower = TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.AC.toString();
        damageDiceDealt = 3;
        damageModifier = AttributeNames.Wisdom.toString();
        isThisWeaponDamage = true;
        hitDescription = "Until the end of the encounter, you gain a +5 power bonus to Athletics checks, a +2 power bonus to speed, and a +2 power bonus to the damage rolls of melee attacks.";
    }
}
