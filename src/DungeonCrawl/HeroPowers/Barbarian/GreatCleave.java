package DungeonCrawl.HeroPowers.Barbarian;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class GreatCleave extends HeroPower {
    public GreatCleave() {
        powerName = "Great Cleave";
        characterClass = HeroClassInformation.CharacterClasses.Barbarian.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "Close Burst 1";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 2;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        bonusDamage = true;
        hitDescription = "1[W] + Strength modifier damage + 1 damage for each enemy adjacent to you.";
    }
}
