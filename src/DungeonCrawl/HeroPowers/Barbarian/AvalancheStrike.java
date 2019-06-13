package DungeonCrawl.HeroPowers.Barbarian;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;

public class AvalancheStrike extends HeroPower {
    public AvalancheStrike() {
        powerName = "Avalanche Strike";
        characterClass = HeroClasses.Barbarian.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 3;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        bonusDamage = true;
        powersAdditionalOptions = "Rageblood Vigor";
        hitDescription = "Hit: 3[W] + Strength modifier damage. Rageblood Vigor: The attack deals extra damage equal to your Constitution modifier. Effect: Until the start of your next turn, any attacker gains a +4 bonus to attack rolls against you.";
    }
}
