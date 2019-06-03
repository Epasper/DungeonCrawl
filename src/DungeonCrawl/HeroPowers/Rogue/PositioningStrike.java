package DungeonCrawl.HeroPowers.Rogue;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class PositioningStrike extends HeroPower {
    public PositioningStrike() {
        powerName = "Positioning Strike";
        characterClass = HeroClassInformation.CharacterClasses.Rogue.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Dexterity.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Will.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Dexterity.toString();
        isThisWeaponDamage = true;
        canThisAttackAlsoBeRanged = true;
        hitDescription = "1[W] + Dexterity modifier damage, and you slide the target 1 square.\n" +
                "Artful Dodger: You slide the target a number of squares equal to your Charisma modifier";
    }
}
