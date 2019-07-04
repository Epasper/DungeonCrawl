package DungeonCrawl.HeroPowers.Fighter;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class ComebackStrike extends HeroPower {
    public ComebackStrike() {
        powerName = "Comeback Strike";
        characterClass = HeroClasses.Fighter.toString();
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
        hitDescription =" 2[W] + Strength Modifier damage, and you can spend a healing surge.";
    }
}
