package DungeonCrawl.HeroPowers.Sorcerer;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class ChaosBolt extends HeroPower {
    public ChaosBolt() {
        setPowerName("Chaos Bolt");
        setCharacterClass(HeroClasses.Sorcerer.toString());
        setTypeOfPower(TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(10);
        setNumberOfTargets("one target");
        setAttributeUsedToHit(AttributeNames.Charisma.toString());
        setDefenseToBeChecked(CreatureDefenses.Will.toString());
        setDamageDiceDealt(1);
        setTypeOfDamageDice(10);
        setDamageModifier(AttributeNames.Charisma.toString());
        setThisWeaponDamage(false);
        setHitDescription("Wild Magic: If you roll an even number for the primary attack roll and hit your target, make a secondary attack.\n" +
                "Secondary target: One creature within 5 squares of the target last hit by this power.\n" +
                "Secondary attack: Charisma vs. Will\n" +
                "Hit: 1d6 psychic damage. If you rolled an even number for the secondary attack roll, repeat the secondary attack. You can attack a creature only once with a single use of this power.");
    }
}
