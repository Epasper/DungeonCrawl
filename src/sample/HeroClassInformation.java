package sample;

import sample.HeroPowers.Avenger.BondOfPursuit;
import sample.HeroPowers.Avenger.BondOfRetribution;
import sample.HeroPowers.Avenger.OverwhelmingStrike;
import sample.HeroPowers.Avenger.RadiantVengeance;
import sample.HeroPowers.Barbarian.DevastatingStrike;
import sample.HeroPowers.Barbarian.HowlingStrike;
import sample.HeroPowers.Barbarian.PressingStrike;
import sample.HeroPowers.HeroPower;
import sample.HeroPowers.Barbarian.RecuperatingStrike;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeroClassInformation {

    Map<String, Integer> classSkillPoints = new HashMap<>();
    Map<String, List<String>> availableSkills = new HashMap<>();
    Map<String, Integer> hitDiceAt1st = new HashMap<>();
    Map<String, Integer> hitDicePerLevel = new HashMap<>();
    Map<String, List<String>> armorProficiencies = new HashMap<>();
    private Map<String, List<HeroPower>> atWillPowersAtLevel1 = new HashMap<>();

    public enum ExpandedAction {FREE, MINOR, STANDARD}

    public enum TypeOfPower {AT_WILL, ENCOUNTER, DAILY}

    public enum CharacterSkills {
        Acrobatics, Arcana, Athletics, Bluff, Diplomacy, Dungeoneering, Endurance, Heal, History, Insight, Intimidate, Nature, Perception, Religion, Stealth, Streetwise, Thievery
    }

    public enum CharacterClasses {
        Avenger, Barbarian, Bard, Cleric, Druid, Fighter, Invoker, Paladin, Ranger, Rogue, Shaman, Sorcerer, Warden, Warlock, Warlord, Wizard
    }

    public enum CharacterRaces {
        Deva, Dragonborn, Dwarf, Eladrin, Elf, Gnome, Goliath, Halfelf, Halforc, Halfling, Human, Shifter, Tiefling
    }

    public enum Attributes {
        Strength, Constitution, Dexterity, Intelligence, Wisdom, Charisma
    }

    public enum Defenses {
        AC, Fortitude, Reflex, Will
    }

    //todo think about refactoring the Map onto something else, perhaps something DRY

    public HeroClassInformation() {
        populateTheTablesWithHPs();
        populateTheTablesWithSkills();
        populateTheTablesWithAtWillPowers();
    }

    public Map<String, Integer> getClassSkillPoints() {
        return classSkillPoints;
    }

    public void setClassSkillPoints(Map<String, Integer> classSkillPoints) {
        this.classSkillPoints = classSkillPoints;
    }

    public Map<String, List<String>> getAvailableSkills() {
        return availableSkills;
    }

    public void setAvailableSkills(Map<String, List<String>> availableSkills) {
        this.availableSkills = availableSkills;
    }

    public Map<String, Integer> getHitDiceAt1st() {
        return hitDiceAt1st;
    }

    public void setHitDiceAt1st(Map<String, Integer> hitDiceAt1st) {
        this.hitDiceAt1st = hitDiceAt1st;
    }

    public Map<String, List<HeroPower>> getAtWillPowersAtLevel1() {
        return atWillPowersAtLevel1;
    }

    public void setAtWillPowersAtLevel1(Map<String, List<HeroPower>> atWillPowersAtLevel1) {
        this.atWillPowersAtLevel1 = atWillPowersAtLevel1;
    }

    private void populateTheTablesWithAtWillPowers() {
        List<HeroPower> avenger = new ArrayList<>();
        atWillPowersAtLevel1.put("Avenger", avenger);
        avenger.add(new BondOfRetribution());
        avenger.add(new BondOfPursuit());
        avenger.add(new OverwhelmingStrike());
        avenger.add(new RadiantVengeance());
        List<HeroPower> barbarian = new ArrayList<>();
        atWillPowersAtLevel1.put(CharacterClasses.Barbarian.toString(), barbarian);
        barbarian.add(new RecuperatingStrike());
        barbarian.add(new PressingStrike());
        barbarian.add(new DevastatingStrike());
        barbarian.add(new HowlingStrike());
    }

    private void populateTheTablesWithSkills() {
        classSkillPoints.put("Avenger", 4);
        List<String> avenger = new ArrayList<>();
        avenger.add("Acrobatics");
        avenger.add("Athletics");
        avenger.add("Endurance");
        avenger.add("Heal");
        avenger.add("Intimidate");
        avenger.add("Perception");
        avenger.add("Religion");
        avenger.add("Stealth");
        avenger.add("Streetwise");
        availableSkills.put("Avenger", avenger);
        classSkillPoints.put("Barbarian", 3);
        List<String> barbarian = new ArrayList<>();
        barbarian.add("Acrobatics");
        barbarian.add("Athletics");
        barbarian.add("Endurance");
        barbarian.add("Heal");
        barbarian.add("Intimidate");
        barbarian.add("Nature");
        barbarian.add("Perception");
        availableSkills.put("Barbarian", barbarian);
        classSkillPoints.put("Bard", 5);
        List<String> bard = new ArrayList<>();
        bard.add("Acrobatics");
        bard.add("Arcana");
        bard.add("Athletics");
        bard.add("Bluff");
        bard.add("Diplomacy");
        bard.add("Dungeoneering");
        bard.add("Heal");
        bard.add("History");
        bard.add("Insight");
        bard.add("Intimidate");
        bard.add("Perception");
        bard.add("Religion");
        bard.add("Streetwise");
        availableSkills.put("Bard", bard);
        classSkillPoints.put("Cleric", 4);
        List<String> cleric = new ArrayList<>();
        cleric.add("Arcana");
        cleric.add("Diplomacy");
        cleric.add("Heal");
        cleric.add("History");
        cleric.add("Insight");
        cleric.add("Religion");
        availableSkills.put("Cleric", cleric);
        classSkillPoints.put("Druid", 4);
        List<String> druid = new ArrayList<>();
        druid.add("Arcana");
        druid.add("Athletics");
        druid.add("Diplomacy");
        druid.add("Endurance");
        druid.add("Heal");
        druid.add("History");
        druid.add("Insight");
        druid.add("Nature");
        druid.add("Perception");
        availableSkills.put("Druid", druid);
        classSkillPoints.put("Fighter", 3);
        List<String> fighter = new ArrayList<>();
        fighter.add("Athletics");
        fighter.add("Endurance");
        fighter.add("Heal");
        fighter.add("Intimidate");
        fighter.add("Streetwise");
        availableSkills.put("Fighter", fighter);
        classSkillPoints.put("Invoker", 4);
        List<String> invoker = new ArrayList<>();
        invoker.add("Arcana");
        invoker.add("Diplomacy");
        invoker.add("Endurance");
        invoker.add("History");
        invoker.add("Insight");
        invoker.add("Intimidate");
        invoker.add("Religion");
        availableSkills.put("Invoker", invoker);
        classSkillPoints.put("Paladin", 4);
        List<String> paladin = new ArrayList<>();
        paladin.add("Diplomacy");
        paladin.add("Endurance");
        paladin.add("Heal");
        paladin.add("History");
        paladin.add("Insight");
        paladin.add("Intimidate");
        paladin.add("Religion");
        availableSkills.put("Paladin", paladin);
        classSkillPoints.put("Ranger", 6);
        List<String> ranger = new ArrayList<>();
        ranger.add("Acrobatics");
        ranger.add("Athletics");
        ranger.add("Dungeoneering");
        ranger.add("Endurance");
        ranger.add("Heal");
        ranger.add("Nature");
        ranger.add("Perception");
        ranger.add("Stealth");
        availableSkills.put("Ranger", ranger);
        classSkillPoints.put("Rogue", 6);
        List<String> rogue = new ArrayList<>();
        rogue.add("Acrobatics");
        rogue.add("Athletics");
        rogue.add("Bluff");
        rogue.add("Dungeoneering");
        rogue.add("Insight");
        rogue.add("Intimidate");
        rogue.add("Perception");
        rogue.add("Stealth");
        rogue.add("Streetwise");
        rogue.add("Thievery");
        availableSkills.put("Rogue", rogue);
        classSkillPoints.put("Shaman", 4);
        List<String> shaman = new ArrayList<>();
        shaman.add("Arcana");
        shaman.add("Athletics");
        shaman.add("Endurance");
        shaman.add("Heal");
        shaman.add("History");
        shaman.add("Insight");
        shaman.add("Perception");
        shaman.add("Religion");
        availableSkills.put("Shaman", shaman);
        classSkillPoints.put("Sorcerer", 4);
        List<String> sorcerer = new ArrayList<>();
        sorcerer.add("Athletics");
        sorcerer.add("Bluff");
        sorcerer.add("Diplomacy");
        sorcerer.add("Dungeoneering");
        sorcerer.add("Endurance");
        sorcerer.add("History");
        sorcerer.add("Insight");
        sorcerer.add("Intimidate");
        sorcerer.add("Nature");
        availableSkills.put("Sorcerer", sorcerer);
        classSkillPoints.put("Warden", 4);
        List<String> warden = new ArrayList<>();
        warden.add("Athletics");
        warden.add("Dungeoneering");
        warden.add("Endurance");
        warden.add("Heal");
        warden.add("Intimidate");
        warden.add("Nature");
        warden.add("Perception");
        availableSkills.put("Warden", warden);
        classSkillPoints.put("Warlock", 4);
        List<String> warlock = new ArrayList<>();
        warlock.add("Arcana");
        warlock.add("Bluff");
        warlock.add("History");
        warlock.add("Insight");
        warlock.add("Intimidate");
        warlock.add("Religion");
        warlock.add("Streetwise");
        warlock.add("Thievery");
        availableSkills.put("Warlock", warlock);
        classSkillPoints.put("Wizard", 4);
        List<String> wizard = new ArrayList<>();
        wizard.add("Diplomacy");
        wizard.add("Dungeoneering");
        wizard.add("History");
        wizard.add("Insight");
        wizard.add("Nature");
        wizard.add("Religion");
        availableSkills.put("Wizard", wizard);
        classSkillPoints.put("Warlord", 4);
        List<String> warlord = new ArrayList<>();
        warlord.add("Athletics");
        warlord.add("Diplomacy");
        warlord.add("Endurance");
        warlord.add("Heal");
        warlord.add("History");
        warlord.add("Intimidate");
        availableSkills.put("Warlord", warlord);
    }

    private void populateTheTablesWithHPs() {
        hitDiceAt1st.put("Avenger", 14);
        hitDiceAt1st.put("Barbarian", 15);
        hitDiceAt1st.put("Bard", 12);
        hitDiceAt1st.put("Cleric", 12);
        hitDiceAt1st.put("Druid", 12);
        hitDiceAt1st.put("Fighter", 15);
        hitDiceAt1st.put("Invoker", 10);
        hitDiceAt1st.put("Paladin", 15);
        hitDiceAt1st.put("Ranger", 12);
        hitDiceAt1st.put("Rogue", 12);
        hitDiceAt1st.put("Shaman", 12);
        hitDiceAt1st.put("Warden", 17);
        hitDiceAt1st.put("Warlord", 12);
        hitDiceAt1st.put("Warlock", 12);
        hitDiceAt1st.put("Sorcerer", 12);
        hitDiceAt1st.put("Wizard", 10);
    }
}
