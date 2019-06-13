package DungeonCrawl.HeroPowers.Cleric;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class CascadeOfLight extends HeroPower {
    public CascadeOfLight() {
        powerName = "Cascade of Light";
        characterClass = HeroClasses.Cleric.toString();
        typeOfPower = TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.Will.toString();
        damageDiceDealt = 3;
        damageModifier = AttributeNames.Wisdom.toString();
        typeOfDamageDice = 8;
        isThisWeaponDamage = false;
        hitDescription = "3d8 + Wisdom modifier radiant damage, and the target gains vulnerable 5 to all damage from your attacks (save ends).\n" +
                "\n" +
                "Miss: Half damage.";

    }
}
