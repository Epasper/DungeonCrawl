package DungeonCrawl.HeroPowers.Wizard;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class ForceOrb extends HeroPower {
    public ForceOrb() {
        setPowerName("Force CrystalOrb");
        setCharacterClass(HeroClasses.Wizard.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(20);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Intelligence.toString());
        setDefenseToBeChecked(CreatureDefenses.Reflex.toString());
        setDamageDiceDealt(2);
        setTypeOfDamageDice(8);
        setDamageModifier(AttributeNames.Intelligence.toString());
        setThisWeaponDamage(false);
        setHitDescription("2d8 + Intelligence modifier force damage, and you make the secondary attack.\"\n" +
                "\n" +
                "Secondary range: area burst 1 centered on the primary target\n" +
                "Secondary target: each enemy adjacent to within the secondary area of effect other than the primary target\n" +
                "Secondary attack: Intelligence vs. Reflex\n" +
                "Hit:: 1d10 + Intelligence modifier force damage.");
    }
}
