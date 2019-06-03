package DungeonCrawl.HeroPowers.Cleric;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClassInformation;

public class GuardianOfFaith extends HeroPower {
    public GuardianOfFaith() {
        powerName = "Guardian of Faith";
        characterClass = HeroClassInformation.CharacterClasses.Cleric.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 5;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Will.toString();
        damageDiceDealt = 3;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        typeOfDamageDice = 8;
        isThisWeaponDamage = false;
        hitDescription = "You conjure a guardian that occupies 1 squre within range. The guardian occupies its square, although creatures can move through it. The guardian lasts until the end of the encounter. \n" +
                "Any enemy that ends its turn adjacent to the guardian is subject to a Wisdom vs. Fortitude attack. On a hit, the attack deals 1d8 + Wisdom modifier radiant damage.\n" +
                "\n" +
                "Move Action: The guardian moves 3 squares.";
    }
}
