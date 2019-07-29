package DungeonCrawl.Model;

import javafx.scene.image.Image;

public class Monster extends Creature {
    private String monsterName;
    private String monsterType;
    private int xpValue;
    private int initiativeBonus;
    private String attack1Name;
    private String attack2Name;
    private String attack3Name;
    private int attack1toHitBonus;
    private int attack2toHitBonus;
    private int attack3toHitBonus;
    private String attack1Description;
    private String attack2Description;
    private String attack3Description;
    private int attack1DamageDiceType;
    private int attack2DamageDiceType;
    private int attack3DamageDiceType;
    private int attack1DamageDiceAmount;
    private int attack2DamageDiceAmount;
    private int attack3DamageDiceAmount;
    private int attack1DamageBonus;
    private int attack2DamageBonus;
    private int attack3DamageBonus;
    private String attack1DefenseToBeChecked;
    private String attack2DefenseToBeChecked;
    private String attack3DefenseToBeChecked;
    private String loreDescription;
    private String passive1Description;
    private String passive2Description;
    private String passive3Description;

    @Override
    public String toString() {
        return " Monster name: " + getMonsterName() + " Monster type: " + getMonsterType();
    }

    public Monster() {
    }

    public String getLoreDescription() {
        return loreDescription;
    }

    public void setLoreDescription(String loreDescription) {
        this.loreDescription = loreDescription;
    }

    public String getPassive1Description() {
        return passive1Description;
    }

    public void setPassive1Description(String passive1Description) {
        this.passive1Description = passive1Description;
    }

    public String getPassive2Description() {
        return passive2Description;
    }

    public void setPassive2Description(String passive2Description) {
        this.passive2Description = passive2Description;
    }

    public String getPassive3Description() {
        return passive3Description;
    }

    public void setPassive3Description(String passive3Description) {
        this.passive3Description = passive3Description;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }


    public int getXpValue() {
        return xpValue;
    }

    public void setXpValue(int xpValue) {
        this.xpValue = xpValue;
    }

    public int getInitiativeBonus() {
        return initiativeBonus;
    }

    public void setInitiativeBonus(int initiativeBonus) {
        this.initiativeBonus = initiativeBonus;
    }

    public String getAttack1Name() {
        return attack1Name;
    }

    public void setAttack1Name(String attack1Name) {
        this.attack1Name = attack1Name;
    }

    public String getAttack2Name() {
        return attack2Name;
    }

    public void setAttack2Name(String attack2Name) {
        this.attack2Name = attack2Name;
    }

    public String getAttack3Name() {
        return attack3Name;
    }

    public void setAttack3Name(String attack3Name) {
        this.attack3Name = attack3Name;
    }

    public int getAttack1toHitBonus() {
        return attack1toHitBonus;
    }

    public void setAttack1toHitBonus(int attack1toHitBonus) {
        this.attack1toHitBonus = attack1toHitBonus;
    }

    public int getAttack2toHitBonus() {
        return attack2toHitBonus;
    }

    public void setAttack2toHitBonus(int attack2toHitBonus) {
        this.attack2toHitBonus = attack2toHitBonus;
    }

    public int getAttack3toHitBonus() {
        return attack3toHitBonus;
    }

    public void setAttack3toHitBonus(int attack3toHitBonus) {
        this.attack3toHitBonus = attack3toHitBonus;
    }

    public String getAttack1Description() {
        return attack1Description;
    }

    public void setAttack1Description(String attack1Description) {
        this.attack1Description = attack1Description;
    }

    public String getAttack2Description() {
        return attack2Description;
    }

    public void setAttack2Description(String attack2Description) {
        this.attack2Description = attack2Description;
    }

    public String getAttack3Description() {
        return attack3Description;
    }

    public void setAttack3Description(String attack3Description) {
        this.attack3Description = attack3Description;
    }

    public int getAttack1DamageDiceType() {
        return attack1DamageDiceType;
    }

    public void setAttack1DamageDiceType(int attack1DamageDiceType) {
        this.attack1DamageDiceType = attack1DamageDiceType;
    }

    public int getAttack2DamageDiceType() {
        return attack2DamageDiceType;
    }

    public void setAttack2DamageDiceType(int attack2DamageDiceType) {
        this.attack2DamageDiceType = attack2DamageDiceType;
    }

    public int getAttack3DamageDiceType() {
        return attack3DamageDiceType;
    }

    public void setAttack3DamageDiceType(int attack3DamageDiceType) {
        this.attack3DamageDiceType = attack3DamageDiceType;
    }

    public int getAttack1DamageDiceAmount() {
        return attack1DamageDiceAmount;
    }

    public void setAttack1DamageDiceAmount(int attack1DamageDiceAmount) {
        this.attack1DamageDiceAmount = attack1DamageDiceAmount;
    }

    public int getAttack2DamageDiceAmount() {
        return attack2DamageDiceAmount;
    }

    public void setAttack2DamageDiceAmount(int attack2DamageDiceAmount) {
        this.attack2DamageDiceAmount = attack2DamageDiceAmount;
    }

    public int getAttack3DamageDiceAmount() {
        return attack3DamageDiceAmount;
    }

    public void setAttack3DamageDiceAmount(int attack3DamageDiceAmount) {
        this.attack3DamageDiceAmount = attack3DamageDiceAmount;
    }

    public int getAttack1DamageBonus() {
        return attack1DamageBonus;
    }

    public void setAttack1DamageBonus(int attack1DamageBonus) {
        this.attack1DamageBonus = attack1DamageBonus;
    }

    public int getAttack2DamageBonus() {
        return attack2DamageBonus;
    }

    public void setAttack2DamageBonus(int attack2DamageBonus) {
        this.attack2DamageBonus = attack2DamageBonus;
    }

    public int getAttack3DamageBonus() {
        return attack3DamageBonus;
    }

    public void setAttack3DamageBonus(int attack3DamageBonus) {
        this.attack3DamageBonus = attack3DamageBonus;
    }

    public String getAttack1DefenseToBeChecked() {
        return attack1DefenseToBeChecked;
    }

    public void setAttack1DefenseToBeChecked(String attack1DefenseToBeChecked) {
        this.attack1DefenseToBeChecked = attack1DefenseToBeChecked;
    }

    public String getAttack2DefenseToBeChecked() {
        return attack2DefenseToBeChecked;
    }

    public void setAttack2DefenseToBeChecked(String attack2DefenseToBeChecked) {
        this.attack2DefenseToBeChecked = attack2DefenseToBeChecked;
    }

    public String getAttack3DefenseToBeChecked() {
        return attack3DefenseToBeChecked;
    }

    public void setAttack3DefenseToBeChecked(String attack3DefenseToBeChecked) {
        this.attack3DefenseToBeChecked = attack3DefenseToBeChecked;
    }

    public void setHeroName(String monsterName) {
        this.monsterName = monsterName;
    }

    public String getMonsterName() {
        return monsterName;
    }

}
