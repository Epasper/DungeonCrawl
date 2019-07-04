package DungeonCrawl.HeroPowers.Druid;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class FiresOfLife extends HeroPower {
    public FiresOfLife() {
        powerName = "Fires of Life";
        characterClass = HeroClasses.Druid.toString();
        typeOfPower = TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "Burst 1";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.Will.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        damageModifier = AttributeNames.Wisdom.toString();;
        isThisWeaponDamage = false;
        hitDescription = "1d6 + Wisdom modifier fire damage, and ongoing 5 fire damage (save ends). If the target drops to 0 hit points before it saves against the ongoing damage, one creature of the user's choice within 5 squares of the target regains hit points equal to 5 + the user's Constitution modifier.\n" +
                "Aftereffect: One creature of the user's choice within 5 squares of the target regains hit points equal to the user's Constitution modifier.\n" +
                "\n" +
                "Miss: Half damage.";
    }
}
