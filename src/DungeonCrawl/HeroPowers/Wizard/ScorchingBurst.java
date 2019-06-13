package DungeonCrawl.HeroPowers.Wizard;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class ScorchingBurst extends HeroPower {
    public ScorchingBurst() {
        powerName = "Scorching Burst";
        characterClass = HeroClasses.Wizard.toString();
        typeOfPower = TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "Burst 1";
        attributeUsedToHit = AttributeNames.Intelligence.toString();
        defenseToBeChecked = CreatureDefenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        damageModifier = AttributeNames.Intelligence.toString();
        isThisWeaponDamage = false;
        hitDescription = "1d6 + Intelligence modifier fire damage.";
    }
}
