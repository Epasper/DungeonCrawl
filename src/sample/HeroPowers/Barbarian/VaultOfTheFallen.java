package sample.HeroPowers.Barbarian;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class VaultOfTheFallen extends HeroPower {
    public VaultOfTheFallen() {
        powerName = "Vault of the Fallen";
        characterClass = HeroClassInformation.CharacterClasses.Barbarian.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One or Two targets";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 2;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        bonusDamage = true;
        typeOfBonusDamageDice = 6;
        powersAdditionalOptions = "Thaneborn Triumph";
        hitDescription = "1[W] + 1d6 + Strength modifier damage. Effect: If you target two creatures, you can shift 1 square after the first attack. Thaneborn Triumph: The number of squares you can shift equals your Charisma modifier.";
    }
}
