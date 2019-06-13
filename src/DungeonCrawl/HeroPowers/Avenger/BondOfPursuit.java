package DungeonCrawl.HeroPowers.Avenger;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class BondOfPursuit extends HeroPower {
    public BondOfPursuit() {
        powerName = "Bond of Pursuit";
        characterClass = HeroClasses.Avenger.toString();
        typeOfPower = TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = AttributeNames.Wisdom.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Wisdom modifier damage. If the target doesn't end its next turn adjacent to the user, the user can take a free action to shift a number of squares up to 1 + the user's Dexterity modifier. This shift must end closer to the target than it began.";
    }
}
