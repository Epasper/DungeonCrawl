package DungeonCrawl.HeroPowers.Paladin;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class BolsteringStrike extends HeroPower {
    public BolsteringStrike() {
        powerName = "Bolstering Strike";
        characterClass = HeroClasses.Paladin.toString();
        typeOfPower = TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Charisma.toString();
        defenseToBeChecked = CreatureDefenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = AttributeNames.Charisma.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Charisma modifier damage, and you gain temporary hit points equal to your Wisdom modifier.";
    }
}
