package DungeonCrawl.HeroPowers.Warlock;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class Witchfire extends HeroPower {
    public Witchfire() {
        setPowerName("Witchfire");
        setCharacterClass(HeroClasses.Warlock.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(10);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Charisma.toString());
        setDefenseToBeChecked(CreatureDefenses.Reflex.toString());
        setDamageDiceDealt(2);
        setTypeOfDamageDice(8);
        setDamageModifier(AttributeNames.Charisma.toString());
        setThisWeaponDamage(false);
        setPowersAdditionalOptions("Fey Pact");
        setHitDescription("2d6 + Charisma modifier fire damage, and the target takes a −2 penalty to attack rolls until the end of your next turn.\n" +
                "Fey Pact: The penalty to attack rolls is equal to 2 + your Intelligence modifier.");
    }
}
