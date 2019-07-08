package DungeonCrawl.HeroPowers.Bard;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class Blunder extends HeroPower {
    public Blunder() {
        setPowerName("Blunder");
        setCharacterClass(HeroClasses.Bard.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(5);
        setTypeOfDamageDice(6);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Charisma.toString());
        setDefenseToBeChecked(CreatureDefenses.Will.toString());
        setDamageDiceDealt(1);
        setDamageModifier(AttributeNames.Charisma.toString());
        setThisWeaponDamage(false);
        setPowersAdditionalOptions("Virtue of Cunning");
        setHitDescription("Hit: 1d6 + Charisma modifier damage, and you slide the target 2 squares. During the slide, you or one of your allies can make a melee basic attack against the target as a free action, with a +2 power bonus to the attack roll. Virtue of Cunning: The power bonus to the attack roll equals 1 + your Intelligence modifier.");
    }
}
