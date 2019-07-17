package DungeonCrawl.Model;

import DungeonCrawl.GUI.DungeonConsoleGUI;
import DungeonCrawl.GUI.FieldColors;
import DungeonCrawl.GUI.GUIUtilities;
import DungeonCrawl.HeroPowers.HeroPower;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class PathFinder extends EncounterManager{

    private DungeonConsoleGUI dungeonConsoleGUI = new DungeonConsoleGUI();

    private List<Monster> discoveredMonsters = new ArrayList<>();
    private boolean alarmedMonsterVisible = false;
    private int numberOfEncountersInThisDungeon;
    private boolean isCurrentEncounterFinished;

    public DungeonConsoleGUI getDungeonConsoleGUI() {
        return dungeonConsoleGUI;
    }

    public void setDungeonConsoleGUI(DungeonConsoleGUI dungeonConsoleGUI) {
        this.dungeonConsoleGUI = dungeonConsoleGUI;
    }

    public int getNumberOfEncountersInThisDungeon() {
        return numberOfEncountersInThisDungeon;
    }

    public void setNumberOfEncountersInThisDungeon(int numberOfEncountersInThisDungeon) {
        this.numberOfEncountersInThisDungeon = numberOfEncountersInThisDungeon;
    }

    public boolean isCurrentEncounterFinished() {
        return isCurrentEncounterFinished;
    }

    public void setCurrentEncounterFinished(boolean currentEncounterFinished) {
        isCurrentEncounterFinished = currentEncounterFinished;
    }

    public boolean isAlarmedMonsterVisible() {
        return alarmedMonsterVisible;
    }

    public void setAlarmedMonsterVisible(boolean alarmedMonsterVisible) {
        this.alarmedMonsterVisible = alarmedMonsterVisible;
    }

    public List<Monster> getDiscoveredMonsters() {
        return discoveredMonsters;
    }

    public void setDiscoveredMonsters(List<Monster> discoveredMonsters) {
        this.discoveredMonsters = discoveredMonsters;
    }

    public void checkTheAttacksRange(Hero hero, DungeonMap dungeonMap, Button[][] buttonGrid, HeroPower heroPower) {

        int XPos = hero.getMapXPos();
        int YPos = hero.getMapYPos();
        int range = heroPower.getRange();
        if (range == 0) {
            range = 2;
        }
        for (int a = -1; a < 2; a += 2) {
            for (int b = -1; b < 2; b += 2) {
                for (int i = 0; i < range; i++) {
                    for (int j = 0; j < range; j++) {
                        try {
                            double temp = Math.pow(i, 2) + Math.pow(j, 2);
                            if (temp < Math.pow(range, 2)) {
                                if (dungeonMap.getMapTilesArray()[XPos + i * a][YPos + j * b].getTypeOfTile().contains("Room")) {
                                    dungeonMap.getMapTilesArray()[XPos + i * a][YPos + j * b].setInRangedAttackRange(true);
                                    buttonGrid[XPos + i * a][YPos + j * b].setStyle(FieldColors.ATTACK_RANGE);
                                } else {
                                    break;
                                }
                            }

                        } catch (IndexOutOfBoundsException ignored) {

                        }
                    }
                }
            }
        }

    }

    public void checkTheAvailableDistance(Hero hero, DungeonMap dungeonMap, Button[][] buttonGrid, String reasonForChecking) {
        System.out.println("Checking begins");
        int YPos = hero.getMapYPos();
        int XPos = hero.getMapXPos();
        double heroSteps = hero.getCurrentSpeed();
        double heroInteractionSteps;
        if (hero.getCurrentSpeed() > 0.9) {
            heroInteractionSteps = 1.1;
        } else {
            heroInteractionSteps = 0;
        }
        if (reasonForChecking.contains("Attack")) {
            System.out.println("Checking For Attack");
            recursiveCheckDistance(dungeonMap, buttonGrid, "Start", YPos, XPos, hero.getAttackRange(), "Attack Range");
        } else {
            recursiveCheckDistance(dungeonMap, buttonGrid, "Start", YPos, XPos, heroSteps, "Walk Range");
            recursiveCheckDistance(dungeonMap, buttonGrid, "Start", YPos, XPos, heroInteractionSteps, "Interaction Range");
            System.out.println("X: " + XPos + " Y: " + YPos + " Speed: " + hero.getSpeed());
        }
    }

    private void recursiveCheckDistance(DungeonMap dungeonMap, Button[][] buttonGrid, String previousDirection, int YPos, int XPos, double range, String reasonForChecking) {
        if (previousDirection.contains("North")) previousDirection = "North";
        else if (previousDirection.contains("East")) previousDirection = "East";
        else if (previousDirection.contains("West")) previousDirection = "West";
        else if (previousDirection.contains("South")) previousDirection = "South";
        String currentTileTypeNorth = "North";
        String currentTileTypeEast = "East";
        String currentTileTypeWest = "West";
        String currentTileTypeSouth = "South";
        try {
            currentTileTypeNorth += dungeonMap.getMapTilesArray()[XPos][YPos + 1].getTypeOfTile();
            if (dungeonMap.getMapTilesArray()[XPos][YPos + 1].getOccupyingCreatureTypeId() > 0) {
                currentTileTypeNorth += "Occupied";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            currentTileTypeEast += dungeonMap.getMapTilesArray()[XPos + 1][YPos].getTypeOfTile();
            if (dungeonMap.getMapTilesArray()[XPos + 1][YPos].getOccupyingCreatureTypeId() > 0) {
                currentTileTypeEast += "Occupied";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            currentTileTypeWest += dungeonMap.getMapTilesArray()[XPos - 1][YPos].getTypeOfTile();
            if (dungeonMap.getMapTilesArray()[XPos - 1][YPos].getOccupyingCreatureTypeId() > 0) {
                currentTileTypeWest += "Occupied";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            currentTileTypeSouth += dungeonMap.getMapTilesArray()[XPos][YPos - 1].getTypeOfTile();
            if (dungeonMap.getMapTilesArray()[XPos][YPos - 1].getOccupyingCreatureTypeId() > 0) {
                currentTileTypeSouth += "Occupied";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        if (range > 0) {
            setDistanceOnSingleTile(dungeonMap, buttonGrid, previousDirection, currentTileTypeNorth, XPos, YPos, range, reasonForChecking);
            setDistanceOnSingleTile(dungeonMap, buttonGrid, previousDirection, currentTileTypeEast, XPos, YPos, range, reasonForChecking);
            setDistanceOnSingleTile(dungeonMap, buttonGrid, previousDirection, currentTileTypeWest, XPos, YPos, range, reasonForChecking);
            setDistanceOnSingleTile(dungeonMap, buttonGrid, previousDirection, currentTileTypeSouth, XPos, YPos, range, reasonForChecking);
        }
    }

    private void setDistanceOnSingleTile(DungeonMap dungeonMap, Button[][] buttonGrid, String previousDirection, String currentDirection, int XPos, int YPos, double iterations, String reasonForChecking) {
        double stepDecrement;
        stepDecrement = calculateTheStepDecrement(previousDirection, currentDirection);
        MapTile mapTile;
        Button gridButton;
        int temporaryX = XPos;
        int temporaryY = YPos;
        if (currentDirection.contains("North")) {
            temporaryY++;
        } else if (currentDirection.contains("East")) {
            temporaryX++;
        } else if (currentDirection.contains("West")) {
            temporaryX--;
        } else if (currentDirection.contains("South")) {
            temporaryY--;
        }
        if (reasonForChecking.contains("Interact") && currentDirection.contains(previousDirection)) {
            temporaryX = XPos;
            temporaryY = YPos;
        }
        mapTile = dungeonMap.getMapTilesArray()[temporaryX][temporaryY];
        gridButton = buttonGrid[temporaryX][temporaryY];
        if (currentDirection.contains("Room") || currentDirection.contains("Corridor") || currentDirection.contains("Opened")) {
            if (reasonForChecking.contains("Attack")) {
                gridButton.setStyle(FieldColors.ATTACK);
                markTheTileAsAccessible(reasonForChecking, mapTile, gridButton);
                recursiveCheckDistance(dungeonMap, buttonGrid, currentDirection, temporaryY, temporaryX, iterations - stepDecrement, reasonForChecking);
            } else if (!currentDirection.contains("Occupied") || (reasonForChecking.contains("Interaction"))) {
                markTheTileAsAccessible(reasonForChecking, mapTile, gridButton);
                recursiveCheckDistance(dungeonMap, buttonGrid, currentDirection, temporaryY, temporaryX, iterations - stepDecrement, reasonForChecking);
            }
        } else if (currentDirection.contains("Wall")) {
            mapTile.setAlreadyDiscovered(true);
            return;
        } else if (currentDirection.contains("Closed")) {
            mapTile.setAlreadyDiscovered(true);
            mapTile.setInWalkRange(true);
            gridButton.setStyle(FieldColors.INTERACTION);
            if (reasonForChecking.contains("Interact")) {
                mapTile.setWithinInteractionRange(true);
            }
            return;
        }
        dungeonMap.getMapTilesArray()[temporaryX][temporaryY] = mapTile;
        buttonGrid[temporaryX][temporaryY] = gridButton;
    }

    private void markTheTileAsAccessible(String reasonForChecking, MapTile mapTile, Button gridButton) {
        mapTile.setAlreadyDiscovered(true);
        if (!reasonForChecking.contains("Attack")) {
            mapTile.setInRangedAttackRange(true);
            mapTile.setInWalkRange(true);
        }
        if (reasonForChecking.contains("Walk")) {
            gridButton.setStyle(FieldColors.WALK_RANGE);
        } else if (reasonForChecking.contains("Interact")) {
            mapTile.setWithinInteractionRange(true);
            gridButton.setStyle(FieldColors.INTERACTION_RANGE);
            if (mapTile.getOccupyingCreatureTypeId() > 100) {
                gridButton.setStyle(FieldColors.ATTACK);
            }
        } else if (reasonForChecking.contains("Attack") && mapTile.getOccupyingCreatureTypeId() > 100) {
            //mapTile.setWithinInteractionRange(true);
            //gridButton.setStyle("-fx-color: #ff0000");
        }
    }


    private double calculateTheStepDecrement(String previousDirection, String currentDirection) {
        double stepDecrement;
        if ((previousDirection.contains("South") || previousDirection.contains("North"))
                &&
                (currentDirection.contains("West") || (currentDirection.contains("East")))) {
            stepDecrement = 0.8;
        } else if ((previousDirection.contains("West") || previousDirection.contains("East"))
                &&
                (currentDirection.contains("South") || (currentDirection.contains("North")))) {
            stepDecrement = 0.8;
        } else {
            stepDecrement = 1;
        }
        return stepDecrement;
    }

    void checkTheLineOfSight(DungeonMap dungeonMap, Button[][] buttonGrid, Hero hero) {
        int LOSRange = hero.getAttackRange();
        int YPos = hero.getMapYPos();
        int XPos = hero.getMapXPos();
        checkTheSightForOneDirection(dungeonMap, buttonGrid, YPos, XPos, LOSRange);
        checkTheSightForOneDirection(dungeonMap, buttonGrid, YPos, XPos, LOSRange);
        checkTheSightForOneDirection(dungeonMap, buttonGrid, YPos, XPos, LOSRange);
        checkTheSightForOneDirection(dungeonMap, buttonGrid, YPos, XPos, LOSRange);
    }

    private void checkTheSightForOneDirection(DungeonMap dungeonMap, Button[][] buttonGrid, int YPos, int XPos, int range) {
        for (int dir2 = -1; dir2 < 2; dir2 += 2) {
            for (int dir1 = -1; dir1 < 2; dir1 += 2) {
                for (int i = 0; i < range; i++) {
                    for (int j = 0; j < range; j++) {
                        if (i == 0 && j == 0) continue;
                        try {
                            int currentXPos = XPos + i * dir1;
                            int currentYPos = YPos + j * dir2;
                            MapTile currentMapTile = dungeonMap.getMapTilesArray()[currentXPos][currentYPos];
                            boolean mapTileIsOccupied = currentMapTile.getOccupyingCreatureTypeId() > 0;
                            if (!currentMapTile.isCurrentlyBehindCover() || !currentMapTile.isCurrentlyInvisible()) {
                                if (mapTileIsOccupied) {
                                    for (int k = 0; k < 5; k++) {
                                        int deltaX = i + 1;
                                        int deltaY = j + 1;
                                        double skewingCoefficient;
                                        skewingCoefficient = deltaX / deltaY;
                                        //System.out.println("DeltaX: " + deltaX + " DeltaY: " + deltaY);
                                        int valueX = currentXPos + (i * k * dir1);
                                        int valueY = currentYPos + (j * k * dir2);
                                        markTileAsUnreachable(dungeonMap, buttonGrid, valueX, valueY);
                                        //todo implement the logic from algorithm.java
                                        while (deltaY > 1 || deltaX > 1) {
                                            if (deltaX == 1) skewingCoefficient = 0.1;
                                            if (deltaY == 1) skewingCoefficient = 10;
                                            int modifiedValueX = valueX + dir1;
                                            int modifiedValueY = valueY + dir2;
                                            if (skewingCoefficient <= 5 && skewingCoefficient >= 0.2) {
                                                markTileAsUnreachable(dungeonMap, buttonGrid, modifiedValueX, modifiedValueY);
                                                deltaY--;
                                                deltaX--;
                                                valueX += dir1;
                                                valueY += dir2;
                                                if (deltaY > 0) {
                                                    skewingCoefficient = deltaX / deltaY;
                                                }
                                            } else if (skewingCoefficient > 5) {
                                                markTileAsUnreachable(dungeonMap, buttonGrid, modifiedValueX, valueY);
                                                deltaX--;
                                                valueX += dir1;
                                                skewingCoefficient = deltaX / deltaY;
                                            } else if (skewingCoefficient < 0.2) {
                                                markTileAsUnreachable(dungeonMap, buttonGrid, valueX, modifiedValueY);
                                                deltaY--;
                                                valueY += dir2;
                                                if (deltaY > 0) {
                                                    skewingCoefficient = deltaX / deltaY;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (IndexOutOfBoundsException ignored) {
                        }
                    }
                }
            }
        }
    }

    private void markTileAsUnreachable(DungeonMap dungeonMap, Button[][] buttonGrid, int valueX, int valueY) {
        dungeonMap.getMapTilesArray()[valueX][valueY].setCurrentlyInvisible(true);
        buttonGrid[valueX][valueY].setStyle(FieldColors.BEHIND_BARRIER);

    }

    private void setTheRoomAsVisible(int XPos, int YPos, DungeonMap dungeonMap, List<Monster> allMonstersList) {
        List<Room> listOfCurrentRooms = dungeonMap.getAllRoomsList();
        for (Room currentRoom : listOfCurrentRooms) {
            if (currentRoom.getRoomXStartPos() - 1 < XPos && ((currentRoom.getRoomXStartPos() + currentRoom.getRoomWidth() + 1) > XPos)) {
                if (currentRoom.getRoomYStartPos() - 1 < YPos && ((currentRoom.getRoomYStartPos() + currentRoom.getRoomHeight() + 1) > YPos)) {
                    System.out.println("Discovered room marked as visible.\n" +
                            " Starting X: " + currentRoom.getRoomXStartPos() +
                            "Starting Y: " + currentRoom.getRoomYStartPos() +
                            "\n" + "Width: " + currentRoom.getRoomWidth() + "Height: " + currentRoom.getRoomHeight());
                    System.out.println("Verification if the room is occupied:");
                    for (int i = -1; i < currentRoom.getRoomWidth() + 1; i++) {
                        for (int j = -1; j < currentRoom.getRoomHeight() + 1; j++) {
                            try {
                                MapTile currentMapTile = dungeonMap.getMapTilesArray()[currentRoom.getRoomXStartPos() + i][currentRoom.getRoomYStartPos() + j];
                                currentMapTile.setCurrentlyInvisible(false);
                                currentMapTile.setAlreadyDiscovered(true);
                                verifyIfTheMonsterOnThisTileIsAlarmed(allMonstersList, currentMapTile);
                            } catch (IndexOutOfBoundsException ignored) {
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean checkIfTheEncounterShouldStart(List<Monster> allMonstersList, List<Hero> listOfHeroes, Hero hero, DungeonMap dungeonMap, boolean fightAlreadyTakingPlace) {
        int XPos = hero.getMapXPos();
        int YPos = hero.getMapYPos();
        setTheRoomAsVisible(XPos, YPos, dungeonMap, allMonstersList);
        if (alarmedMonsterVisible && !fightAlreadyTakingPlace) {
            System.out.println(ConsoleColors.ANSI_YELLOW + "Roll for Initiative!" + ConsoleColors.ANSI_RESET);
            for (Monster monster : discoveredMonsters) {
                System.out.println("Passing the monster: " + monster.getMonsterName() + " UUID: " + monster.getCurrentMonsterUniqueID());
            }
            dungeonConsoleGUI.fillTheInitiativeTracker(listOfHeroes, discoveredMonsters, true);
            return true;
        }
        return fightAlreadyTakingPlace;
    }

    private void verifyIfTheMonsterOnThisTileIsAlarmed(List<Monster> allMonstersList, MapTile currentMapTile) {
        GUIUtilities guiUtilities = new GUIUtilities();
        if (currentMapTile.getOccupyingCreatureTypeId() > 100) {
            Monster monster = guiUtilities.getSingleMonsterByUniqueID(currentMapTile.getOccupyingCreatureUniqueID(), allMonstersList);
            if (!monster.isThisCreatureDead()) {
                discoveredMonsters.add(monster);
                setAlarmedMonsterVisible(true);
                System.out.println("Found a monster. Adding: " + monster.getMonsterName() + " UUID: " + monster.getCurrentMonsterUniqueID());
                isCurrentEncounterFinished = false;
                numberOfEncountersInThisDungeon++;
                System.out.println("This is the encounter number: " + numberOfEncountersInThisDungeon);
            }
        }
    }
}


