package DungeonCrawl.HeroPowers.Warlock;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class VampiricEmbrace extends HeroPower {
    public VampiricEmbrace() {
        setPowerName("Vampiric Embrace");
        setCharacterClass(HeroClasses.Warlock.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(5);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Constitution.toString());
        setDefenseToBeChecked(CreatureDefenses.Will.toString());
        setDamageDiceDealt(2);
        setTypeOfDamageDice(8);
        setDamageModifier(AttributeNames.Constitution.toString());
        setThisWeaponDamage(false);
        setPowersAdditionalOptions("Infernal Pact");
        setHitDescription("2d8 + Constitution modifier necrotic damage, and you gain 5 temporary hit points.\"\n" +
                "Infernal Pact: Add your Intelligence modifier to the temporary hit points.");
    }
}
