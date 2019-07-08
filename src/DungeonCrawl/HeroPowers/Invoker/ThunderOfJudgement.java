package DungeonCrawl.HeroPowers.Invoker;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class ThunderOfJudgement extends HeroPower {
    public ThunderOfJudgement() {
        setPowerName("Spear of the Inquisitor");
        setCharacterClass(HeroClasses.Invoker.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(10);
        setNumberOfTargets("One or Two or Three Targets");
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.Fortitude.toString());
        setDamageDiceDealt(1);
        setTypeOfDamageDice(6);
        setDamageModifier(AttributeNames.Wisdom.toString());
        setThisWeaponDamage(false);
        setPowersAdditionalOptions("Covenant of Wrath");
        setHitDescription("Hit: \"1d6 + Wisdom modifier thunder damage, or 2d6 + Wisdom modifier thunder damage if you target only one creature. In addition, the target is dazed until the end of your next turn.\"\n" +
                "\n" +
                "Covenant of Wrath: You also push the target a number of squares equal to your Constitution modifier.");
    }
}
