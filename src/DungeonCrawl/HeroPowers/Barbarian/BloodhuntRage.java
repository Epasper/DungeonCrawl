package DungeonCrawl.HeroPowers.Barbarian;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class BloodhuntRage extends HeroPower {
    public BloodhuntRage() {
        powerName = "Bloodhunt Rage";
        characterClass = HeroClasses.Barbarian.toString();
        typeOfPower = TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Strength.toString();
        defenseToBeChecked = CreatureDefenses.AC.toString();
        damageDiceDealt = 3;
        damageModifier = AttributeNames.Strength.toString();
        isThisWeaponDamage = true;
        bonusDamage = true;
        hitDescription = "You enter the rage of the bloodhunt. Until the rage ends, you gain a bonus to melee damage rolls equal to your Constitution modifier if either you or your target is bloodied.";
    }
}
