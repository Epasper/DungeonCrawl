package DungeonCrawl.HeroPowers.Warden;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class HungryEarth extends HeroPower {
    public HungryEarth() {
        powerName = "Hungry Earth";
        characterClass = HeroClassInformation.CharacterClasses.Warden.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "Close Burst 1";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Fortitude.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        bonusDamageModifier = HeroClassInformation.Attributes.Constitution.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Strength modifier damage.\n" +
                "\n" +
                "Effect: Until the end of your next turn, each square in the burst is difficult terrain for your enemies.";
    }
}
