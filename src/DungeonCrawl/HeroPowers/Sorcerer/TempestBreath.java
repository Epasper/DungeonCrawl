package DungeonCrawl.HeroPowers.Sorcerer;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class TempestBreath extends HeroPower {
    public TempestBreath() {
        powerName = "Burning Spray";
        characterClass = HeroClasses.Sorcerer.toString();
        typeOfPower = TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "Close Blast 3";
        attributeUsedToHit = AttributeNames.Charisma.toString();
        defenseToBeChecked = CreatureDefenses.Reflex.toString();
        damageDiceDealt = 3;
        typeOfDamageDice = 6;
        damageModifier = AttributeNames.Charisma.toString();
        isThisWeaponDamage = false;
        bonusDamageModifier = AttributeNames.Strength.toString();
        hitDescription = "2d6 + Charisma modifier acid damage, and the target can’t gain combat advantage against any creature until the end of your next turn. \n\nDragon Magic: You gain concealment until the end of your next turn.";
    }
}
