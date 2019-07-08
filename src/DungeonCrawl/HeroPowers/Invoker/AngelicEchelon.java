package DungeonCrawl.HeroPowers.Invoker;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class AngelicEchelon extends HeroPower {
    public AngelicEchelon() {
        setPowerName("Angelic Echelon");
        setCharacterClass(HeroClasses.Invoker.toString());
        setTypeOfPower(TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("Close Burst 3");
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.Will.toString());
        setDamageDiceDealt(1);
        setTypeOfDamageDice(6);
        setDamageModifier(AttributeNames.Wisdom.toString());
        setThisWeaponDamage(false);
        setHitDescription("Hit: 1d6 + Wisdom modifier radiant damage. Whenever\n" +
                "\n" +
                "the target attacks before the end of your next turn, the\n" +
                "\n" +
                "target takes 5 radiant damage.\n" +
                "Miss: Half damage");
    }
}
