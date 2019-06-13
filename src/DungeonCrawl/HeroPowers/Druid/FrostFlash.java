package DungeonCrawl.HeroPowers.Druid;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class FrostFlash extends HeroPower {
    public FrostFlash() {
        powerName = "Frost Flash";
        characterClass = HeroClasses.Druid.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One Target";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.Fortitude.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        bonusDamageModifier = AttributeNames.Wisdom.toString();
        damageModifier = "None";
        isThisWeaponDamage = false;
        hitDescription = "1d6 + Wisdom modifier cold damage. The target is immobilized until the end of the user's next turn. Primal Guardian: Extra damage equal to the user's Constitution modifier.";
    }
}
