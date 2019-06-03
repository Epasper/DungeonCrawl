package DungeonCrawl.HeroPowers.Warlord;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class CommandersStrike extends HeroPower {
    public CommandersStrike() {
        powerName = "Furious Smash";
        characterClass = HeroClassInformation.CharacterClasses.Warlock.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        damageDiceDealt = 0;
        bonusDamageModifier = HeroClassInformation.Attributes.Intelligence.toString();
        isThisWeaponDamage = true;
        hitDescription = "One of your allies can take a free action to make a melee basic attack against the target. The ally gains a bonus to the damage roll equal to your Intelligence modifier.";
    }
}
