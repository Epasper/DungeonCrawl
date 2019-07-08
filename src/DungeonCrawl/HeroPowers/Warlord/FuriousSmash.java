package DungeonCrawl.HeroPowers.Warlord;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class FuriousSmash extends HeroPower {
    public FuriousSmash() {
        setPowerName("Furious Smash");
        setCharacterClass(HeroClasses.Warlord.toString());
        setTypeOfPower(TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Strength.toString());
        setDefenseToBeChecked(CreatureDefenses.Fortitude.toString());
        setDamageDiceDealt(0);
        setDamageModifier(AttributeNames.Strength.toString());
        setBonusDamageModifier(AttributeNames.Charisma.toString());
        setThisWeaponDamage(true);
        setHitDescription("Strength modifier damage. Choose an ally adjacent to you or to the target. The ally gains a power bonus to the next attack roll and damage roll that he or she makes against the target before the end of his or her next turn. The power bonus equals your Charisma modifier.");
    }
}
