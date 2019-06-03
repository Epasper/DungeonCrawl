package DungeonCrawl.HeroPowers.Bard;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClassInformation;

public class StirringShout extends HeroPower {
    public StirringShout() {
        powerName = "Stirring Shout";
        characterClass = HeroClassInformation.CharacterClasses.Bard.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Charisma.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Will.toString();
        damageDiceDealt = 2;
        typeOfDamageDice = 6;
        damageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = false;
        hitDescription = "2d6 + Charisma modifier psychic damage.\n" +
                "\n" +
                "Effect: Until the end of the encounter, whenever an ally hits the target, that ally regains hit points equal to your Charisma modifier.";
    }
}
