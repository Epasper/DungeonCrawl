package DungeonCrawl.HeroPowers.Invoker;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class AngelicEchelon extends HeroPower {
    public AngelicEchelon() {
        powerName = "Angelic Echelon";
        characterClass = HeroClasses.Invoker.toString();
        typeOfPower = TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "Close Burst 3";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.Will.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        damageModifier = AttributeNames.Wisdom.toString();
        isThisWeaponDamage = false;
        hitDescription = "Hit: 1d6 + Wisdom modifier radiant damage. Whenever\n" +
                "\n" +
                "the target attacks before the end of your next turn, the\n" +
                "\n" +
                "target takes 5 radiant damage.\n" +
                "Miss: Half damage";
    }
}
