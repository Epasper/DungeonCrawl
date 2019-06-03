package DungeonCrawl.HeroPowers.Warlock;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class DiabolicGrasp extends HeroPower {
    public DiabolicGrasp() {
        powerName = "Diabolic Grasp";
        characterClass = HeroClassInformation.CharacterClasses.Warlock.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Constitution.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Fortitude.toString();
        damageDiceDealt = 2;
        typeOfDamageDice = 8;
        damageModifier = HeroClassInformation.Attributes.Constitution.toString();
        isThisWeaponDamage = false;
        powersAdditionalOptions = "Infernal Pact";
        hitDescription = "2d8 + Constitution modifier damage, and you slide the target 2 squares.\n" +
                "Infernal Pact: The distance of the slide equals 1 + your Intelligence modifier.";
    }
}
