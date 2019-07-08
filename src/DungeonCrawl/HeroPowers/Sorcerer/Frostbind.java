package DungeonCrawl.HeroPowers.Sorcerer;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class Frostbind extends HeroPower {
    public Frostbind() {
        setPowerName("Frostbind");
        setCharacterClass(HeroClasses.Sorcerer.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(10);
        setNumberOfTargets("one target");
        setAttributeUsedToHit(AttributeNames.Charisma.toString());
        setDefenseToBeChecked(CreatureDefenses.Fortitude.toString());
        setDamageDiceDealt(3);
        setTypeOfDamageDice(6);
        setDamageModifier(AttributeNames.Charisma.toString());
        setThisWeaponDamage(false);
        setHitDescription("3d6 + Charisma modifier cold damage, and the target takes a –2 penalty to Reflex until the end of your next turn.");
    }
}
