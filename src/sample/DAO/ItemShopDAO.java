package sample.DAO;


import sample.DTO.CharacterCreatorDTO;
import sample.DTO.ItemShopDTO;
import sample.Items.Item;
import sample.Model.Hero;
import sample.StaticRules.ItemInformation;

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
    
    public void putItemDtoToDatabase(ItemShopDTO itemShopDTO, Hero hero) throws SQLException {
        String sql = "UPDATE dungeon.hero_equipment SET " +
                "hero_id=?," +
                "right_hand_slot=?," +
                "left_hand_slot=?," +
                "head_slot=?," +
                "torso_slot=?," +
                "feet_slot=?," +
                "arms_slot=?," +
                "backpack1=?," +
                "backpack2=?," +
                "backpack3=?," +
                "backpack4=?," +
                "backpack5=?," +
                "backpack6=?," +
                "backpack7=?," +
                "backpack8=?," +
                "backpack9=?," +
                "backpack10=?," +
                "backpack11=?," +
                "backpack12=?," +
                "backpack13=?," +
                "backpack14=?," +
                "backpack15=?," +
                "backpack16=?," +
                "backpack17=?," +
                "backpack18=?," +
                "backpack19=?," +
                "backpack20=?," +
                "WHERE (`idhero_equipment`=?)";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, hero.getID());
        pst.setString(2, itemShopDTO.getMapOfItems().get("Right Hand Slot Item").getItemName());
        pst.setString(3, itemShopDTO.getMapOfItems().get("Left Hand Slot Item").getItemName());
        pst.setString(4, itemShopDTO.getMapOfItems().get("Torso Slot Item").getItemName());
        pst.setString(5, itemShopDTO.getMapOfItems().get("Head Slot Item").getItemName());
        pst.setString(6, itemShopDTO.getMapOfItems().get("Feet Slot Item").getItemName());
        pst.setString(7, itemShopDTO.getMapOfItems().get("Arms Slot Item").getItemName());
        pst.setString(8, itemShopDTO.getMapOfItems().get("Backpack Slot 1 Item").getItemName());
        pst.setString(9, itemShopDTO.getMapOfItems().get("Backpack Slot 2 Item").getItemName());
        pst.setString(10, itemShopDTO.getMapOfItems().get("Backpack Slot 3 Item").getItemName());
        pst.setString(11, itemShopDTO.getMapOfItems().get("Backpack Slot 4 Item").getItemName());
        pst.setString(12, itemShopDTO.getMapOfItems().get("Backpack Slot 5 Item").getItemName());
        pst.setString(13, itemShopDTO.getMapOfItems().get("Backpack Slot 6 Item").getItemName());
        pst.setString(14, itemShopDTO.getMapOfItems().get("Backpack Slot 7 Item").getItemName());
        pst.setString(15, itemShopDTO.getMapOfItems().get("Backpack Slot 8 Item").getItemName());
        pst.setString(16, itemShopDTO.getMapOfItems().get("Backpack Slot 9 Item").getItemName());
        pst.setString(17, itemShopDTO.getMapOfItems().get("Backpack Slot 10 Item").getItemName());
        pst.setString(18, itemShopDTO.getMapOfItems().get("Backpack Slot 11 Item").getItemName());
        pst.setString(19, itemShopDTO.getMapOfItems().get("Backpack Slot 12 Item").getItemName());
        pst.setString(20, itemShopDTO.getMapOfItems().get("Backpack Slot 13 Item").getItemName());
        pst.setString(21, itemShopDTO.getMapOfItems().get("Backpack Slot 14 Item").getItemName());
        pst.setString(22, itemShopDTO.getMapOfItems().get("Backpack Slot 15 Item").getItemName());
        pst.setString(23, itemShopDTO.getMapOfItems().get("Backpack Slot 16 Item").getItemName());
        pst.setString(24, itemShopDTO.getMapOfItems().get("Backpack Slot 17 Item").getItemName());
        pst.setString(25, itemShopDTO.getMapOfItems().get("Backpack Slot 18 Item").getItemName());
        pst.setString(26, itemShopDTO.getMapOfItems().get("Backpack Slot 19 Item").getItemName());
        pst.setString(27, itemShopDTO.getMapOfItems().get("Backpack Slot 20 Item").getItemName());
        pst.setInt(27, hero.getID());
        pst.executeUpdate();
        System.out.println("Character has successfully been added to the database");
    }

    public Map getHeroEquipmentByHeroID(int heroId) throws SQLException {
        ItemInformation itemInformation = new ItemInformation();
        Map<String, Item> mapToBeReturned = new HashMap<>();
        String sql = "SELECT * FROM hero_equipment WHERE (hero_id=?);";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, heroId);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            mapToBeReturned.put("Right Hand Slot Item", itemInformation.allItemsList.get(rs.getString("right_hand_slot")));
            mapToBeReturned.put("Left Hand Slot Item", itemInformation.allItemsList.get(rs.getString("left_hand_slot")));
            mapToBeReturned.put("Head Slot Item", itemInformation.allItemsList.get(rs.getString("head_slot")));
            mapToBeReturned.put("Torso Slot Item", itemInformation.allItemsList.get(rs.getString("torso_slot")));
            mapToBeReturned.put("Feet Slot Item", itemInformation.allItemsList.get(rs.getString("feet_slot")));
            mapToBeReturned.put("Arms Slot Item", itemInformation.allItemsList.get(rs.getString("arms_slot")));
            mapToBeReturned.put("Backpack Slot 1 Item", itemInformation.allItemsList.get(rs.getString("backpack1")));
            mapToBeReturned.put("Backpack Slot 2 Item", itemInformation.allItemsList.get(rs.getString("backpack2")));
            mapToBeReturned.put("Backpack Slot 3 Item", itemInformation.allItemsList.get(rs.getString("backpack3")));
            mapToBeReturned.put("Backpack Slot 4 Item", itemInformation.allItemsList.get(rs.getString("backpack4")));
            mapToBeReturned.put("Backpack Slot 5 Item", itemInformation.allItemsList.get(rs.getString("backpack5")));
            mapToBeReturned.put("Backpack Slot 6 Item", itemInformation.allItemsList.get(rs.getString("backpack6")));
            mapToBeReturned.put("Backpack Slot 7 Item", itemInformation.allItemsList.get(rs.getString("backpack7")));
            mapToBeReturned.put("Backpack Slot 8 Item", itemInformation.allItemsList.get(rs.getString("backpack8")));
            mapToBeReturned.put("Backpack Slot 9 Item", itemInformation.allItemsList.get(rs.getString("backpack9")));
            mapToBeReturned.put("Backpack Slot 10 Item", itemInformation.allItemsList.get(rs.getString("backpack10")));
            mapToBeReturned.put("Backpack Slot 11 Item", itemInformation.allItemsList.get(rs.getString("backpack11")));
            mapToBeReturned.put("Backpack Slot 12 Item", itemInformation.allItemsList.get(rs.getString("backpack12")));
            mapToBeReturned.put("Backpack Slot 13 Item", itemInformation.allItemsList.get(rs.getString("backpack13")));
            mapToBeReturned.put("Backpack Slot 14 Item", itemInformation.allItemsList.get(rs.getString("backpack14")));
            mapToBeReturned.put("Backpack Slot 15 Item", itemInformation.allItemsList.get(rs.getString("backpack15")));
            mapToBeReturned.put("Backpack Slot 16 Item", itemInformation.allItemsList.get(rs.getString("backpack16")));
            mapToBeReturned.put("Backpack Slot 17 Item", itemInformation.allItemsList.get(rs.getString("backpack17")));
            mapToBeReturned.put("Backpack Slot 18 Item", itemInformation.allItemsList.get(rs.getString("backpack18")));
            mapToBeReturned.put("Backpack Slot 19 Item", itemInformation.allItemsList.get(rs.getString("backpack19")));
            mapToBeReturned.put("Backpack Slot 20 Item", itemInformation.allItemsList.get(rs.getString("backpack20")));
        }
        return mapToBeReturned;
    }
    //todo add DAO for shop transactions
}
