package DungeonCrawl.HeroPowers.Paladin;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class RadiantDelirium extends HeroPower {
    public RadiantDelirium() {
        powerName = "Radiant Delirium";
        characterClass = HeroClasses.Paladin.toString();
        typeOfPower = TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 5;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Charisma.toString();
        defenseToBeChecked = CreatureDefenses.Will.toString();
        damageDiceDealt = 3;
        typeOfDamageDice = 8;
        damageModifier = AttributeNames.Charisma.toString();
        isThisWeaponDamage = false;
        hitDescription = "Hit: 3d8 + Charisma modifier radiant damage, and the target is dazed until the end of your next turn. In addition, the target takes a −2 penalty to AC (save ends).\n" +
                "\n" +
                "Miss: Half damage, and the target is dazed until the end of your next turn.";
    }
}
