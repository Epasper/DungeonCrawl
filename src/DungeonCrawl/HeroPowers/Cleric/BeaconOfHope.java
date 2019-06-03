package DungeonCrawl.HeroPowers.Cleric;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClassInformation;

public class BeaconOfHope extends HeroPower {
    public BeaconOfHope() {
        powerName = "Beacon of Hope";
        characterClass = HeroClassInformation.CharacterClasses.Cleric.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "Close Burst 3";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Will.toString();
        damageDiceDealt = 0;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        typeOfDamageDice = 0;
        isThisWeaponDamage = false;
        hitDescription = "You and each ally in the burst regain 5 hit points. Until the end of the encounter, whenever you restore hit points with a healing power, the recipient regains 5 additional hit points.";

    }
}
