package DungeonCrawl.HeroPowers.Bard;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class EchoesOfTheGuardian extends HeroPower {
    public EchoesOfTheGuardian() {
        setPowerName("Echoes of the Guardian");
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
        setHitDescription("2[W] + Charisma modifier damage, and until the end of your next turn, the target is marked by an ally within 5 squares of you.\n" +
                "\n" +
                "Miss: Half damage.\n" +
                "\n" +
                "Effect: Until the end of the encounter, once during each of your turns, choose an ally within 5 squares of you when you hit an enemy. Until the end of your next turn, that enemy is marked by that ally.");
    }
}
