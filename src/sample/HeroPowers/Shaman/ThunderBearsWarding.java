package sample.HeroPowers.Shaman;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class ThunderBearsWarding extends HeroPower {
    public ThunderBearsWarding() {
        powerName = "Thunder Bear' s Warding";
        characterClass = HeroClassInformation.CharacterClasses.Shaman.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 5;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Fortitude.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = false;
        powersAdditionalOptions = "Protector Spirit";
        hitDescription = "1d6 + Wisdom modifier thunder damage. Until the end of your next turn, you and your allies gain resistance to all damage equal to your Constitution modifier while adjacent to your spirit companion.\n" +
                "Protector Spirit: You or an ally within 5 squares of you gains temporary hit points equal to your Constitution modifier.";
    }
}
