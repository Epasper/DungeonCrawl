package sample.HeroPowers.Rogue;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class TorturousStrike extends HeroPower {
    public TorturousStrike() {
        powerName = "Torturous Strike";
        characterClass = HeroClassInformation.CharacterClasses.Rogue.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Dexterity.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 2;
        damageModifier = HeroClassInformation.Attributes.Dexterity.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Dexterity modifier damage, and you slide the target 1 square.\n" +
                "Artful Dodger: You slide the target a number of squares equal to your Charisma modifier";
    }
}
