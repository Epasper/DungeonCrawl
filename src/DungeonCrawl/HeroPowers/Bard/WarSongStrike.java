package DungeonCrawl.HeroPowers.Bard;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class WarSongStrike extends HeroPower {
    public WarSongStrike() {
        powerName = "War Song Strike";
        characterClass = HeroClasses.Bard.toString();
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
        hitDescription = "1[W] + Charisma modifier damage, and any ally who hits the target before the end of your next turn gains temporary hit points equal to your Constitution modifier.";
    }
}
