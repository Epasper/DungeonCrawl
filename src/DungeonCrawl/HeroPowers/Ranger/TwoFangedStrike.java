package DungeonCrawl.HeroPowers.Ranger;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class TwoFangedStrike extends HeroPower {
    public TwoFangedStrike() {
        powerName = "Two-Fanged Strike";
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
        bonusDamageModifier = AttributeNames.Wisdom.toString();
        hitDescription = "Hit: 1[W]+ Strength modifier damage (melee) or 1[W]+Dexterity modifier damage per attack.\n" +
                "If both attacks hit, you deal extra damage equal to your wisdom modifier.";
    }
}
