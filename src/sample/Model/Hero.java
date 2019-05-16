package sample.Model;

import javafx.scene.image.Image;
import sample.HeroPowers.HeroPower;

import java.util.ArrayList;
import java.util.List;

public class Hero extends Creature {

    private String heroClass;
    private String heroRace;
    private int heroLevel;
    private int heroExperience;
    private List<HeroPower> atWillPowers = new ArrayList<>();
    private List<HeroPower> encounterPowers = new ArrayList<>();
    private List<HeroPower> dailyPowers = new ArrayList<>();
    private int gold;
    private int heroIconId;
    private int strength;
    private int constitution;
    private int dexterity;
    private int intelligence;
    private int wisdom;
    private int charisma;
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
    //todo remove all icons from HDD after reconnecting things to SQL
    private Image heroIcon = new Image(getClass().getResourceAsStream("icon1.png"));

    public Hero() {
    }

    public String getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public String getHeroRace() {
        return heroRace;
    }

    public void setHeroRace(String heroRace) {
        this.heroRace = heroRace;
    }

    public int getHeroLevel() {
        return heroLevel;
    }

    public void setHeroLevel(int heroLevel) {
        this.heroLevel = heroLevel;
    }

    public int getHeroExperience() {
        return heroExperience;
    }

    public void setHeroExperience(int heroExperience) {
        this.heroExperience = heroExperience;
    }

    public List<HeroPower> getAtWillPowers() {
        return atWillPowers;
    }

    public void setAtWillPowers(List<HeroPower> atWillPowers) {
        this.atWillPowers = atWillPowers;
    }

    public List<HeroPower> getEncounterPowers() {
        return encounterPowers;
    }

    public void setEncounterPowers(List<HeroPower> encounterPowers) {
        this.encounterPowers = encounterPowers;
    }

    public List<HeroPower> getDailyPowers() {
        return dailyPowers;
    }

    public void setDailyPowers(List<HeroPower> dailyPowers) {
        this.dailyPowers = dailyPowers;
    }

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

    public Image getHeroIcon() {
        return heroIcon;
    }


    public void setGold(int gold) {
        this.gold = gold;
    }


    public void setHeroIcon(Image heroIcon) {
        this.heroIcon = heroIcon;
    }


    public int getGold() {
        return gold;
    }

//todo add a proper attack method.
    public void attackAMonster(Monster attackedMonster) {
        System.out.println("Hero: " + this.heroName + ", a " + this.heroClass + ", has attacked a(n) " + attackedMonster.getMonsterType() + " monster");
    }

}
