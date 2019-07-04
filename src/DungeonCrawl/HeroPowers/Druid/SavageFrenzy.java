package DungeonCrawl.HeroPowers.Druid;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class SavageFrenzy extends HeroPower {
    public SavageFrenzy() {
        powerName = "Savage Frenzy";
        characterClass = HeroClasses.Druid.toString();
        typeOfPower = TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10  ;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.Reflex.toString();
        damageDiceDealt = 2;
        typeOfDamageDice = 10;
        damageModifier = AttributeNames.Wisdom.toString();
        isThisWeaponDamage = false;
        isThisABeastFormAttack = true;
        hitDescription = "Effect: The target grants combat advantage until it moves or until the end of the encounter. \n" +
                "The first time the target moves before the end of the encounter, each enemy within 5 squares of the target is knocked prone.";
    }
}
