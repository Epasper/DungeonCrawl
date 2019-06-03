package DungeonCrawl.HeroPowers.Wizard;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class CloudOfDaggers extends HeroPower {
    public CloudOfDaggers() {
        powerName = "Cloud of Daggers";
        characterClass = HeroClassInformation.CharacterClasses.Wizard.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Intelligence.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        damageModifier = HeroClassInformation.Attributes.Intelligence.toString();
        bonusDamageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = false;
        hitDescription = "The power's area becomes a zone that lasts until the end of your next turn or until you end it as a minor action. Any creature that enters the zone or starts its turn there takes force damage equal to your Wisdom modifier (minimum 1). A creature can take this damage only once per turn.";
    }
}
