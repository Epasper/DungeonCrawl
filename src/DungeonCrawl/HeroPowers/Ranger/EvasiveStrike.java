package DungeonCrawl.HeroPowers.Ranger;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class EvasiveStrike extends HeroPower {
    public EvasiveStrike() {
        powerName = "Evasive Strike";
        characterClass = HeroClasses.Ranger.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 20;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Strength.toString();
        defenseToBeChecked = CreatureDefenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = AttributeNames.Strength.toString();
        isThisWeaponDamage = true;
        hitDescription = "Special: You can shift a number of squares equal to 1+ Wisdom modifier either before or after the attack. \n" +
                "Strength vs. AC(melee) or Dexterity vs. AC(ranged)\n" +
                "\n" +
                "Hit: 2[W] + Dexterity(ranged) modifier damage or 2[W] + Strength(melee) modifier damage.";
    }
}
