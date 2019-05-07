package sample.HeroPowers.Sorcerer;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class BedevilingBurst extends HeroPower {
    public BedevilingBurst() {
        powerName = "Bedeviling Burst";
        characterClass = HeroClassInformation.CharacterClasses.Sorcerer.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 5;
        numberOfTargets = "One or Two targets";
        attributeUsedToHit = HeroClassInformation.Attributes.Charisma.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Will.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 10;
        damageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = false;
        hitDescription = "1d10 + Charisma modifier psychic damage, and you push the target a number of squares equal to your Dexterity modifier.\n\nSpecial: Wild Magic:If you rolled an even number on the attack roll, you slide the target instead of pushing it.";
    }
}
