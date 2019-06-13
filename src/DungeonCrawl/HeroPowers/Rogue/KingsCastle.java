package DungeonCrawl.HeroPowers.Rogue;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class KingsCastle extends HeroPower {
    public KingsCastle() {
        powerName = "King's Castle";
        characterClass = HeroClasses.Rogue.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Dexterity.toString();
        defenseToBeChecked = CreatureDefenses.Reflex.toString();
        damageDiceDealt = 1;
        damageModifier = AttributeNames.Dexterity.toString();
        isThisWeaponDamage = true;
        canThisAttackAlsoBeRanged = true;
        hitDescription = "Hit: \"2[W] + Dexterity modifier damage.\"\n" +
                "\n" +
                "Effect: \"Switch places with a willing adjacent ally.";
    }
}
