package DungeonCrawl.HeroPowers.Wizard;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class IcyTerrain extends HeroPower {
    public IcyTerrain() {
        powerName = "Icy Terrain";
        characterClass = HeroClasses.Wizard.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "Burst";
        burstValue = 1;
        attributeUsedToHit = AttributeNames.Intelligence.toString();
        defenseToBeChecked = CreatureDefenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        damageModifier = AttributeNames.Intelligence.toString();
        isThisWeaponDamage = false;
        hitDescription = "1d6 + Intelligence modifier cold damage, and the target falls prone.\"\n" +
                "\n" +
                "Effect: \"The burst creates a zone that lasts until the end of your next turn or until you end it as a minor action. The ground of the zone is difficult terrain.";
    }
}
