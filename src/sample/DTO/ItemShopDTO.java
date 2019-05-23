package sample.DTO;

import sample.Items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemShopDTO {

    private Map<String, Item> mapOfItems;
    private static List<String> listOfItemNames;
    private int heroID;


    public ItemShopDTO(int heroID) {
       /* listOfItemNames.add("Right Hand Slot Item");
        listOfItemNames.add("Left Hand Slot Item");
        listOfItemNames.add("Torso Slot Item");
        listOfItemNames.add("Head Slot Item");
        listOfItemNames.add("Feet Slot Item");
        listOfItemNames.add("Arms Slot Item");
        listOfItemNames.add("Backpack Slot 1 Item");
        listOfItemNames.add("Backpack Slot 2 Item");
        listOfItemNames.add("Backpack Slot 3 Item");
        listOfItemNames.add("Backpack Slot 4 Item");
        listOfItemNames.add("Backpack Slot 5 Item");
        listOfItemNames.add("Backpack Slot 6 Item");
        listOfItemNames.add("Backpack Slot 7 Item");
        listOfItemNames.add("Backpack Slot 8 Item");
        listOfItemNames.add("Backpack Slot 9 Item");
        listOfItemNames.add("Backpack Slot 10 Item");
        listOfItemNames.add("Backpack Slot 11 Item");
        listOfItemNames.add("Backpack Slot 12 Item");
        listOfItemNames.add("Backpack Slot 13 Item");
        listOfItemNames.add("Backpack Slot 14 Item");
        listOfItemNames.add("Backpack Slot 15 Item");
        listOfItemNames.add("Backpack Slot 16 Item");
        listOfItemNames.add("Backpack Slot 17 Item");
        listOfItemNames.add("Backpack Slot 18 Item");
        listOfItemNames.add("Backpack Slot 19 Item");
        listOfItemNames.add("Backpack Slot 20 Item");*/
        this.heroID = heroID;
    }

    public Map<String, Item> getMapOfItems() {

        return mapOfItems;
    }

    public void setMapOfItems(Map<String, Item> mapOfItems) {
        this.mapOfItems = mapOfItems;
    }

    public Item getItemBySlotName(String slotName) {
        return mapOfItems.get(slotName);
    }
}


