package DungeonCrawl.HeroPowers.Cleric;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClassInformation;

public class CascadeOfLight extends HeroPower {
    public CascadeOfLight() {
        powerName = "Cascade of Light";
        characterClass = HeroClassInformation.CharacterClasses.Cleric.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Wisdom.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Will.toString();
        damageDiceDealt = 3;
        damageModifier = HeroClassInformation.Attributes.Wisdom.toString();
        typeOfDamageDice = 8;
        isThisWeaponDamage = false;
        hitDescription = "3d8 + Wisdom modifier radiant damage, and the target gains vulnerable 5 to all damage from your attacks (save ends).\n" +
                "\n" +
                "Miss: Half damage.";

    }
}
