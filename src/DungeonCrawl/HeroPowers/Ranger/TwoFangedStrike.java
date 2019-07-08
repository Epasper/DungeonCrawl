package DungeonCrawl.HeroPowers.Ranger;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class TwoFangedStrike extends HeroPower {
    public TwoFangedStrike() {
        setPowerName("Two-Fanged Strike");
        setCharacterClass(HeroClasses.Ranger.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(20);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Strength.toString());
        setDefenseToBeChecked(CreatureDefenses.AC.toString());
        setDamageDiceDealt(1);
        setDamageModifier(AttributeNames.Strength.toString());
        setThisWeaponDamage(true);
        setBonusDamageModifier(AttributeNames.Wisdom.toString());
        setHitDescription("Hit: 1[W]+ Strength modifier damage (melee) or 1[W]+Dexterity modifier damage per attack.\n" +
                "If both attacks hit, you deal extra damage equal to your wisdom modifier.");
    }
}
