package DungeonCrawl.HeroPowers.Warlord;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class CommandersStrike extends HeroPower {
    public CommandersStrike() {
        powerName = "Furious Smash";
        characterClass = HeroClasses.Warlock.toString();
        typeOfPower = TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        damageDiceDealt = 0;
        bonusDamageModifier = AttributeNames.Intelligence.toString();
        isThisWeaponDamage = true;
        hitDescription = "One of your allies can take a free action to make a melee basic attack against the target. The ally gains a bonus to the damage roll equal to your Intelligence modifier.";
    }
}
