package DungeonCrawl.Model;

import DungeonCrawl.Items.Item;

import java.util.ArrayList;
import java.util.List;

public class MonsterDrop {
    private List<Item> itemDropList = new ArrayList<>();
    private int monsterXP;
    private int MonsterLevel;
    private int MonsterGold;
    private static List<MundaneItem> listOfMundaneItems;

    public static List<MundaneItem> getListOfMundaneItems() {
        return listOfMundaneItems;
    }

    public static void setListOfMundaneItems(List<MundaneItem> listOfMundaneItems) {
        MonsterDrop.listOfMundaneItems = listOfMundaneItems;
    }

    public MonsterDrop(int monsterLevel) {
        MonsterLevel = monsterLevel;
        listOfMundaneItems = prepareAListOfMundaneItems(monsterLevel);
    }

    public MundaneItem addAnItem(String itemName, int itemValue, int itemWeight) {
        return new MundaneItem(itemName, itemValue, itemWeight);
    }

    //todo add a legitimate list of items from an online generator

    public List<MundaneItem> prepareAListOfMundaneItems(int itemsLevel) {
        List<MundaneItem> listToBeReturned = new ArrayList<>();
        switch (itemsLevel) {
            case 1: {
                listToBeReturned.add(addAnItem("Bronze Medallion", 5, 0));
                listToBeReturned.add(addAnItem("Lucky Charm", 5, 0));
                listToBeReturned.add(addAnItem("Set of Playing Dice", 5, 0));
                listToBeReturned.add(addAnItem("Set of Playing Cards", 5, 0));
                listToBeReturned.add(addAnItem("Carved Stick", 5, 0));
                listToBeReturned.add(addAnItem("Embroidered Napkin", 5, 0));
                break;
            }
            case 2: {
                listToBeReturned.add(addAnItem("Bronze Medallion", 10, 0));
                listToBeReturned.add(addAnItem("Lucky Charm", 10, 0));
                listToBeReturned.add(addAnItem("Set of Playing Dice", 10, 0));
                listToBeReturned.add(addAnItem("Set of Playing Cards", 10, 0));
                listToBeReturned.add(addAnItem("Carved Stick", 10, 0));
                listToBeReturned.add(addAnItem("Dog figurine", 10, 0));
            }
            case 3: {
                listToBeReturned.add(addAnItem("Bronze Medallion", 15, 0));
                listToBeReturned.add(addAnItem("Lucky Charm", 15, 0));
                listToBeReturned.add(addAnItem("Set of Playing Dice", 15, 0));
                listToBeReturned.add(addAnItem("Set of Playing Cards", 15, 0));
                listToBeReturned.add(addAnItem("Carved Stick", 15, 0));
                listToBeReturned.add(addAnItem("Silver Ring", 15, 0));
            }
        }
        return listToBeReturned;
    }

    public class MundaneItem {
        private String itemName;
        private int itemValue;
        private int itemWeight;

        public MundaneItem(String itemName, int itemValue, int itemWeight) {
            this.setItemName(itemName);
            this.setItemValue(itemValue);
            this.setItemWeight(itemWeight);
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public int getItemValue() {
            return itemValue;
        }

        public void setItemValue(int itemValue) {
            this.itemValue = itemValue;
        }

        public int getItemWeight() {
            return itemWeight;
        }

        public void setItemWeight(int itemWeight) {
            this.itemWeight = itemWeight;
        }
    }

    public List<Item> getItemDropList() {
        return itemDropList;
    }

    public void setItemDropList(List<Item> itemDropList) {
        this.itemDropList = itemDropList;
    }

    public int getMonsterXP() {
        return monsterXP;
    }

    public void setMonsterXP(int monsterXP) {
        this.monsterXP = monsterXP;
    }

    public int getMonsterLevel() {
        return MonsterLevel;
    }

    public void setMonsterLevel(int monsterLevel) {
        MonsterLevel = monsterLevel;
    }

    public int getMonsterGold() {
        return MonsterGold;
    }

    public void setMonsterGold(int monsterGold) {
        MonsterGold = monsterGold;
    }
}
