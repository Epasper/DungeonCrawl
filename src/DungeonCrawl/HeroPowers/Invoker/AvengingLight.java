package DungeonCrawl.HeroPowers.Invoker;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class AvengingLight extends HeroPower {
    public AvengingLight() {
        powerName = "Avenging Light";
        characterClass = HeroClasses.Invoker.toString();
        typeOfPower = TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.Fortitude.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 10;
        damageModifier = AttributeNames.Wisdom.toString();
        isThisWeaponDamage = false;
        bonusDamageModifier = AttributeNames.Constitution.toString();
        hitDescription = "1d10 + Wisdom modifier radiant damage. If a bloodied ally is adjacent to the target, the attack deals extra damage equal to your Constitution modifier.";
    }
}
