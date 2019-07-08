package DungeonCrawl.HeroPowers.Bard;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class MisdirectedMark extends HeroPower {
    public MisdirectedMark() {
        setPowerName("Misdirected Mark");
        setCharacterClass(HeroClasses.Bard.toString());
        setTypeOfPower(TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(10);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Charisma.toString());
        setDefenseToBeChecked(CreatureDefenses.Reflex.toString());
        setDamageDiceDealt(1);
        setTypeOfDamageDice(8);
        setDamageModifier(AttributeNames.Charisma.toString());
        setThisWeaponDamage(false);
        setHitDescription("1d8 + Charisma modifier damage, and the target is marked by an ally within 5 squares of you until the end of your next turn.");
    }
}
