package DungeonCrawl.HeroPowers.Invoker;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class PurgingFlame extends HeroPower {
    public PurgingFlame() {
        powerName = "Purging Flame";
        characterClass = HeroClasses.Invoker.toString();
        typeOfPower = TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.Fortitude.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 10;
        damageModifier = AttributeNames.Wisdom.toString();
        isThisWeaponDamage = false;
        bonusDamageModifier = AttributeNames.Constitution.toString();
        hitDescription = "Hit: 1d10 + Wisdom modifier fire damage, and ongoing 10 fire damage (save ends).\n" +
                "\n" +
                "Miss: Half damage, and ongoing 5 fire damage (save ends).";
    }
}
