package DungeonCrawl.HeroPowers.Barbarian;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class AvalancheStrike extends HeroPower {
    public AvalancheStrike() {
        setPowerName("Avalanche Strike");
        setCharacterClass(HeroClasses.Barbarian.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Strength.toString());
        setDefenseToBeChecked(CreatureDefenses.AC.toString());
        setDamageDiceDealt(3);
        setDamageModifier(AttributeNames.Strength.toString());
        setThisWeaponDamage(true);
        setBonusDamage(true);
        setPowersAdditionalOptions("Rageblood Vigor");
        setHitDescription("Hit: 3[W] + Strength modifier damage. Rageblood Vigor: The attack deals extra damage equal to your Constitution modifier. Effect: Until the start of your next turn, any attacker gains a +4 bonus to attack rolls against you.");
    }
}
