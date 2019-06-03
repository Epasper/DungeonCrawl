package DungeonCrawl.HeroPowers.Barbarian;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class RecuperatingStrike extends HeroPower {

    public RecuperatingStrike() {
        powerName = "Recuperating Strike";
        characterClass = HeroClassInformation.CharacterClasses.Barbarian.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        hitDescription = "1 [W] + Strength modifier damage, and you gain temporary hit points equal to your Constitution modifier. If you are raging, the number of temporary hit points you gain equals 5 + your Constitution modifier.";
    }
}
