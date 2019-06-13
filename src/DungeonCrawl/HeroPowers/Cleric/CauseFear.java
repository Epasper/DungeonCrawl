package DungeonCrawl.HeroPowers.Cleric;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class CauseFear extends HeroPower {
    public CauseFear() {
        powerName = "Cause Fear";
        characterClass = HeroClasses.Cleric.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.Will.toString();
        damageDiceDealt = 0;
        damageModifier = AttributeNames.Wisdom.toString();
        typeOfDamageDice = 0;
        isThisWeaponDamage = false;
        hitDescription = "The target is compelled to take a free action to move as far away from you as it can, moving a number of squares equal to its speed + your Charisma modifier. It avoids hindering terrain and difficult terrain if it can. This movement is not considered forced movement, so it provokes opportunity attacks.";

    }
}
