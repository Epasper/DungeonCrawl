package DungeonCrawl.HeroPowers.Druid;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class DartingBite extends HeroPower {
    public DartingBite() {
        setPowerName("Darting Bite");
        setCharacterClass(HeroClasses.Druid.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One or Two targets");
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.Will.toString());
        setDamageDiceDealt(1);
        setTypeOfDamageDice(10);
        setDamageModifier(AttributeNames.Wisdom.toString());
        setThisWeaponDamage(false);
        setThisABeastFormAttack(true);
        setPowersAdditionalOptions("Primal Predator");
        setHitDescription("1d10 + Wisdom modifier damage. If at least one target is hit, the user can shift up to 2 squares. Primal Predator: If at least one target is hit, the user can instead shift a number of squares up to his or her Dexterity modifier.");
    }
}
