package sample.Model;

import javafx.scene.image.Image;

public class Monster extends Creature {
    private String heroName;
    public String monsterType;
    private int hitPoints;
    private int someResource;
    private String imagePath;
    public Image monsterImage = new Image(getClass().getResourceAsStream("Images\\icon1.png"));
    private double speed = 6;

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setGold(int gold) {
        this.someResource = gold;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getHeroName() {
        return heroName;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getGold() {
        return someResource;
    }

    public String getImagePath() {
        return imagePath;
    }

    public double getSpeed() {
        return speed;
    }

}
