package sample.DAO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import sample.DTO.CharacterCreatorDTO;
import sample.HeroPowers.HeroPower;
import sample.Model.Hero;
import sample.StaticRules.HeroClassInformation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CharacterCreatorDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";

    private Connection conn;
    private PreparedStatement pst;

    public CharacterCreatorDAO() throws SQLException {
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Creating connection...");
        conn.createStatement();
    }

    public Image getHeroIconByID(int id) throws SQLException, IOException {
        String sql = "SELECT heroicons.id_hero_icons, heroicons.hero_icon FROM dungeon.heroicons WHERE (id_hero_icons=?);";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            Blob blob = rs.getBlob("hero_icon");
            InputStream in = blob.getBinaryStream();
            BufferedImage bufferedImage = ImageIO.read(in);
            return SwingFXUtils.toFXImage(bufferedImage, null);
        }
        return null;
    }

    public ResultSet getAllHeroIcons() throws SQLException {
        String sql = "SELECT `heroicons`.`id_hero_icons`,`heroicons`.`hero_icon`FROM `dungeon`.`heroicons`;";
        pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        return rs;
    }

    public List<String> getAllHeroNames() throws SQLException {
        List<String> namesToBeReturned = new ArrayList<>();
        String sql = "SELECT" +
                "    `heroes`.`hero_name`" +
                "FROM `dungeon`.`heroes`;";
        pst = conn.prepareStatement(sql);
        ResultSet results = pst.executeQuery();
        while (results.next()) {
            String name = results.getString("hero_name");
            namesToBeReturned.add(name);
        }
        return namesToBeReturned;
    }

    public int getNumberOfHeroes() throws SQLException {
        String sql = "SELECT COUNT(*) from dungeon.heroes;";
        int numberOfHeroes = 0;
        pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            numberOfHeroes = rs.getInt("COUNT(*)");
        }
        return numberOfHeroes;
    }

    public Hero getAHeroByID(int ID) throws SQLException, IOException {
        Hero hero = new Hero();
        HeroClassInformation heroClassInformation = new HeroClassInformation();
        System.out.println("-----> Hero ID From DAO" + ID);
        String sql = "SELECT * FROM dungeon.heroes WHERE idheroes = ?;";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, ID);
        ResultSet rs = pst.executeQuery();
        String a = "a";
        String b = "B";
        //todo think about DRY here
        while (rs.next()) {
            a = rs.getString("hero_name");
            b = rs.getString("icon_id");
            hero.setHeroIcon(getHeroIconByID(rs.getInt("icon_id")));
            hero.setID(rs.getInt("idheroes"));
            hero.setHeroName(rs.getString("hero_name"));
            String heroClass = rs.getString("hero_class");
            hero.setHeroClass(heroClass);
            hero.setHeroRace(rs.getString("hero_race"));
            hero.setStrength(rs.getInt("strength"));
            hero.setConstitution(rs.getInt("constitution"));
            hero.setDexterity(rs.getInt("dexterity"));
            hero.setIntelligence(rs.getInt("intelligence"));
            hero.setWisdom(rs.getInt("wisdom"));
            hero.setCharisma(rs.getInt("charisma"));
            manageHeroDefenses(hero, rs);
            manageHeroSkills(hero, rs);
            manageHeroPowers(hero, heroClassInformation, rs, heroClass);
        }
        System.out.println(hero.getHeroName() + "|||" + a + " Icon number: " + b);
        return hero;
    }

    private void manageHeroDefenses(Hero hero, ResultSet rs) throws SQLException {
        hero.setAC(rs.getInt("ac"));
        hero.setFortitude(rs.getInt("fortitude"));
        hero.setReflex(rs.getInt("reflex"));
        hero.setWill(rs.getInt("will"));
    }

    private void manageHeroSkills(Hero hero, ResultSet rs) throws SQLException {
        hero.setAcrobatics(rs.getInt("sk_acrobatics"));
        hero.setArcana(rs.getInt("sk_arcana"));
        hero.setAthletics(rs.getInt("sk_athletics"));
        hero.setBluff(rs.getInt("sk_bluff"));
        hero.setDiplomacy(rs.getInt("sk_diplomacy"));
        hero.setDungeoneering(rs.getInt("sk_dungeoneering"));
        hero.setEndurance(rs.getInt("sk_endurance"));
        hero.setHeal(rs.getInt("sk_heal"));
        hero.setHistory(rs.getInt("sk_history"));
        hero.setInsight(rs.getInt("sk_insight"));
        hero.setIntimidate(rs.getInt("sk_intimidate"));
        hero.setNature(rs.getInt("sk_nature"));
        hero.setPerception(rs.getInt("sk_perception"));
        hero.setReligion(rs.getInt("sk_religion"));
        hero.setStealth(rs.getInt("sk_stealth"));
        hero.setStreetwise(rs.getInt("sk_streetwise"));
        hero.setThievery(rs.getInt("sk_thievery"));
    }

    private void manageHeroPowers(Hero hero, HeroClassInformation heroClassInformation, ResultSet rs, String heroClass) throws SQLException {
        String allAtWillPowers = rs.getString("powers_at_will");
        String allEncounterPowers = rs.getString("powers_encounter");
        String allDailyPowers = rs.getString("powers_daily");
        List<HeroPower> allAtWillPowersForHero = heroClassInformation.getAtWillPowersAtLevel1().get(heroClass);
        List<HeroPower> validAtWillPowersForHero = new ArrayList<>();
        for (HeroPower currentPower : allAtWillPowersForHero) {
            if (allAtWillPowers.contains(currentPower.getPowerName())) {
                validAtWillPowersForHero.add(currentPower);
            }
        }
        hero.setAtWillPowers(validAtWillPowersForHero);
        List<HeroPower> allEncounterPowersForHero = heroClassInformation.getEncounterPowersAtLevel1().get(heroClass);
        List<HeroPower> validEncounterPowersForHero = new ArrayList<>();
        for (HeroPower currentPower : allEncounterPowersForHero) {
            if (allEncounterPowers.contains(currentPower.getPowerName())) {
                validEncounterPowersForHero.add(currentPower);
            }
        }
        hero.setEncounterPowers(validEncounterPowersForHero);
        List<HeroPower> allDailyPowersForHero = heroClassInformation.getDailyPowersAtLevel1().get(heroClass);
        List<HeroPower> validDailyPowersForHero = new ArrayList<>();
        for (HeroPower currentPower : allDailyPowersForHero) {
            if (allDailyPowers.contains(currentPower.getPowerName())) {
                validDailyPowersForHero.add(currentPower);
            }
        }
        hero.setDailyPowers(validDailyPowersForHero);
    }

    public List<CharacterCreatorDTO> getAllHeroes() throws SQLException, IOException {
        List<CharacterCreatorDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM dungeon.heroes";
        pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            CharacterCreatorDTO dto = new CharacterCreatorDTO();
            dto.setHeroImage(getHeroIconByID(rs.getInt("icon_id")));
            dto.setHeroID(rs.getInt("idheroes"));
            dto.setHeroName(rs.getString("hero_name"));
            dto.setHeroClass(rs.getString("hero_class"));
            dto.setHeroRace(rs.getString("hero_race"));
            dto.setStrength(rs.getInt("strength"));
            dto.setConstitution(rs.getInt("constitution"));
            dto.setDexterity(rs.getInt("dexterity"));
            dto.setIntelligence(rs.getInt("intelligence"));
            dto.setWisdom(rs.getInt("wisdom"));
            dto.setCharisma(rs.getInt("charisma"));
            dto.setAC(rs.getInt("ac"));
            dto.setFortitude(rs.getInt("fortitude"));
            dto.setReflex(rs.getInt("reflex"));
            dto.setWill(rs.getInt("will"));
            dto.setHeroIconId(rs.getInt("icon_id"));
            dto.setAcrobatics(rs.getInt("sk_acrobatics"));
            dto.setArcana(rs.getInt("sk_arcana"));
            dto.setAthletics(rs.getInt("sk_athletics"));
            dto.setBluff(rs.getInt("sk_bluff"));
            dto.setDiplomacy(rs.getInt("sk_diplomacy"));
            dto.setDungeoneering(rs.getInt("sk_dungeoneering"));
            dto.setEndurance(rs.getInt("sk_endurance"));
            dto.setHeal(rs.getInt("sk_heal"));
            dto.setHistory(rs.getInt("sk_history"));
            dto.setInsight(rs.getInt("sk_insight"));
            dto.setIntimidate(rs.getInt("sk_intimidate"));
            dto.setNature(rs.getInt("sk_nature"));
            dto.setPerception(rs.getInt("sk_perception"));
            dto.setReligion(rs.getInt("sk_religion"));
            dto.setStealth(rs.getInt("sk_stealth"));
            dto.setStreetwise(rs.getInt("sk_streetwise"));
            dto.setThievery(rs.getInt("sk_thievery"));
            //todo write a separate method that accepts a full string from sql, and changes it to list of Strings (check if it's necessary)
            String allAtWillPowers = rs.getString("powers_at_will");
            dto.setAtWillPower1(allAtWillPowers.substring(0, allAtWillPowers.indexOf("_") - 1));
            dto.setAtWillPower2(allAtWillPowers.substring(allAtWillPowers.lastIndexOf("_") + 1));
            String allEncounterPowers = rs.getString("powers_encounter");
            dto.setEncounterPower1(allEncounterPowers.substring(0, allEncounterPowers.indexOf("_") - 1));
            String allDailyPowers = rs.getString("powers_daily");
            dto.setDailyPower1(allDailyPowers.substring(0, allDailyPowers.indexOf("_") - 1));
            list.add(dto);
        }
        for (CharacterCreatorDTO a : list) {
            System.out.println("HERO" + a.getHeroName() + "COPIED FROM DATABASE");
        }
        return list;
    }

    public void addAHeroToDatabase(CharacterCreatorDTO heroToBeAdded) throws SQLException {
        String sql = "INSERT INTO dungeon.heroes(" +
                "hero_name," +
                "hero_class," +
                "hero_race," +
                "strength," +
                "constitution," +
                "dexterity," +
                "intelligence," +
                "wisdom," +
                "charisma," +
                "ac," +
                "fortitude," +
                "reflex," +
                "will," +
                "gold," +
                "icon_id," +
                "sk_acrobatics," +
                "sk_arcana," +
                "sk_athletics," +
                "sk_bluff," +
                "sk_diplomacy," +
                "sk_dungeoneering," +
                "sk_endurance," +
                "sk_heal," +
                "sk_history," +
                "sk_insight," +
                "sk_intimidate," +
                "sk_nature," +
                "sk_perception," +
                "sk_religion," +
                "sk_stealth," +
                "sk_streetwise," +
                "sk_thievery," +
                "powers_at_will," +
                "powers_encounter," +
                "powers_daily)" +
                "VALUES" +
                "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        pst = conn.prepareStatement(sql);
        pst.setString(1, heroToBeAdded.getHeroName());
        pst.setString(2, heroToBeAdded.getHeroClass());
        pst.setString(3, heroToBeAdded.getHeroRace());
        pst.setInt(4, heroToBeAdded.getStrength());
        pst.setInt(5, heroToBeAdded.getConstitution());
        pst.setInt(6, heroToBeAdded.getDexterity());
        pst.setInt(7, heroToBeAdded.getIntelligence());
        pst.setInt(8, heroToBeAdded.getWisdom());
        pst.setInt(9, heroToBeAdded.getCharisma());
        pst.setInt(10, heroToBeAdded.getCharisma());
        pst.setInt(11, heroToBeAdded.getFortitude());
        pst.setInt(12, heroToBeAdded.getReflex());
        pst.setInt(13, heroToBeAdded.getWill());
        pst.setInt(14, heroToBeAdded.getGold());
        pst.setInt(15, heroToBeAdded.getHeroIconId());
        pst.setInt(16, heroToBeAdded.getAcrobatics());
        pst.setInt(17, heroToBeAdded.getArcana());
        pst.setInt(18, heroToBeAdded.getAthletics());
        pst.setInt(19, heroToBeAdded.getBluff());
        pst.setInt(20, heroToBeAdded.getDiplomacy());
        pst.setInt(21, heroToBeAdded.getDungeoneering());
        pst.setInt(22, heroToBeAdded.getEndurance());
        pst.setInt(23, heroToBeAdded.getHeal());
        pst.setInt(24, heroToBeAdded.getHistory());
        pst.setInt(25, heroToBeAdded.getInsight());
        pst.setInt(26, heroToBeAdded.getIntimidate());
        pst.setInt(27, heroToBeAdded.getNature());
        pst.setInt(28, heroToBeAdded.getPerception());
        pst.setInt(29, heroToBeAdded.getReligion());
        pst.setInt(30, heroToBeAdded.getStealth());
        pst.setInt(31, heroToBeAdded.getStreetwise());
        pst.setInt(32, heroToBeAdded.getThievery());
        pst.setString(33, heroToBeAdded.getAtWillPower1() + "___" + heroToBeAdded.getAtWillPower2());
        pst.setString(34, heroToBeAdded.getEncounterPower1() + "___");
        pst.setString(35, heroToBeAdded.getDailyPower1() + "___");
        pst.executeUpdate();
        System.out.println("Character has successfully been added to the database");
    }

}