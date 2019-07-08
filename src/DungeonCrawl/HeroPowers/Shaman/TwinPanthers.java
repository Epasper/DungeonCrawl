package DungeonCrawl.HeroPowers.Shaman;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class TwinPanthers extends HeroPower {
    public TwinPanthers() {
        setPowerName("Twin Panthers");
        setCharacterClass(HeroClasses.Shaman.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(5);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.Reflex.toString());
        setDamageDiceDealt(1);
        setTypeOfDamageDice(6);
        setDamageModifier(AttributeNames.Wisdom.toString());
        setThisWeaponDamage(false);
        setPowersAdditionalOptions("Stalker Spirit");
        setHitDescription("Stalker Spirit: If the target is bloodied, the attack roll gains a bonus equal to the user's Intelligence modifier.\n" +
                "\n" +
                "Hit: 1d8 + Wisdom modifier damage. Until the end of the user's next turn, the user or his or her allies gain combat advantage on melee attacks against any enemy adjacent to the user's spirit companion.\n" +
                "\n" +
                "Effect: Make the attack one more time against the same target or a different target.");
    }
}
