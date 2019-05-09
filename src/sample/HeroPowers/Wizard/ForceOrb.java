package sample.HeroPowers.Wizard;

import sample.StaticRules.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class ForceOrb extends HeroPower {
    public ForceOrb() {
        powerName = "Force Orb";
        characterClass = HeroClassInformation.CharacterClasses.Wizard.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 20;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Intelligence.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 2;
        typeOfDamageDice = 8;
        damageModifier = HeroClassInformation.Attributes.Intelligence.toString();
        isThisWeaponDamage = false;
        hitDescription = "2d8 + Intelligence modifier force damage, and you make the secondary attack.\"\n" +
                "\n" +
                "Secondary range: area burst 1 centered on the primary target\n" +
                "Secondary target: each enemy adjacent to within the secondary area of effect other than the primary target\n" +
                "Secondary attack: Intelligence vs. Reflex\n" +
                "Hit:: 1d10 + Intelligence modifier force damage.";
    }
}
