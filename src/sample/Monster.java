package sample;

import javafx.scene.image.Image;

public class Monster extends Creature {
    String heroName;
    int monsterID; //Greater than 100 for identification purposes
    //int mapXPos;
    //int mapYPos;
    String monsterType;
    int hitPoints;
    int someResource;
    private String imagePath;
    Image monsterImage = new Image(getClass().getResourceAsStream("Images\\icon1.png"));
    double speed = 6;

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public void setMonsterID(int monsterID) {
        this.monsterID = monsterID;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setSomeResource(int someResource) {
        this.someResource = someResource;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setMonsterImage(Image monsterImage) {
        this.monsterImage = monsterImage;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getHeroName() {
        return heroName;
    }

    public int getMonsterID() {
        return monsterID;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getSomeResource() {
        return someResource;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Image getMonsterImage() {
        return monsterImage;
    }

    public double getSpeed() {
        return speed;
    }

}
