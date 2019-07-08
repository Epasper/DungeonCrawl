package DungeonCrawl.HeroPowers.Druid;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class FiresOfLife extends HeroPower {
    public FiresOfLife() {
        setPowerName("Fires of Life");
        setCharacterClass(HeroClasses.Druid.toString());
        setTypeOfPower(TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(10);
        setNumberOfTargets("Burst");
        setBurstValue(1);
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.Will.toString());
        setDamageDiceDealt(1);
        setTypeOfDamageDice(6);
        setDamageModifier(AttributeNames.Wisdom.toString());;
        setThisWeaponDamage(false);
        setHitDescription("1d6 + Wisdom modifier fire damage, and ongoing 5 fire damage (save ends). If the target drops to 0 hit points before it saves against the ongoing damage, one creature of the user's choice within 5 squares of the target regains hit points equal to 5 + the user's Constitution modifier.\n" +
                "Aftereffect: One creature of the user's choice within 5 squares of the target regains hit points equal to the user's Constitution modifier.\n" +
                "\n" +
                "Miss: Half damage.");
    }
}
