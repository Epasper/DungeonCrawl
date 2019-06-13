package DungeonCrawl.HeroPowers.Avenger;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class AngelicAlacrity extends HeroPower {
    public AngelicAlacrity() {
        powerName = "Angelic Alacrity";
        characterClass = HeroClasses.Avenger.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.AC.toString();
        damageDiceDealt = 2;
        damageModifier = AttributeNames.Wisdom.toString();
        isThisWeaponDamage = true;
        secondAttributeUsed = AttributeNames.Dexterity.toString();
        powersAdditionalOptions = "Censure of Pursuit";
        hitDescription = "Effect: Before the attack, you shift 2 squares. Censure of Pursuit: The number of squares you shift equals 1 + your Dexterity modifier.";
    }
}
