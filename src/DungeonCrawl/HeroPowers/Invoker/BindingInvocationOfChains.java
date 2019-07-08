package DungeonCrawl.HeroPowers.Invoker;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class BindingInvocationOfChains extends HeroPower {
    public BindingInvocationOfChains() {
        setPowerName("Angelic Echelon");
        setCharacterClass(HeroClasses.Invoker.toString());
        setTypeOfPower(TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("Close Burst 10");
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.Will.toString());
        setDamageDiceDealt(0);
        setTypeOfDamageDice(1);
        setDamageModifier(AttributeNames.Wisdom.toString());
        setThisWeaponDamage(false);
        setHitDescription("Hit: The target is slowed (save ends).\n" +
                "\n" +
                "Miss: The target is slowed until the end of your next turn.");
    }
}
