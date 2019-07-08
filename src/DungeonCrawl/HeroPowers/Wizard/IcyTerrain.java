package DungeonCrawl.HeroPowers.Wizard;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class IcyTerrain extends HeroPower {
    public IcyTerrain() {
        setPowerName("Icy Terrain");
        setCharacterClass(HeroClasses.Wizard.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(10);
        setNumberOfTargets("Burst");
        setBurstValue(1);
        setAttributeUsedToHit(AttributeNames.Intelligence.toString());
        setDefenseToBeChecked(CreatureDefenses.Reflex.toString());
        setDamageDiceDealt(1);
        setTypeOfDamageDice(6);
        setDamageModifier(AttributeNames.Intelligence.toString());
        setThisWeaponDamage(false);
        setHitDescription("1d6 + Intelligence modifier cold damage, and the target falls prone.\"\n" +
                "\n" +
                "Effect: \"The burst creates a zone that lasts until the end of your next turn or until you end it as a minor action. The ground of the zone is difficult terrain.");
    }
}
