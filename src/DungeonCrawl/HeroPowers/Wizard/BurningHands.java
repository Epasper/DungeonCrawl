package DungeonCrawl.HeroPowers.Wizard;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class BurningHands extends HeroPower {
    public BurningHands() {
        powerName = "Burning Hands";
        characterClass = HeroClassInformation.CharacterClasses.Wizard.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "Close Blast 5";
        attributeUsedToHit = HeroClassInformation.Attributes.Intelligence.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 2;
        typeOfDamageDice = 6;
        damageModifier = HeroClassInformation.Attributes.Intelligence.toString();
        isThisWeaponDamage = false;
        hitDescription = "2d6 + Intelligence modifier fire damage.\n\nMiss: Half damage.";
    }
}
