package DungeonCrawl.HeroPowers.Avenger;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClassInformation;

public class OathOfTheFinalDuel extends HeroPower {
    public OathOfTheFinalDuel() {
        powerName = "Oath of the Final Duel";
        characterClass = HeroClassInformation.CharacterClasses.Avenger.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 2;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = true;
        hitDescription = "Until the end of the encounter, if the target is more than 3 squares away from you at the start of your turn, you can teleport to a space within 3 squares of it as a minor action. This effect ends if you end your turn more than 3 squares away from the target.";
    }
}
