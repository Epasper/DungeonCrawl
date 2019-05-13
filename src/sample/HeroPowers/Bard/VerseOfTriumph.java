package sample.HeroPowers.Bard;

import sample.HeroPowers.HeroPower;
import sample.StaticRules.HeroClassInformation;

public class VerseOfTriumph extends HeroPower {
    public VerseOfTriumph() {
        powerName = "Verse of Triumph";
        characterClass = HeroClassInformation.CharacterClasses.Bard.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Charisma.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 2;
        damageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = true;
        hitDescription = "2[W] + Charisma modifier damage.\n" +
                "\n" +
                "Miss: Half damage.\n" +
                "\n" +
                "Effect: Until the end of the encounter, you and any ally within 5 squares of you gain a +1 power bonus to damage rolls and saving throws. In addition, whenever you or an ally reduces an enemy to 0 hit points with any attack, you and any ally within 5 squares of the enemy can shift 1 square as a free action.";
    }
}
