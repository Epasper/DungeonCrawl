package DungeonCrawl.HeroPowers.Ranger;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class HitAndRun extends HeroPower {
    public HitAndRun() {
        setPowerName("Hit and Run");
        setCharacterClass(HeroClasses.Ranger.toString());
        setTypeOfPower(TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Strength.toString());
        setDefenseToBeChecked(CreatureDefenses.AC.toString());
        setDamageDiceDealt(1);
        setDamageModifier(AttributeNames.Strength.toString());
        setThisWeaponDamage(true);
        setHitDescription("1[W] + Strength modifier damage. If you move in the same turn after this attack, leaving the first square adjacent to the target does not provoke an opportunity attack from the target.");
    }
}
