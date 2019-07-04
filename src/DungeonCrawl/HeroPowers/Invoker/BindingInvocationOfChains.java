package DungeonCrawl.HeroPowers.Invoker;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class BindingInvocationOfChains extends HeroPower {
    public BindingInvocationOfChains() {
        powerName = "Angelic Echelon";
        characterClass = HeroClasses.Invoker.toString();
        typeOfPower = TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "Close Burst 10";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.Will.toString();
        damageDiceDealt = 0;
        typeOfDamageDice = 1;
        damageModifier = AttributeNames.Wisdom.toString();
        isThisWeaponDamage = false;
        hitDescription = "Hit: The target is slowed (save ends).\n" +
                "\n" +
                "Miss: The target is slowed until the end of your next turn.";
    }
}
