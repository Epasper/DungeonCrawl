package DungeonCrawl.DTO;


import DungeonCrawl.Items.Item;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class HeroDTO {

    private int heroID;
    private String heroName;
    private String heroClass;
    private String heroRace;
    private int heroLevel;
    private int hitPoints;
    private int gold;
    private double speed = 6;
    private String atWillPower1;
    private String atWillPower1IconID = "-1";
    private String atWillPower2;
    private String atWillPower2IconID = "-1";
    private String encounterPower1;
    private String encounterPowerIconID = "-1";
    private String dailyPower1;
    private String dailyPowerIconID = "-1";
    private String allAtWillPowers;
    private String allEncounterPowers;
    private String allDailyPowers;
    private int heroIconId = 0;
    private int strength;
    private int constitution;
    private int dexterity;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int ac;
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
    private Image heroImage;
    private List<String> heroEquipment = new ArrayList<>();
    private List<String> heroEquipmentNames = new ArrayList<>();

    public String getAtWillPower1IconID() {
        return atWillPower1IconID;
    }

    public void setAtWillPower1IconID(String atWillPower1IconID) {
        this.atWillPower1IconID = atWillPower1IconID;
    }

    public String getAtWillPower2IconID() {
        return atWillPower2IconID;
    }

    public void setAtWillPower2IconID(String atWillPower2IconID) {
        this.atWillPower2IconID = atWillPower2IconID;
    }

    public String getEncounterPowerIconID() {
        return encounterPowerIconID;
    }

    public void setEncounterPowerIconID(String encounterPowerIconID) {
        this.encounterPowerIconID = encounterPowerIconID;
    }

    public String getDailyPowerIconID() {
        return dailyPowerIconID;
    }

    public void setDailyPowerIconID(String dailyPowerIconID) {
        this.dailyPowerIconID = dailyPowerIconID;
    }

    public int getHeroLevel() {
        return heroLevel;
    }

    public void setHeroLevel(int heroLevel) {
        this.heroLevel = heroLevel;
    }

    public String getAllAtWillPowers() {
        return allAtWillPowers;
    }

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public void setAllAtWillPowers(String allAtWillPowers) {
        this.allAtWillPowers = allAtWillPowers;
    }

    public String getAllEncounterPowers() {
        return allEncounterPowers;
    }

    public void setAllEncounterPowers(String allEncounterPowers) {
        this.allEncounterPowers = allEncounterPowers;
    }

    public String getAllDailyPowers() {
        return allDailyPowers;
    }

    public void setAllDailyPowers(String allDailyPowers) {
        this.allDailyPowers = allDailyPowers;
    }

    public Image getHeroImage() {
        return heroImage;
    }

    public void setHeroImage(Image heroImage) {
        this.heroImage = heroImage;
    }

    public int getHeroID() {
        return heroID;
    }

    public void setHeroID(int heroID) {
        this.heroID = heroID;
    }

    public int getHeroIconId() {
        return heroIconId;
    }

    public void setHeroIconId(int heroIconId) {
        this.heroIconId = heroIconId;
    }

    public String getHeroRace() {
        return heroRace;
    }

    public void setHeroRace(String heroRace) {
        this.heroRace = heroRace;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getAtWillPower1() {
        return atWillPower1;
    }

    public void setAtWillPower1(String atWillPower1) {
        this.atWillPower1 = atWillPower1;
    }

    public String getAtWillPower2() {
        return atWillPower2;
    }

    public void setAtWillPower2(String atWillPower2) {
        this.atWillPower2 = atWillPower2;
    }

    public String getEncounterPower1() {
        return encounterPower1;
    }

    public void setEncounterPower1(String encounterPower1) {
        this.encounterPower1 = encounterPower1;
    }

    public String getDailyPower1() {
        return dailyPower1;
    }

    public void setDailyPower1(String dailyPower1) {
        this.dailyPower1 = dailyPower1;
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


    public List<String> getHeroEquipmentNames() {
        return heroEquipmentNames;
    }

    public void setHeroEquipmentNames(List<String> heroEquipmentNames) {
        this.heroEquipmentNames = heroEquipmentNames;
    }

    public List<String> getHeroEquipment() {
        return heroEquipment;
    }

    public void setHeroEquipment(List<String> heroEquipment) {
        this.heroEquipment = heroEquipment;
    }
}
