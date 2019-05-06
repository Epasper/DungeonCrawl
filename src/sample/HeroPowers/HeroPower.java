package sample.HeroPowers;

public abstract class HeroPower {

    protected String powerName;
    protected String characterClass;
    protected String typeOfPower;
    protected String usedAction;
    protected int powerLevel;
    protected int range; //for melee skills use range = 0
    protected String numberOfTargets;
    protected String attributeUsed;
    protected String defenseToBeChecked;
    protected String hitDescription;
    protected int damageDiceDealt;
    protected String damageModifier;
    protected boolean isThisWeaponDamage;
    protected int typeOfDamageDice;
    protected boolean bonusDamage;
    protected int typeOfBonusDamageDice;
    protected String bonusDamageModifier;

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getTypeOfPower() {
        return typeOfPower;
    }

    public void setTypeOfPower(String typeOfPower) {
        this.typeOfPower = typeOfPower;
    }

    public String getUsedAction() {
        return usedAction;
    }

    public void setUsedAction(String usedAction) {
        this.usedAction = usedAction;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getNumberOfTargets() {
        return numberOfTargets;
    }

    public void setNumberOfTargets(String numberOfTargets) {
        this.numberOfTargets = numberOfTargets;
    }

    public String getAttributeUsed() {
        return attributeUsed;
    }

    public void setAttributeUsed(String attributeUsed) {
        this.attributeUsed = attributeUsed;
    }

    public String getDefenseToBeChecked() {
        return defenseToBeChecked;
    }

    public void setDefenseToBeChecked(String defenseToBeChecked) {
        this.defenseToBeChecked = defenseToBeChecked;
    }

    public String getHitDescription() {
        return hitDescription;
    }

    public void setHitDescription(String hitDescription) {
        this.hitDescription = hitDescription;
    }

    public int getDamageDiceDealt() {
        return damageDiceDealt;
    }

    public void setDamageDiceDealt(int damageDiceDealt) {
        this.damageDiceDealt = damageDiceDealt;
    }

    public String getDamageModifier() {
        return damageModifier;
    }

    public void setDamageModifier(String damageModifier) {
        this.damageModifier = damageModifier;
    }

    public boolean isThisWeaponDamage() {
        return isThisWeaponDamage;
    }

    public void setThisWeaponDamage(boolean thisWeaponDamage) {
        isThisWeaponDamage = thisWeaponDamage;
    }

    public int getTypeOfDamageDice() {
        return typeOfDamageDice;
    }

    public void setTypeOfDamageDice(int typeOfDamageDice) {
        this.typeOfDamageDice = typeOfDamageDice;
    }

    public boolean isBonusDamage() {
        return bonusDamage;
    }

    public void setBonusDamage(boolean bonusDamage) {
        this.bonusDamage = bonusDamage;
    }

    public int getTypeOfBonusDamageDice() {
        return typeOfBonusDamageDice;
    }

    public void setTypeOfBonusDamageDice(int typeOfBonusDamageDice) {
        this.typeOfBonusDamageDice = typeOfBonusDamageDice;
    }
}
