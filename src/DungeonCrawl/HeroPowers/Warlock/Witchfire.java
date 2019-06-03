package DungeonCrawl.HeroPowers.Warlock;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class Witchfire extends HeroPower {
    public Witchfire() {
        powerName = "Witchfire";
        characterClass = HeroClassInformation.CharacterClasses.Warlock.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Charisma.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 2;
        typeOfDamageDice = 8;
        damageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = false;
        powersAdditionalOptions = "Fey Pact";
        hitDescription = "2d6 + Charisma modifier fire damage, and the target takes a −2 penalty to attack rolls until the end of your next turn.\n" +
                "Fey Pact: The penalty to attack rolls is equal to 2 + your Intelligence modifier.";
    }
}
