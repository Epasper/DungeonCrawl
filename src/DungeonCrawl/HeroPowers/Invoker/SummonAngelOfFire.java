package DungeonCrawl.HeroPowers.Invoker;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class SummonAngelOfFire extends HeroPower {
    public SummonAngelOfFire() {
        powerName = "Summon Angel of Fire";
        characterClass = HeroClasses.Invoker.toString();
        typeOfPower = TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 5;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.Fortitude.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 8;
        damageModifier = AttributeNames.Wisdom.toString();
        isThisWeaponDamage = false;
        bonusDamageModifier = AttributeNames.Constitution.toString();
        hitDescription = "You summon a Medium angel of fire in an\n" +
                "\n" +
                "unoccupied square within range. The angel has speed 6 and fly 6 (hover). You can give the angel the following\n" +
                "\n" +
                "special commands.\n" +
                "Standard Action: Close burst 1; targets each creature\n" +
                "\n" +
                "in burst; Wisdom vs. Reflex; 1d8 + Wisdom modifier fire\n" +
                "\n" +
                "damage.\n" +
                "Opportunity Attack: Melee 1; targets one creature; Wisdom vs. Reflex; 1d8 + Wisdom modifier fire damage.";
    }
}
