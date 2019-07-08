package DungeonCrawl.HeroPowers.Warlord;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class WarlordsFavor extends HeroPower {
    public WarlordsFavor() {
        setPowerName("Warlord's Favor");
        setCharacterClass(HeroClasses.Warlord.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Strength.toString());
        setDefenseToBeChecked(CreatureDefenses.Reflex.toString());
        setDamageDiceDealt(1);
        setDamageModifier(AttributeNames.Strength.toString());
        setThisWeaponDamage(true);
        setPowersAdditionalOptions("Tactical Presence");
        setHitDescription("2[W] + Strength modifier damage. One ally within 5 squares of you gains a +2 power bonus to attack rolls against the target until the end of your next turn.\n" +
                "Tactical Presence: The bonus equals 1 + your Intelligence modifier.");
    }
}
