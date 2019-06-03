package DungeonCrawl.HeroPowers.Druid;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class CallOfTheBeast extends HeroPower {
    public CallOfTheBeast() {
        powerName = "Call of the Beast";
        characterClass = HeroClassInformation.CharacterClasses.Druid.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "Burst 1, Enemies only";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Fortitude.toString();
        damageDiceDealt = 0;
        typeOfDamageDice = 0;
        damageModifier = "None";
        isThisWeaponDamage = false;
        hitDescription = "The target can't gain combat advantage until the end of your next turn. In addition, on its next turn the target takes psychic damage equal to 5 + your Wisdom modifier when it makes any attack that doesn't include your ally nearest to it as a target.";
    }
}