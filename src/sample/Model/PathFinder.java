package sample.Model;

import javafx.scene.control.Button;

public class PathFinder {

    public void checkTheAvailableDistance(Hero hero, DungeonMap dungeonMap, Button[][] buttonGrid) {
        int YPos = hero.getMapYPos();
        int XPos = hero.getMapXPos();
        double heroSteps = hero.getCurrentSpeed();
        double heroInteractionSteps;
        if (hero.getCurrentSpeed() > 0.9) {
            heroInteractionSteps = 1.1;
        } else {
            heroInteractionSteps = 0;
        }
        recursiveCheckDistance(dungeonMap, buttonGrid, "Start", YPos, XPos, heroSteps, "Walk Range");
        recursiveCheckDistance(dungeonMap, buttonGrid, "Start", YPos, XPos, heroInteractionSteps, "Interaction Range");
        System.out.println("X: " + XPos + " Y: " + YPos + " Speed: " + hero.getSpeed());
    }

    public void recursiveCheckDistance(DungeonMap dungeonMap, Button[][] buttonGrid, String previousDirection, int YPos, int XPos, double range, String reasonForChecking) {
        if (previousDirection.contains("North")) previousDirection = "North";
        else if (previousDirection.contains("East")) previousDirection = "East";
        else if (previousDirection.contains("West")) previousDirection = "West";
        else if (previousDirection.contains("South")) previousDirection = "South";
        String currentTileTypeNorth = "North";
        String currentTileTypeEast = "East";
        String currentTileTypeWest = "West";
        String currentTileTypeSouth = "South";
        try {
            currentTileTypeNorth += dungeonMap.getMapTilesArray()[XPos][YPos + 1].typeOfTile;
            if (dungeonMap.getMapTilesArray()[XPos][YPos + 1].getOccupyingCreatureId() > 0) {
                currentTileTypeNorth += "Occupied";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            currentTileTypeEast += dungeonMap.getMapTilesArray()[XPos + 1][YPos].typeOfTile;
            if (dungeonMap.getMapTilesArray()[XPos + 1][YPos].getOccupyingCreatureId() > 0) {
                currentTileTypeEast += "Occupied";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            currentTileTypeWest += dungeonMap.getMapTilesArray()[XPos - 1][YPos].typeOfTile;
            if (dungeonMap.getMapTilesArray()[XPos - 1][YPos].getOccupyingCreatureId() > 0) {
                currentTileTypeWest += "Occupied";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            currentTileTypeSouth += dungeonMap.getMapTilesArray()[XPos][YPos - 1].typeOfTile;
            if (dungeonMap.getMapTilesArray()[XPos][YPos - 1].getOccupyingCreatureId() > 0) {
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

    public void setDistanceOnSingleTile(DungeonMap dungeonMap, Button[][] buttonGrid, String previousDirection, String currentDirection, int XPos, int YPos, double iterations, String reasonForChecking) {
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
            if (!currentDirection.contains("Occupied") || (reasonForChecking.contains("Interaction"))) {
                markTheTileAsAccessible(reasonForChecking, mapTile, gridButton);
                recursiveCheckDistance(dungeonMap, buttonGrid, currentDirection, temporaryY, temporaryX, iterations - stepDecrement, reasonForChecking);
            }
        } else if (currentDirection.contains("Wall")) {
            mapTile.alreadyDiscovered = true;
        } else if (currentDirection.contains("Closed")) {
            mapTile.alreadyDiscovered = true;
            mapTile.inWalkRange = true;
            gridButton.setStyle("-fx-color: #333399");
            if (reasonForChecking.contains("Interact")) {
                mapTile.withinInteractionRange = true;
            }
        }
        dungeonMap.getMapTilesArray()[temporaryX][temporaryY] = mapTile;
        buttonGrid[temporaryX][temporaryY] = gridButton;
    }

    public void markTheTileAsAccessible(String reasonForChecking, MapTile mapTile, Button gridButton) {
        mapTile.alreadyDiscovered = true;
        mapTile.inWalkRange = true;
        if (reasonForChecking.contains("Walk")) {
            gridButton.setStyle("-fx-color: #00ff00");
        } else if (reasonForChecking.contains("Interact")) {
            mapTile.withinInteractionRange = true;
            gridButton.setStyle("-fx-color: #ffff00");
            if (mapTile.getOccupyingCreatureId() > 100) {
                gridButton.setStyle("-fx-color: #ff0000");
            }
        }
    }

    public double calculateTheStepDecrement(String previousDirection, String currentDirection) {
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

    public void checkTheLineOfSight(DungeonMap dungeonMap, Button[][] buttonGrid, Hero hero) {
        int YPos = hero.getMapYPos();
        int XPos = hero.getMapXPos();
        checkTheSightForOneDirection(dungeonMap, buttonGrid, YPos, XPos, 1, 1);
        checkTheSightForOneDirection(dungeonMap, buttonGrid, YPos, XPos, 1, -1);
        checkTheSightForOneDirection(dungeonMap, buttonGrid, YPos, XPos, -1, 1);
        checkTheSightForOneDirection(dungeonMap, buttonGrid, YPos, XPos, -1, -1);
    }

    private void checkTheSightForOneDirection(DungeonMap dungeonMap, Button[][] buttonGrid, int YPos, int XPos, int dir1, int dir2) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0 && j == 0) continue;
                try {
                    int currentXPos = XPos + i * dir1;
                    int currentYPos = YPos + j * dir2;
                    MapTile currentMapTile = dungeonMap.getMapTilesArray()[currentXPos][currentYPos];
                    boolean mapTileIsOccupied = currentMapTile.getOccupyingCreatureId() > 0;
                    if (!currentMapTile.isCurrentlyBehindCover() || !currentMapTile.isCurrentlyInvisible()) {
                        if (mapTileIsOccupied) {
                            for (int k = 0; k < 5; k++) {
                                int deltaX = i + 1;
                                int deltaY = j + 1;
                                double skewingCoefficient;
                                skewingCoefficient = deltaX / deltaY;
                                System.out.println("DeltaX: " + deltaX + " DeltaY: " + deltaY);
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

    private void markTileAsUnreachable(DungeonMap dungeonMap, Button[][] buttonGrid, int valueX, int valueY) {
        dungeonMap.getMapTilesArray()[valueX][valueY].setCurrentlyInvisible(true);
        buttonGrid[valueX][valueY].setStyle("-fx-color: #ff6600");

    }

}
