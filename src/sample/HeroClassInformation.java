package sample;

import sample.HeroPowers.Avenger.BondOfPursuit;
import sample.HeroPowers.Avenger.BondOfRetribution;
import sample.HeroPowers.Avenger.OverwhelmingStrike;
import sample.HeroPowers.Avenger.RadiantVengeance;
import sample.HeroPowers.Barbarian.DevastatingStrike;
import sample.HeroPowers.Barbarian.HowlingStrike;
import sample.HeroPowers.Barbarian.PressingStrike;
import sample.HeroPowers.Bard.GuidingStrike;
import sample.HeroPowers.Bard.MisdirectedMark;
import sample.HeroPowers.Bard.ViciousMockery;
import sample.HeroPowers.Bard.WarSongStrike;
import sample.HeroPowers.Cleric.LanceOfFaith;
import sample.HeroPowers.Cleric.PriestsShield;
import sample.HeroPowers.Cleric.RighteousBrand;
import sample.HeroPowers.Cleric.SacredFlame;
import sample.HeroPowers.Druid.*;
import sample.HeroPowers.Fighter.Cleave;
import sample.HeroPowers.Fighter.ReapingStrike;
import sample.HeroPowers.Fighter.SureStrike;
import sample.HeroPowers.Fighter.TideOfIron;
import sample.HeroPowers.HeroPower;
import sample.HeroPowers.Barbarian.RecuperatingStrike;
import sample.HeroPowers.Invoker.AvengingLight;
import sample.HeroPowers.Invoker.DivineBolts;
import sample.HeroPowers.Invoker.SunStrike;
import sample.HeroPowers.Paladin.BolsteringStrike;
import sample.HeroPowers.Paladin.EnfeeblingStrike;
import sample.HeroPowers.Paladin.HolyStrike;
import sample.HeroPowers.Paladin.ValiantStrike;
import sample.HeroPowers.Ranger.CarefulAttack;
import sample.HeroPowers.Ranger.HitAndRun;
import sample.HeroPowers.Ranger.NimbleStrike;
import sample.HeroPowers.Ranger.TwinStrike;
import sample.HeroPowers.Rogue.DeftStrike;
import sample.HeroPowers.Rogue.PiercingStrike;
import sample.HeroPowers.Rogue.RiposteStrike;
import sample.HeroPowers.Rogue.SlyFlourish;
import sample.HeroPowers.Shaman.*;
import sample.HeroPowers.Sorcerer.*;
import sample.HeroPowers.Warlock.DireRadiance;
import sample.HeroPowers.Warlock.EldritchBlast;
import sample.HeroPowers.Warlock.Eyebite;
import sample.HeroPowers.Warlock.HellishRebuke;
import sample.HeroPowers.Warlord.CommandersStrike;
import sample.HeroPowers.Warlord.FuriousSmash;
import sample.HeroPowers.Warlord.VipersStrike;
import sample.HeroPowers.Warlord.WolfsPackTactics;
import sample.HeroPowers.Wizard.*;

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
        atWillPowersAtLevel1.put(CharacterClasses.Avenger.toString(), avenger);
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
        List<HeroPower> bard = new ArrayList<>();
        atWillPowersAtLevel1.put(CharacterClasses.Bard.toString(), bard);
        bard.add(new GuidingStrike());
        bard.add(new MisdirectedMark());
        bard.add(new ViciousMockery());
        bard.add(new WarSongStrike());
        List<HeroPower> cleric = new ArrayList<>();
        atWillPowersAtLevel1.put(CharacterClasses.Cleric.toString(), cleric);
        cleric.add(new LanceOfFaith());
        cleric.add(new PriestsShield());
        cleric.add(new RighteousBrand());
        cleric.add(new SacredFlame());
        List<HeroPower> druid = new ArrayList<>();
        atWillPowersAtLevel1.put(CharacterClasses.Druid.toString(), druid);
        druid.add(new CallOfTheBeast());
        druid.add(new ChillWind());
        druid.add(new GraspingClaws());
        druid.add(new Pounce());
        druid.add(new SavageRend());
        druid.add(new ThornWhip());
        List<HeroPower> fighter = new ArrayList<>();
        atWillPowersAtLevel1.put(CharacterClasses.Fighter.toString(), fighter);
        fighter.add(new Cleave());
        fighter.add(new ReapingStrike());
        fighter.add(new SureStrike());
        fighter.add(new TideOfIron());
        List<HeroPower> invoker = new ArrayList<>();
        atWillPowersAtLevel1.put(CharacterClasses.Invoker.toString(), invoker);
        invoker.add(new AvengingLight());
        invoker.add(new DivineBolts());
        invoker.add(new GraspingClaws());
        invoker.add(new SunStrike());
        List<HeroPower> paladin = new ArrayList<>();
        atWillPowersAtLevel1.put(CharacterClasses.Paladin.toString(), paladin);
        paladin.add(new BolsteringStrike());
        paladin.add(new EnfeeblingStrike());
        paladin.add(new HolyStrike());
        paladin.add(new ValiantStrike());
        List<HeroPower> ranger = new ArrayList<>();
        atWillPowersAtLevel1.put(CharacterClasses.Ranger.toString(), ranger);
        ranger.add(new CarefulAttack());
        ranger.add(new HitAndRun());
        ranger.add(new NimbleStrike());
        ranger.add(new TwinStrike());
        List<HeroPower> rogue = new ArrayList<>();
        atWillPowersAtLevel1.put(CharacterClasses.Rogue.toString(), rogue);
        rogue.add(new DeftStrike());
        rogue.add(new PiercingStrike());
        rogue.add(new RiposteStrike());
        rogue.add(new SlyFlourish());
        List<HeroPower> shaman = new ArrayList<>();
        atWillPowersAtLevel1.put(CharacterClasses.Shaman.toString(), shaman);
        shaman.add(new DefendingStrike());
        shaman.add(new HauntingSpirits());
        shaman.add(new ProtectingStrike());
        shaman.add(new StalkersStrike());
        shaman.add(new WatchersStrike());
        shaman.add(new WrathOfWinter());
        List<HeroPower> sorcerer = new ArrayList<>();
        atWillPowersAtLevel1.put(CharacterClasses.Sorcerer.toString(), sorcerer);
        sorcerer.add(new AcidOrb());
        sorcerer.add(new BurningSpray());
        sorcerer.add(new ChaosBolt());
        sorcerer.add(new Dragonfrost());
        sorcerer.add(new StormWalk());
        List<HeroPower> warlock = new ArrayList<>();
        atWillPowersAtLevel1.put(CharacterClasses.Warlock.toString(), warlock);
        warlock.add(new DireRadiance());
        warlock.add(new EldritchBlast());
        warlock.add(new Eyebite());
        warlock.add(new HellishRebuke());
        List<HeroPower> warlord = new ArrayList<>();
        atWillPowersAtLevel1.put(CharacterClasses.Warlord.toString(), warlord);
        warlord.add(new CommandersStrike());
        warlord.add(new FuriousSmash());
        warlord.add(new VipersStrike());
        warlord.add(new WolfsPackTactics());
        List<HeroPower> wizard = new ArrayList<>();
        atWillPowersAtLevel1.put(CharacterClasses.Wizard.toString(), wizard);
        wizard.add(new CloudOfDaggers());
        wizard.add(new MagicMissile());
        wizard.add(new RayOfFrost());
        wizard.add(new ScorchingBurst());
        wizard.add(new Thunderwave());
    }

    public HeroPower getHeroPowerByName(String className, String powerName) {

        //todo nullpointer
        for (HeroPower currentPower : atWillPowersAtLevel1.get(className)) {
            if (powerName.equals(currentPower.getPowerName())) {
                return currentPower;
            }
        }
        return null;
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
