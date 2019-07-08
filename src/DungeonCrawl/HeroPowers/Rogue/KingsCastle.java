package DungeonCrawl.HeroPowers.Rogue;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class KingsCastle extends HeroPower {
    public KingsCastle() {
        setPowerName("King's Castle");
        setCharacterClass(HeroClasses.Rogue.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Dexterity.toString());
        setDefenseToBeChecked(CreatureDefenses.Reflex.toString());
        setDamageDiceDealt(1);
        setDamageModifier(AttributeNames.Dexterity.toString());
        setThisWeaponDamage(true);
        setCanThisAttackAlsoBeRanged(true);
        setHitDescription("Hit: \"2[W] + Dexterity modifier damage.\"\n" +
                "\n" +
                "Effect: \"Switch places with a willing adjacent ally.");
    }
}
