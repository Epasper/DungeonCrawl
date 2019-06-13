package DungeonCrawl.HeroPowers.Shaman;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class CallToTheAncientDefender extends HeroPower {
    public CallToTheAncientDefender() {
        powerName = "Call to the Ancient Defender";
        characterClass = HeroClasses.Shaman.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.Fortitude.toString();
        damageDiceDealt = 2;
        typeOfDamageDice = 8;
        damageModifier = AttributeNames.Wisdom.toString();
        isThisWeaponDamage = false;
        isThisASpiritAttack = true;
        hitDescription = "Hit: 2d8 + Wisdom modifier damage. Until the end of your next turn, you and your allies gain a +5 bonus to all defenses against opportunity attacks while adjacent to your spirit companion.";
    }
}
