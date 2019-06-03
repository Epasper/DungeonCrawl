package DungeonCrawl.HeroPowers.Avenger;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClassInformation;

public class TempleOfLight extends HeroPower {
    public TempleOfLight() {
        powerName = "Aspect of Might";
        characterClass = HeroClassInformation.CharacterClasses.Avenger.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 2;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        isThisWeaponDamage = true;
        hitDescription = "The attack creates a zone of radiant energy in a burst 2 centered on the target. The zone lasts until the end of the encounter. When the target moves, the zone moves with it, remaining centered on it. Whenever you hit a creature that is within the zone, that attack deals 1d6 extra radiant damage.";
    }
}
