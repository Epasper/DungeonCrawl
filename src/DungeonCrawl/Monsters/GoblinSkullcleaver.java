package DungeonCrawl.Monsters;

import javafx.scene.image.Image;
import DungeonCrawl.Model.Monster;

public class GoblinSkullcleaver extends Monster {

    public GoblinSkullcleaver() {
        this.setLevel(3);
        this.setID(102);
        this.setHitPoints(53);
        this.setCurrentHitPoints(53);
        this.setAC(16);
        this.setFortitude(15);
        this.setReflex(14);
        this.setWill(12);
        this.setHeroName("Goblin Skullcleaver");
        this.setMonsterType("Humanoid");
        this.setCreatureIcon(new Image(getClass().getResourceAsStream("MonsterImages\\GoblinSkullcleaver.png")));
        this.setXpValue(150);
        this.setInitiativeBonus(5);
        this.setAttack1Name("Battleaxe");
        this.setAttack1toHitBonus(6);
        this.setAttack1DamageDiceType(10);
        this.setAttack1DamageDiceAmount(1);
        this.setAttack1DamageBonus(5);
        this.setAttack1DefenseToBeChecked("AC");
        super.updateTheDefensesMap();
    }

}
