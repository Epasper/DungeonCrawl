package DungeonCrawl.HeroPowers.Rogue;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class KingsCastle extends HeroPower {
    public KingsCastle() {
        powerName = "King's Castle";
        characterClass = HeroClassInformation.CharacterClasses.Rogue.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Dexterity.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Dexterity.toString();
        isThisWeaponDamage = true;
        canThisAttackAlsoBeRanged = true;
        hitDescription = "Hit: \"2[W] + Dexterity modifier damage.\"\n" +
                "\n" +
                "Effect: \"Switch places with a willing adjacent ally.";
    }
}
