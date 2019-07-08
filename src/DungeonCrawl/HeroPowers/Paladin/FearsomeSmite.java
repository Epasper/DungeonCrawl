package DungeonCrawl.HeroPowers.Paladin;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class FearsomeSmite extends HeroPower {
    public FearsomeSmite() {
        setPowerName("Fearsome Smite");
        setCharacterClass(HeroClasses.Paladin.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Charisma.toString());
        setDefenseToBeChecked(CreatureDefenses.AC.toString());
        setDamageDiceDealt(2);
        setDamageModifier(AttributeNames.Charisma.toString());
        setThisWeaponDamage(true);
        setHitDescription("2[W] + Charisma modifier damage. Until the end of your next turn, the target takes a penalty to attack rolls equal to your Wisdom modifier.");
    }
}
