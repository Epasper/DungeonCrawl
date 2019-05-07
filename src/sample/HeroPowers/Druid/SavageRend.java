package sample.HeroPowers.Druid;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class SavageRend extends HeroPower {
    public SavageRend() {
        powerName = "Savage Rend";
        characterClass = HeroClassInformation.CharacterClasses.Druid.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 8;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = false;
        isThisABeastFormAttack = true;
        hitDescription = "1d8 + Wisdom modifier damage, and you slide the target 1 square. Savage rend can be used as a melee basic attack.";
    }
}
