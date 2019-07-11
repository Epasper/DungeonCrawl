package DungeonCrawl.HeroPowers;

import DungeonCrawl.GUI.GUIUtilities;
import DungeonCrawl.Model.*;

import java.util.ArrayList;
import java.util.List;

public abstract class HeroPower {

    //todo write the daily powers for level 1. Last updated: Paladin

    //todo change a map of powers into a power factory.

    private String powerName;
    private String characterClass;
    private String typeOfPower;
    private String usedAction;
    private int powerLevel;
    private int range; //for melee skills use range = 0
    private String numberOfTargets;
    private String attributeUsedToHit;
    private int bonusToHit;
    private String defenseToBeChecked;
    private String hitDescription;
    private int damageDiceDealt;
    private String damageModifier;
    private boolean isThisWeaponDamage;
    private int typeOfDamageDice;
    private boolean bonusDamage;
    private int typeOfBonusDamageDice;
    private String bonusDamageModifier;
    private boolean canThisAttackAlsoBeRanged = false;
    private boolean isThisASpiritAttack = false;
    private boolean isThisABeastFormAttack = false;
    private String secondAttributeUsed;
    private String powersAdditionalOptions;
    private int burstValue = 0;
    private String powerIconId;
    private int numberOfLockedEncounters = 0;
    private List<Coordinates> affectedCoordinatesList = new ArrayList<>();

    public int getBurstValue() {
        return burstValue;
    }

    public void setBurstValue(int burstValue) {
        this.burstValue = burstValue;
    }

    public int getNumberOfLockedEncounters() {
        return numberOfLockedEncounters;
    }

    public void setNumberOfLockedEncounters(int numberOfLockedEncounters) {
        this.numberOfLockedEncounters = numberOfLockedEncounters;
    }

    public String getPowerIconId() {
        return powerIconId;
    }

    public void setPowerIconId(String powerIconId) {
        this.powerIconId = powerIconId;
    }

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

    public String getAttributeUsedToHit() {
        return attributeUsedToHit;
    }

    public void setAttributeUsedToHit(String attributeUsedToHit) {
        this.attributeUsedToHit = attributeUsedToHit;
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

    public List<Coordinates> getAffectedCoordinatesList() {
        return affectedCoordinatesList;
    }

    public void setAffectedCoordinatesList(List<Coordinates> affectedCoordinatesList) {
        this.affectedCoordinatesList = affectedCoordinatesList;
    }

    public int getBonusToHit() {
        return bonusToHit;
    }

    public void setBonusToHit(int bonusToHit) {
        this.bonusToHit = bonusToHit;
    }

    public String getBonusDamageModifier() {
        return bonusDamageModifier;
    }

    public void setBonusDamageModifier(String bonusDamageModifier) {
        this.bonusDamageModifier = bonusDamageModifier;
    }

    public boolean isCanThisAttackAlsoBeRanged() {
        return canThisAttackAlsoBeRanged;
    }

    public void setCanThisAttackAlsoBeRanged(boolean canThisAttackAlsoBeRanged) {
        this.canThisAttackAlsoBeRanged = canThisAttackAlsoBeRanged;
    }

    public boolean isThisASpiritAttack() {
        return isThisASpiritAttack;
    }

    public void setThisASpiritAttack(boolean thisASpiritAttack) {
        isThisASpiritAttack = thisASpiritAttack;
    }

    public boolean isThisABeastFormAttack() {
        return isThisABeastFormAttack;
    }

    public void setThisABeastFormAttack(boolean thisABeastFormAttack) {
        isThisABeastFormAttack = thisABeastFormAttack;
    }

    public String getSecondAttributeUsed() {
        return secondAttributeUsed;
    }

    public void setSecondAttributeUsed(String secondAttributeUsed) {
        this.secondAttributeUsed = secondAttributeUsed;
    }

    public String getPowersAdditionalOptions() {
        return powersAdditionalOptions;
    }

    public void setPowersAdditionalOptions(String powersAdditionalOptions) {
        this.powersAdditionalOptions = powersAdditionalOptions;
    }

    public class Coordinates {
        private int XCoordinate;
        private int YCoordinate;

        public int getXCoordinate() {
            return XCoordinate;
        }

        public void setXCoordinate(int XCoordinate) {
            this.XCoordinate = XCoordinate;
        }

        public int getYCoordinate() {
            return YCoordinate;
        }

        public void setYCoordinate(int YCoordinate) {
            this.YCoordinate = YCoordinate;
        }
    }

    public List<Creature> determineTheNumberOfCreaturesAttacked(int XPos, int YPos, DungeonMap dungeonMap, List<Monster> allDiscoveredMonsters, List<Hero> allDiscoveredHeroes) {
        GUIUtilities guiUtilities = new GUIUtilities();
        List<Creature> listOfCreaturesAttacked = new ArrayList<>();
        System.out.println("---" + XPos + "---" + YPos + "---");
        if (this.getNumberOfTargets().contains("Burst")) {
            //todo add a GUI element that shows the range of Blast attacks
            manageBurstAttack(XPos, YPos, dungeonMap, allDiscoveredMonsters, allDiscoveredHeroes, listOfCreaturesAttacked);
        } else {
            listOfCreaturesAttacked.add(guiUtilities.getSingleMonsterByUniqueID(dungeonMap.getMapTilesArray()[XPos][YPos].getOccupyingCreatureUniqueID(), allDiscoveredMonsters));
        }
        return listOfCreaturesAttacked;
    }

    //todo encounter and daily powers has to be locked after using, not after selecting it.

    private void manageBurstAttack(int XPos, int YPos, DungeonMap dungeonMap, List<Monster> allDiscoveredMonsters, List<Hero> allDiscoveredHeroes, List<Creature> listOfCreaturesAttacked) {
        int burstValue = this.getBurstValue();
        for (int i = -burstValue; i < burstValue + 1; i++) {
            for (int j = -burstValue; j < burstValue + 1; j++) {
                Coordinates coordinates = new Coordinates();
                coordinates.setXCoordinate(XPos + i);
                coordinates.setYCoordinate(YPos + j);
                affectedCoordinatesList.add(coordinates);
                try {
                    int creatureId = dungeonMap.getMapTilesArray()[XPos + i][YPos + j].getOccupyingCreatureTypeId();
                    if (creatureId > 100) {
                        creatureId = dungeonMap.getMapTilesArray()[XPos + i][YPos + j].getOccupyingCreatureUniqueID();
                        for (Monster monster : allDiscoveredMonsters) {
                            if (monster.getCurrentMonsterUniqueID() == creatureId) {
                                listOfCreaturesAttacked.add(monster);
                            }
                        }
                    } else {
                        for (Hero hero : allDiscoveredHeroes) {
                            if (hero.getID() == creatureId) {
                                listOfCreaturesAttacked.add(hero);
                            }
                        }
                    }
                } catch (NullPointerException ignored) {
                }
            }
        }
    }
}
