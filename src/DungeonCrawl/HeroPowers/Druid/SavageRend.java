package DungeonCrawl.HeroPowers.Druid;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class SavageRend extends HeroPower {
    public SavageRend() {
        setPowerName("Savage Rend");
        setCharacterClass(HeroClasses.Druid.toString());
        setTypeOfPower(TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.Reflex.toString());
        setDamageDiceDealt(1);
        setTypeOfDamageDice(8);
        setDamageModifier(AttributeNames.Wisdom.toString());
        setThisWeaponDamage(false);
        setThisABeastFormAttack(true);
        setHitDescription("1d8 + Wisdom modifier damage, and you slide the target 1 square. Savage rend can be used as a melee basic attack.");
    }
}
