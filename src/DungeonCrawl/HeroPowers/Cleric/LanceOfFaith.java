package DungeonCrawl.HeroPowers.Cleric;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class LanceOfFaith extends HeroPower {
    public LanceOfFaith() {
        setPowerName("Lance of Faith");
        setCharacterClass(HeroClasses.Cleric.toString());
        setTypeOfPower(TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(10); //todo change this to 5 after testing
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.Reflex.toString());
        setDamageDiceDealt(1);
        setDamageModifier(AttributeNames.Wisdom.toString());
        setTypeOfDamageDice(8);
        setThisWeaponDamage(false);
        setHitDescription("1d8 + Wisdom modifier radiant damage, and one ally you can see gains a +2 power bonus to his or her next attack roll against the target.");

    }
}
