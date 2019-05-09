package sample.HeroPowers.Invoker;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class AstralTerror extends HeroPower {
    public AstralTerror() {
        powerName = "Astral Terror";
        characterClass = HeroClassInformation.CharacterClasses.Invoker.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "Burst 1";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = false;
        powersAdditionalOptions = "Covenant of Preservation";
        hitDescription = "Hit: 1d6 + Wisdom modifier radiant damage.\n" +
                "\n" +
                "Effect: Each ally in the burst gains a +2 power bonus to AC until the end of your next turn.\n" +
                "\n" +
                "Covenant of Preservation: The bonus to AC equals 1 + your Intelligence modifier.";
    }
}
