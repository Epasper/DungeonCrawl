package DungeonCrawl.HeroPowers.Warlord;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class WarlordsFavor extends HeroPower {
    public WarlordsFavor() {
        powerName = "Warlord's Favor";
        characterClass = HeroClasses.Warlord.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Strength.toString();
        defenseToBeChecked = CreatureDefenses.Reflex.toString();
        damageDiceDealt = 1;
        damageModifier = AttributeNames.Strength.toString();
        isThisWeaponDamage = true;
        powersAdditionalOptions = "Tactical Presence";
        hitDescription = "2[W] + Strength modifier damage. One ally within 5 squares of you gains a +2 power bonus to attack rolls against the target until the end of your next turn.\n" +
                "Tactical Presence: The bonus equals 1 + your Intelligence modifier.";
    }
}
