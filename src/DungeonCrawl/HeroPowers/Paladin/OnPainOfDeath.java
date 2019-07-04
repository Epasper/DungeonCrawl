package DungeonCrawl.HeroPowers.Paladin;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class OnPainOfDeath extends HeroPower {
    public OnPainOfDeath() {
        powerName = "On Pain of Death";
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
        hitDescription = "Hit: \"3d8 + Charisma modifier damage. Once per round, the target takes 1d8 damage after making any attacks on its turn (save ends).\"\n" +
                "\n" +
                "Miss: \"Half damage. Once per round, the target takes 1d4 damage after making any attacks on its turn (save ends)";
    }
}
