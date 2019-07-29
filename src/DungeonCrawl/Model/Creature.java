package DungeonCrawl.Model;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class Creature {
    private String heroName;
    private Image creatureIcon;
    private Image creaturePortrait;
    private int ID;
    private int currentMonsterUniqueID;
    private int mapXPos;
    private int mapYPos;
    private int hitPoints;
    private int currentHitPoints;
    private double speed = 6;
    private double currentSpeed = speed;
    private int fortitude;
    private int reflex;
    private int will;
    private int AC;
    private int currentInitiative;
    private int initiativeBonus;
    private Map<String, Integer> defensesMap = new HashMap<>();
    private boolean isThisCreatureDead = false;
    private boolean isThisCreatureBloodied = false;
    private int attackRange = 1;
    private boolean finishedMovement;

    public Image getCreaturePortrait() {
        return creaturePortrait;
    }

    public void setCreaturePortrait(Image creaturePortrait) {
        this.creaturePortrait = creaturePortrait;
    }

    public boolean isThisCreatureBloodied() {
        return isThisCreatureBloodied;
    }

    public void setThisCreatureBloodied(boolean thisCreatureBloodied) {
        isThisCreatureBloodied = thisCreatureBloodied;
    }

    public boolean isFinishedMovement() {
        return finishedMovement;
    }

    public void setFinishedMovement(boolean finishedMovement) {
        this.finishedMovement = finishedMovement;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public boolean isThisCreatureDead() {
        return isThisCreatureDead;
    }

    public void setThisCreatureDead(boolean thisCreatureDead) {
        isThisCreatureDead = thisCreatureDead;
    }

    public Image getCreatureIcon() {
        return creatureIcon;
    }

    public void setCreatureIcon(Image creatureIcon) {
        this.creatureIcon = creatureIcon;
    }

    public int getCurrentMonsterUniqueID() {
        return currentMonsterUniqueID;
    }

    public int getInitiativeBonus() {
        return initiativeBonus;
    }

    public void setInitiativeBonus(int initiativeBonus) {
        this.initiativeBonus = initiativeBonus;
    }

    public int getCurrentInitiative() {
        return currentInitiative;
    }

    public void setCurrentInitiative(int currentInitiative) {
        this.currentInitiative = currentInitiative;
    }

    public void setCurrentMonsterUniqueID(int currentMonsterUniqueID) {
        this.currentMonsterUniqueID = currentMonsterUniqueID;
    }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(int currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
    }

    public Creature() {
    }

    public void updateTheDefensesMap() {
        defensesMap.put("ac", AC);
        defensesMap.put("reflex", reflex);
        defensesMap.put("fortitude", fortitude);
        defensesMap.put("will", will);
    }

    public Map<String, Integer> getDefensesMap() {
        return defensesMap;
    }

    public void setDefensesMap(Map<String, Integer> defensesMap) {
        this.defensesMap = defensesMap;
    }

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
        return getHeroName();
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
