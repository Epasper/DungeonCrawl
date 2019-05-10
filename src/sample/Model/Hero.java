package sample.Model;

import javafx.scene.image.Image;

public class Hero extends Creature {

    private int hitPoints;
    private int gold;
    private int heroIconId;
    private int strength;
    private int constitution;
    private int dexterity;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int fortitude;
    private int reflex;
    private int will;
    private int Acrobatics;
    private int Arcana;
    private int Athletics;
    private int Bluff;
    private int Diplomacy;
    private int Dungeoneering;
    private int Endurance;
    private int Heal;
    private int History;
    private int Insight;
    private int Intimidate;
    private int Nature;
    private int Perception;
    private int Religion;
    private int Stealth;
    private int Streetwise;
    private int Thievery;

    public int getHeroIconId() {
        return heroIconId;
    }

    public void setHeroIconId(int heroIconId) {
        this.heroIconId = heroIconId;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getFortitude() {
        return fortitude;
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

    public int getAcrobatics() {
        return Acrobatics;
    }

    public void setAcrobatics(int acrobatics) {
        Acrobatics = acrobatics;
    }

    public int getArcana() {
        return Arcana;
    }

    public void setArcana(int arcana) {
        Arcana = arcana;
    }

    public int getAthletics() {
        return Athletics;
    }

    public void setAthletics(int athletics) {
        Athletics = athletics;
    }

    public int getBluff() {
        return Bluff;
    }

    public void setBluff(int bluff) {
        Bluff = bluff;
    }

    public int getDiplomacy() {
        return Diplomacy;
    }

    public void setDiplomacy(int diplomacy) {
        Diplomacy = diplomacy;
    }

    public int getDungeoneering() {
        return Dungeoneering;
    }

    public void setDungeoneering(int dungeoneering) {
        Dungeoneering = dungeoneering;
    }

    public int getEndurance() {
        return Endurance;
    }

    public void setEndurance(int endurance) {
        Endurance = endurance;
    }

    public int getHeal() {
        return Heal;
    }

    public void setHeal(int heal) {
        Heal = heal;
    }

    public int getHistory() {
        return History;
    }

    public void setHistory(int history) {
        History = history;
    }

    public int getInsight() {
        return Insight;
    }

    public void setInsight(int insight) {
        Insight = insight;
    }

    public int getIntimidate() {
        return Intimidate;
    }

    public void setIntimidate(int intimidate) {
        Intimidate = intimidate;
    }

    public int getNature() {
        return Nature;
    }

    public void setNature(int nature) {
        Nature = nature;
    }

    public int getPerception() {
        return Perception;
    }

    public void setPerception(int perception) {
        Perception = perception;
    }

    public int getReligion() {
        return Religion;
    }

    public void setReligion(int religion) {
        Religion = religion;
    }

    public int getStealth() {
        return Stealth;
    }

    public void setStealth(int stealth) {
        Stealth = stealth;
    }

    public int getStreetwise() {
        return Streetwise;
    }

    public void setStreetwise(int streetwise) {
        Streetwise = streetwise;
    }

    public int getThievery() {
        return Thievery;
    }

    public void setThievery(int thievery) {
        Thievery = thievery;
    }

    public Image getHeroImage() {
        return heroImage;
    }
    public Image heroImage = new Image(getClass().getResourceAsStream("Images\\icon1.png"));

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setGold(int gold) {
        this.gold = gold;
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

    public int getGold() {
        return gold;
    }

    public double getSpeed() {
        return speed;
    }

    public void attackAMonster(Monster attackedMonster) {
        System.out.println("Hero: " + this.heroName + ", a " + this.heroClass + ", has attacked a(n) " + attackedMonster.monsterType + " monster");
    }

}
