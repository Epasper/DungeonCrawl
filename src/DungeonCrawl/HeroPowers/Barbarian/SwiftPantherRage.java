package DungeonCrawl.HeroPowers.Barbarian;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class SwiftPantherRage extends HeroPower {
    public SwiftPantherRage() {
        setPowerName("Swift Panther Rage");
        setCharacterClass(HeroClasses.Barbarian.toString());
        setTypeOfPower(TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Strength.toString());
        setDefenseToBeChecked(CreatureDefenses.AC.toString());
        setDamageDiceDealt(3);
        setDamageModifier(AttributeNames.Strength.toString());
        setThisWeaponDamage(true);
        setBonusDamage(true);
        setHitDescription("You enter the rage of the swift panther. Until the rage ends, you gain a +2 bonus to speed and can shift 2 squares as a move action.");
    }
}
