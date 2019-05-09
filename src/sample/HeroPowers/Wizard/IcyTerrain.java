package sample.HeroPowers.Wizard;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class IcyTerrain extends HeroPower {
    public IcyTerrain() {
        powerName = "Icy Terrain";
        characterClass = HeroClassInformation.CharacterClasses.Wizard.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "Burst 1";
        attributeUsedToHit = HeroClassInformation.Attributes.Intelligence.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        damageModifier = HeroClassInformation.Attributes.Intelligence.toString();
        isThisWeaponDamage = false;
        hitDescription = "1d6 + Intelligence modifier cold damage, and the target falls prone.\"\n" +
                "\n" +
                "Effect: \"The burst creates a zone that lasts until the end of your next turn or until you end it as a minor action. The ground of the zone is difficult terrain.";
    }
}
