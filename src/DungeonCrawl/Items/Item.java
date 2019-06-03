package DungeonCrawl.Items;

import javafx.scene.image.Image;

public class Item {

    //todo write the daily powers for level 1. Last updated: Cleric

    protected String itemName;
    protected String itemType;
    protected String itemSlot;
    protected String properties;
    protected String itemGroup;
    protected int itemLevel;
    protected int price;
    protected int range; //for melee skills use range = 0
    protected int bonusToHit;
    protected int proficiencyBonus;
    protected int bonusToDamage;
    protected int weight;
    private String itemDescription;
    protected int numberOfDamageDiceDealt;
    protected int typeOfDamageDice;
    private boolean isThisItemConsumable = false;
    protected int bonusToAC;
    protected Image itemImage;

    public Image getItemImage() {
        return itemImage;
    }

    public void setItemImage(Image itemImage) {
        this.itemImage = itemImage;
    }

    public int getBonusToAC() {
        return bonusToAC;
    }

    public void setBonusToAC(int bonusToAC) {
        this.bonusToAC = bonusToAC;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getItemGroup() {
        return itemGroup;
    }

    public void setItemGroup(String itemGroup) {
        this.itemGroup = itemGroup;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public void setProficiencyBonus(int proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
    }

    public boolean isThisItemConsumable() {
        return isThisItemConsumable;
    }

    public void setThisItemConsumable(boolean thisItemConsumable) {
        isThisItemConsumable = thisItemConsumable;
    }

    public int getBonusToDamage() {
        return bonusToDamage;
    }

    public void setBonusToDamage(int bonusToDamage) {
        this.bonusToDamage = bonusToDamage;
    }

    public int getBonusToHit() {
        return bonusToHit;
    }

    public void setBonusToHit(int bonusToHit) {
        this.bonusToHit = bonusToHit;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemSlot() {
        return itemSlot;
    }

    public void setItemSlot(String itemSlot) {
        this.itemSlot = itemSlot;
    }

    public int getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(int itemLevel) {
        this.itemLevel = itemLevel;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getNumberOfDamageDiceDealt() {
        return numberOfDamageDiceDealt;
    }

    public void setNumberOfDamageDiceDealt(int numberOfDamageDiceDealt) {
        this.numberOfDamageDiceDealt = numberOfDamageDiceDealt;
    }

    public int getTypeOfDamageDice() {
        return typeOfDamageDice;
    }

    public void setTypeOfDamageDice(int typeOfDamageDice) {
        this.typeOfDamageDice = typeOfDamageDice;
    }

}
