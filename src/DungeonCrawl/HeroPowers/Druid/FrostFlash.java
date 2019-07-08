package DungeonCrawl.HeroPowers.Druid;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class FrostFlash extends HeroPower {
    public FrostFlash() {
        setPowerName("Frost Flash");
        setCharacterClass(HeroClasses.Druid.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(10);
        setNumberOfTargets("One Target");
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.Fortitude.toString());
        setDamageDiceDealt(1);
        setTypeOfDamageDice(6);
        setBonusDamageModifier(AttributeNames.Wisdom.toString());
        setDamageModifier("None");
        setThisWeaponDamage(false);
        setHitDescription("1d6 + Wisdom modifier cold damage. The target is immobilized until the end of the user's next turn. Primal Guardian: Extra damage equal to the user's Constitution modifier.");
    }
}
