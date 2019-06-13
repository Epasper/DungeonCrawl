package DungeonCrawl.HeroPowers.Warden;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class WildbloodFrenzy extends HeroPower {
    public WildbloodFrenzy() {
        powerName = "Wildblood Frenzy";
        characterClass = HeroClasses.Warden.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Strength.toString();
        defenseToBeChecked = CreatureDefenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = AttributeNames.Strength.toString();
        bonusDamageModifier = AttributeNames.Constitution.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Strength modifier damage.\n" +
                "\n" +
                "Effect: Make the attack one more time against the same target or a different one.";
    }
}
