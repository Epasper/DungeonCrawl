package DungeonCrawl.HeroPowers.Rogue;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class TorturousStrike extends HeroPower {
    public TorturousStrike() {
        setPowerName("Torturous Strike");
        setCharacterClass(HeroClasses.Rogue.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Dexterity.toString());
        setDefenseToBeChecked(CreatureDefenses.AC.toString());
        setDamageDiceDealt(2);
        setDamageModifier(AttributeNames.Dexterity.toString());
        setThisWeaponDamage(true);
        setHitDescription("1[W] + Dexterity modifier damage, and you slide the target 1 square.\n" +
                "Artful Dodger: You slide the target a number of squares equal to your Charisma modifier");
    }
}
