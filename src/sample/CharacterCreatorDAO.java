package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CharacterCreatorDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";

    Connection conn;
    Statement stmt;
    PreparedStatement pst;

    public CharacterCreatorDAO() throws SQLException {
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Creating connection...");
        stmt = conn.createStatement();

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

    public void addAHero(CharacterCreatorDTO heroToBeAdded) throws SQLException {
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
                "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
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
        pst.setInt(14, heroToBeAdded.getAcrobatics());
        pst.setInt(15, heroToBeAdded.getArcana());
        pst.setInt(16, heroToBeAdded.getAthletics());
        pst.setInt(17, heroToBeAdded.getBluff());
        pst.setInt(18, heroToBeAdded.getDiplomacy());
        pst.setInt(19, heroToBeAdded.getDungeoneering());
        pst.setInt(20, heroToBeAdded.getEndurance());
        pst.setInt(21, heroToBeAdded.getHeal());
        pst.setInt(22, heroToBeAdded.getHistory());
        pst.setInt(23, heroToBeAdded.getInsight());
        pst.setInt(24, heroToBeAdded.getIntimidate());
        pst.setInt(25, heroToBeAdded.getNature());
        pst.setInt(26, heroToBeAdded.getPerception());
        pst.setInt(27, heroToBeAdded.getReligion());
        pst.setInt(28, heroToBeAdded.getStealth());
        pst.setInt(29, heroToBeAdded.getStreetwise());
        pst.setInt(30, heroToBeAdded.getThievery());
        pst.executeUpdate();
        System.out.println("Character has successfully been added to the database");
    }

    void connectWithDatabase(String sql) {


        try {


            //String sql = "select * from dungeon.heroes";
            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                String name = rs.getString("HERO_NAME");
//                String heroclass = rs.getString("HERO_CLASS");
//                String heroRace = rs.getString("HERO_RACE");
//                System.out.println(name + "\t" + heroclass +
//                        "\t" + heroRace + "\t");
//            }
            System.out.println("Database accessed successfully...");

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException ignored) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");

    }


}
