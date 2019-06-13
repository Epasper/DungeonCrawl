package DungeonCrawl.HeroPowers.Avenger;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class RenewingStrike extends HeroPower {
    public RenewingStrike() {
        powerName = "Renewing Strike";
        characterClass = HeroClasses.Avenger.toString();
        typeOfPower = TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.Reflex.toString();
        damageDiceDealt = 2;
        damageModifier = AttributeNames.Wisdom.toString();
        isThisWeaponDamage = false;
        damageDiceDealt = 10;
        hitDescription = "2d10 + Wisdom modifier lightning damage\n" +
                "\n" +
                "Miss: Half damage\n" +
                "\n" +
                "Effect: You can spend a healing surge";
    }
}
