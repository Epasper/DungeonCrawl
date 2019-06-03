package DungeonCrawl.HeroPowers.Rogue;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class SlyFlourish extends HeroPower {
    public SlyFlourish() {
        powerName = "Sly Flourish";
        characterClass = HeroClassInformation.CharacterClasses.Rogue.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Dexterity.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Dexterity.toString();
        bonusDamageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = true;
        canThisAttackAlsoBeRanged = true;
        hitDescription = "1[W] + Dexterity modifier + Charisma modifier damage.";
    }
}
