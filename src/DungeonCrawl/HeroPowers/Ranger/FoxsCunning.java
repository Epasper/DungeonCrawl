package DungeonCrawl.HeroPowers.Ranger;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class FoxsCunning extends HeroPower {
    public FoxsCunning() {
        powerName = "Fox's Cunning";
        characterClass = HeroClassInformation.CharacterClasses.Ranger.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.REACTION.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        canThisAttackAlsoBeRanged = true;
        hitDescription = "Trigger: an enemy makes a melee attack against the user\n" +
                "\n" +
                "Effect: The user shifts up to 1 square, then makes a basic attack against the triggering enemy. The attack roll for the basic attack gains a power bonus equal to the user's Wisdom modifier. ";
    }
}
