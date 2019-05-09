package sample;

import javafx.scene.image.Image;

public class Creature {
    String heroName;
    int ID;
    int mapXPos;
    int mapYPos;
    String heroClass;
    private int hitPoints;
    private int someResource;
    private String imagePath;
    double speed = 6;
    private double currentSpeed = speed;

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setMapXPos(int mapXPos) {
        this.mapXPos = mapXPos;
    }

    public void setMapYPos(int mapYPos) {
        this.mapYPos = mapYPos;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
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

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getHeroName() {
        return heroName;
    }

    public int getID() {
        return ID;
    }

    public int getMapXPos() {
        return mapXPos;
    }

    public int getMapYPos() {
        return mapYPos;
    }

    public String getHeroClass() {
        return heroClass;
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
}
