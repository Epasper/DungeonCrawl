package DungeonCrawl.HeroPowers.Druid;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class TwistingVines extends HeroPower {
    public TwistingVines() {
        powerName = "Twisting Vines";
        characterClass = HeroClassInformation.CharacterClasses.Druid.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "Area Burst 1";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 8;
        bonusDamageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        damageModifier = "None";
        isThisWeaponDamage = false;
        hitDescription = "1d8 + Wisdom modifier damage. Each square adjacent to the target becomes difficult terrain until the end of the user's next turn.";
    }
}
