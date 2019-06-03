package DungeonCrawl.Monsters;

import javafx.scene.image.Image;
import DungeonCrawl.Model.Monster;

public class GoblinSharpshooter extends Monster {

    public GoblinSharpshooter() {
        this.setID(101);
        this.setHitPoints(31);
        this.setAC(16);
        this.setFortitude(12);
        this.setReflex(14);
        this.setWill(11);
        this.setHeroName("Goblin Sharpshooter");
        this.setMonsterType("Humanoid");
        this.setMonsterImage(new Image(getClass().getResourceAsStream("MonsterImages\\GoblinSharpshooter.png")));
        this.setXpValue(125);
        this.setInitiativeBonus(5);
        this.setAttack1Name("Short Sword");
        this.setAttack1Name("Hand Crossbow");
        this.setAttack1toHitBonus(6);
        this.setAttack1toHitBonus(9);
        this.setAttack1DamageDiceType(6);
        this.setAttack2DamageDiceType(6);
        this.setAttack1DamageDiceAmount(1);
        this.setAttack2DamageDiceAmount(1);
        this.setAttack1DamageBonus(2);
        this.setAttack2DamageBonus(4);
        this.setAttack1DefenseToBeChecked("AC");
        this.setAttack2DefenseToBeChecked("AC");
        this.setPassive1Description("When a goblin sharpshooter makes a ranged attack from hiding\n" +
                "and misses, it is still considered to be hiding.");
        this.setPassive1Description("The goblin sharpshooter deals an extra 1d6 damage against any\n" +
                "target it has combat advantage against.");
        super.updateTheDefensesMap();
    }

}
