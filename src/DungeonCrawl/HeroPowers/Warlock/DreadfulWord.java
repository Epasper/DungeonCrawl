package DungeonCrawl.HeroPowers.Warlock;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class DreadfulWord extends HeroPower {
    public DreadfulWord() {
        powerName = "Dreadful Word";
        characterClass = HeroClasses.Warlock.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Charisma.toString();
        defenseToBeChecked = CreatureDefenses.Will.toString();
        damageDiceDealt = 2;
        typeOfDamageDice = 8;
        damageModifier = AttributeNames.Charisma.toString();
        isThisWeaponDamage = false;
        powersAdditionalOptions = "Star Pact";
        hitDescription = "2d8 + Charisma modifier psychic damage, and the target takes a −1 penalty to Will defense until the end of your next turn.\n" +
                "Star Pact: The penalty to Will defense is equal to 1 + your Intelligence modifier.";
    }
}
