package DungeonCrawl.HeroPowers.Paladin;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class ShieldingSmite extends HeroPower {
    public ShieldingSmite() {
        powerName = "Shielding Smite";
        characterClass = HeroClasses.Paladin.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Charisma.toString();
        defenseToBeChecked = CreatureDefenses.Reflex.toString();
        damageDiceDealt = 2;
        damageModifier = AttributeNames.Charisma.toString();
        isThisWeaponDamage = true;
        hitDescription = "Until the end of your next turn, one ally within 5 squares of you gains a power bonus to AC equal to your Wisdom modifier.";
    }
}
