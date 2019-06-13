package DungeonCrawl.HeroPowers.Sorcerer;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class BedevilingBurst extends HeroPower {
    public BedevilingBurst() {
        powerName = "Bedeviling Burst";
        characterClass = HeroClasses.Sorcerer.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 5;
        numberOfTargets = "One or Two targets";
        attributeUsedToHit = AttributeNames.Charisma.toString();
        defenseToBeChecked = CreatureDefenses.Will.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 10;
        damageModifier = AttributeNames.Charisma.toString();
        isThisWeaponDamage = false;
        hitDescription = "1d10 + Charisma modifier psychic damage, and you push the target a number of squares equal to your Dexterity modifier.\n\nSpecial: Wild Magic:If you rolled an even number on the attack roll, you slide the target instead of pushing it.";
    }
}
