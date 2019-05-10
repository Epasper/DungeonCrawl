package sample.Model;

public class Creature {
    public String heroName;
    public int ID;
    public int mapXPos;
    public int mapYPos;
    public String heroClass;
    public String heroRace;
    private int hitPoints;
    private int someResource;
    public double speed = 6;
    private double currentSpeed = speed;

    public String getHeroRace() {
        return heroRace;
    }

    public void setHeroRace(String heroRace) {
        this.heroRace = heroRace;
    }

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

    public void setGold(int gold) {
        this.someResource = gold;
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

    public int getGold() {
        return someResource;
    }

    public double getSpeed() {
        return speed;
    }
}
