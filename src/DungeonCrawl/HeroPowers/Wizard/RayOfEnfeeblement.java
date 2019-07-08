package DungeonCrawl.HeroPowers.Wizard;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class RayOfEnfeeblement extends HeroPower {
    public RayOfEnfeeblement() {
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
        setHitDescription("1d10 + Intelligence modifier necrotic damage, and the target is weakened until the end of your next turn.\n" +
                "\n" +
                "Miss: Half damage.");
    }
}
