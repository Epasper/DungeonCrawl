package DungeonCrawl.HeroPowers.Ranger;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class FoxsCunning extends HeroPower {
    public FoxsCunning() {
        setPowerName("Fox's Cunning");
        setCharacterClass(HeroClasses.Ranger.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.REACTION.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Strength.toString());
        setDefenseToBeChecked(CreatureDefenses.AC.toString());
        setDamageDiceDealt(1);
        setDamageModifier(AttributeNames.Strength.toString());
        setThisWeaponDamage(true);
        setCanThisAttackAlsoBeRanged(true);
        setHitDescription("Trigger: an enemy makes a melee attack against the user\n" +
                "\n" +
                "Effect: The user shifts up to 1 square, then makes a basic attack against the triggering enemy. The attack roll for the basic attack gains a power bonus equal to the user's Wisdom modifier. ");
    }
}
