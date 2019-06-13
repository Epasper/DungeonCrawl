package DungeonCrawl.HeroPowers.Invoker;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class ThunderOfJudgement extends HeroPower {
    public ThunderOfJudgement() {
        powerName = "Spear of the Inquisitor";
        characterClass = HeroClasses.Invoker.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One or Two or Three Targets";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.Fortitude.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        damageModifier = AttributeNames.Wisdom.toString();
        isThisWeaponDamage = false;
        powersAdditionalOptions = "Covenant of Wrath";
        hitDescription = "Hit: \"1d6 + Wisdom modifier thunder damage, or 2d6 + Wisdom modifier thunder damage if you target only one creature. In addition, the target is dazed until the end of your next turn.\"\n" +
                "\n" +
                "Covenant of Wrath: You also push the target a number of squares equal to your Constitution modifier.";
    }
}
