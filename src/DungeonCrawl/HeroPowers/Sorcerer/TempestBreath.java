package DungeonCrawl.HeroPowers.Sorcerer;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;

public class TempestBreath extends HeroPower {
    public TempestBreath() {
        powerName = "Burning Spray";
        characterClass = HeroClassInformation.CharacterClasses.Sorcerer.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "Close Blast 3";
        attributeUsedToHit = HeroClassInformation.Attributes.Charisma.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.Reflex.toString();
        damageDiceDealt = 3;
        typeOfDamageDice = 6;
        damageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = false;
        bonusDamageModifier = HeroClassInformation.Attributes.Strength.toString();
        hitDescription = "2d6 + Charisma modifier acid damage, and the target can’t gain combat advantage against any creature until the end of your next turn. \n\nDragon Magic: You gain concealment until the end of your next turn.";
    }
}
