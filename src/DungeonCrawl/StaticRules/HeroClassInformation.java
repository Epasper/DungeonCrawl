package DungeonCrawl.StaticRules;

import DungeonCrawl.HeroPowers.Avenger.*;
import DungeonCrawl.HeroPowers.Barbarian.*;
import DungeonCrawl.HeroPowers.Bard.*;
import DungeonCrawl.HeroPowers.Cleric.*;
import DungeonCrawl.HeroPowers.Druid.*;
import DungeonCrawl.HeroPowers.Fighter.*;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.HeroPowers.Invoker.*;
import DungeonCrawl.HeroPowers.Paladin.*;
import DungeonCrawl.HeroPowers.Ranger.*;
import DungeonCrawl.HeroPowers.Rogue.*;
import DungeonCrawl.HeroPowers.Shaman.*;
import DungeonCrawl.HeroPowers.Sorcerer.*;
import DungeonCrawl.HeroPowers.Warlock.*;
import DungeonCrawl.HeroPowers.Warlord.*;
import DungeonCrawl.HeroPowers.Wizard.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeroClassInformation {

    public Map<String, Integer> classSkillPoints = new HashMap<>();
    public Map<String, List<String>> availableSkills = new HashMap<>();
    public Map<String, Integer> hitDiceAt1st = new HashMap<>();
    Map<String, Integer> hitDicePerLevel = new HashMap<>();
    public Map<HeroSkills, AttributeNames> skillsAndCorrespondingAttributes = new HashMap<>();
    private Map<String, List<HeroPower>> atWillPowersAtLevel1 = new HashMap<>();
    private Map<String, List<HeroPower>> atWillPowers = new HashMap<>();
    private Map<String, List<HeroPower>> encounterPowersAtLevel1 = new HashMap<>();
    private Map<String, List<HeroPower>> encounterPowers = new HashMap<>();
    private Map<String, List<HeroPower>> dailyPowersAtLevel1 = new HashMap<>();
    private Map<String, List<HeroPower>> dailyPowers = new HashMap<>();
    private Map<String, List<String>> classTraits = new HashMap<>();
    private Map<String, List<String>> classWeaponProficiencies = new HashMap<>();
    private Map<String, List<String>> classArmorProficiencies = new HashMap<>();

    public Map<String, List<String>> getClassWeaponProficiencies() {
        return classWeaponProficiencies;
    }

    public void setClassWeaponProficiencies(Map<String, List<String>> classWeaponProficiencies) {
        this.classWeaponProficiencies = classWeaponProficiencies;
    }

    public Map<String, List<String>> getClassArmorProficiencies() {
        return classArmorProficiencies;
    }

    public void setClassArmorProficiencies(Map<String, List<String>> classArmorProficiencies) {
        this.classArmorProficiencies = classArmorProficiencies;
    }

    public Map<String, List<HeroPower>> getDailyPowersAtLevel1() {
        return dailyPowersAtLevel1;
    }

    public void setDailyPowersAtLevel1(Map<String, List<HeroPower>> dailyPowersAtLevel1) {
        this.dailyPowersAtLevel1 = dailyPowersAtLevel1;
    }

    public Map<String, List<HeroPower>> getDailyPowers() {
        return dailyPowers;
    }

    public void setDailyPowers(Map<String, List<HeroPower>> dailyPowers) {
        this.dailyPowers = dailyPowers;
    }

    public Map<String, List<HeroPower>> getAtWillPowers() {
        return atWillPowers;
    }

    public void setAtWillPowers(Map<String, List<HeroPower>> atWillPowers) {
        this.atWillPowers = atWillPowers;
    }

    public Map<String, List<HeroPower>> getEncounterPowers() {
        return encounterPowers;
    }

    public void setEncounterPowers(Map<String, List<HeroPower>> encounterPowers) {
        this.encounterPowers = encounterPowers;
    }

    public Map<String, List<String>> getClassTraits() {
        return classTraits;
    }

    public void setClassTraits(Map<String, List<String>> classTraits) {
        this.classTraits = classTraits;
    }

    public Map<String, List<HeroPower>> getEncounterPowersAtLevel1() {
        return encounterPowersAtLevel1;
    }

    public void setEncounterPowersAtLevel1(Map<String, List<HeroPower>> encounterPowersAtLevel1) {
        this.encounterPowersAtLevel1 = encounterPowersAtLevel1;
    }

    public HeroClassInformation() {
        populateTheTablesWithHPs();
        populateTheTablesWithSkills();
        populateTheTablesWithAtWillPowers();
        populateTheTablesWithEncounterPowers();
        populateTheSkillsAndCorrespondingAttributes();
        populateTheTablesWithTraits();
        populateTheTablesWithDailyPowers();
        populateTheProficienciesMaps();
    }

    //todo add a factory class instead of passing all lists.

    private void populateTheProficienciesMaps() {
        List<String> avengerArmor = new ArrayList<>();
        List<String> avengerWeapon = new ArrayList<>();
        avengerArmor.add("Cloth Armor");
        avengerWeapon.add("Simple Melee");
        avengerWeapon.add("Military Melee");
        avengerWeapon.add("Simple Ranged");
        avengerWeapon.add("Holy Symbol");
        classArmorProficiencies.put("Avenger", avengerArmor);
        classWeaponProficiencies.put("Avenger", avengerWeapon);
        List<String> barbarianArmor = new ArrayList<>();
        List<String> barbarianWeapon = new ArrayList<>();
        barbarianArmor.add("Cloth Armor");
        barbarianArmor.add("Leather Armor");
        barbarianArmor.add("Hide Armor");
        barbarianWeapon.add("Simple Melee");
        barbarianWeapon.add("Military Melee");
        classArmorProficiencies.put("Barbarian", barbarianArmor);
        classWeaponProficiencies.put("Barbarian", barbarianWeapon);
        List<String> bardArmor = new ArrayList<>();
        List<String> bardWeapon = new ArrayList<>();
        bardArmor.add("Cloth Armor");
        bardArmor.add("Leather Armor");
        bardArmor.add("Hide Armor");
        bardArmor.add("Chainmail");
        bardWeapon.add("Simple Melee");
        bardWeapon.add("Longsword");
        bardWeapon.add("Scimitar");
        bardWeapon.add("Short Sword");
        bardWeapon.add("Simple Ranged");
        bardWeapon.add("Military Ranged");
        bardWeapon.add("Wand");
        classArmorProficiencies.put("Bard", bardArmor);
        classWeaponProficiencies.put("Bard", bardWeapon);
        List<String> clericArmor = new ArrayList<>();
        List<String> clericWeapon = new ArrayList<>();
        clericArmor.add("Cloth Armor");
        clericArmor.add("Leather Armor");
        clericArmor.add("Hide Armor");
        clericArmor.add("Chainmail");
        clericWeapon.add("Simple Melee");
        clericWeapon.add("Holy Symbol");
        clericWeapon.add("Simple Ranged");
        classArmorProficiencies.put("Cleric", clericArmor);
        classWeaponProficiencies.put("Cleric", clericWeapon);
        List<String> druidArmor = new ArrayList<>();
        List<String> druidWeapon = new ArrayList<>();
        druidArmor.add("Cloth Armor");
        druidArmor.add("Leather Armor");
        druidArmor.add("Hide Armor");
        druidWeapon.add("Simple Melee");
        druidWeapon.add("Totem");
        druidWeapon.add("Staff");
        druidWeapon.add("Simple Ranged");
        classArmorProficiencies.put("Druid", druidArmor);
        classWeaponProficiencies.put("Druid", druidWeapon);
        List<String> fighterArmor = new ArrayList<>();
        List<String> fighterWeapon = new ArrayList<>();
        fighterArmor.add("Cloth Armor");
        fighterArmor.add("Leather Armor");
        fighterArmor.add("Hide Armor");
        fighterArmor.add("Chainmail");
        fighterArmor.add("Scale");
        fighterArmor.add("Light Shield");
        fighterArmor.add("Heavy Shield");
        fighterWeapon.add("Simple Melee");
        fighterWeapon.add("Military Melee");
        fighterWeapon.add("Simple Ranged");
        fighterWeapon.add("Military Ranged");
        classArmorProficiencies.put("Fighter", fighterArmor);
        classWeaponProficiencies.put("Fighter", fighterWeapon);
        List<String> invokerArmor = new ArrayList<>();
        List<String> invokerWeapon = new ArrayList<>();
        invokerArmor.add("Cloth Armor");
        invokerArmor.add("Leather Armor");
        invokerArmor.add("Hide Armor");
        invokerArmor.add("Chainmail");
        invokerWeapon.add("Simple Melee");
        invokerWeapon.add("Simple Ranged");
        invokerWeapon.add("Rod");
        invokerWeapon.add("Staff");
        classArmorProficiencies.put("Invoker", invokerArmor);
        classWeaponProficiencies.put("Invoker", invokerWeapon);
        List<String> paladinArmor = new ArrayList<>();
        List<String> paladinWeapon = new ArrayList<>();
        paladinArmor.add("Cloth Armor");
        paladinArmor.add("Leather Armor");
        paladinArmor.add("Hide Armor");
        paladinArmor.add("Chainmail");
        paladinArmor.add("Scale");
        paladinArmor.add("Plate");
        paladinArmor.add("Chainmail");
        paladinArmor.add("Light Shield");
        paladinArmor.add("Heavy Shield");
        paladinWeapon.add("Simple Melee");
        paladinWeapon.add("Military Melee");
        paladinWeapon.add("Simple Ranged");
        paladinWeapon.add("Holy Symbol");
        classArmorProficiencies.put("Paladin", paladinArmor);
        classWeaponProficiencies.put("Paladin", paladinWeapon);
        List<String> rangerArmor = new ArrayList<>();
        List<String> rangerWeapon = new ArrayList<>();
        rangerArmor.add("Cloth Armor");
        rangerArmor.add("Leather Armor");
        rangerWeapon.add("Simple Melee");
        rangerWeapon.add("Military Melee");
        rangerWeapon.add("Simple Ranged");
        rangerWeapon.add("Military Ranged");
        classArmorProficiencies.put("Ranger", rangerArmor);
        classWeaponProficiencies.put("Ranger", rangerWeapon);
        List<String> rogueArmor = new ArrayList<>();
        List<String> rogueWeapon = new ArrayList<>();
        rogueArmor.add("Cloth Armor");
        rogueArmor.add("Leather Armor");
        rogueArmor.add("Hide Armor");
        rogueWeapon.add("Dagger");
        rogueWeapon.add("Hand Crossbow");
        rogueWeapon.add("Shuriken");
        rogueWeapon.add("Sling");
        rogueWeapon.add("Short Sword");
        classArmorProficiencies.put("Rogue", rogueArmor);
        classWeaponProficiencies.put("Rogue", rogueWeapon);
        List<String> shamanArmor = new ArrayList<>();
        List<String> shamanWeapon = new ArrayList<>();
        shamanArmor.add("Cloth Armor");
        shamanArmor.add("Leather Armor");
        shamanWeapon.add("Simple Melee");
        shamanWeapon.add("Longspear");
        shamanWeapon.add("Totem");
        classArmorProficiencies.put("Shaman", shamanArmor);
        classWeaponProficiencies.put("Shaman", shamanWeapon);
        List<String> sorcererArmor = new ArrayList<>();
        List<String> sorcererWeapon = new ArrayList<>();
        sorcererArmor.add("Cloth Armor");
        sorcererWeapon.add("Simple Melee");
        sorcererWeapon.add("Simple Ranged");
        sorcererWeapon.add("Dagger");
        sorcererWeapon.add("Staff");
        classArmorProficiencies.put("Sorcerer", sorcererArmor);
        classWeaponProficiencies.put("Sorcerer", sorcererWeapon);
        List<String> wardenArmor = new ArrayList<>();
        List<String> wardenWeapon = new ArrayList<>();
        wardenArmor.add("Cloth Armor");
        wardenArmor.add("Leather Armor");
        wardenArmor.add("Hide Armor");
        wardenArmor.add("Light Shield");
        wardenArmor.add("Heavy Shield");
        wardenWeapon.add("Simple Melee");
        wardenWeapon.add("Military Melee");
        wardenWeapon.add("Simple Ranged");
        classArmorProficiencies.put("Warden", wardenArmor);
        classWeaponProficiencies.put("Warden", wardenWeapon);
        List<String> warlockArmor = new ArrayList<>();
        List<String> warlockWeapon = new ArrayList<>();
        warlockArmor.add("Cloth Armor");
        warlockArmor.add("Leather Armor");
        warlockWeapon.add("Simple Melee");
        warlockWeapon.add("Simple Ranged");
        warlockWeapon.add("Rod");
        warlockWeapon.add("Wand");
        classArmorProficiencies.put("Warlock", warlockArmor);
        classWeaponProficiencies.put("Warlock", warlockWeapon);
        List<String> warlordArmor = new ArrayList<>();
        List<String> warlordWeapon = new ArrayList<>();
        warlordArmor.add("Cloth Armor");
        warlordArmor.add("Leather Armor");
        warlordArmor.add("Hide Armor");
        warlordArmor.add("Chainmail");
        warlordArmor.add("Light Shield");
        warlordWeapon.add("Simple Melee");
        warlordWeapon.add("Military Melee");
        warlordWeapon.add("Simple Ranged");
        classArmorProficiencies.put("Warlord", warlordArmor);
        classWeaponProficiencies.put("Warlord", warlordWeapon);
        List<String> wizardArmor = new ArrayList<>();
        List<String> wizardWeapon = new ArrayList<>();
        wizardArmor.add("Cloth Armor");
        wizardWeapon.add("Dagger");
        wizardWeapon.add("Quarterstaff");
        wizardWeapon.add("Orb");
        wizardWeapon.add("Staff");
        wizardWeapon.add("Wand");
        wizardWeapon.add("Tome");
        classArmorProficiencies.put("Wizard", wizardArmor);
        classWeaponProficiencies.put("Wizard", wizardWeapon);

    }


    private void populateTheSkillsAndCorrespondingAttributes() {
        skillsAndCorrespondingAttributes.put(HeroSkills.Acrobatics, AttributeNames.Dexterity);
        skillsAndCorrespondingAttributes.put(HeroSkills.Arcana, AttributeNames.Intelligence);
        skillsAndCorrespondingAttributes.put(HeroSkills.Athletics, AttributeNames.Strength);
        skillsAndCorrespondingAttributes.put(HeroSkills.Bluff, AttributeNames.Charisma);
        skillsAndCorrespondingAttributes.put(HeroSkills.Diplomacy, AttributeNames.Charisma);
        skillsAndCorrespondingAttributes.put(HeroSkills.Dungeoneering, AttributeNames.Wisdom);
        skillsAndCorrespondingAttributes.put(HeroSkills.Endurance, AttributeNames.Constitution);
        skillsAndCorrespondingAttributes.put(HeroSkills.Heal, AttributeNames.Wisdom);
        skillsAndCorrespondingAttributes.put(HeroSkills.History, AttributeNames.Wisdom);
        skillsAndCorrespondingAttributes.put(HeroSkills.Insight, AttributeNames.Wisdom);
        skillsAndCorrespondingAttributes.put(HeroSkills.Intimidate, AttributeNames.Charisma);
        skillsAndCorrespondingAttributes.put(HeroSkills.Nature, AttributeNames.Wisdom);
        skillsAndCorrespondingAttributes.put(HeroSkills.Perception, AttributeNames.Wisdom);
        skillsAndCorrespondingAttributes.put(HeroSkills.Religion, AttributeNames.Wisdom);
        skillsAndCorrespondingAttributes.put(HeroSkills.Stealth, AttributeNames.Dexterity);
        skillsAndCorrespondingAttributes.put(HeroSkills.Streetwise, AttributeNames.Charisma);
        skillsAndCorrespondingAttributes.put(HeroSkills.Thievery, AttributeNames.Dexterity);
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
        atWillPowersAtLevel1.put(HeroClasses.Avenger.toString(), avenger);
        avenger.add(new BondOfRetribution());
        avenger.add(new BondOfPursuit());
        avenger.add(new OverwhelmingStrike());
        avenger.add(new RadiantVengeance());
        List<HeroPower> barbarian = new ArrayList<>();
        atWillPowersAtLevel1.put(HeroClasses.Barbarian.toString(), barbarian);
        barbarian.add(new RecuperatingStrike());
        barbarian.add(new PressingStrike());
        barbarian.add(new DevastatingStrike());
        barbarian.add(new HowlingStrike());
        List<HeroPower> bard = new ArrayList<>();
        atWillPowersAtLevel1.put(HeroClasses.Bard.toString(), bard);
        bard.add(new GuidingStrike());
        bard.add(new MisdirectedMark());
        bard.add(new ViciousMockery());
        bard.add(new WarSongStrike());
        List<HeroPower> cleric = new ArrayList<>();
        atWillPowersAtLevel1.put(HeroClasses.Cleric.toString(), cleric);
        cleric.add(new LanceOfFaith());
        cleric.add(new PriestsShield());
        cleric.add(new RighteousBrand());
        cleric.add(new SacredFlame());
        List<HeroPower> druid = new ArrayList<>();
        atWillPowersAtLevel1.put(HeroClasses.Druid.toString(), druid);
        druid.add(new CallOfTheBeast());
        druid.add(new ChillWind());
        druid.add(new GraspingClaws());
        druid.add(new Pounce());
        druid.add(new SavageRend());
        druid.add(new ThornWhip());
        List<HeroPower> fighter = new ArrayList<>();
        atWillPowersAtLevel1.put(HeroClasses.Fighter.toString(), fighter);
        fighter.add(new Cleave());
        fighter.add(new ReapingStrike());
        fighter.add(new SureStrike());
        fighter.add(new TideOfIron());
        List<HeroPower> invoker = new ArrayList<>();
        atWillPowersAtLevel1.put(HeroClasses.Invoker.toString(), invoker);
        invoker.add(new AvengingLight());
        invoker.add(new DivineBolts());
        invoker.add(new GraspingClaws());
        invoker.add(new SunStrike());
        List<HeroPower> paladin = new ArrayList<>();
        atWillPowersAtLevel1.put(HeroClasses.Paladin.toString(), paladin);
        paladin.add(new BolsteringStrike());
        paladin.add(new EnfeeblingStrike());
        paladin.add(new HolyStrike());
        paladin.add(new ValiantStrike());
        List<HeroPower> ranger = new ArrayList<>();
        atWillPowersAtLevel1.put(HeroClasses.Ranger.toString(), ranger);
        ranger.add(new CarefulAttack());
        ranger.add(new HitAndRun());
        ranger.add(new NimbleStrike());
        ranger.add(new TwinStrike());
        List<HeroPower> rogue = new ArrayList<>();
        atWillPowersAtLevel1.put(HeroClasses.Rogue.toString(), rogue);
        rogue.add(new DeftStrike());
        rogue.add(new PiercingStrike());
        rogue.add(new RiposteStrike());
        rogue.add(new SlyFlourish());
        List<HeroPower> shaman = new ArrayList<>();
        atWillPowersAtLevel1.put(HeroClasses.Shaman.toString(), shaman);
        shaman.add(new DefendingStrike());
        shaman.add(new HauntingSpirits());
        shaman.add(new ProtectingStrike());
        shaman.add(new StalkersStrike());
        shaman.add(new WatchersStrike());
        shaman.add(new WrathOfWinter());
        List<HeroPower> sorcerer = new ArrayList<>();
        atWillPowersAtLevel1.put(HeroClasses.Sorcerer.toString(), sorcerer);
        sorcerer.add(new AcidOrb());
        sorcerer.add(new BurningSpray());
        sorcerer.add(new ChaosBolt());
        sorcerer.add(new Dragonfrost());
        sorcerer.add(new StormWalk());
        List<HeroPower> warlock = new ArrayList<>();
        atWillPowersAtLevel1.put(HeroClasses.Warlock.toString(), warlock);
        warlock.add(new DireRadiance());
        warlock.add(new EldritchBlast());
        warlock.add(new Eyebite());
        warlock.add(new HellishRebuke());
        List<HeroPower> warlord = new ArrayList<>();
        atWillPowersAtLevel1.put(HeroClasses.Warlord.toString(), warlord);
        warlord.add(new CommandersStrike());
        warlord.add(new FuriousSmash());
        warlord.add(new VipersStrike());
        warlord.add(new WolfsPackTactics());
        List<HeroPower> wizard = new ArrayList<>();
        atWillPowersAtLevel1.put(HeroClasses.Wizard.toString(), wizard);
        wizard.add(new CloudOfDaggers());
        wizard.add(new MagicMissile());
        wizard.add(new RayOfFrost());
        wizard.add(new ScorchingBurst());
        wizard.add(new Thunderwave());
    }

    private void populateTheTablesWithEncounterPowers() {
        List<HeroPower> avenger = new ArrayList<>();
        encounterPowersAtLevel1.put(HeroClasses.Avenger.toString(), avenger);
        avenger.add(new AngelicAlacrity());
        avenger.add(new AvengingEcho());
        avenger.add(new SharedMadness());
        avenger.add(new WhirlwindCharge());
        List<HeroPower> barbarian = new ArrayList<>();
        encounterPowersAtLevel1.put(HeroClasses.Barbarian.toString(), barbarian);
        barbarian.add(new AvalancheStrike());
        barbarian.add(new Bloodletting());
        barbarian.add(new GreatCleave());
        barbarian.add(new VaultOfTheFallen());
        List<HeroPower> bard = new ArrayList<>();
        encounterPowersAtLevel1.put(HeroClasses.Bard.toString(), bard);
        bard.add(new Blunder());
        bard.add(new FastFriends());
        bard.add(new InspiringRefrain());
        bard.add(new ShoutOfTriumph());
        List<HeroPower> cleric = new ArrayList<>();
        encounterPowersAtLevel1.put(HeroClasses.Cleric.toString(), cleric);
        cleric.add(new CauseFear());
        cleric.add(new DivineGlow());
        cleric.add(new HealingStrike());
        cleric.add(new WrathfulThunder());
        List<HeroPower> druid = new ArrayList<>();
        encounterPowersAtLevel1.put(HeroClasses.Druid.toString(), druid);
        druid.add(new CullTheHerd());
        druid.add(new DartingBite());
        druid.add(new FrostFlash());
        druid.add(new TwistingVines());
        List<HeroPower> fighter = new ArrayList<>();
        encounterPowersAtLevel1.put(HeroClasses.Fighter.toString(), fighter);
        fighter.add(new CoveringAttack());
        fighter.add(new PassingAttack());
        fighter.add(new SpinningSweep());
        fighter.add(new SteelSerpentStrike());
        List<HeroPower> invoker = new ArrayList<>();
        encounterPowersAtLevel1.put(HeroClasses.Invoker.toString(), invoker);
        invoker.add(new AstralTerror());
        invoker.add(new BladeOfAstralFire());
        invoker.add(new SpearOfTheInquisitor());
        invoker.add(new ThunderOfJudgement());
        List<HeroPower> paladin = new ArrayList<>();
        encounterPowersAtLevel1.put(HeroClasses.Paladin.toString(), paladin);
        paladin.add(new FearsomeSmite());
        paladin.add(new PiercingSmite());
        paladin.add(new RadiantSmite());
        paladin.add(new ShieldingSmite());
        List<HeroPower> ranger = new ArrayList<>();
        encounterPowersAtLevel1.put(HeroClasses.Ranger.toString(), ranger);
        ranger.add(new DireWolverineStrike());
        ranger.add(new EvasiveStrike());
        ranger.add(new FoxsCunning());
        ranger.add(new TwoFangedStrike());
        List<HeroPower> rogue = new ArrayList<>();
        encounterPowersAtLevel1.put(HeroClasses.Rogue.toString(), rogue);
        rogue.add(new DazingStrike());
        rogue.add(new KingsCastle());
        rogue.add(new PositioningStrike());
        rogue.add(new TorturousStrike());
        List<HeroPower> shaman = new ArrayList<>();
        encounterPowersAtLevel1.put(HeroClasses.Shaman.toString(), shaman);
        shaman.add(new CallToTheAncientDefender());
        shaman.add(new ThunderBearsWarding());
        shaman.add(new TwinPanthers());
        List<HeroPower> sorcerer = new ArrayList<>();
        encounterPowersAtLevel1.put(HeroClasses.Sorcerer.toString(), sorcerer);
        sorcerer.add(new BedevilingBurst());
        sorcerer.add(new ExplosivePyre());
        sorcerer.add(new Frostbind());
        sorcerer.add(new TempestBreath());
        sorcerer.add(new ThunderSlam());
        List<HeroPower> warlock = new ArrayList<>();
        encounterPowersAtLevel1.put(HeroClasses.Warlock.toString(), warlock);
        warlock.add(new DiabolicGrasp());
        warlock.add(new DreadfulWord());
        warlock.add(new VampiricEmbrace());
        warlock.add(new Witchfire());
        List<HeroPower> warlord = new ArrayList<>();
        encounterPowersAtLevel1.put(HeroClasses.Warlord.toString(), warlord);
        warlord.add(new GuardingAttack());
        warlord.add(new HammerAndAnvil());
        warlord.add(new LeafOnTheWind());
        warlord.add(new WarlordsFavor());
        List<HeroPower> wizard = new ArrayList<>();
        encounterPowersAtLevel1.put(HeroClasses.Wizard.toString(), wizard);
        wizard.add(new BurningHands());
        wizard.add(new ChillStrike());
        wizard.add(new ForceOrb());
        wizard.add(new IcyTerrain());
        wizard.add(new RayOfEnfeeblement());
    }

    private void populateTheTablesWithDailyPowers() {
        List<HeroPower> avenger = new ArrayList<>();
        dailyPowersAtLevel1.put(HeroClasses.Avenger.toString(), avenger);
        avenger.add(new AspectOfMight());
        avenger.add(new OathOfTheFinalDuel());
        avenger.add(new RenewingStrike());
        avenger.add(new TempleOfLight());
        List<HeroPower> barbarian = new ArrayList<>();
        dailyPowersAtLevel1.put(HeroClasses.Barbarian.toString(), barbarian);
        barbarian.add(new BloodhuntRage());
        barbarian.add(new MacetailsRage());
        barbarian.add(new RageDrakesFrenzy());
        barbarian.add(new SwiftPantherRage());
        List<HeroPower> bard = new ArrayList<>();
        dailyPowersAtLevel1.put(HeroClasses.Bard.toString(), bard);
        bard.add(new EchoesOfTheGuardian());
        bard.add(new SlayersSong());
        bard.add(new StirringShout());
        bard.add(new VerseOfTriumph());
        List<HeroPower> cleric = new ArrayList<>();
        dailyPowersAtLevel1.put(HeroClasses.Cleric.toString(), cleric);
        cleric.add(new AvengingFlame());
        cleric.add(new BeaconOfHope());
        cleric.add(new CascadeOfLight());
        cleric.add(new GuardianOfFaith());
        List<HeroPower> druid = new ArrayList<>();
        dailyPowersAtLevel1.put(HeroClasses.Druid.toString(), druid);
        druid.add(new CullTheHerd());
        druid.add(new DartingBite());
        druid.add(new FrostFlash());
        druid.add(new TwistingVines());
        List<HeroPower> fighter = new ArrayList<>();
        dailyPowersAtLevel1.put(HeroClasses.Fighter.toString(), fighter);
        fighter.add(new CoveringAttack());
        fighter.add(new PassingAttack());
        fighter.add(new SpinningSweep());
        fighter.add(new SteelSerpentStrike());
        List<HeroPower> invoker = new ArrayList<>();
        dailyPowersAtLevel1.put(HeroClasses.Invoker.toString(), invoker);
        invoker.add(new AstralTerror());
        invoker.add(new BladeOfAstralFire());
        invoker.add(new SpearOfTheInquisitor());
        invoker.add(new ThunderOfJudgement());
        List<HeroPower> paladin = new ArrayList<>();
        dailyPowersAtLevel1.put(HeroClasses.Paladin.toString(), paladin);
        paladin.add(new FearsomeSmite());
        paladin.add(new PiercingSmite());
        paladin.add(new RadiantSmite());
        paladin.add(new ShieldingSmite());
        List<HeroPower> ranger = new ArrayList<>();
        dailyPowersAtLevel1.put(HeroClasses.Ranger.toString(), ranger);
        ranger.add(new DireWolverineStrike());
        ranger.add(new EvasiveStrike());
        ranger.add(new FoxsCunning());
        ranger.add(new TwoFangedStrike());
        List<HeroPower> rogue = new ArrayList<>();
        dailyPowersAtLevel1.put(HeroClasses.Rogue.toString(), rogue);
        rogue.add(new DazingStrike());
        rogue.add(new KingsCastle());
        rogue.add(new PositioningStrike());
        rogue.add(new TorturousStrike());
        List<HeroPower> shaman = new ArrayList<>();
        dailyPowersAtLevel1.put(HeroClasses.Shaman.toString(), shaman);
        shaman.add(new CallToTheAncientDefender());
        shaman.add(new ThunderBearsWarding());
        shaman.add(new TwinPanthers());
        List<HeroPower> sorcerer = new ArrayList<>();
        dailyPowersAtLevel1.put(HeroClasses.Sorcerer.toString(), sorcerer);
        sorcerer.add(new BedevilingBurst());
        sorcerer.add(new ExplosivePyre());
        sorcerer.add(new Frostbind());
        sorcerer.add(new TempestBreath());
        sorcerer.add(new ThunderSlam());
        List<HeroPower> warlock = new ArrayList<>();
        dailyPowersAtLevel1.put(HeroClasses.Warlock.toString(), warlock);
        warlock.add(new DiabolicGrasp());
        warlock.add(new DreadfulWord());
        warlock.add(new VampiricEmbrace());
        warlock.add(new Witchfire());
        List<HeroPower> warlord = new ArrayList<>();
        dailyPowersAtLevel1.put(HeroClasses.Warlord.toString(), warlord);
        warlord.add(new GuardingAttack());
        warlord.add(new HammerAndAnvil());
        warlord.add(new LeafOnTheWind());
        warlord.add(new WarlordsFavor());
        List<HeroPower> wizard = new ArrayList<>();
        dailyPowersAtLevel1.put(HeroClasses.Wizard.toString(), wizard);
        wizard.add(new BurningHands());
        wizard.add(new ChillStrike());
        wizard.add(new ForceOrb());
        wizard.add(new IcyTerrain());
        wizard.add(new RayOfEnfeeblement());
    }


    private void populateTheTablesWithTraits() {
        List<String> avenger = new ArrayList<>();
        classTraits.put(HeroClasses.Avenger.toString(), avenger);
        avenger.add("Censure of Pursuit");
        avenger.add("Censure of Retribution");
        List<String> barbarian = new ArrayList<>();
        classTraits.put(HeroClasses.Barbarian.toString(), barbarian);
        barbarian.add("Rageblood Vigor");
        barbarian.add("Thaneborn Triumph");
        List<String> bard = new ArrayList<>();
        classTraits.put(HeroClasses.Bard.toString(), bard);
        bard.add("Virtue of Cunning");
        bard.add("Virtue of Valor");
        List<String> cleric = new ArrayList<>();
        classTraits.put(HeroClasses.Cleric.toString(), cleric);
        cleric.add("Death Domain");
        cleric.add("Domination Domain");
        cleric.add("Earth Domain");
        cleric.add("Storm Domain");
        cleric.add("Sun Domain");
        List<String> druid = new ArrayList<>();
        classTraits.put(HeroClasses.Druid.toString(), druid);
        druid.add("Primal Guardian");
        druid.add("Primal Predator");
        List<String> fighter = new ArrayList<>();
        classTraits.put(HeroClasses.Fighter.toString(), fighter);
        fighter.add("Great Weapon Fighter");
        fighter.add("Guardian Fighter");
        List<String> invoker = new ArrayList<>();
        classTraits.put(HeroClasses.Invoker.toString(), invoker);
        invoker.add("Covenant of Preservation");
        invoker.add("Covenant of Wrath");
        List<String> paladin = new ArrayList<>();
        classTraits.put(HeroClasses.Paladin.toString(), paladin);
        paladin.add("Avenging Paladin");
        paladin.add("Protecting Paladin");
        List<String> ranger = new ArrayList<>();
        classTraits.put(HeroClasses.Ranger.toString(), ranger);
        ranger.add("Archer Ranger");
        ranger.add("Two-Blade Ranger");
        List<String> rogue = new ArrayList<>();
        classTraits.put(HeroClasses.Rogue.toString(), rogue);
        rogue.add("Brutal Scoundrel");
        rogue.add("Artful Dodger");
        List<String> shaman = new ArrayList<>();
        classTraits.put(HeroClasses.Shaman.toString(), shaman);
        shaman.add("Protector Spirit");
        shaman.add("Stalker Spirit");
        List<String> sorcerer = new ArrayList<>();
        classTraits.put(HeroClasses.Sorcerer.toString(), sorcerer);
        sorcerer.add("Cosmic Magic");
        sorcerer.add("Dragon Magic");
        sorcerer.add("Wild Magic");
        List<String> warlock = new ArrayList<>();
        classTraits.put(HeroClasses.Warlock.toString(), warlock);
        warlock.add("Fey Pact");
        warlock.add("Star Pact");
        List<String> warlord = new ArrayList<>();
        classTraits.put(HeroClasses.Warlord.toString(), warlord);
        warlord.add("Inspiring Presence");
        warlord.add("Tactical Presence");
        List<String> wizard = new ArrayList<>();
        classTraits.put(HeroClasses.Wizard.toString(), wizard);
        wizard.add("Arcanist");
        wizard.add("Mage");
    }

    public List<String> manageRacialStatBonuses(String raceName) {
        List<String> racialBonuses = new ArrayList<>();
        switch (raceName) {
            case "Deva": {
                racialBonuses.add("Charisma");
                racialBonuses.add("Intelligence");
                racialBonuses.add("Wisdom");
                break;
            }
            case "Dragonborn": {
                racialBonuses.add("Charisma");
                racialBonuses.add("Strength");
                racialBonuses.add("Constitution");
                break;
            }
            case "Dwarf": {
                racialBonuses.add("Constitution");
                racialBonuses.add("Strength");
                racialBonuses.add("Wisdom");
                break;
            }
            case "Eladrin":
            case "Gnome": {
                racialBonuses.add("Intelligence");
                racialBonuses.add("Dexterity");
                racialBonuses.add("Charisma");
                break;
            }
            case "Elf": {
                racialBonuses.add("Dexterity");
                racialBonuses.add("Intelligence");
                racialBonuses.add("Wisdom");
                break;
            }
            case "Goliath": {
                racialBonuses.add("Strength");
                racialBonuses.add("Constitution");
                racialBonuses.add("Wisdom");
                break;
            }
            case "Halfelf": {
                racialBonuses.add("Constitution");
                racialBonuses.add("Wisdom");
                racialBonuses.add("Charisma");
                break;
            }
            case "Halforc": {
                racialBonuses.add("Dexterity");
                racialBonuses.add("Strength");
                racialBonuses.add("Constitution");
                break;
            }
            case "Halfling": {
                racialBonuses.add("Dexterity");
                racialBonuses.add("Charisma");
                racialBonuses.add("Constitution");
                break;
            }
            case "Shifter": {
                racialBonuses.add("Wisdom");
                racialBonuses.add("Strength");
                racialBonuses.add("Dexterity");
                break;
            }
            case "Tiefling": {
                racialBonuses.add("Charisma");
                racialBonuses.add("Constitution");
                racialBonuses.add("Intelligence");
                break;
            }
        }
        return racialBonuses;
    }

    public List<String> manageClassDefenceBonuses(String className) {
        List<String> listOfBonuses = new ArrayList<>();
        switch (className) {
            case "Avenger":
            case "Invoker":
            case "Paladin": {
                listOfBonuses.add(CreatureDefenses.Fortitude.toString());
                listOfBonuses.add(CreatureDefenses.Reflex.toString());
                listOfBonuses.add(CreatureDefenses.Will.toString());
                break;
            }
            case "Barbarian":
            case "Fighter": {
                listOfBonuses.add(CreatureDefenses.Fortitude.toString());
                listOfBonuses.add(CreatureDefenses.Fortitude.toString());
                break;
            }
            case "Bard":
            case "Druid":
            case "Warlock": {
                listOfBonuses.add(CreatureDefenses.Reflex.toString());
                listOfBonuses.add(CreatureDefenses.Will.toString());
                break;
            }
            case "Cleric":
            case "Sorcerer":
            case "Wizard": {
                listOfBonuses.add(CreatureDefenses.Will.toString());
                listOfBonuses.add(CreatureDefenses.Will.toString());
                break;
            }
            case "Ranger": {
                listOfBonuses.add(CreatureDefenses.Fortitude.toString());
                listOfBonuses.add(CreatureDefenses.Reflex.toString());
                break;
            }
            case "Rogue": {
                listOfBonuses.add(CreatureDefenses.Reflex.toString());
                listOfBonuses.add(CreatureDefenses.Reflex.toString());
                break;
            }
            case "Shaman":
            case "Warden":
            case "Warlord": {
                listOfBonuses.add(CreatureDefenses.Fortitude.toString());
                listOfBonuses.add(CreatureDefenses.Will.toString());
                break;
            }
        }
        return listOfBonuses;
    }

    public HeroPower getHeroPowerByName(String className, String powerName, String typeOfPower) {

        try {
            if (typeOfPower.contains("Will")) {
                for (HeroPower currentPower : atWillPowersAtLevel1.get(className)) {
                    if (powerName.equals(currentPower.getPowerName())) {
                        return currentPower;
                    }
                }
            } else if (typeOfPower.contains("Encounter")) {
                for (HeroPower currentPower : encounterPowersAtLevel1.get(className)) {
                    if (powerName.equals(currentPower.getPowerName())) {
                        return currentPower;
                    }
                }
            } else if (typeOfPower.contains("Daily")) {
                for (HeroPower currentPower : dailyPowersAtLevel1.get(className)) {
                    if (powerName.equals(currentPower.getPowerName())) {
                        return currentPower;
                    }
                }
            }
        } catch (NullPointerException ignored) {
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
