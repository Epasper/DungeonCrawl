package DungeonCrawl.HeroPowers.Invoker;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class AstralTerror extends HeroPower {
    public AstralTerror() {
        setPowerName("Astral Terror");
        setCharacterClass(HeroClasses.Invoker.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(10);
        setNumberOfTargets("Burst");
        setBurstValue(1);
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.Reflex.toString());
        setDamageDiceDealt(1);
        setTypeOfDamageDice(6);
        setDamageModifier(AttributeNames.Wisdom.toString());
        setThisWeaponDamage(false);
        setPowersAdditionalOptions("Covenant of Preservation");
        setHitDescription("Hit: 1d6 + Wisdom modifier radiant damage.\n" +
                "\n" +
                "Effect: Each ally in the burst gains a +2 power bonus to AC until the end of your next turn.\n" +
                "\n" +
                "Covenant of Preservation: The bonus to AC equals 1 + your Intelligence modifier.");
    }
}
