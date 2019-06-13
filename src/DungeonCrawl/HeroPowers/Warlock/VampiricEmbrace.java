package DungeonCrawl.HeroPowers.Warlock;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class VampiricEmbrace extends HeroPower {
    public VampiricEmbrace() {
        powerName = "Vampiric Embrace";
        characterClass = HeroClasses.Warlock.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 5;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Constitution.toString();
        defenseToBeChecked = CreatureDefenses.Will.toString();
        damageDiceDealt = 2;
        typeOfDamageDice = 8;
        damageModifier = AttributeNames.Constitution.toString();
        isThisWeaponDamage = false;
        powersAdditionalOptions = "Infernal Pact";
        hitDescription = "2d8 + Constitution modifier necrotic damage, and you gain 5 temporary hit points.\"\n" +
                "Infernal Pact: Add your Intelligence modifier to the temporary hit points.";
    }
}
