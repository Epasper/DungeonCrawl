package sample.HeroPowers.Avenger;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class AvengingEcho extends HeroPower {
    public AvengingEcho() {
        powerName = "Avenging Echo";
        characterClass = HeroClassInformation.CharacterClasses.Avenger.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = true;
        secondAttributeUsed = HeroClassInformation.Attributes.Intelligence.toString();
        powersAdditionalOptions = "Censure of Retribution";
        hitDescription = "1[W] + Wisdom modifier damage. Until the end of your next turn, any enemy that ends its turn adjacent to you or hits or misses you takes 5 radiant damage. Censure of Retribution: The radiant damage equals 5 + your Intelligence modifier.";
    }
}
