package DungeonCrawl.HeroPowers.Rogue;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class RiposteStrike extends HeroPower {
    public RiposteStrike() {
        powerName = "Riposte Strike";
        characterClass = HeroClasses.Rogue.toString();
        typeOfPower = TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Dexterity.toString();
        defenseToBeChecked = CreatureDefenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = AttributeNames.Dexterity.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Dexterity modifier damage. If the target attacks you before the start of your next turn, you make your riposte against the target as an immediate interrupt: a Strength vs. AC attack that deals 1[W] + Strength modifier damage.";
    }
}
