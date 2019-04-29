package sample;

import java.util.List;
import java.util.Random;

class Map {
    private int corridorMaxLength = 8;
    private int numberOfTilesY = 40;
    private int numberOfTilesX = 40;
    private MapTile[][] mapTilesArray = new MapTile[numberOfTilesX][numberOfTilesY];
    private boolean isThisTheFirstSpawningRoom = true;
    private List<Hero> heroList;
    private List<Monster> monsterList;

    public Map(List<Hero> heroList, List<Monster> monsterList) {
        this.heroList = heroList;
        this.monsterList = monsterList;
        for (Hero hero : heroList) {
            System.out.println("ID: " + hero.ID + " Class: " + hero.heroClass);
        }
        for (Monster monster : monsterList) {
            System.out.println("ID: " + monster.ID + " Class: " + monster.monsterType);
        }
    }

    void drawAMap() {
        seedAMap();
        trimAllInvalidCorridors();
        checkTheBlankTilesForWalls();
        markTheDoorTiles();
    }

    private void fillTheMapWithRooms() {
        for (int i = 0; i < numberOfTilesX; i++) {
            for (int j = 0; j < numberOfTilesY; j++) {
                MapTile mapTile = new MapTile();
                getMapTilesArray()[i][j] = mapTile;
            }
        }
    }

    private boolean checkAroundForExistingRooms(int posX, int posY) {
        boolean foundRoom = false;
//        try {
//            foundRoom = (mapTilesArray[posX - 1][posY].typeOfTile.equals("Room"));
//        } catch (IndexOutOfBoundsException ignored) {
//            foundRoom = true;
//        }
//        try {
//            foundRoom = (mapTilesArray[posX][posY - 1].typeOfTile.equals("Room"));
//        } catch (IndexOutOfBoundsException ignored) {
//            foundRoom = true;
//        }
        try {
            foundRoom = getMapTilesArray()[posX - 1][posY - 1].typeOfTile.equals("Room");
        } catch (IndexOutOfBoundsException ignored) {
            foundRoom = true;
        }
        return foundRoom;
    }

    private void seedAMap() {
        fillTheMapWithRooms();
        for (int i = 0; i < numberOfTilesX; i++) {
            for (int j = 0; j < numberOfTilesY; j++) {
                seedASingleTile(i, j);
            }
        }
    }

    private void seedASingleTile(int i, int j) {
        boolean checkThisTileForRooms = false;
        boolean checkAroundForRooms = false;
        boolean checkThisTileForCorridors = false;
        try {
            checkThisTileForCorridors = getMapTilesArray()[i][j].typeOfTile.contains("Corridor");
        } catch (NullPointerException ignored) {
        }
        try {
            checkThisTileForRooms = (getMapTilesArray()[i][j].typeOfTile.equals("Room") || getMapTilesArray()[i][j].typeOfTile.equals("RoomSeed"));
        } catch (NullPointerException ignored) {
        }
        if (!checkThisTileForRooms) {
            checkAroundForRooms = checkAroundForExistingRooms(i, j);
        }
        getMapTilesArray()[i][j].rollForTypeOfTile(checkThisTileForRooms, checkAroundForRooms, checkThisTileForCorridors);
        if (getMapTilesArray()[i][j].typeOfTile.equals("RoomSeed")) {
            seedARoom(i, j);
        }
    }

    private void seedARoom(int initialXPos, int initialYPos) {
        Random randomH = new Random();
        Random randomW = new Random();
        Room room = new Room();
        room.roomYPos = initialYPos;
        room.roomXPos = initialXPos;
        int minRoomHeight = 7;
        int maxRoomHeight = 12;
        room.roomHeight = randomH.nextInt(maxRoomHeight - minRoomHeight);
        int minRoomWidth = 7;
        int maxRoomWidth = 12;
        room.roomWidth = randomW.nextInt(maxRoomWidth - minRoomWidth);
        room.roomHeight += minRoomHeight;
        room.roomWidth += minRoomWidth;
        if (checkIfTheRoomCanBeSeeded(room)) {
            for (int i = 0; i < room.roomWidth; i++) {
                for (int j = 0; j < room.roomHeight; j++) {
                    seedASingleRoomTile(initialXPos, initialYPos, i, j);
                }
            }
            if (isThisTheFirstSpawningRoom) {
                spawnHeroesInTheFirstRoom(room);
                isThisTheFirstSpawningRoom = false;
            } else {
                spawnMonstersInARoom(room);
            }
            seedCorridors(room);
        } else {
            getMapTilesArray()[initialXPos][initialYPos].typeOfTile = "Blank";
        }
    }

    private void seedASingleRoomTile(int initialXPos, int initialYPos, int i, int j) {
        try {
            if (isThisTheFirstSpawningRoom) {
                getMapTilesArray()[initialXPos + i][initialYPos + j].visible = true;
            }
            getMapTilesArray()[initialXPos + i][initialYPos + j].typeOfTile = "Room";
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    private boolean searchForCrossingCorridors(int XPos, int YPos, String typeOfCorridor) {
        boolean crossingCorridorFound = false;
        if (typeOfCorridor.contains("Vertical")) {
            try {
                for (int i = 0; i < corridorMaxLength + 1; i++) {
                    if (getMapTilesArray()[XPos + i][YPos].typeOfTile.contains("Corridor")) {
                        crossingCorridorFound = true;
                        break;
                    }
                }
            } catch (IndexOutOfBoundsException | NullPointerException ignored) {
            }
        } else if (typeOfCorridor.contains("Horizontal")) {
            try {
                for (int i = 0; i < corridorMaxLength + 1; i++) {
                    if (getMapTilesArray()[XPos][YPos + i].typeOfTile.contains("Corridor")) {
                        crossingCorridorFound = true;
                        break;
                    }
                }
            } catch (IndexOutOfBoundsException | NullPointerException ignored) {
            }
        }
        return crossingCorridorFound;
    }


    private void seedCorridors(Room room) {

        Random randomH = new Random();
        int VSpawn = randomH.nextInt(room.roomHeight - 2);
        VSpawn++;
        Random randomV = new Random();
        int HSpawn = randomV.nextInt(room.roomWidth - 2);
        HSpawn++;
        if (!searchForCrossingCorridors(room.roomXPos + room.roomWidth, room.roomXPos + room.roomWidth, "CorridorVertical")) {
            for (int i = 0; i < corridorMaxLength; i++) {
                try {
                    if (!getMapTilesArray()[room.roomXPos + room.roomWidth + i][room.roomYPos + VSpawn].typeOfTile.contains("Room")) {
                        getMapTilesArray()[room.roomXPos + room.roomWidth + i][room.roomYPos + VSpawn].typeOfTile = "CorridorVertical";
                    }
                } catch (IndexOutOfBoundsException ignored) {

                } catch (NullPointerException e) {
                    getMapTilesArray()[room.roomXPos + room.roomWidth + i][room.roomYPos + VSpawn].typeOfTile = "CorridorVertical";
                }
            }
        }
        if (!searchForCrossingCorridors(room.roomXPos + HSpawn, room.roomYPos + room.roomHeight, "CorridorHorizontal")) {
            for (int i = 0; i < corridorMaxLength; i++) {
                try {
                    if (!getMapTilesArray()[room.roomXPos + HSpawn][room.roomYPos + room.roomHeight + i].typeOfTile.contains("Room")) {
                        getMapTilesArray()[room.roomXPos + HSpawn][room.roomYPos + room.roomHeight + i].typeOfTile = "CorridorHorizontal";
                    }
                } catch (IndexOutOfBoundsException ignored) {

                } catch (NullPointerException e) {
                    getMapTilesArray()[room.roomXPos + HSpawn][room.roomYPos + room.roomHeight + i].typeOfTile = "CorridorHorizontal";
                }
            }
        }
    }

    private boolean checkIfTheRoomHasEntrance(Room room) {
        boolean roomEntranceFound = false;
        for (int i = 0; i < room.roomWidth; i++) {
            for (int j = 0; j < room.roomHeight; j++) {
                try {
                    if (getMapTilesArray()[room.roomXPos + i][room.roomYPos + j].typeOfTile.contains("Corridor")) {
                        roomEntranceFound = true;
                        break;
                    }
                } catch (NullPointerException | IndexOutOfBoundsException ignored) {

                }

            }
        }
        return roomEntranceFound;
    }


    private boolean checkIfTheRoomCanBeSeeded(Room room) {
        boolean seedingAllowed = true;
        boolean roomHasEntrance;
        try {
            for (int i = -1; i < room.roomWidth + 1; i++) {
                for (int j = -1; j < room.roomHeight + 1; j++) {
                    if (i != 0 || j != 0) {
                        try {
                            if (getMapTilesArray()[room.roomXPos + i][room.roomYPos + j].typeOfTile.contains("Room")) {
                                seedingAllowed = false;
                                break;
                            }
                        } catch (NullPointerException ignored) {
                        }
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            seedingAllowed = false;
        }
        roomHasEntrance = checkIfTheRoomHasEntrance(room);
        seedingAllowed = seedingAllowed && roomHasEntrance;
        if (isThisTheFirstSpawningRoom) {
            seedingAllowed = true;
        }
        return seedingAllowed;
    }

    private boolean checkIfTheCorridorTileIsInvalid(String typeOfCorridor, int XPos, int YPos) {
        boolean corridorIsInvalid = false;
        if (typeOfCorridor.contains("Vertical")) {
            for (int i = 0; i < corridorMaxLength + 1; i++) {
                try {
                    if (getMapTilesArray()[XPos + i][YPos].typeOfTile.contains("Room")) {
                        corridorIsInvalid = false;
                        break;
                    } else if ((getMapTilesArray()[XPos + i][YPos].typeOfTile.contains("Blank"))) {
                        corridorIsInvalid = true;
                        break;
                    } else {
                        corridorIsInvalid = true;
                    }
                } catch (IndexOutOfBoundsException e) {
                    corridorIsInvalid = true;
                }
            }
        } else if (typeOfCorridor.contains("Horizontal")) {
            for (int i = 0; i < corridorMaxLength + 1; i++) {
                try {
                    if (getMapTilesArray()[XPos][YPos + i].typeOfTile.contains("Room")) {
                        corridorIsInvalid = false;
                        break;
                    } else if ((getMapTilesArray()[XPos][YPos + i].typeOfTile.contains("Blank"))) {
                        corridorIsInvalid = true;
                        break;
                    } else {
                        corridorIsInvalid = true;
                    }
                } catch (IndexOutOfBoundsException e) {
                    corridorIsInvalid = true;
                }
            }
        }
        return corridorIsInvalid;
    }

    private void trimAllInvalidCorridors() {
        boolean trimThisTile;
        for (int i = 0; i < numberOfTilesX; i++) {
            for (int j = 0; j < numberOfTilesY; j++) {
                if (getMapTilesArray()[i][j].typeOfTile.contains("Corridor")) {
                    trimThisTile = checkIfTheCorridorTileIsInvalid(getMapTilesArray()[i][j].typeOfTile, i, j);
                    if (trimThisTile) {
                        getMapTilesArray()[i][j].typeOfTile = "Blank";
                    }
                }
            }
        }
    }

    //todo check if it's possible to unite hero and monster spawn methods according to DRY

    //todo make a proper encounter generator so that monster spawning is not fake

    private void spawnMonstersInARoom(Room room) {
        Random randX = new Random();
        int currentMonsterXPos;
        Random randY = new Random();
        int currentMonsterYPos;
        for (int i = 0; i < monsterList.size(); i++) {
            currentMonsterXPos = randX.nextInt(room.roomWidth);
            currentMonsterYPos = randY.nextInt(room.roomHeight);
            Monster currentMonster = monsterList.get(i);
            if (getMapTilesArray()[room.roomXPos + currentMonsterXPos][room.roomYPos + currentMonsterYPos].occupyingCreatureId == 0) {
                getMapTilesArray()[room.roomXPos + currentMonsterXPos][room.roomYPos + currentMonsterYPos].occupyingCreatureId = currentMonster.ID;
                currentMonster.mapXPos = room.roomXPos + currentMonsterXPos;
                currentMonster.mapYPos = room.roomYPos + currentMonsterYPos;
                System.out.println("Monster Class: " + currentMonster.monsterType + " X: " + currentMonster.mapXPos + " Y: " + currentMonster.mapYPos);
            } else {
                i--;
            }
        }
    }

    void clearMapReachableProperties(Map map) {
        for (int i = 0; i < numberOfTilesX; i++) {
            for (int j = 0; j < numberOfTilesY; j++) {
                map.getMapTilesArray()[i][j].inWalkRange = false;
                map.getMapTilesArray()[i][j].withinInteractionRange = false;
            }
        }
    }

    private void spawnHeroesInTheFirstRoom(Room room) {
        Random randX = new Random();
        int currentHeroXPos;
        Random randY = new Random();
        int currentHeroYPos;
        for (int i = 0; i < heroList.size(); i++) {
            currentHeroXPos = randX.nextInt(room.roomWidth);
            currentHeroYPos = randY.nextInt(room.roomHeight);
            Hero currentHero = heroList.get(i);
            if (getMapTilesArray()[room.roomXPos + currentHeroXPos][room.roomYPos + currentHeroYPos].occupyingCreatureId == 0) {
                getMapTilesArray()[room.roomXPos + currentHeroXPos][room.roomYPos + currentHeroYPos].occupyingCreatureId = currentHero.ID;
                currentHero.mapXPos = room.roomXPos + currentHeroXPos;
                currentHero.mapYPos = room.roomYPos + currentHeroYPos;
                System.out.println("Hero Class: " + currentHero.heroClass + " X: " + currentHero.mapXPos + " Y: " + currentHero.mapYPos);
            } else {
                i--;
            }
        }
    }

    //todo cleanup the east-south mess in arrays
    //todo include corridors and thin walls in the map drawing procedure

    private void checkTheBlankTilesForWalls() {
        for (int i = 0; i < numberOfTilesX; i++) {
            for (int j = 0; j < numberOfTilesY; j++) {
                String foundBorders = "";
                if (getMapTilesArray()[i][j].typeOfTile.contains("Blank")) {
                    foundBorders = checkForStraightWalls(i, j, foundBorders);
                    if (foundBorders.length() < 2) {
                        foundBorders = checkForCorners(i, j, foundBorders);
                    }
                    if (foundBorders.length() > 2) {
                        getMapTilesArray()[i][j].typeOfTile = "Wall" + foundBorders;
                    }
                }
            }

        }
    }

    private String checkForStraightWalls(int i, int j, String foundBorders) {
        try {
            if (getMapTilesArray()[i + 1][j].typeOfTile.contains("Room")) {
                foundBorders += "East";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            if (getMapTilesArray()[i - 1][j].typeOfTile.contains("Room")) {
                foundBorders += "West";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            if (getMapTilesArray()[i][j + 1].typeOfTile.contains("Room")) {
                foundBorders += "North";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            if (getMapTilesArray()[i][j - 1].typeOfTile.contains("Room")) {
                foundBorders += "South";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        return foundBorders;
    }

    private String checkForCorners(int i, int j, String foundBorders) {
        try {
            if (getMapTilesArray()[i - 1][j - 1].typeOfTile.contains("Room")) {
                foundBorders = "CornerSW";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            if (getMapTilesArray()[i + 1][j - 1].typeOfTile.contains("Room")) {
                foundBorders = "CornerSE";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            if (getMapTilesArray()[i + 1][j + 1].typeOfTile.contains("Room")) {
                foundBorders = "CornerNW";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            if (getMapTilesArray()[i - 1][j + 1].typeOfTile.contains("Room")) {
                foundBorders = "CornerNE";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        return foundBorders;
    }

    private void markTheDoorTiles() {
        for (int i = 0; i < numberOfTilesX; i++) {
            for (int j = 0; j < numberOfTilesY; j++) {
                if (getMapTilesArray()[i][j].typeOfTile.contains("Corridor") &&
                        getMapTilesArray()[i - 1][j].typeOfTile.contains("Room")) {
                    getMapTilesArray()[i][j].typeOfTile = "ClosedDoorHorizontal";
                } else if (getMapTilesArray()[i][j].typeOfTile.contains("Corridor") &&
                        getMapTilesArray()[i + 1][j].typeOfTile.contains("Room")) {
                    getMapTilesArray()[i][j].typeOfTile = "ClosedDoorHorizontal";
                } else if (getMapTilesArray()[i][j].typeOfTile.contains("Corridor") &&
                        getMapTilesArray()[i][j - 1].typeOfTile.contains("Room")) {
                    getMapTilesArray()[i][j].typeOfTile = "ClosedDoorVertical";
                } else if (getMapTilesArray()[i][j].typeOfTile.contains("Corridor") &&
                        getMapTilesArray()[i][j + 1].typeOfTile.contains("Room")) {
                    getMapTilesArray()[i][j].typeOfTile = "ClosedDoorVertical";
                }
            }
        }
    }

    public MapTile[][] getMapTilesArray() {
        return mapTilesArray;
    }

    public void setMapTilesArray(MapTile[][] mapTilesArray) {
        this.mapTilesArray = mapTilesArray;
    }
}
