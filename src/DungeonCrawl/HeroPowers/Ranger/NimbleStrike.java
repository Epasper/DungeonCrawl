package DungeonCrawl.HeroPowers.Ranger;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class NimbleStrike extends HeroPower {
    public NimbleStrike() {
        powerName = "Nimble Strike";
        characterClass = HeroClasses.Ranger.toString();
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
        hitDescription = "Shift 1 square before or after you attack. 1[W] + Dexterity modifier damage.";
    }
}
