package DungeonCrawl.Model;

public class AttackResults {
    //todo change the attack methods, so that they use this class.
    private int damage;
    private int attributeBonus;
    private int toHitModifier;
    private int defenseChecked;
    private boolean hitSuccess;
    private int diceRollValue;

    public int getDiceRollValue() {
        return diceRollValue;
    }

    public void setDiceRollValue(int diceRollValue) {
        this.diceRollValue = diceRollValue;
    }

    public int getAttributeBonus() {
        return attributeBonus;
    }

    public void setAttributeBonus(int attributeBonus) {
        this.attributeBonus = attributeBonus;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getToHitModifier() {
        return toHitModifier;
    }

    public void setToHitModifier(int toHitModifier) {
        this.toHitModifier = toHitModifier;
    }

    public int getDefenseChecked() {
        return defenseChecked;
    }

    public void setDefenseChecked(int defenseChecked) {
        this.defenseChecked = defenseChecked;
    }

    public boolean isHitSuccess() {
        return hitSuccess;
    }

    public void setHitSuccess(boolean hitSuccess) {
        this.hitSuccess = hitSuccess;
    }
}
