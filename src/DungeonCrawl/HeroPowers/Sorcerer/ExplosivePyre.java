package DungeonCrawl.HeroPowers.Sorcerer;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class ExplosivePyre extends HeroPower {
    public ExplosivePyre() {
        setPowerName("Explosive Pyre");
        setCharacterClass(HeroClasses.Sorcerer.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(10);
        setNumberOfTargets("one target");
        setAttributeUsedToHit(AttributeNames.Charisma.toString());
        setDefenseToBeChecked(CreatureDefenses.Will.toString());
        setDamageDiceDealt(1);
        setTypeOfDamageDice(10);
        setDamageModifier(AttributeNames.Charisma.toString());
        setThisWeaponDamage(false);
        setHitDescription("2d8 + Charisma modifier damage. Until the start of your next turn, any enemy that enters a square adjacent to the target or starts its turn there takes 1d6 fire damage. An enemy can take this damage only once per turn.");
    }
}
