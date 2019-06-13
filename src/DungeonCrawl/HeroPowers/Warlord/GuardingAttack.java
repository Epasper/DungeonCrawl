package DungeonCrawl.HeroPowers.Warlord;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class GuardingAttack extends HeroPower {
    public GuardingAttack() {
        powerName = "Guarding Attack";
        characterClass = HeroClasses.Warlord.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Strength.toString();
        defenseToBeChecked = CreatureDefenses.AC.toString();
        damageDiceDealt = 2;
        damageModifier = AttributeNames.Strength.toString();
        isThisWeaponDamage = true;
        hitDescription = "2[W] + Strength modifier damage. One ally adjacent to you or to the target gains a +2 power bonus to AC against the target's attacks. The bonus lasts until the end of your next turn.\n" +
                "Inspiring Presence: The bonus equals 1 + your Charisma modifier.";
    }
}
