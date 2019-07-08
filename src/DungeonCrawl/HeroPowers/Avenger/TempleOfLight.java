package DungeonCrawl.HeroPowers.Avenger;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class TempleOfLight extends HeroPower {
    public TempleOfLight() {
        setPowerName("Aspect of Might");
        setCharacterClass(HeroClasses.Avenger.toString());
        setTypeOfPower(TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.AC.toString());
        setDamageDiceDealt(2);
        setDamageModifier(AttributeNames.Wisdom.toString());
        setThisWeaponDamage(true);
        setHitDescription("The attack creates a zone of radiant energy in a burst 2 centered on the target. The zone lasts until the end of the encounter. When the target moves, the zone moves with it, remaining centered on it. Whenever you hit a creature that is within the zone, that attack deals 1d6 extra radiant damage.");
    }
}
