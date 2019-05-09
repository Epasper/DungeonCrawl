package sample;

import javafx.scene.image.Image;

public class Hero extends Creature {

    private int hitPoints;
    private int someResource;
    private String imagePath;
    Image heroImage = new Image(getClass().getResourceAsStream("Images\\icon1.png"));

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setSomeResource(int someResource) {
        this.someResource = someResource;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setHeroImage(Image heroImage) {
        this.heroImage = heroImage;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
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

    public Image getHeroImage() {
        return heroImage;
    }

    public double getSpeed() {
        return speed;
    }

    void attackAMonster(Monster attackedMonster) {
        System.out.println("Hero: " + this.heroName + ", a " + this.heroClass + ", has attacked a(n) " + attackedMonster.monsterType + " monster");
    }

}
