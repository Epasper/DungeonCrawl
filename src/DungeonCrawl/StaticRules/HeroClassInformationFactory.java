package DungeonCrawl.StaticRules;

import DungeonCrawl.HeroPowers.HeroPower;

import java.util.List;

public class HeroClassInformationFactory {

    private String className;
    private Integer classSkillPoints;
    private List<String> availableSkills;
    private Integer hitDiceAt1st;
    private Integer hitDicePerLevel;
    private List<HeroPower> atWillPowersAtLevel1;
    private List<HeroPower> atWillPowers;
    private List<HeroPower> encounterPowersAtLevel1;
    private List<HeroPower> encounterPowers;
    private List<HeroPower> dailyPowersAtLevel1;
    private List<HeroPower> dailyPowers;
    private List<String> classTraits;
    private List<String> classWeaponProficiencies;
    private List<String> classArmorProficiencies;

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
