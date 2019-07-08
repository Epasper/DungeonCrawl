package DungeonCrawl.HeroPowers.Bard;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class VerseOfTriumph extends HeroPower {
    public VerseOfTriumph() {
        setPowerName("Verse of Triumph");
        setCharacterClass(HeroClasses.Bard.toString());
        setTypeOfPower(TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Charisma.toString());
        setDefenseToBeChecked(CreatureDefenses.AC.toString());
        setDamageDiceDealt(2);
        setDamageModifier(AttributeNames.Charisma.toString());
        setThisWeaponDamage(true);
        setHitDescription("2[W] + Charisma modifier damage.\n" +
                "\n" +
                "Miss: Half damage.\n" +
                "\n" +
                "Effect: Until the end of the encounter, you and any ally within 5 squares of you gain a +1 power bonus to damage rolls and saving throws. In addition, whenever you or an ally reduces an enemy to 0 hit points with any attack, you and any ally within 5 squares of the enemy can shift 1 square as a free action.");
    }
}
