package DungeonCrawl.DAO;


import DungeonCrawl.DTO.ItemsDTO;
import DungeonCrawl.Items.Item;
import DungeonCrawl.Model.Hero;
import DungeonCrawl.StaticRules.ItemInformation;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ItemsDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";

    private Connection conn;
    private PreparedStatement pst;


    public ItemsDAO() throws SQLException {
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Creating connection...");
        conn.createStatement();
    }

    public void removeItemFromSlotInDatabase(Hero hero, String slotToBeRemoved) throws SQLException {
        String slotSQLAdapter = null;
        switch (slotToBeRemoved) {
            case "Right Hand Slot Item":
                slotSQLAdapter = "right_hand_slot=null";
                break;
            case "Left Hand Slot Item":
                slotSQLAdapter = "left_hand_slot=null";
                break;
            case "Torso Slot Item":
                slotSQLAdapter = "torso_slot=null";
                break;
            case "Head Slot Item":
                slotSQLAdapter = "head_slot=null";
                break;
            case "Feet Slot Item":
                slotSQLAdapter = "feet_slot=null";
                break;
            case "Arms Slot Item":
                slotSQLAdapter = "arms_slot=null";
                break;
            case "Backpack Slot 1 Item":
                slotSQLAdapter = "backpack1=null";
                break;
            case "Backpack Slot 2 Item":
                slotSQLAdapter = "backpack2=null";
                break;
            case "Backpack Slot 3 Item":
                slotSQLAdapter = "backpack3=null";
                break;
            case "Backpack Slot 4 Item":
                slotSQLAdapter = "backpack4=null";
                break;
            case "Backpack Slot 5 Item":
                slotSQLAdapter = "backpack5=null";
                break;
            case "Backpack Slot 6 Item":
                slotSQLAdapter = "backpack6=null";
                break;
            case "Backpack Slot 7 Item":
                slotSQLAdapter = "backpack7=null";
                break;
            case "Backpack Slot 8 Item":
                slotSQLAdapter = "backpack8=null";
                break;
            case "Backpack Slot 9 Item":
                slotSQLAdapter = "backpack9=null";
                break;
            case "Backpack Slot 10 Item":
                slotSQLAdapter = "backpack10=null";
                break;
            case "Backpack Slot 11 Item":
                slotSQLAdapter = "backpack11=null";
                break;
            case "Backpack Slot 12 Item":
                slotSQLAdapter = "backpack12=null";
                break;
            case "Backpack Slot 13 Item":
                slotSQLAdapter = "backpack13=null";
                break;
            case "Backpack Slot 14 Item":
                slotSQLAdapter = "backpack14=null";
                break;
            case "Backpack Slot 15 Item":
                slotSQLAdapter = "backpack15=null";
                break;
            case "Backpack Slot 16 Item":
                slotSQLAdapter = "backpack16=null";
                break;
            case "Backpack Slot 17 Item":
                slotSQLAdapter = "backpack17=null";
                break;
            case "Backpack Slot 18 Item":
                slotSQLAdapter = "backpack18=null";
                break;
            case "Backpack Slot 19 Item":
                slotSQLAdapter = "backpack19=null";
                break;
            case "Backpack Slot 20 Item":
                slotSQLAdapter = "backpack20=null";
                break;
        }
        String sql = "UPDATE dungeon.hero_equipment SET " + slotSQLAdapter +
                " WHERE (`idhero_equipment`=?)";
        pst = conn.prepareStatement(sql);
        //pst.setString(1, itemShopDTO.getMapOfItems().get(slotToBeRemoved).getItemName());
        pst.setInt(1, hero.getID());
        pst.executeUpdate();
        System.out.println("Character has successfully been added to the database");
    }

    public void putItemIntoSlotInDatabase(ItemsDTO itemShopDTO, Hero hero, String slotToBeFilled) throws SQLException {
        String slotSQLAdapter = null;
        switch (slotToBeFilled) {
            case "Right Hand Slot Item":
                slotSQLAdapter = "right_hand_slot=?";
                break;
            case "Left Hand Slot Item":
                slotSQLAdapter = "left_hand_slot=?";
                break;
            case "Torso Slot Item":
                slotSQLAdapter = "torso_slot=?";
                break;
            case "Head Slot Item":
                slotSQLAdapter = "head_slot=?";
                break;
            case "Feet Slot Item":
                slotSQLAdapter = "feet_slot=?";
                break;
            case "Arms Slot Item":
                slotSQLAdapter = "arms_slot=?";
                break;
            case "Backpack Slot 1 Item":
                slotSQLAdapter = "backpack1=?";
                break;
            case "Backpack Slot 2 Item":
                slotSQLAdapter = "backpack2=?";
                break;
            case "Backpack Slot 3 Item":
                slotSQLAdapter = "backpack3=?";
                break;
            case "Backpack Slot 4 Item":
                slotSQLAdapter = "backpack4=?";
                break;
            case "Backpack Slot 5 Item":
                slotSQLAdapter = "backpack5=?";
                break;
            case "Backpack Slot 6 Item":
                slotSQLAdapter = "backpack6=?";
                break;
            case "Backpack Slot 7 Item":
                slotSQLAdapter = "backpack7=?";
                break;
            case "Backpack Slot 8 Item":
                slotSQLAdapter = "backpack8=?";
                break;
            case "Backpack Slot 9 Item":
                slotSQLAdapter = "backpack9=?";
                break;
            case "Backpack Slot 10 Item":
                slotSQLAdapter = "backpack10=?";
                break;
            case "Backpack Slot 11 Item":
                slotSQLAdapter = "backpack11=?";
                break;
            case "Backpack Slot 12 Item":
                slotSQLAdapter = "backpack12=?";
                break;
            case "Backpack Slot 13 Item":
                slotSQLAdapter = "backpack13=?";
                break;
            case "Backpack Slot 14 Item":
                slotSQLAdapter = "backpack14=?";
                break;
            case "Backpack Slot 15 Item":
                slotSQLAdapter = "backpack15=?";
                break;
            case "Backpack Slot 16 Item":
                slotSQLAdapter = "backpack16=?";
                break;
            case "Backpack Slot 17 Item":
                slotSQLAdapter = "backpack17=?";
                break;
            case "Backpack Slot 18 Item":
                slotSQLAdapter = "backpack18=?";
                break;
            case "Backpack Slot 19 Item":
                slotSQLAdapter = "backpack19=?";
                break;
            case "Backpack Slot 20 Item":
                slotSQLAdapter = "backpack20=?";
                break;
        }
        String sql = "UPDATE dungeon.hero_equipment SET " + slotSQLAdapter +
                "WHERE (`idhero_equipment`=?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, itemShopDTO.getMapOfItems().get(slotToBeFilled).getItemName());
        pst.setInt(2, hero.getID());
        pst.executeUpdate();
        System.out.println("Character has successfully been added to the database");
    }

    public Map<String, Item> getHeroEquipmentByHeroID(int heroId) throws SQLException {
        ItemInformation itemInformation = new ItemInformation();
        Map<String, Item> mapToBeReturned = new HashMap<>();
        String sql = "SELECT * FROM dungeon.hero_equipment WHERE (idhero_equipment=?);";
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
}
