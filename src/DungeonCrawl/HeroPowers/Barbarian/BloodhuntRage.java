package DungeonCrawl.HeroPowers.Barbarian;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClassInformation;

public class BloodhuntRage extends HeroPower {
    public BloodhuntRage() {
        powerName = "Bloodhunt Rage";
        characterClass = HeroClassInformation.CharacterClasses.Barbarian.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 3;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        bonusDamage = true;
        hitDescription = "You enter the rage of the bloodhunt. Until the rage ends, you gain a bonus to melee damage rolls equal to your Constitution modifier if either you or your target is bloodied.";
    }
}
