package DungeonCrawl.HeroPowers.Warden;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class EarthSpikes extends HeroPower {
    public EarthSpikes() {
        setPowerName("Earth Spikes");
        setCharacterClass(HeroClasses.Warden.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Strength.toString());
        setDefenseToBeChecked(CreatureDefenses.AC.toString());
        setDamageDiceDealt(1);
        setDamageModifier(AttributeNames.Strength.toString());
        setThisWeaponDamage(true);
        setHitDescription("1[W] + Strength modifier damage. Until the end of your next turn, the target's space and each square adjacent to it are filled with spikes. Any enemy that enters this spike-filled area or starts its turn there takes 5 damage. ");
    }
}
