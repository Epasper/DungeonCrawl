package DungeonCrawl.HeroPowers.Bard;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClassInformation;

public class EchoesOfTheGuardian extends HeroPower {
    public EchoesOfTheGuardian() {
        powerName = "Echoes of the Guardian";
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
        hitDescription = "2[W] + Charisma modifier damage, and until the end of your next turn, the target is marked by an ally within 5 squares of you.\n" +
                "\n" +
                "Miss: Half damage.\n" +
                "\n" +
                "Effect: Until the end of the encounter, once during each of your turns, choose an ally within 5 squares of you when you hit an enemy. Until the end of your next turn, that enemy is marked by that ally.";
    }
}
