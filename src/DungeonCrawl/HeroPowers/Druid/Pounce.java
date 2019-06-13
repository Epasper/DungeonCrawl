package DungeonCrawl.HeroPowers.Druid;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;

public class Pounce extends HeroPower {
    public Pounce() {
        powerName = "Pounce";
        characterClass = HeroClasses.Druid.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 8;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = false;
        isThisABeastFormAttack = true;
        hitDescription = "1d8 + Wisdom modifier damage. The target grants combat advantage to the next creature that attacks it before the end of your next turn. A character can use pounce instead of the melee basic attack or bull rush part of a charge action.";
    }
}
