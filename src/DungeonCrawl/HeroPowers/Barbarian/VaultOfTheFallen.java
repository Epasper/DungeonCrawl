package DungeonCrawl.HeroPowers.Barbarian;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class VaultOfTheFallen extends HeroPower {
    public VaultOfTheFallen() {
        powerName = "Vault of the Fallen";
        characterClass = HeroClasses.Barbarian.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One or Two targets";
        attributeUsedToHit = AttributeNames.Strength.toString();
        defenseToBeChecked = CreatureDefenses.AC.toString();
        damageDiceDealt = 2;
        damageModifier = AttributeNames.Strength.toString();
        isThisWeaponDamage = true;
        bonusDamage = true;
        typeOfBonusDamageDice = 6;
        powersAdditionalOptions = "Thaneborn Triumph";
        hitDescription = "1[W] + 1d6 + Strength modifier damage. Effect: If you target two creatures, you can shift 1 square after the first attack. Thaneborn Triumph: The number of squares you can shift equals your Charisma modifier.";
    }
}
