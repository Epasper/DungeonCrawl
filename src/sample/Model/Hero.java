package sample.Model;

import javafx.scene.image.Image;

public class Hero extends Creature {

    private int hitPoints;
    private int someResource;
    private String imagePath;

    //todo fix the issue with image path; probably path have to be set for absolute path, not local.

    public Image heroImage = new Image(getClass().getResourceAsStream("Images\\icon1.png"));

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


    public double getSpeed() {
        return speed;
    }

    public void attackAMonster(Monster attackedMonster) {
        System.out.println("Hero: " + this.heroName + ", a " + this.heroClass + ", has attacked a(n) " + attackedMonster.monsterType + " monster");
    }

}
