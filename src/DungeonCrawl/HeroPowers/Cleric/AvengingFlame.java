package DungeonCrawl.HeroPowers.Cleric;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class AvengingFlame extends HeroPower {
    public AvengingFlame() {
        setPowerName("Avenging Flame");
        setCharacterClass(HeroClasses.Cleric.toString());
        setTypeOfPower(TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(0);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Strength.toString());
        setDefenseToBeChecked(CreatureDefenses.AC.toString());
        setDamageDiceDealt(2);
        setDamageModifier(AttributeNames.Strength.toString());
        setThisWeaponDamage(true);
        setHitDescription("2[W] + Strength modifier damage, and ongoing 5 fire damage (save ends). If the target attacks on its turn, it can’t make a saving throw against the ongoing damage on that turn.[PH:64][Dr399:Cleric]\n" +
                "\n" +
                "Miss: Half damage");
    }
}
