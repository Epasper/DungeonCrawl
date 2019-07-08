package DungeonCrawl.HeroPowers.Warden;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class ThunderRamAssault extends HeroPower {
    public ThunderRamAssault() {
        setPowerName("Thunder Ram Assault");
        setCharacterClass(HeroClasses.Warden.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Strength.toString());
        setDefenseToBeChecked(CreatureDefenses.AC.toString());
        setDamageDiceDealt(1);
        setDamageModifier(AttributeNames.Strength.toString());
        setBonusDamageModifier(AttributeNames.Constitution.toString());
        setThisWeaponDamage(true);
        setHitDescription("1[W] + Strength modifier thunder damage. Make a secondary attack that is a close blast 3.");
    }
}
