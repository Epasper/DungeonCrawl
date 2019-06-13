package DungeonCrawl.HeroPowers.Avenger;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class AvengingEcho extends HeroPower {
    public AvengingEcho() {
        powerName = "Avenging Echo";
        characterClass = HeroClasses.Avenger.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = AttributeNames.Wisdom.toString();
        isThisWeaponDamage = true;
        secondAttributeUsed = AttributeNames.Intelligence.toString();
        powersAdditionalOptions = "Censure of Retribution";
        hitDescription = "1[W] + Wisdom modifier damage. Until the end of your next turn, any enemy that ends its turn adjacent to you or hits or misses you takes 5 radiant damage. Censure of Retribution: The radiant damage equals 5 + your Intelligence modifier.";
    }
}
