package DungeonCrawl.HeroPowers.Cleric;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class AvengingFlame extends HeroPower {
    public AvengingFlame() {
        powerName = "Avenging Flame";
        characterClass = HeroClasses.Cleric.toString();
        typeOfPower = TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Strength.toString();
        defenseToBeChecked = CreatureDefenses.AC.toString();
        damageDiceDealt = 2;
        damageModifier = AttributeNames.Strength.toString();
        isThisWeaponDamage = true;
        hitDescription = "2[W] + Strength modifier damage, and ongoing 5 fire damage (save ends). If the target attacks on its turn, it can’t make a saving throw against the ongoing damage on that turn.[PH:64][Dr399:Cleric]\n" +
                "\n" +
                "Miss: Half damage";
    }
}
