package DungeonCrawl.HeroPowers.Wizard;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class CloudOfDaggers extends HeroPower {
    public CloudOfDaggers() {
        powerName = "Cloud of Daggers";
        characterClass = HeroClasses.Wizard.toString();
        typeOfPower = TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Intelligence.toString();
        defenseToBeChecked = CreatureDefenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        damageModifier = AttributeNames.Intelligence.toString();
        bonusDamageModifier = AttributeNames.Wisdom.toString();
        isThisWeaponDamage = false;
        hitDescription = "The power's area becomes a zone that lasts until the end of your next turn or until you end it as a minor action. Any creature that enters the zone or starts its turn there takes force damage equal to your Wisdom modifier (minimum 1). A creature can take this damage only once per turn.";
    }
}
