package DungeonCrawl.HeroPowers.Wizard;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class ForceOrb extends HeroPower {
    public ForceOrb() {
        powerName = "Force CrystalOrb";
        characterClass = HeroClasses.Wizard.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 20;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Intelligence.toString();
        defenseToBeChecked = CreatureDefenses.Reflex.toString();
        damageDiceDealt = 2;
        typeOfDamageDice = 8;
        damageModifier = AttributeNames.Intelligence.toString();
        isThisWeaponDamage = false;
        hitDescription = "2d8 + Intelligence modifier force damage, and you make the secondary attack.\"\n" +
                "\n" +
                "Secondary range: area burst 1 centered on the primary target\n" +
                "Secondary target: each enemy adjacent to within the secondary area of effect other than the primary target\n" +
                "Secondary attack: Intelligence vs. Reflex\n" +
                "Hit:: 1d10 + Intelligence modifier force damage.";
    }
}
