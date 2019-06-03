package DungeonCrawl.HeroPowers.Avenger;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class BondOfPursuit extends HeroPower {
    public BondOfPursuit() {
        powerName = "Bond of Pursuit";
        characterClass = HeroClassInformation.CharacterClasses.Avenger.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Wisdom modifier damage. If the target doesn't end its next turn adjacent to the user, the user can take a free action to shift a number of squares up to 1 + the user's Dexterity modifier. This shift must end closer to the target than it began.";
    }
}
