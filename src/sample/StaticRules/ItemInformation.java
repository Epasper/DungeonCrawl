package sample.StaticRules;

import sample.Items.Armor.*;
import sample.Items.Item;
import sample.Items.Weapons.*;

import java.util.HashMap;
import java.util.Map;

public class ItemInformation {

    public Map<String, Item> weaponsList = new HashMap<>();
    public Map<String, Item> armorsList = new HashMap<>();


    public ItemInformation() {
        populateTheTablesWithWeapons();
        populateTheTablesWithArmor();
    }

    private void populateTheTablesWithArmor() {
        armorsList.put("Chainmail", new Chainmail());
        armorsList.put("Hide Armor", new HideArmor());
        armorsList.put("Leather Armor", new LeatherArmor());
        armorsList.put("Plate Armor", new PlateArmor());
        armorsList.put("Scale Armor", new ScaleArmor());

    }

    private void populateTheTablesWithWeapons() {
        weaponsList.put("Battleaxe", new Battleaxe());
        weaponsList.put("Broadsword", new Broadsword());
        weaponsList.put("Falchion", new Falchion());
        weaponsList.put("Flail", new Flail());
        weaponsList.put("Greataxe", new Battleaxe());
        weaponsList.put("Greatsword", new Greatsword());
        weaponsList.put("Handaxe", new Handaxe());
        weaponsList.put("Khopesh", new Khopesh());
        weaponsList.put("Longsword", new Longsword());

    }
}
