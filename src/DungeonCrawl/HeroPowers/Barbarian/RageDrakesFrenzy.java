package DungeonCrawl.HeroPowers.Barbarian;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class RageDrakesFrenzy extends HeroPower {
    public RageDrakesFrenzy() {
        powerName = "Rage Drake's Frenzy";
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
        hitDescription = "You enter the rage of the rage drake. Until the rage ends, once per round when you reduce an enemy to 0 hit points, you can make a melee basic attack as a free action.";
    }
}
