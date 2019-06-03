package DungeonCrawl.HeroPowers.Invoker;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class ThunderOfJudgement extends HeroPower {
    public ThunderOfJudgement() {
        powerName = "Spear of the Inquisitor";
        characterClass = HeroClassInformation.CharacterClasses.Invoker.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One or Two or Three Targets";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Fortitude.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = false;
        powersAdditionalOptions = "Covenant of Wrath";
        hitDescription = "Hit: \"1d6 + Wisdom modifier thunder damage, or 2d6 + Wisdom modifier thunder damage if you target only one creature. In addition, the target is dazed until the end of your next turn.\"\n" +
                "\n" +
                "Covenant of Wrath: You also push the target a number of squares equal to your Constitution modifier.";
    }
}
