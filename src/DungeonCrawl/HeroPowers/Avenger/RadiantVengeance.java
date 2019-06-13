package DungeonCrawl.HeroPowers.Avenger;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;

public class RadiantVengeance extends HeroPower {
    public RadiantVengeance() {
        powerName = "Radiant Vengeance";
        characterClass = HeroClasses.Avenger.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = false;
        damageDiceDealt = 8;
        hitDescription = "1d8 + Wisdom modifier radiant damage, and you gain temporary hit points equal to your Wisdom modifier.";
    }
}
