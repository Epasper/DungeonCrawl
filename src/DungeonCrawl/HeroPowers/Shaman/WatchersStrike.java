package DungeonCrawl.HeroPowers.Shaman;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;

public class WatchersStrike extends HeroPower {
    public WatchersStrike() {
        powerName = "Watcher's Strike";
        characterClass = HeroClasses.Shaman.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 8;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = false;
        isThisASpiritAttack = true;
        hitDescription = "1d8 + Wisdom modifier damage. Until the end of your next turn, you and your allies gain a +1 bonus to attack rolls and a +5 bonus to Perception checks while adjacent to your spirit companion.";
    }
}
