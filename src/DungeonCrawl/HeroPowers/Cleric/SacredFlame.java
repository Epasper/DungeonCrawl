package DungeonCrawl.HeroPowers.Cleric;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class SacredFlame extends HeroPower {
    public SacredFlame() {
        powerName = "Sacred Flame";
        characterClass = HeroClasses.Cleric.toString();
        typeOfPower = TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 5;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.Reflex.toString();
        damageDiceDealt = 1;
        damageModifier = AttributeNames.Wisdom.toString();
        typeOfDamageDice = 6;
        isThisWeaponDamage = false;
        hitDescription = "1d6 + Wisdom modifier radiant damage, and one ally you can see chooses either to make a saving throw or to gain temporary hit points equal to your Charisma modifier + one-half your level.";

    }
}
