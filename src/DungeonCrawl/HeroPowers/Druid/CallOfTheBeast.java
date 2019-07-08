package DungeonCrawl.HeroPowers.Druid;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class CallOfTheBeast extends HeroPower {
    public CallOfTheBeast() {
        setPowerName("Call of the Beast");
        setCharacterClass(HeroClasses.Druid.toString());
        setTypeOfPower(TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(10);
        setNumberOfTargets("Burst");
        setBurstValue(1);
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.Fortitude.toString());
        setDamageDiceDealt(0);
        setTypeOfDamageDice(0);
        setDamageModifier("None");
        setThisWeaponDamage(false);
        setHitDescription("The target can't gain combat advantage until the end of your next turn. In addition, on its next turn the target takes psychic damage equal to 5 + your Wisdom modifier when it makes any attack that doesn't include your ally nearest to it as a target.");
    }
}
