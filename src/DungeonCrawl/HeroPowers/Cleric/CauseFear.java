package DungeonCrawl.HeroPowers.Cleric;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class CauseFear extends HeroPower {
    public CauseFear() {
        setPowerName("Cause Fear");
        setCharacterClass(HeroClasses.Cleric.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(10);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.Will.toString());
        setDamageDiceDealt(0);
        setDamageModifier(AttributeNames.Wisdom.toString());
        setTypeOfDamageDice(0);
        setThisWeaponDamage(false);
        setHitDescription("The target is compelled to take a free action to move as far away from you as it can, moving a number of squares equal to its speed + your Charisma modifier. It avoids hindering terrain and difficult terrain if it can. This movement is not considered forced movement, so it provokes opportunity attacks.");

    }
}
