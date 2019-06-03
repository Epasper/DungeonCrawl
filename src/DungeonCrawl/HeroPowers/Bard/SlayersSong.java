package DungeonCrawl.HeroPowers.Bard;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.StaticRules.HeroClassInformation;

public class SlayersSong extends HeroPower {
    public SlayersSong() {
        powerName = "Slayer's Song";
        characterClass = HeroClassInformation.CharacterClasses.Bard.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.DAILY.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Charisma.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 2;
        damageModifier = HeroClassInformation.Attributes.Charisma.toString();
        isThisWeaponDamage = true;
        hitDescription = "2[W] + Charisma modifier damage, and the target grants combat advantage to you and your allies (save ends).\n" +
                "\n" +
                "Miss: Half damage.\n" +
                "\n" +
                "Effect: Until the end of the encounter, whenever you hit an enemy, that enemy grants combat advantage to you and your allies until the end of your next turn.";
    }
}
