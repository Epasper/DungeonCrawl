package DungeonCrawl.HeroPowers.Wizard;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.TypesOfActions;

public class MagicMissile extends HeroPower {
    public MagicMissile() {
        setPowerName("Magic Missile");
        setCharacterClass(HeroClasses.Wizard.toString());
        setTypeOfPower(TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(10);
        setNumberOfTargets("One target");
        setAttributeUsedToHit("None");
        setDefenseToBeChecked("None");
        setDamageDiceDealt(0);
        setTypeOfDamageDice(0);
        setDamageModifier(AttributeNames.Intelligence.toString());
        setThisWeaponDamage(false);
        setHitDescription("2 + Intelligence modifier force damage. Add the enhancement bonus, if any, on the implement used for magic missile to magic missile's damage.");
    }
}
