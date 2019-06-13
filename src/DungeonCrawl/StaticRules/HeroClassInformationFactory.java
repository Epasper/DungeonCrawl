package DungeonCrawl.StaticRules;

import DungeonCrawl.HeroPowers.HeroPower;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeroClassInformationFactory {

    private String className;
    private Integer classSkillPoints;
    private List<String> availableSkills = new ArrayList<>();
    private Integer hitDiceAt1st;
    private Integer hitDicePerLevel;
    private List<HeroPower> atWillPowersAtLevel1 = new ArrayList<>();
    private List<HeroPower> atWillPowers = new ArrayList<>();
    private List<HeroPower> encounterPowersAtLevel1 = new ArrayList<>();
    private List<HeroPower> encounterPowers = new ArrayList<>();
    private List<HeroPower> dailyPowersAtLevel1 = new ArrayList<>();
    private List<HeroPower> dailyPowers = new ArrayList<>();
    private List<String> classTraits = new ArrayList<>();
    private List<String> classWeaponProficiencies = new ArrayList<>();
    private List<String> classArmorProficiencies = new ArrayList<>();

    public HeroClassInformationFactory(String className) {
        this.className = className;
        HeroClassInformation heroClassInformation = new HeroClassInformation();
        this.classSkillPoints = heroClassInformation.getClassSkillPoints().get(className);
        this.availableSkills = heroClassInformation.getAvailableSkills().get(className);
        this.hitDiceAt1st = heroClassInformation.getHitDiceAt1st().get(className);
        this.atWillPowersAtLevel1 = heroClassInformation.getAtWillPowersAtLevel1().get(className);
        this.atWillPowers = heroClassInformation.getAtWillPowers().get(className);
        this.encounterPowersAtLevel1 = heroClassInformation.getEncounterPowersAtLevel1().get(className);
        this.encounterPowers = heroClassInformation.getEncounterPowers().get(className);
        this.dailyPowersAtLevel1 = heroClassInformation.getDailyPowersAtLevel1().get(className);
        this.dailyPowers = heroClassInformation.getDailyPowers().get(className);
        this.classTraits = heroClassInformation.getClassTraits().get(className);
        this.classWeaponProficiencies = heroClassInformation.getClassWeaponProficiencies().get(className);
        this.classArmorProficiencies = heroClassInformation.getClassArmorProficiencies().get(className);
    }

    public String getClassName() {
        return className;
    }

    public Integer getClassSkillPoints() {
        return classSkillPoints;
    }

    public List<String> getAvailableSkills() {
        return availableSkills;
    }

    public Integer getHitDiceAt1st() {
        return hitDiceAt1st;
    }

    public Integer getHitDicePerLevel() {
        return hitDicePerLevel;
    }

    public List<HeroPower> getAtWillPowersAtLevel1() {
        return atWillPowersAtLevel1;
    }

    public List<HeroPower> getAtWillPowers() {
        return atWillPowers;
    }

    public List<HeroPower> getEncounterPowersAtLevel1() {
        return encounterPowersAtLevel1;
    }

    public List<HeroPower> getEncounterPowers() {
        return encounterPowers;
    }

    public List<HeroPower> getDailyPowersAtLevel1() {
        return dailyPowersAtLevel1;
    }

    public List<HeroPower> getDailyPowers() {
        return dailyPowers;
    }

    public List<String> getClassTraits() {
        return classTraits;
    }

    public List<String> getClassWeaponProficiencies() {
        return classWeaponProficiencies;
    }

    public List<String> getClassArmorProficiencies() {
        return classArmorProficiencies;
    }
}
