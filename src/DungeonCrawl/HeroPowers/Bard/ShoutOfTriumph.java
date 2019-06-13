package DungeonCrawl.HeroPowers.Bard;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class ShoutOfTriumph extends HeroPower {
    public ShoutOfTriumph() {
        powerName = "Shout of Triumph";
        characterClass = HeroClasses.Bard.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        typeOfDamageDice = 6;
        numberOfTargets = "Close Blast 3";
        attributeUsedToHit = AttributeNames.Charisma.toString();
        defenseToBeChecked = CreatureDefenses.Will.toString();
        damageDiceDealt = 1;
        damageModifier = AttributeNames.Charisma.toString();
        isThisWeaponDamage = false;
        powersAdditionalOptions = "Virtue of Valor";
        hitDescription = "Hit: 1d6 + Charisma modifier thunder damage, and you push the target 1 square. Effect: You slide each ally in the blast 1 square. Virtue of Valor: The number of squares you push the target and slide the allies equals your Constitution modifier.";
    }
}
