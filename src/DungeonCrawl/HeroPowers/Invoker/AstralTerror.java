package DungeonCrawl.HeroPowers.Invoker;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class AstralTerror extends HeroPower {
    public AstralTerror() {
        powerName = "Astral Terror";
        characterClass = HeroClasses.Invoker.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "Burst 1";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        damageModifier = AttributeNames.Wisdom.toString();
        isThisWeaponDamage = false;
        powersAdditionalOptions = "Covenant of Preservation";
        hitDescription = "Hit: 1d6 + Wisdom modifier radiant damage.\n" +
                "\n" +
                "Effect: Each ally in the burst gains a +2 power bonus to AC until the end of your next turn.\n" +
                "\n" +
                "Covenant of Preservation: The bonus to AC equals 1 + your Intelligence modifier.";
    }
}
