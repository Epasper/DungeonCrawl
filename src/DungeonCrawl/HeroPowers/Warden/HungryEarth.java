package DungeonCrawl.HeroPowers.Warden;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class HungryEarth extends HeroPower {
    public HungryEarth() {
        setPowerName("Hungry Earth");
        setCharacterClass(HeroClasses.Warden.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("Close Burst 1");
        setAttributeUsedToHit(AttributeNames.Strength.toString());
        setDefenseToBeChecked(CreatureDefenses.Fortitude.toString());
        setDamageDiceDealt(1);
        setDamageModifier(AttributeNames.Strength.toString());
        setBonusDamageModifier(AttributeNames.Constitution.toString());
        setThisWeaponDamage(true);
        setHitDescription("1[W] + Strength modifier damage.\n" +
                "\n" +
                "Effect: Until the end of your next turn, each square in the burst is difficult terrain for your enemies.");
    }
}
