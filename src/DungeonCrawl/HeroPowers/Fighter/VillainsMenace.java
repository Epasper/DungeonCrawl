package DungeonCrawl.HeroPowers.Fighter;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class VillainsMenace extends HeroPower {
    public VillainsMenace() {
        powerName = "Villain's Menace";
        characterClass = HeroClasses.Fighter.toString();
        typeOfPower = TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Strength.toString();
        defenseToBeChecked = CreatureDefenses.AC.toString();
        damageDiceDealt = 2;
        damageModifier = AttributeNames.Strength.toString();
        isThisWeaponDamage = true;
        hitDescription = "Hit: 2[W] + Strength modifier damage, and you gain a +2 power bonus to attack rolls and a +4 power bonus to damage rolls against the target until the end of the encounter.[PH:78]\n" +
                "\n" +
                "Miss: Gain a +1 power bonus to attack rolls and a +2 power bonus to damage rolls against the target until the end of the encounter.";
    }
}
