package DungeonCrawl.HeroPowers.Sorcerer;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class BedevilingBurst extends HeroPower {
    public BedevilingBurst() {
        setPowerName("Bedeviling Burst");
        setCharacterClass(HeroClasses.Sorcerer.toString());
        setTypeOfPower(TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(5);
        setNumberOfTargets("One or Two targets");
        setAttributeUsedToHit(AttributeNames.Charisma.toString());
        setDefenseToBeChecked(CreatureDefenses.Will.toString());
        setDamageDiceDealt(1);
        setTypeOfDamageDice(10);
        setDamageModifier(AttributeNames.Charisma.toString());
        setThisWeaponDamage(false);
        setHitDescription("1d10 + Charisma modifier psychic damage, and you push the target a number of squares equal to your Dexterity modifier.\n\nSpecial: Wild Magic:If you rolled an even number on the attack roll, you slide the target instead of pushing it.");
    }
}
