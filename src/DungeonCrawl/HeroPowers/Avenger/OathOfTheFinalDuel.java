package DungeonCrawl.HeroPowers.Avenger;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class OathOfTheFinalDuel extends HeroPower {
    public OathOfTheFinalDuel() {
        setPowerName("Oath of the Final Duel");
        setCharacterClass(HeroClasses.Avenger.toString());
        setTypeOfPower(TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.AC.toString());
        setDamageDiceDealt(2);
        setDamageModifier(AttributeNames.Wisdom.toString());
        setThisWeaponDamage(true);
        setHitDescription("Until the end of the encounter, if the target is more than 3 squares away from you at the start of your turn, you can teleport to a space within 3 squares of it as a minor action. This effect ends if you end your turn more than 3 squares away from the target.");
    }
}
