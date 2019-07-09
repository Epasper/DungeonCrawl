package DungeonCrawl.Model;

import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.Items.Item;

import java.util.*;

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
    private int acrobatics;
    private int arcana;
    private int athletics;
    private int bluff;
    private int diplomacy;
    private int dungeoneering;
    private int endurance;
    private int heal;
    private int history;
    private int insight;
    private int intimidate;
    private int nature;
    private int perception;
    private int religion;
    private int stealth;
    private int streetwise;
    private int thievery;
    private Map<String, Integer> heroAttributesMap;
    private Map<String, Item> heroEquipment;
    private int aggressionLevel = 5;

    public int getAggressionLevel() {
        return aggressionLevel;
    }

    public void setAggressionLevel(int aggressionLevel) {
        this.aggressionLevel = aggressionLevel;
    }

    public Map<String, Item> getHeroEquipment() {
        return heroEquipment;
    }

    public void setHeroEquipment(Map<String, Item> heroEquipment) {
        this.heroEquipment = heroEquipment;
    }

    public Hero() {
    }

    public void updateTheAttributesMap() {
        Map<String, Integer> heroAttributesMap = new HashMap<>();
        heroAttributesMap.put("strength", strength);
        heroAttributesMap.put("constitution", constitution);
        heroAttributesMap.put("dexterity", dexterity);
        heroAttributesMap.put("intelligence", intelligence);
        heroAttributesMap.put("wisdom", wisdom);
        heroAttributesMap.put("charisma", charisma);
        this.heroAttributesMap = heroAttributesMap;
    }

    public Map<String, Integer> getHeroAttributesMap() {
        return heroAttributesMap;
    }

    public void setHeroAttributesMap(Map<String, Integer> heroAttributesMap) {
        this.heroAttributesMap = heroAttributesMap;
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
        return acrobatics;
    }

    public void setAcrobatics(int acrobatics) {
        this.acrobatics = acrobatics;
    }

    public int getArcana() {
        return arcana;
    }

    public void setArcana(int arcana) {
        this.arcana = arcana;
    }

    public int getAthletics() {
        return athletics;
    }

    public void setAthletics(int athletics) {
        this.athletics = athletics;
    }

    public int getBluff() {
        return bluff;
    }

    public void setBluff(int bluff) {
        this.bluff = bluff;
    }

    public int getDiplomacy() {
        return diplomacy;
    }

    public void setDiplomacy(int diplomacy) {
        this.diplomacy = diplomacy;
    }

    public int getDungeoneering() {
        return dungeoneering;
    }

    public void setDungeoneering(int dungeoneering) {
        this.dungeoneering = dungeoneering;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public int getInsight() {
        return insight;
    }

    public void setInsight(int insight) {
        this.insight = insight;
    }

    public int getIntimidate() {
        return intimidate;
    }

    public void setIntimidate(int intimidate) {
        this.intimidate = intimidate;
    }

    public int getNature() {
        return nature;
    }

    public void setNature(int nature) {
        this.nature = nature;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public int getReligion() {
        return religion;
    }

    public void setReligion(int religion) {
        this.religion = religion;
    }

    public int getStealth() {
        return stealth;
    }

    public void setStealth(int stealth) {
        this.stealth = stealth;
    }

    public int getStreetwise() {
        return streetwise;
    }

    public void setStreetwise(int streetwise) {
        this.streetwise = streetwise;
    }

    public int getThievery() {
        return thievery;
    }

    public void setThievery(int thievery) {
        this.thievery = thievery;
    }


    public void setGold(int gold) {
        this.gold = gold;
    }


    public int getGold() {
        return gold;
    }

    public AttackResults attackAMonster(Creature attackedCreature, HeroPower powerUsedForAttacking) {
        AttackResults attackResults = new AttackResults();
        String usedAttribute = powerUsedForAttacking.getAttributeUsedToHit();
        heroAttributesMap.forEach((k, v) -> System.out.println("Hero Attribute: " + k + " Value: " + v));
        System.out.println("Attacked Monster: " + attackedCreature.getMonsterName());
        System.out.println("Attacked Monster UUID: " + attackedCreature.getCurrentMonsterUniqueID());
        System.out.println(usedAttribute);
        int attributeBonus = (heroAttributesMap.get(usedAttribute.toLowerCase()) - 10) / 2;
        String attackedDefense = powerUsedForAttacking.getDefenseToBeChecked().toLowerCase();
        int defenseValue = attackedCreature.getDefensesMap().get(attackedDefense);
        Random random = new Random();
        int diceRoll = random.nextInt(20) + 1;
        attackResults.setAttributeBonus(attributeBonus);
        attackResults.setDefenseChecked(defenseValue);
        attackResults.setDiceRollValue(diceRoll);
        return attackResults;
    }
}
