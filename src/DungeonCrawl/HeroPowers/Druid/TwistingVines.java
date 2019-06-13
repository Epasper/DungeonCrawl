package DungeonCrawl.HeroPowers.Druid;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class TwistingVines extends HeroPower {
    public TwistingVines() {
        powerName = "Twisting Vines";
        characterClass = HeroClasses.Druid.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "Area Burst 1";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 8;
        bonusDamageModifier = AttributeNames.Wisdom.toString();
        damageModifier = "None";
        isThisWeaponDamage = false;
        hitDescription = "1d8 + Wisdom modifier damage. Each square adjacent to the target becomes difficult terrain until the end of the user's next turn.";
    }
}
