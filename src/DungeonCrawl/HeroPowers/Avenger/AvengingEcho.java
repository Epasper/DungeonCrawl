package DungeonCrawl.HeroPowers.Avenger;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class AvengingEcho extends HeroPower {
    public AvengingEcho() {
        setPowerName("Avenging Echo");
        setCharacterClass(HeroClasses.Avenger.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Wisdom.toString());
        setDefenseToBeChecked(CreatureDefenses.AC.toString());
        setDamageDiceDealt(1);
        setDamageModifier(AttributeNames.Wisdom.toString());
        setThisWeaponDamage(true);
        setSecondAttributeUsed(AttributeNames.Intelligence.toString());
        setPowersAdditionalOptions("Censure of Retribution");
        setHitDescription("1[W] + Wisdom modifier damage. Until the end of your next turn, any enemy that ends its turn adjacent to you or hits or misses you takes 5 radiant damage. Censure of Retribution: The radiant damage equals 5 + your Intelligence modifier.");
    }
}
