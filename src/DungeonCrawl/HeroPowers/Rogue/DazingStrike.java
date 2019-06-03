package DungeonCrawl.HeroPowers.Rogue;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class DazingStrike extends HeroPower {
    public DazingStrike() {
        powerName = "Dazing Strike";
        characterClass = HeroClassInformation.CharacterClasses.Rogue.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Dexterity.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Dexterity.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Dexterity modifier damage, and the target is dazed until the end of your next turn";
    }
}
