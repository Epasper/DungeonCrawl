package DungeonCrawl.HeroPowers.Paladin;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.*;

public class RadiantDelirium extends HeroPower {
    public RadiantDelirium() {
        setPowerName("Radiant Delirium");
        setCharacterClass(HeroClasses.Paladin.toString());
        setTypeOfPower(TypesOfPowers.DAILY.toString().replace('_', ' ').toLowerCase());
        setUsedAction(TypesOfActions.STANDARD.toString().toLowerCase());
        setPowerLevel(1);
        setRange(5);
        setNumberOfTargets("One target");
        setAttributeUsedToHit(AttributeNames.Charisma.toString());
        setDefenseToBeChecked(CreatureDefenses.Will.toString());
        setDamageDiceDealt(3);
        setTypeOfDamageDice(8);
        setDamageModifier(AttributeNames.Charisma.toString());
        setThisWeaponDamage(false);
        setHitDescription("Hit: 3d8 + Charisma modifier radiant damage, and the target is dazed until the end of your next turn. In addition, the target takes a −2 penalty to AC (save ends).\n" +
                "\n" +
                "Miss: Half damage, and the target is dazed until the end of your next turn.");
    }
}
