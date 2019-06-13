package DungeonCrawl.HeroPowers.Sorcerer;

import DungeonCrawl.StaticRules.HeroClassInformation;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class ChaosBolt extends HeroPower {
    public ChaosBolt() {
        powerName = "Chaos Bolt";
        characterClass = HeroClasses.Sorcerer.toString();
        typeOfPower = TypesOfPowers.AT_WILL.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 10;
        numberOfTargets = "one target";
        attributeUsedToHit = AttributeNames.Charisma.toString();
        defenseToBeChecked = CreatureDefenses.Will.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 10;
        damageModifier = AttributeNames.Charisma.toString();
        isThisWeaponDamage = false;
        hitDescription = "Wild Magic: If you roll an even number for the primary attack roll and hit your target, make a secondary attack.\n" +
                "Secondary target: One creature within 5 squares of the target last hit by this power.\n" +
                "Secondary attack: Charisma vs. Will\n" +
                "Hit: 1d6 psychic damage. If you rolled an even number for the secondary attack roll, repeat the secondary attack. You can attack a creature only once with a single use of this power.";
    }
}
