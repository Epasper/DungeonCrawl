package sample.HeroPowers.Warlord;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class WarlordsFavor extends HeroPower {
    public WarlordsFavor() {
        powerName = "Warlord's Favor";
        characterClass = HeroClassInformation.CharacterClasses.Warlord.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        powersAdditionalOptions = "Tactical Presence";
        hitDescription = "2[W] + Strength modifier damage. One ally within 5 squares of you gains a +2 power bonus to attack rolls against the target until the end of your next turn.\n" +
                "Tactical Presence: The bonus equals 1 + your Intelligence modifier.";
    }
}
