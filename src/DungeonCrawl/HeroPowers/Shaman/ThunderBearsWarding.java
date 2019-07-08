package DungeonCrawl.HeroPowers.Shaman;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class ThunderBearsWarding extends HeroPower {
    public ThunderBearsWarding() {
        setPowerName("Thunder Bear' s Warding");
        setCharacterClass(HeroClasses.Shaman.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(5);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.Fortitude.toString());
        setDamageDiceDealt(1);
        setTypeOfDamageDice(6);
        setDamageModifier(AttributeNames.Wisdom.toString());
        setThisWeaponDamage(false);
        setPowersAdditionalOptions("Protector Spirit");
        setHitDescription("1d6 + Wisdom modifier thunder damage. Until the end of your next turn, you and your allies gain resistance to all damage equal to your Constitution modifier while adjacent to your spirit companion.\n" +
                "Protector Spirit: You or an ally within 5 squares of you gains temporary hit points equal to your Constitution modifier.");
    }
}
