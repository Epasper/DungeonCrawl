package DungeonCrawl.HeroPowers.Druid;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class FrostFlash extends HeroPower {
    public FrostFlash() {
        powerName = "Frost Flash";
        characterClass = HeroClassInformation.CharacterClasses.Druid.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One Target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Fortitude.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        bonusDamageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        damageModifier = "None";
        isThisWeaponDamage = false;
        hitDescription = "1d6 + Wisdom modifier cold damage. The target is immobilized until the end of the user's next turn. Primal Guardian: Extra damage equal to the user's Constitution modifier.";
    }
}
