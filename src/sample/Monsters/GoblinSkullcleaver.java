package sample.Monsters;

import javafx.scene.image.Image;
import sample.Model.Monster;

public class GoblinSkullcleaver extends Monster {

    public GoblinSkullcleaver() {
        this.setHitPoints(53);
        this.setAC(16);
        this.setFortitude(15);
        this.setReflex(14);
        this.setWill(12);
        this.setMonsterName("Goblin Skullcleaver");
        this.setMonsterType("Humanoid");
        this.setMonsterImage(new Image(getClass().getResourceAsStream("Images\\GoblinSkullcleaver.png")));
        this.setXpValue(150);
        this.setInitiativeBonus(5);
        this.setAttack1Name("Battleaxe");
        this.setAttack1toHitBonus(6);
        this.setAttack1DamageDiceType(10);
        this.setAttack1DamageDiceAmount(1);
        this.setAttack1DamageBonus(5);
        this.setAttack1DefenseToBeChecked("AC");
    }

}
