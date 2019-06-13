package DungeonCrawl.HeroPowers.Warlock;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;

public class DireRadiance extends HeroPower {
    public DireRadiance() {
        powerName = "Dire Radiance";
        characterClass = HeroClasses.Warlock.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Charisma.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        damageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = false;
        hitDescription = "1d6 + Charisma or Constitution modifier radiant damage. The first time the target moves closer to you on its next turn, it takes an extra 1d6 + Charisma or Constitution modifier damage.";
    }
}
