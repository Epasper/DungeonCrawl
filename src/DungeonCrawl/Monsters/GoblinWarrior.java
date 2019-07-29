package DungeonCrawl.Monsters;

import javafx.scene.image.Image;
import DungeonCrawl.Model.Monster;

public class GoblinWarrior extends Monster {

    public GoblinWarrior() {
        this.setID(103);
        this.setHitPoints(29);
        this.setCurrentHitPoints(29);
        this.setAC(17);
        this.setFortitude(13);
        this.setReflex(15);
        this.setWill(12);
        this.setHeroName("Goblin Warrior");
        this.setMonsterType("Humanoid");
        this.setCreatureIcon(new Image(getClass().getResourceAsStream("MonsterImages\\GoblinWarrior.png")));
        this.setXpValue(100);
        this.setInitiativeBonus(5);
        this.setAttack1Name("Spear");
        this.setAttack1Name("Javelin");
        this.setAttack1toHitBonus(6);
        this.setAttack1toHitBonus(6);
        this.setAttack1DamageDiceType(8);
        this.setAttack2DamageDiceType(6);
        this.setAttack1DamageDiceAmount(1);
        this.setAttack2DamageDiceAmount(1);
        this.setAttack1DamageBonus(2);
        this.setAttack2DamageBonus(2);
        this.setAttack1DefenseToBeChecked("AC");
        this.setAttack2DefenseToBeChecked("AC");
        this.setPassive1Description("If, on its turn, the goblin warrior ends its move at least 4 squares\n" +
                "away from its starting point, it deals an extra 1d6 damage on its\n" +
                "ranged attacks until the start of its next turn.");
        this.setPassive1Description("The goblin warrior can move up to half its speed; at any point\n" +
                "during that movement, it makes one ranged attack without\n" +
                "provoking an opportunity attack.");
        super.updateTheDefensesMap();
    }

}
