package sample;

import java.sql.*;


public class SQLConnector {

    static final String DB_URL = "jdbc:mysql://localhost:3306/mysql";
    static final String USER = "root";
    static final String PASS = "root";

    void startAConnection() {

        Connection conn = null;
        Statement stmt = null;
        try {


            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating database...");
            stmt = conn.createStatement();

            String sql = "select * from dungeon.heroes";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("NAME");
                String heroclass = rs.getString("class");
                String heroRace = rs.getString("race");
                System.out.println(name + "\t" + heroclass +
                        "\t" + heroRace + "\t");
            }
            System.out.println("Database created successfully...");

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
