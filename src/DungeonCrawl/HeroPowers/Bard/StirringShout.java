package DungeonCrawl.HeroPowers.Bard;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class StirringShout extends HeroPower {
    public StirringShout() {
        powerName = "Stirring Shout";
        characterClass = HeroClasses.Bard.toString();
        typeOfPower = TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Charisma.toString();
        defenseToBeChecked = CreatureDefenses.Will.toString();
        damageDiceDealt = 2;
        typeOfDamageDice = 6;
        damageModifier = AttributeNames.Charisma.toString();
        isThisWeaponDamage = false;
        hitDescription = "2d6 + Charisma modifier psychic damage.\n" +
                "\n" +
                "Effect: Until the end of the encounter, whenever an ally hits the target, that ally regains hit points equal to your Charisma modifier.";
    }
}
