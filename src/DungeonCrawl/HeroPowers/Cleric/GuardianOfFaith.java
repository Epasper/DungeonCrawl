package DungeonCrawl.HeroPowers.Cleric;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class GuardianOfFaith extends HeroPower {
    public GuardianOfFaith() {
        setPowerName("Guardian of Faith");
        setCharacterClass(HeroClasses.Cleric.toString());
        setTypeOfPower(TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(5);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.Will.toString());
        setDamageDiceDealt(3);
        setDamageModifier(AttributeNames.Wisdom.toString());
        setTypeOfDamageDice(8);
        setThisWeaponDamage(false);
        setHitDescription("You conjure a guardian that occupies 1 squre within range. The guardian occupies its square, although creatures can move through it. The guardian lasts until the end of the encounter. \n" +
                "Any enemy that ends its turn adjacent to the guardian is subject to a Wisdom vs. Fortitude attack. On a hit, the attack deals 1d8 + Wisdom modifier radiant damage.\n" +
                "\n" +
                "Move Action: The guardian moves 3 squares.");
    }
}
