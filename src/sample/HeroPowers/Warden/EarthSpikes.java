package sample.HeroPowers.Warden;

import sample.HeroClassInformation;
import sample.HeroPowers.HeroPower;

public class EarthSpikes extends HeroPower {
    public EarthSpikes() {
        powerName = "Earth Spikes";
        characterClass = HeroClassInformation.CharacterClasses.Warden.toString();
        typeOfPower = HeroClassInformation.TypeOfPower.ENCOUNTER.toString().replace('_', ' ').toLowerCase();
        usedAction = HeroClassInformation.ExpandedAction.STANDARD.toString().toLowerCase();
        powerLevel = 1;
        range = 0;
        numberOfTargets = "One target";
        attributeUsedToHit = HeroClassInformation.Attributes.Strength.toString();
        defenseToBeChecked = HeroClassInformation.Defenses.AC.toString();
        damageDiceDealt = 1;
        damageModifier = HeroClassInformation.Attributes.Strength.toString();
        isThisWeaponDamage = true;
        hitDescription = "1[W] + Strength modifier damage. Until the end of your next turn, the target's space and each square adjacent to it are filled with spikes. Any enemy that enters this spike-filled area or starts its turn there takes 5 damage. ";
    }
}
