package sample.HeroPowers.Warlock;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class VampiricEmbrace extends HeroPower {
    public VampiricEmbrace() {
        powerName = "Vampiric Embrace";
        characterClass = HeroClassInformation.CharacterClasses.Warlock.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 5;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Constitution.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Will.toString();
        damageDiceDealt = 2;
        typeOfDamageDice = 8;
        damageModifier = HeroClassInformation.Attributes.Constitution.toString();
        isThisWeaponDamage = false;
        powersAdditionalOptions = "Infernal Pact";
        hitDescription = "2d8 + Constitution modifier necrotic damage, and you gain 5 temporary hit points.\"\n" +
                "Infernal Pact: Add your Intelligence modifier to the temporary hit points.";
    }
}
