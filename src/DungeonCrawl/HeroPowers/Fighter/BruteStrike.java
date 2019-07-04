package DungeonCrawl.HeroPowers.Fighter;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class BruteStrike extends HeroPower {
    public BruteStrike() {
        powerName = "Brute Strike";
        characterClass = HeroClasses.Fighter.toString();
        typeOfPower = TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Strength.toString();
        defenseToBeChecked = CreatureDefenses.AC.toString();
        damageDiceDealt = 3;
        damageModifier = AttributeNames.Strength.toString();
        isThisWeaponDamage = true;
        hitDescription = "Hit: \"3[W] + Strength modifier damage.";
    }
}
