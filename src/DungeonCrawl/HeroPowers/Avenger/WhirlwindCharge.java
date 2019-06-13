package DungeonCrawl.HeroPowers.Avenger;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;

public class WhirlwindCharge extends HeroPower {
    public WhirlwindCharge() {
        powerName = "Whirlwind Charge";
        characterClass = HeroClasses.Avenger.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 2;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = true;
        hitDescription = "2[W] + Wisdom modifier damage. Special: When charging, you can use this power in place of a melee basic attack. If you charge, you gain a +4 bonus to AC against opportunity attacks you provoke while moving to the target.";
    }
}
