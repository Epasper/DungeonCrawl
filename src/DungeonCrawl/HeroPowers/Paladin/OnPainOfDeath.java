package DungeonCrawl.HeroPowers.Paladin;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class OnPainOfDeath extends HeroPower {
    public OnPainOfDeath() {
        setPowerName("On Pain of Death");
        setCharacterClass(HeroClasses.Paladin.toString());
        setTypeOfPower(TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(5);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Charisma.toString());
        setDefenseToBeChecked(CreatureDefenses.Will.toString());
        setDamageDiceDealt(3);
        setTypeOfDamageDice(8);
        setDamageModifier(AttributeNames.Charisma.toString());
        setThisWeaponDamage(false);
        setHitDescription("Hit: \"3d8 + Charisma modifier damage. Once per round, the target takes 1d8 damage after making any attacks on its turn (save ends).\"\n" +
                "\n" +
                "Miss: \"Half damage. Once per round, the target takes 1d4 damage after making any attacks on its turn (save ends)");
    }
}
