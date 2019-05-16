package sample.Model;

public class Creature {
    public String heroName;
    private int ID;
    private int mapXPos;
    private int mapYPos;
    private int hitPoints;
    private double speed = 6;
    private double currentSpeed = speed;
    private int fortitude;
    private int reflex;
    private int will;
    private int AC;

    public int getFortitude() {
        return fortitude;
    }

    public int getAC() {
        return AC;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setAC(int AC) {
        this.AC = AC;
    }

    public void setFortitude(int fortitude) {
        this.fortitude = fortitude;
    }

    public int getReflex() {
        return reflex;
    }

    public void setReflex(int reflex) {
        this.reflex = reflex;
    }

    public int getWill() {
        return will;
    }

    public void setWill(int will) {
        this.will = will;
    }

    public void setHeroName(String monsterName) {
        this.heroName = monsterName;
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

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getMonsterName() {
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

    public int getHitPoints() {
        return hitPoints;
    }

    public double getSpeed() {
        return speed;
    }
}
