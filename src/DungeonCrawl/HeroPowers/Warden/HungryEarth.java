package DungeonCrawl.HeroPowers.Warden;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class HungryEarth extends HeroPower {
    public HungryEarth() {
        powerName = "Hungry Earth";
        characterClass = HeroClasses.Warden.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "Close Burst 1";
        attributeUsedToHit = AttributeNames.Strength.toString();
        defenseToBeChecked = CreatureDefenses.Fortitude.toString();
        damageDiceDealt = 1;
        damageModifier = AttributeNames.Strength.toString();
        bonusDamageModifier = AttributeNames.Constitution.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Strength modifier damage.\n" +
                "\n" +
                "Effect: Until the end of your next turn, each square in the burst is difficult terrain for your enemies.";
    }
}
