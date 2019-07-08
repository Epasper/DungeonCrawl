package DungeonCrawl.HeroPowers.Bard;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class ShoutOfTriumph extends HeroPower {
    public ShoutOfTriumph() {
        setPowerName("Shout of Triumph");
        setCharacterClass(HeroClasses.Bard.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setTypeOfDamageDice(6);
        setNumberOfTargets("Close Blast 3");
        setAttributeUsedToHit(AttributeNames.Charisma.toString());
        setDefenseToBeChecked(CreatureDefenses.Will.toString());
        setDamageDiceDealt(1);
        setDamageModifier(AttributeNames.Charisma.toString());
        setThisWeaponDamage(false);
        setPowersAdditionalOptions("Virtue of Valor");
        setHitDescription("Hit: 1d6 + Charisma modifier thunder damage, and you push the target 1 square. Effect: You slide each ally in the blast 1 square. Virtue of Valor: The number of squares you push the target and slide the allies equals your Constitution modifier.");
    }
}
