package DungeonCrawl.HeroPowers.Bard;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class FastFriends extends HeroPower {
    public FastFriends() {
        setPowerName("Fast Friends");
        setCharacterClass(HeroClasses.Bard.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(5);
        setTypeOfDamageDice(0);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Charisma.toString());
        setDefenseToBeChecked(CreatureDefenses.Will.toString());
        setDamageDiceDealt(0);
        setDamageModifier(AttributeNames.Charisma.toString());
        setThisWeaponDamage(false);
        setHitDescription("Hit: Choose yourself or an ally. The target cannot attack that character until the end of your next turn or until you or one of your allies attacks the target.");
    }
}
