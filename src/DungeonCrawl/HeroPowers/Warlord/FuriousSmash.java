package DungeonCrawl.HeroPowers.Warlord;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;

public class FuriousSmash extends HeroPower {
    public FuriousSmash() {
        powerName = "Furious Smash";
        characterClass = HeroClasses.Warlord.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Fortitude.toString();
        damageDiceDealt = 0;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        bonusDamageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = true;
        hitDescription = "Strength modifier damage. Choose an ally adjacent to you or to the target. The ally gains a power bonus to the next attack roll and damage roll that he or she makes against the target before the end of his or her next turn. The power bonus equals your Charisma modifier.";
    }
}
