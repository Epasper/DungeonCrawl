package DungeonCrawl.HeroPowers.Cleric;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class LanceOfFaith extends HeroPower {
    public LanceOfFaith() {
        powerName = "Lance of Faith";
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
        typeOfDamageDice = 8;
        isThisWeaponDamage = false;
        hitDescription = "1d8 + Wisdom modifier radiant damage, and one ally you can see gains a +2 power bonus to his or her next attack roll against the target.";

    }
}
