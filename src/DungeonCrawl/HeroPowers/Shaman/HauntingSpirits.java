package DungeonCrawl.HeroPowers.Shaman;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class HauntingSpirits extends HeroPower {
    public HauntingSpirits() {
        powerName = "Haunting Spirits";
        characterClass = HeroClasses.Shaman.toString();
        typeOfPower = TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.Will.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 8;
        damageModifier = AttributeNames.Wisdom.toString();
        isThisWeaponDamage = false;
        isThisASpiritAttack = true;
        hitDescription = "1d8 + Wisdom modifier damage, and each ally adjacent to your spirit companion gains temporary hit points equal to your Constitution modifier.";
    }
}
