package DungeonCrawl.Items;

import DungeonCrawl.Items.Armor.*;
import DungeonCrawl.Items.Implements.*;
import DungeonCrawl.Items.Item;
import DungeonCrawl.Items.Weapons.*;

import java.util.HashMap;
import java.util.Map;

public class ItemFactory {

    public Map<String, Item> weaponsList = new HashMap<>();
    public Map<String, Item> armorsList = new HashMap<>();
    public Map<String, Item> implementsList = new HashMap<>();
    private Map<String, Item> allItemsList = new HashMap<>();

    public ItemFactory() {
        populateTheTablesWithWeapons();
        populateTheTablesWithArmor();
        populateTheTablesWithImplements();
        populateAllItemsList();
    }

    public Item getItemByName(String itemName) {
        return allItemsList.get(itemName);
    }

    public Item getWeaponByName(String itemName) {
        return weaponsList.get(itemName);
    }

    public Item getArmorByName(String itemName) {
        return armorsList.get(itemName);
    }

    private void populateTheTablesWithImplements() {
        implementsList.put("Accurate Holy Symbol", new AccurateHolySymbol());
        implementsList.put("Ashen Rod", new AshenRod());
        implementsList.put("Crystal Orb", new CrystalOrb());
        implementsList.put("Dragontooth Wand", new DragontoothWand());
        implementsList.put("Forbidden Tome", new ForbiddenTome());
        implementsList.put("Guardian Staff", new GuardianStaff());
        implementsList.put("Icicle Totem", new IcicleTotem());
    }

    private void populateTheTablesWithArmor() {
        armorsList.put("Chainmail", new Chainmail());
        armorsList.put("Hide Armor", new HideArmor());
        armorsList.put("Leather Armor", new LeatherArmor());
        armorsList.put("Plate Armor", new PlateArmor());
        armorsList.put("Scale Armor", new ScaleArmor());
        armorsList.put("Banded Mail", new BandedMail());
        armorsList.put("Cloth Armor", new ClothArmor());
        armorsList.put("Full Plate Armor", new FullPlate());
        armorsList.put("Ring Mail", new RingMail());
        armorsList.put("Spiked Plate Armor", new SpikedPlate());
        armorsList.put("Splint Mail", new SplintMail());
        armorsList.put("Studded Leather Armor", new StuddedLeather());
    }

    private void populateTheTablesWithWeapons() {
        weaponsList.put("Battleaxe", new Battleaxe());
        weaponsList.put("Broadsword", new Broadsword());
        weaponsList.put("Falchion", new Falchion());
        weaponsList.put("Flail", new Flail());
        weaponsList.put("Greataxe", new Greataxe());
        weaponsList.put("Greatsword", new Greatsword());
        weaponsList.put("Handaxe", new Handaxe());
        weaponsList.put("Khopesh", new Khopesh());
        weaponsList.put("Longsword", new Longsword());
    }

    private void populateAllItemsList() {
        weaponsList.forEach((k, v) -> allItemsList.put(k, v));
        armorsList.forEach((k, v) -> allItemsList.put(k, v));
        implementsList.forEach((k, v) -> allItemsList.put(k, v));
    }
}
