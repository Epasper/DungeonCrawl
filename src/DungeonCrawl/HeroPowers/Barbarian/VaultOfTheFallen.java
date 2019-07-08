package DungeonCrawl.HeroPowers.Barbarian;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class VaultOfTheFallen extends HeroPower {
    public VaultOfTheFallen() {
        setPowerName("Vault of the Fallen");
        setCharacterClass(HeroClasses.Barbarian.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One or Two targets");
        setAttributeUsedToHit(AttributeNames.Strength.toString());
        setDefenseToBeChecked(CreatureDefenses.AC.toString());
        setDamageDiceDealt(2);
        setDamageModifier(AttributeNames.Strength.toString());
        setThisWeaponDamage(true);
        setBonusDamage(true);
        setTypeOfBonusDamageDice(6);
        setPowersAdditionalOptions("Thaneborn Triumph");
        setHitDescription("1[W] + 1d6 + Strength modifier damage. Effect: If you target two creatures, you can shift 1 square after the first attack. Thaneborn Triumph: The number of squares you can shift equals your Charisma modifier.");
    }
}
