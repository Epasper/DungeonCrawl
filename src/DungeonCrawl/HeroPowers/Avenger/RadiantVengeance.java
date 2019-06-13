package DungeonCrawl.HeroPowers.Avenger;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class RadiantVengeance extends HeroPower {
    public RadiantVengeance() {
        powerName = "Radiant Vengeance";
        characterClass = HeroClasses.Avenger.toString();
        typeOfPower = TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.Reflex.toString();
        damageDiceDealt = 1;
        damageModifier = AttributeNames.Wisdom.toString();
        isThisWeaponDamage = false;
        damageDiceDealt = 8;
        hitDescription = "1d8 + Wisdom modifier radiant damage, and you gain temporary hit points equal to your Wisdom modifier.";
    }
}
