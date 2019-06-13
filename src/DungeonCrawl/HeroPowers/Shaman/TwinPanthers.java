package DungeonCrawl.HeroPowers.Shaman;


import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClasses;
import DungeonCrawl.StaticRules.TypesOfPowers;
import DungeonCrawl.StaticRules.AttributeNames;
import DungeonCrawl.StaticRules.CreatureDefenses;
import DungeonCrawl.StaticRules.TypesOfActions;

public class TwinPanthers extends HeroPower {
    public TwinPanthers() {
        powerName = "Twin Panthers";
        characterClass = HeroClasses.Shaman.toString();
        typeOfPower = TypesOfPowers.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = TypesOfActions.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 5;
        numberOfTargets = "One target";
        attributeUsedToHit = AttributeNames.Wisdom.toString();
        defenseToBeChecked = CreatureDefenses.Reflex.toString();
        damageDiceDealt = 1;
        typeOfDamageDice = 6;
        damageModifier = AttributeNames.Wisdom.toString();
        isThisWeaponDamage = false;
        powersAdditionalOptions = "Stalker Spirit";
        hitDescription = "Stalker Spirit: If the target is bloodied, the attack roll gains a bonus equal to the user's Intelligence modifier.\n" +
                "\n" +
                "Hit: 1d8 + Wisdom modifier damage. Until the end of the user's next turn, the user or his or her allies gain combat advantage on melee attacks against any enemy adjacent to the user's spirit companion.\n" +
                "\n" +
                "Effect: Make the attack one more time against the same target or a different target.";
    }
}
