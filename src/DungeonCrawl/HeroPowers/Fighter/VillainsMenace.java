package DungeonCrawl.HeroPowers.Fighter;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class VillainsMenace extends HeroPower {
    public VillainsMenace() {
        setPowerName("Villain's Menace");
        setCharacterClass(HeroClasses.Fighter.toString());
        setTypeOfPower(TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Strength.toString());
        setDefenseToBeChecked(CreatureDefenses.AC.toString());
        setDamageDiceDealt(2);
        setDamageModifier(AttributeNames.Strength.toString());
        setThisWeaponDamage(true);
        setHitDescription("Hit: 2[W] + Strength modifier damage, and you gain a +2 power bonus to attack rolls and a +4 power bonus to damage rolls against the target until the end of the encounter.[PH:78]\n" +
                "\n" +
                "Miss: Gain a +1 power bonus to attack rolls and a +2 power bonus to damage rolls against the target until the end of the encounter.");
    }
}
