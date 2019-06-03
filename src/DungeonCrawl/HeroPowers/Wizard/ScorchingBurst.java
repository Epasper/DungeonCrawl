package DungeonCrawl.HeroPowers.Wizard;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class ScorchingBurst extends HeroPower {
    public ScorchingBurst() {
        powerName = "Scorching Burst";
        characterClass = HeroClassInformation.CharacterClasses.Wizard.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "Burst 1";
        attributeUsedToHit = HeroClassInformation.Attributes.Intelligence.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        damageModifier = HeroClassInformation.Attributes.Intelligence.toString();
        isThisWeaponDamage = false;
        hitDescription = "1d6 + Intelligence modifier fire damage.";
    }
}
