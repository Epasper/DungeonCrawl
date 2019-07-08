package DungeonCrawl.HeroPowers.Invoker;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class PurgingFlame extends HeroPower {
    public PurgingFlame() {
        setPowerName("Purging Flame");
        setCharacterClass(HeroClasses.Invoker.toString());
        setTypeOfPower(TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(10);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.Fortitude.toString());
        setDamageDiceDealt(1);
        setTypeOfDamageDice(10);
        setDamageModifier(AttributeNames.Wisdom.toString());
        setThisWeaponDamage(false);
        setBonusDamageModifier(AttributeNames.Constitution.toString());
        setHitDescription("Hit: 1d10 + Wisdom modifier fire damage, and ongoing 10 fire damage (save ends).\n" +
                "\n" +
                "Miss: Half damage, and ongoing 5 fire damage (save ends).");
    }
}
