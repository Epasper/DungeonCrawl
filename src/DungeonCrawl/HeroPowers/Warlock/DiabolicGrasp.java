package DungeonCrawl.HeroPowers.Warlock;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class DiabolicGrasp extends HeroPower {
    public DiabolicGrasp() {
        setPowerName("Diabolic Grasp");
        setCharacterClass(HeroClasses.Warlock.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(10);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Constitution.toString());
        setDefenseToBeChecked(CreatureDefenses.Fortitude.toString());
        setDamageDiceDealt(2);
        setTypeOfDamageDice(8);
        setDamageModifier(AttributeNames.Constitution.toString());
        setThisWeaponDamage(false);
        setPowersAdditionalOptions("Infernal Pact");
        setHitDescription("2d8 + Constitution modifier damage, and you slide the target 2 squares.\n" +
                "Infernal Pact: The distance of the slide equals 1 + your Intelligence modifier.");
    }
}
