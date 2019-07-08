package DungeonCrawl.HeroPowers.Invoker;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class AvengingLight extends HeroPower {
    public AvengingLight() {
        setPowerName("Avenging Light");
        setCharacterClass(HeroClasses.Invoker.toString());
        setTypeOfPower(TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(10);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.Fortitude.toString());
        setDamageDiceDealt(1);
        setTypeOfDamageDice(10);
        setDamageModifier(AttributeNames.Wisdom.toString());
        setThisWeaponDamage(false);
        setBonusDamageModifier(AttributeNames.Constitution.toString());
        setHitDescription("1d10 + Wisdom modifier radiant damage. If a bloodied ally is adjacent to the target, the attack deals extra damage equal to your Constitution modifier.");
    }
}
