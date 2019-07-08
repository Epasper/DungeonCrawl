package DungeonCrawl.HeroPowers.Invoker;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class SummonAngelOfFire extends HeroPower {
    public SummonAngelOfFire() {
        setPowerName("Summon Angel of Fire");
        setCharacterClass(HeroClasses.Invoker.toString());
        setTypeOfPower(TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(5);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.Fortitude.toString());
        setDamageDiceDealt(1);
        setTypeOfDamageDice(8);
        setDamageModifier(AttributeNames.Wisdom.toString());
        setThisWeaponDamage(false);
        setBonusDamageModifier(AttributeNames.Constitution.toString());
        setHitDescription("You summon a Medium angel of fire in an\n" +
                "\n" +
                "unoccupied square within range. The angel has speed 6 and fly 6 (hover). You can give the angel the following\n" +
                "\n" +
                "special commands.\n" +
                "Standard Action: Close burst 1; targets each creature\n" +
                "\n" +
                "in burst; Wisdom vs. Reflex; 1d8 + Wisdom modifier fire\n" +
                "\n" +
                "damage.\n" +
                "Opportunity Attack: Melee 1; targets one creature; Wisdom vs. Reflex; 1d8 + Wisdom modifier fire damage.");
    }
}
