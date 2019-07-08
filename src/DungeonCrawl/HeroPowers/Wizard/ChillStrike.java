package DungeonCrawl.HeroPowers.Wizard;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class ChillStrike extends HeroPower {
    public ChillStrike() {
        setPowerName("Chill Strike");
        setCharacterClass(HeroClasses.Wizard.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(10);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Intelligence.toString());
        setDefenseToBeChecked(CreatureDefenses.Fortitude.toString());
        setDamageDiceDealt(2);
        setTypeOfDamageDice(8);
        setDamageModifier(AttributeNames.Intelligence.toString());
        setThisWeaponDamage(false);
        setHitDescription("2d8 + Intelligence modifier cold damage, and the target is dazed until the end of your next turn.\"[PH:159]\n" +
                "\n" +
                "Miss: \"The target is slowed until the end of your next turn.");
    }
}
