package DungeonCrawl.HeroPowers.Cleric;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class SacredFlame extends HeroPower {
    public SacredFlame() {
        setPowerName("Sacred Flame");
        setCharacterClass(HeroClasses.Cleric.toString());
        setTypeOfPower(TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(5);
        setNumberOfTargets("Burst"); //todo change this to "one target" after testing
        setBurstValue(2); //todo delete this line after burst testing
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.Reflex.toString());
        setDamageDiceDealt(1);
        setDamageModifier(AttributeNames.Wisdom.toString());
        setTypeOfDamageDice(6);
        setThisWeaponDamage(false);
        setHitDescription("1d6 + Wisdom modifier radiant damage, and one ally you can see chooses either to make a saving throw or to gain temporary hit points equal to your Charisma modifier + one-half your level.");

    }
}
