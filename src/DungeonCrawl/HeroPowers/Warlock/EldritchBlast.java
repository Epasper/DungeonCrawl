package DungeonCrawl.HeroPowers.Warlock;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class EldritchBlast extends HeroPower {
    public EldritchBlast() {
        powerName = "Eldritch Blast";
        characterClass = HeroClassInformation.CharacterClasses.Warlock.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Charisma.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Fortitude.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        damageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = false;
        hitDescription = "Eldritch blast counts as a ranged basic attack. 1d10 + Charisma or Constitution modifier damage.";
    }
}
