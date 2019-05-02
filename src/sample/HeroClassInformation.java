package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeroClassInformation {

    Map<String, Integer> classSkillPoints = new HashMap<>();
    Map<String, List<String>> availableSkills = new HashMap<>();
    static Map<String, Integer> hidDice = new HashMap<>();

    //todo think about refactoring the Map onto something else, perhaps something DRY

    public HeroClassInformation() {
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
        availableSkills.put("Bard", wizard);
    }
}
