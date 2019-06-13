package DungeonCrawl.HeroPowers.Cleric;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class BeaconOfHope extends HeroPower {
    public BeaconOfHope() {
        powerName = "Beacon of Hope";
        characterClass = HeroClasses.Cleric.toString();
        typeOfPower = TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "Close Burst 3";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.Will.toString();
        damageDiceDealt = 0;
        damageModifier = AttributeNames.Wisdom.toString();
        typeOfDamageDice = 0;
        isThisWeaponDamage = false;
        hitDescription = "You and each ally in the burst regain 5 hit points. Until the end of the encounter, whenever you restore hit points with a healing power, the recipient regains 5 additional hit points.";

    }
}
