package DungeonCrawl.HeroPowers.Wizard;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class RayOfEnfeeblement extends HeroPower {
    public RayOfEnfeeblement() {
        powerName = "Chill Strike";
        characterClass = HeroClassInformation.CharacterClasses.Wizard.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Intelligence.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Fortitude.toString();
        damageDiceDealt = 2;
        typeOfDamageDice = 8;
        damageModifier = HeroClassInformation.Attributes.Intelligence.toString();
        isThisWeaponDamage = false;
        hitDescription = "1d10 + Intelligence modifier necrotic damage, and the target is weakened until the end of your next turn.\n" +
                "\n" +
                "Miss: Half damage.";
    }
}
