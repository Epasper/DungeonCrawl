package sample.DAO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import sample.DTO.CharacterCreatorDTO;
import sample.Model.Hero;

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

    public Hero convertDtoToHero(CharacterCreatorDTO dto) throws IOException, SQLException {
        Hero hero = new Hero();
        hero.setID(dto.getHeroID());
        hero.setHeroName(dto.getHeroName());
        hero.setHeroClass(dto.getHeroClass());
        hero.setHeroRace(dto.getHeroRace());
        hero.setHitPoints(dto.getHitPoints());
        hero.setGold(dto.getGold());
        hero.setHeroIconId(dto.getHeroIconId());
        hero.setStrength(dto.getStrength());
        hero.setConstitution(dto.getConstitution());
        hero.setDexterity(dto.getDexterity());
        hero.setIntelligence(dto.getIntelligence());
        hero.setWisdom(dto.getWisdom());
        hero.setCharisma(dto.getCharisma());
        hero.setReflex(dto.getReflex());
        hero.setFortitude(dto.getFortitude());
        hero.setWill(dto.getWill());
        return hero;
    }

    public Hero getAHeroByID(int ID) throws SQLException, IOException {
        Hero hero = new Hero();
        System.out.println("-----> Hero ID From DAO" + ID);
        String sql = "SELECT * FROM dungeon.heroes WHERE idheroes = ?;";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, ID);
        ResultSet rs = pst.executeQuery();
        String a = "a";
        String b = "B";
        while (rs.next()) {
            a = rs.getString("hero_name");
            b = rs.getString("icon_id");
            hero.setHeroIcon(getHeroIconByID(rs.getInt("icon_id")));
            hero.setID(rs.getInt("idheroes"));
            hero.setHeroName(rs.getString("hero_name"));
            hero.setHeroClass(rs.getString("hero_class"));
            hero.setHeroRace(rs.getString("hero_race"));
            hero.setStrength(rs.getInt("strength"));
            hero.setConstitution(rs.getInt("constitution"));
            hero.setDexterity(rs.getInt("dexterity"));
            hero.setIntelligence(rs.getInt("intelligence"));
            hero.setWisdom(rs.getInt("wisdom"));
            hero.setCharisma(rs.getInt("charisma"));
            hero.setFortitude(rs.getInt("fortitude"));
            hero.setReflex(rs.getInt("reflex"));
            hero.setWill(rs.getInt("will"));
            //todo add setters for skills
        }
        System.out.println(hero.getHeroName() + "|||" + a + " Icon number: " + b);
        return hero;
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
            dto.setFortitude(rs.getInt("fortitude"));
            dto.setReflex(rs.getInt("reflex"));
            dto.setWill(rs.getInt("will"));
            dto.setHeroIconId(rs.getInt("icon_id"));
            list.add(dto);
            //todo add setters for skills
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
                "sk_thievery)VALUES" +
                "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
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
        pst.setInt(10, heroToBeAdded.getFortitude());
        pst.setInt(11, heroToBeAdded.getReflex());
        pst.setInt(12, heroToBeAdded.getWill());
        pst.setInt(13, heroToBeAdded.getGold());
        pst.setInt(14, heroToBeAdded.getHeroIconId());
        pst.setInt(15, heroToBeAdded.getAcrobatics());
        pst.setInt(16, heroToBeAdded.getArcana());
        pst.setInt(17, heroToBeAdded.getAthletics());
        pst.setInt(18, heroToBeAdded.getBluff());
        pst.setInt(19, heroToBeAdded.getDiplomacy());
        pst.setInt(20, heroToBeAdded.getDungeoneering());
        pst.setInt(21, heroToBeAdded.getEndurance());
        pst.setInt(22, heroToBeAdded.getHeal());
        pst.setInt(23, heroToBeAdded.getHistory());
        pst.setInt(24, heroToBeAdded.getInsight());
        pst.setInt(25, heroToBeAdded.getIntimidate());
        pst.setInt(26, heroToBeAdded.getNature());
        pst.setInt(27, heroToBeAdded.getPerception());
        pst.setInt(28, heroToBeAdded.getReligion());
        pst.setInt(29, heroToBeAdded.getStealth());
        pst.setInt(30, heroToBeAdded.getStreetwise());
        pst.setInt(31, heroToBeAdded.getThievery());
        pst.executeUpdate();
        System.out.println("Character has successfully been added to the database");
    }

}