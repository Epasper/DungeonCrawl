package sample.DAO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import sample.Items.Item;
import sample.StaticRules.ItemInformation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ItemShopDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";

    private Connection conn;
    private PreparedStatement pst;


    public ItemShopDAO() throws SQLException {
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Creating connection...");
        conn.createStatement();
    }

    public Map getHeroEquipmentByHeroID(int heroId) throws SQLException {
        ItemInformation itemInformation = new ItemInformation();
        Map<String, Item> mapToBeReturned=new HashMap<>();
        String sql = "SELECT * FROM hero_equipment WHERE (hero_id=?);";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, heroId);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            mapToBeReturned.put("Right Hand Slot Item",itemInformation.allItemsList.get(rs.getString("right_hand_slot")));
            mapToBeReturned.put("Left Hand Slot Item",itemInformation.allItemsList.get(rs.getString("left_hand_slot")));
            mapToBeReturned.put("Head Slot Item",itemInformation.allItemsList.get(rs.getString("head_slot")));
            mapToBeReturned.put("Torso Slot Item",itemInformation.allItemsList.get(rs.getString("torso_slot")));
            mapToBeReturned.put("Feet Slot Item",itemInformation.allItemsList.get(rs.getString("feet_slot")));
            mapToBeReturned.put("Arms Slot Item",itemInformation.allItemsList.get(rs.getString("arms_slot")));
            mapToBeReturned.put("Backpack Slot 1 Item",itemInformation.allItemsList.get(rs.getString("backpack1")));
            mapToBeReturned.put("Backpack Slot 2 Item",itemInformation.allItemsList.get(rs.getString("backpack2")));
            mapToBeReturned.put("Backpack Slot 3 Item",itemInformation.allItemsList.get(rs.getString("backpack3")));
            mapToBeReturned.put("Backpack Slot 4 Item",itemInformation.allItemsList.get(rs.getString("backpack4")));
            mapToBeReturned.put("Backpack Slot 5 Item",itemInformation.allItemsList.get(rs.getString("backpack5")));
            mapToBeReturned.put("Backpack Slot 6 Item",itemInformation.allItemsList.get(rs.getString("backpack6")));
            mapToBeReturned.put("Backpack Slot 7 Item",itemInformation.allItemsList.get(rs.getString("backpack7")));
            mapToBeReturned.put("Backpack Slot 8 Item",itemInformation.allItemsList.get(rs.getString("backpack8")));
            mapToBeReturned.put("Backpack Slot 9 Item",itemInformation.allItemsList.get(rs.getString("backpack9")));
            mapToBeReturned.put("Backpack Slot 10 Item",itemInformation.allItemsList.get(rs.getString("backpack10")));
            mapToBeReturned.put("Backpack Slot 11 Item",itemInformation.allItemsList.get(rs.getString("backpack11")));
            mapToBeReturned.put("Backpack Slot 12 Item",itemInformation.allItemsList.get(rs.getString("backpack12")));
            mapToBeReturned.put("Backpack Slot 13 Item",itemInformation.allItemsList.get(rs.getString("backpack13")));
            mapToBeReturned.put("Backpack Slot 14 Item",itemInformation.allItemsList.get(rs.getString("backpack14")));
            mapToBeReturned.put("Backpack Slot 15 Item",itemInformation.allItemsList.get(rs.getString("backpack15")));
            mapToBeReturned.put("Backpack Slot 16 Item",itemInformation.allItemsList.get(rs.getString("backpack16")));
            mapToBeReturned.put("Backpack Slot 17 Item",itemInformation.allItemsList.get(rs.getString("backpack17")));
            mapToBeReturned.put("Backpack Slot 18 Item",itemInformation.allItemsList.get(rs.getString("backpack18")));
            mapToBeReturned.put("Backpack Slot 19 Item",itemInformation.allItemsList.get(rs.getString("backpack19")));
            mapToBeReturned.put("Backpack Slot 20 Item",itemInformation.allItemsList.get(rs.getString("backpack20")));
        }
        return mapToBeReturned;
    }
    //todo add DAO for shop transactions
}
