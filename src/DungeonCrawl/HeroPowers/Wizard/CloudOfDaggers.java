package DungeonCrawl.HeroPowers.Wizard;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class CloudOfDaggers extends HeroPower {
    public CloudOfDaggers() {
        setPowerName("Cloud of Daggers");
        setCharacterClass(HeroClasses.Wizard.toString());
        setTypeOfPower(TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(10);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Intelligence.toString());
        setDefenseToBeChecked(CreatureDefenses.Reflex.toString());
        setDamageDiceDealt(1);
        setTypeOfDamageDice(6);
        setDamageModifier(AttributeNames.Intelligence.toString());
        setBonusDamageModifier(AttributeNames.Wisdom.toString());
        setThisWeaponDamage(false);
        setHitDescription("The power's area becomes a zone that lasts until the end of your next turn or until you end it as a minor action. Any creature that enters the zone or starts its turn there takes force damage equal to your Wisdom modifier (minimum 1). A creature can take this damage only once per turn.");
    }
}
