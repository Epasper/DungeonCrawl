package DungeonCrawl.HeroPowers.Invoker;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;

public class AvengingLight extends HeroPower {
    public AvengingLight() {
        powerName = "Avenging Light";
        characterClass = HeroClasses.Invoker.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Fortitude.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 10;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = false;
        bonusDamageModifier = HeroClassInformation.Attributes.Constitution.toString();
        hitDescription = "1d10 + Wisdom modifier radiant damage. If a bloodied ally is adjacent to the target, the attack deals extra damage equal to your Constitution modifier.";
    }
}
