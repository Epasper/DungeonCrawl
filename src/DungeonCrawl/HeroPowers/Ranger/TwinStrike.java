package DungeonCrawl.HeroPowers.Ranger;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class TwinStrike extends HeroPower {
    public TwinStrike() {
        powerName = "Twin Strike";
        characterClass = HeroClassInformation.CharacterClasses.Ranger.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One or Two targets";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        canThisAttackAlsoBeRanged = true;
        hitDescription = "1[W] + Strength modifier damage (melee) or 1[W] + Dexterity modifier damage (ranged), two attacks.";
    }
}
