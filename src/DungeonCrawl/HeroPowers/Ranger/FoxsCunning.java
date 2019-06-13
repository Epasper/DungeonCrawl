package DungeonCrawl.HeroPowers.Ranger;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class FoxsCunning extends HeroPower {
    public FoxsCunning() {
        powerName = "Fox's Cunning";
        characterClass = HeroClasses.Ranger.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.REACTION.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Strength.toString();
        defenseToBeChecked = CreatureDefenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = AttributeNames.Strength.toString();
        isThisWeaponDamage = true;
        canThisAttackAlsoBeRanged = true;
        hitDescription = "Trigger: an enemy makes a melee attack against the user\n" +
                "\n" +
                "Effect: The user shifts up to 1 square, then makes a basic attack against the triggering enemy. The attack roll for the basic attack gains a power bonus equal to the user's Wisdom modifier. ";
    }
}
