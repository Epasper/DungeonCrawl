package DungeonCrawl.HeroPowers.Druid;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class SavageFrenzy extends HeroPower {
    public SavageFrenzy() {
        setPowerName("Savage Frenzy");
        setCharacterClass(HeroClasses.Druid.toString());
        setTypeOfPower(TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(10);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.Reflex.toString());
        setDamageDiceDealt(2);
        setTypeOfDamageDice(10);
        setDamageModifier(AttributeNames.Wisdom.toString());
        setThisWeaponDamage(false);
        setThisABeastFormAttack(true);
        setHitDescription("Effect: The target grants combat advantage until it moves or until the end of the encounter. \n" +
                "The first time the target moves before the end of the encounter, each enemy within 5 squares of the target is knocked prone.");
    }
}
