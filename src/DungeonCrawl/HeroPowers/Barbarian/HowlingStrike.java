package DungeonCrawl.HeroPowers.Barbarian;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class HowlingStrike extends HeroPower {
    public HowlingStrike() {
        powerName = "Howling Strike";
        characterClass = HeroClasses.Barbarian.toString();
        typeOfPower = TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Strength.toString();
        defenseToBeChecked = CreatureDefenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = AttributeNames.Strength.toString();
        isThisWeaponDamage = true;
        bonusDamage = true;
        typeOfBonusDamageDice = 8;
        hitDescription = "1 [W] + 1d6 + Strength modifier damage. When charging, you can use this power in place of a melee basic attack. If you are raging, you can move 2 extra squares as part of the charge.";
    }
}
