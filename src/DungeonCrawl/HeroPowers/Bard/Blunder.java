package DungeonCrawl.HeroPowers.Bard;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class Blunder extends HeroPower {
    public Blunder() {
        powerName = "Blunder";
        characterClass = HeroClasses.Bard.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 5;
        typeOfDamageDice = 6;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Charisma.toString();
        defenseToBeChecked = CreatureDefenses.Will.toString();
        damageDiceDealt = 1;
        damageModifier = AttributeNames.Charisma.toString();
        isThisWeaponDamage = false;
        powersAdditionalOptions = "Virtue of Cunning";
        hitDescription = "Hit: 1d6 + Charisma modifier damage, and you slide the target 2 squares. During the slide, you or one of your allies can make a melee basic attack against the target as a free action, with a +2 power bonus to the attack roll. Virtue of Cunning: The power bonus to the attack roll equals 1 + your Intelligence modifier.";
    }
}
