package DungeonCrawl.HeroPowers.Warlord;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class WolfsPackTactics extends HeroPower {
    public WolfsPackTactics() {
        powerName = "Wolf Pack Tactics";
        characterClass = HeroClassInformation.CharacterClasses.Warlord.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        hitDescription = "Before the attack, an ally adjacent to you or to the target can shift 1 square as a free action. 1[W] + Strength modifier damage.";
    }
}
