package DungeonCrawl.HeroPowers.Paladin;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class PaladinsJudgement extends HeroPower {
    public PaladinsJudgement() {
        powerName = "Paladins' Judgement";
        characterClass = HeroClasses.Paladin.toString();
        typeOfPower = TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Strength.toString();
        defenseToBeChecked = CreatureDefenses.AC.toString();
        damageDiceDealt = 3;
        damageModifier = AttributeNames.Strength.toString();
        isThisWeaponDamage = true;
        hitDescription = "Hit: \"3[W] + Strength modifier damage, and one ally within 5 squares of you can spend a healing surge.\"\n" +
                "\n" +
                "Miss: \"One ally within 5 squares of you can spend a healing surge.";
    }
}
