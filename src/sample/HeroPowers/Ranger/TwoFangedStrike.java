package sample.HeroPowers.Ranger;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class TwoFangedStrike extends HeroPower {
    public TwoFangedStrike() {
        powerName = "Two-Fanged Strike";
        characterClass = HeroClassInformation.CharacterClasses.Ranger.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 20;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        bonusDamageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        hitDescription = "Hit: 1[W]+ Strength modifier damage (melee) or 1[W]+Dexterity modifier damage per attack.\n" +
                "If both attacks hit, you deal extra damage equal to your wisdom modifier.";
    }
}
