package DungeonCrawl.HeroPowers.Shaman;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class ThunderBearsWarding extends HeroPower {
    public ThunderBearsWarding() {
        powerName = "Thunder Bear' s Warding";
        characterClass = HeroClasses.Shaman.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 5;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.Fortitude.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        damageModifier = AttributeNames.Wisdom.toString();
        isThisWeaponDamage = false;
        powersAdditionalOptions = "Protector Spirit";
        hitDescription = "1d6 + Wisdom modifier thunder damage. Until the end of your next turn, you and your allies gain resistance to all damage equal to your Constitution modifier while adjacent to your spirit companion.\n" +
                "Protector Spirit: You or an ally within 5 squares of you gains temporary hit points equal to your Constitution modifier.";
    }
}
