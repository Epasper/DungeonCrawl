package DungeonCrawl.HeroPowers.Warlock;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class DreadfulWord extends HeroPower {
    public DreadfulWord() {
        powerName = "Dreadful Word";
        characterClass = HeroClassInformation.CharacterClasses.Warlock.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Charisma.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Will.toString();
        damageDiceDealt = 2;
        typeOfDamageDice = 8;
        damageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = false;
        powersAdditionalOptions = "Star Pact";
        hitDescription = "2d8 + Charisma modifier psychic damage, and the target takes a −1 penalty to Will defense until the end of your next turn.\n" +
                "Star Pact: The penalty to Will defense is equal to 1 + your Intelligence modifier.";
    }
}
