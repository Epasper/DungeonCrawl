package DungeonCrawl.HeroPowers.Rogue;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class DeftStrike extends HeroPower {
    public DeftStrike() {
        setPowerName("Deft Strike");
        setCharacterClass(HeroClasses.Rogue.toString());
        setTypeOfPower(TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Dexterity.toString());
        setDefenseToBeChecked(CreatureDefenses.AC.toString());
        setDamageDiceDealt(1);
        setDamageModifier(AttributeNames.Dexterity.toString());
        setThisWeaponDamage(true);
        setCanThisAttackAlsoBeRanged(true);
        setHitDescription("User can move 2 squares before the attack. 1[W] + Dexterity modifier damage.");
    }
}
