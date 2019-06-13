package DungeonCrawl.HeroPowers.Druid;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;

public class DartingBite extends HeroPower {
    public DartingBite() {
        powerName = "Darting Bite";
        characterClass = HeroClasses.Druid.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One or Two targets";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Will.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 10;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = false;
        isThisABeastFormAttack = true;
        powersAdditionalOptions = "Primal Predator";
        hitDescription = "1d10 + Wisdom modifier damage. If at least one target is hit, the user can shift up to 2 squares. Primal Predator: If at least one target is hit, the user can instead shift a number of squares up to his or her Dexterity modifier.";
    }
}
