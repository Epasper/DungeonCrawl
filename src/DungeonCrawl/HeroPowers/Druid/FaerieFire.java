package DungeonCrawl.HeroPowers.Druid;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class FaerieFire extends HeroPower {
    public FaerieFire() {
        powerName = "Faerie Fire";
        characterClass = HeroClasses.Druid.toString();
        typeOfPower = TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "Burst 1";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.Will.toString();
        damageDiceDealt = 3;
        typeOfDamageDice = 6;
        damageModifier = AttributeNames.Wisdom.toString();;
        isThisWeaponDamage = false;
        hitDescription = "The target is slowed and grants combat advantage (save ends both).\n" +
                "Aftereffect: 3d6 + Wisdom modifier radiant damage. The target grants combat advantage until the end of the user's next turn.\n" +
                "\n" +
                "Miss: 1d6 + Wisdom modifier radiant damage. The target grants combat advantage until the end of the user's next turn.";
    }
}
