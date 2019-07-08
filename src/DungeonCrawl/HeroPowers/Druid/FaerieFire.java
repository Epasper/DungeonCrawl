package DungeonCrawl.HeroPowers.Druid;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class FaerieFire extends HeroPower {
    public FaerieFire() {
        setPowerName("Faerie Fire");
        setCharacterClass(HeroClasses.Druid.toString());
        setTypeOfPower(TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(10);
        setNumberOfTargets("Burst");
        setBurstValue(1);
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.Will.toString());
        setDamageDiceDealt(3);
        setTypeOfDamageDice(6);
        setDamageModifier(AttributeNames.Wisdom.toString());;
        setThisWeaponDamage(false);
        setHitDescription("The target is slowed and grants combat advantage (save ends both).\n" +
                "Aftereffect: 3d6 + Wisdom modifier radiant damage. The target grants combat advantage until the end of the user's next turn.\n" +
                "\n" +
                "Miss: 1d6 + Wisdom modifier radiant damage. The target grants combat advantage until the end of the user's next turn.");
    }
}
