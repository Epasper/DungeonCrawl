package DungeonCrawl.HeroPowers.Warlock;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class DiabolicGrasp extends HeroPower {
    public DiabolicGrasp() {
        powerName = "Diabolic Grasp";
        characterClass = HeroClasses.Warlock.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Constitution.toString();
        defenseToBeChecked = CreatureDefenses.Fortitude.toString();
        damageDiceDealt = 2;
        typeOfDamageDice = 8;
        damageModifier = AttributeNames.Constitution.toString();
        isThisWeaponDamage = false;
        powersAdditionalOptions = "Infernal Pact";
        hitDescription = "2d8 + Constitution modifier damage, and you slide the target 2 squares.\n" +
                "Infernal Pact: The distance of the slide equals 1 + your Intelligence modifier.";
    }
}
