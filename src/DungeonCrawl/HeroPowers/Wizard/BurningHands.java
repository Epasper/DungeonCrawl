package DungeonCrawl.HeroPowers.Wizard;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class BurningHands extends HeroPower {
    public BurningHands() {
        powerName = "Burning Hands";
        characterClass = HeroClasses.Wizard.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "Close Blast 5";
        attributeUsedToHit = AttributeNames.Intelligence.toString();
        defenseToBeChecked = CreatureDefenses.Reflex.toString();
        damageDiceDealt = 2;
        typeOfDamageDice = 6;
        damageModifier = AttributeNames.Intelligence.toString();
        isThisWeaponDamage = false;
        hitDescription = "2d6 + Intelligence modifier fire damage.\n\nMiss: Half damage.";
    }
}
