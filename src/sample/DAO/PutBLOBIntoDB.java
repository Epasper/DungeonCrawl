package sample.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class PutBLOBIntoDB {

    public static void putFiles() throws Exception {
        Connection conn = getConnection();
        Statement st = conn.createStatement();

        PreparedStatement ps = conn.prepareStatement("INSERT INTO dungeon.heroicons VALUES(15,?)");

        File file = new File("C:\\Users\\A753403\\IdeaProjects\\DungeonCrawl\\src\\sample\\GUI\\Images\\icon15.png");
        FileInputStream fis = new FileInputStream(file);
        ps.setBinaryStream(1, fis, (int) file.length());
        ps.execute();

        fis.close();
        st.close();
        conn.close();
    }

    private static Connection getConnection() throws Exception {
        //Class.forName("org.hsqldb.jdbcDriver");
        String url = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        return DriverManager.getConnection(url, "root", "root");
    }
}

