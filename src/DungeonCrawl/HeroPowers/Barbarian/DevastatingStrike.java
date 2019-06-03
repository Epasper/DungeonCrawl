package DungeonCrawl.HeroPowers.Barbarian;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class DevastatingStrike extends HeroPower {
    public DevastatingStrike() {
        powerName = "Devastating Strike";
        characterClass = HeroClassInformation.CharacterClasses.Barbarian.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        bonusDamage = true;
        typeOfBonusDamageDice = 8;
        hitDescription = "1 [W] + 1d8 + Strength modifier damage. Until the start of your next turn, any attacker gains a +2 bonus to attack rolls against you. If you are raging, attackers do not gain this bonus.";
    }
}
