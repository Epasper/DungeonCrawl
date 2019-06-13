package DungeonCrawl.HeroPowers.Avenger;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class WhirlwindCharge extends HeroPower {
    public WhirlwindCharge() {
        powerName = "Whirlwind Charge";
        characterClass = HeroClasses.Avenger.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.AC.toString();
        damageDiceDealt = 2;
        damageModifier = AttributeNames.Wisdom.toString();
        isThisWeaponDamage = true;
        hitDescription = "2[W] + Wisdom modifier damage. Special: When charging, you can use this power in place of a melee basic attack. If you charge, you gain a +4 bonus to AC against opportunity attacks you provoke while moving to the target.";
    }
}
