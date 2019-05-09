package sample.HeroPowers.Warlord;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class GuardingAttack extends HeroPower {
    public GuardingAttack() {
        powerName = "Guarding Attack";
        characterClass = HeroClassInformation.CharacterClasses.Warlord.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 2;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        hitDescription = "2[W] + Strength modifier damage. One ally adjacent to you or to the target gains a +2 power bonus to AC against the target's attacks. The bonus lasts until the end of your next turn.\n" +
                "Inspiring Presence: The bonus equals 1 + your Charisma modifier.";
    }
}
