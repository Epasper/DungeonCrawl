package DungeonCrawl.HeroPowers.Sorcerer;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class BurningSpray extends HeroPower {
    public BurningSpray() {
        powerName = "Burning Spray";
        characterClass = HeroClasses.Sorcerer.toString();
        typeOfPower = TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "Blast 3";
        attributeUsedToHit = AttributeNames.Charisma.toString();
        defenseToBeChecked = CreatureDefenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 8;
        damageModifier = AttributeNames.Charisma.toString();
        isThisWeaponDamage = false;
        bonusDamageModifier = AttributeNames.Strength.toString();
        hitDescription = "1d8 + Charisma modifier fire damage. Dragon Magic: The next enemy that hits you with a melee attack before the end of your next turn takes fire damage equal to your Strength modifier.";
    }
}
