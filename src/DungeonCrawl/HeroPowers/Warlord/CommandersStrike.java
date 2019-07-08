package DungeonCrawl.HeroPowers.Warlord;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.TypesOfActions;

public class CommandersStrike extends HeroPower {
    public CommandersStrike() {
        setPowerName("Furious Smash");
        setCharacterClass(HeroClasses.Warlock.toString());
        setTypeOfPower(TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One target");
        setDamageDiceDealt(0);
        setBonusDamageModifier(AttributeNames.Intelligence.toString());
        setThisWeaponDamage(true);
        setHitDescription("One of your allies can take a free action to make a melee basic attack against the target. The ally gains a bonus to the damage roll equal to your Intelligence modifier.");
    }
}
