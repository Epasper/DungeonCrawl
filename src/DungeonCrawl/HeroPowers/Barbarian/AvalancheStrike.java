package DungeonCrawl.HeroPowers.Barbarian;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class AvalancheStrike extends HeroPower {
    public AvalancheStrike() {
        powerName = "Avalanche Strike";
        characterClass = HeroClasses.Barbarian.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Strength.toString();
        defenseToBeChecked = CreatureDefenses.AC.toString();
        damageDiceDealt = 3;
        damageModifier = AttributeNames.Strength.toString();
        isThisWeaponDamage = true;
        bonusDamage = true;
        powersAdditionalOptions = "Rageblood Vigor";
        hitDescription = "Hit: 3[W] + Strength modifier damage. Rageblood Vigor: The attack deals extra damage equal to your Constitution modifier. Effect: Until the start of your next turn, any attacker gains a +4 bonus to attack rolls against you.";
    }
}
