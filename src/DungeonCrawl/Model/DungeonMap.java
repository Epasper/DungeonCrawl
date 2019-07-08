package DungeonCrawl.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DungeonMap {
    private int corridorMaxLength = 8;
    private int numberOfTilesY = 40;
    private int numberOfTilesX = 40;
    private MapTile[][] mapTilesArray = new MapTile[numberOfTilesX][numberOfTilesY];
    private boolean isThisTheFirstSpawningRoom = true;
    private List<Hero> heroList;
    private List<Monster> allMonstersList = new ArrayList<>();
    private List<Room> allRoomsList = new ArrayList<>();
    private int currentMonsterUniqueID = 1;

    public int getNumberOfTilesY() {
        return numberOfTilesY;
    }

    public void setNumberOfTilesY(int numberOfTilesY) {
        this.numberOfTilesY = numberOfTilesY;
    }

    public int getNumberOfTilesX() {
        return numberOfTilesX;
    }

    public void setNumberOfTilesX(int numberOfTilesX) {
        this.numberOfTilesX = numberOfTilesX;
    }

    public List<Room> getAllRoomsList() {
        return allRoomsList;
    }

    public void setAllRoomsList(List<Room> allRoomsList) {
        this.allRoomsList = allRoomsList;
    }

    public List<Monster> getAllMonstersList() {
        return allMonstersList;
    }

    public void setAllMonstersList(List<Monster> allMonstersList) {
        this.allMonstersList = allMonstersList;
    }

    public List<Hero> getHeroList() {
        return heroList;
    }

    public void setHeroList(List<Hero> heroList) {
        this.heroList = heroList;
    }

    public DungeonMap(List<Hero> heroList) {
        this.heroList = heroList;
    }

    public void drawAMap() {
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
        boolean foundRoom;
        try {
            foundRoom = getMapTilesArray()[posX - 1][posY - 1].getTypeOfTile().equals("Room");
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
            checkThisTileForCorridors = getMapTilesArray()[i][j].getTypeOfTile().contains("Corridor");
        } catch (NullPointerException ignored) {
        }
        try {
            checkThisTileForRooms = (getMapTilesArray()[i][j].getTypeOfTile().equals("Room") || getMapTilesArray()[i][j].getTypeOfTile().equals("RoomSeed"));
        } catch (NullPointerException ignored) {
        }
        if (!checkThisTileForRooms) {
            checkAroundForRooms = checkAroundForExistingRooms(i, j);
        }
        getMapTilesArray()[i][j].rollForTypeOfTile(checkThisTileForRooms, checkAroundForRooms, checkThisTileForCorridors);
        if (getMapTilesArray()[i][j].getTypeOfTile().equals("RoomSeed")) {
            seedARoom(i, j);
        }
    }

    private void seedARoom(int initialXPos, int initialYPos) {
        Random randomH = new Random();
        Random randomW = new Random();
        Room room = new Room();
        room.roomYStartPos = initialYPos;
        room.roomXStartPos = initialXPos;
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
            allRoomsList.add(room);
        } else {
            getMapTilesArray()[initialXPos][initialYPos].setTypeOfTile("Blank");
        }
    }

    private void seedASingleRoomTile(int initialXPos, int initialYPos, int i, int j) {
        try {
            if (isThisTheFirstSpawningRoom) {
                getMapTilesArray()[initialXPos + i][initialYPos + j].setAlreadyDiscovered(true);
            }
            getMapTilesArray()[initialXPos + i][initialYPos + j].setTypeOfTile("Room");
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    private boolean searchForCrossingCorridors(int XPos, int YPos, String typeOfCorridor) {
        boolean crossingCorridorFound = false;
        if (typeOfCorridor.contains("Vertical")) {
            try {
                for (int i = 0; i < corridorMaxLength + 1; i++) {
                    if (getMapTilesArray()[XPos + i][YPos].getTypeOfTile().contains("Corridor")) {
                        crossingCorridorFound = true;
                        break;
                    }
                }
            } catch (IndexOutOfBoundsException | NullPointerException ignored) {
            }
        } else if (typeOfCorridor.contains("Horizontal")) {
            try {
                for (int i = 0; i < corridorMaxLength + 1; i++) {
                    if (getMapTilesArray()[XPos][YPos + i].getTypeOfTile().contains("Corridor")) {
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
        if (!searchForCrossingCorridors(room.roomXStartPos + room.roomWidth, room.roomXStartPos + room.roomWidth, "CorridorVertical")) {
            for (int i = 0; i < corridorMaxLength; i++) {
                try {
                    if (!getMapTilesArray()[room.roomXStartPos + room.roomWidth + i][room.roomYStartPos + VSpawn].getTypeOfTile().contains("Room")) {
                        getMapTilesArray()[room.roomXStartPos + room.roomWidth + i][room.roomYStartPos + VSpawn].setTypeOfTile("CorridorVertical");
                    }
                } catch (IndexOutOfBoundsException ignored) {

                } catch (NullPointerException e) {
                    getMapTilesArray()[room.roomXStartPos + room.roomWidth + i][room.roomYStartPos + VSpawn].setTypeOfTile("CorridorVertical");
                }
            }
        }
        if (!searchForCrossingCorridors(room.roomXStartPos + HSpawn, room.roomYStartPos + room.roomHeight, "CorridorHorizontal")) {
            for (int i = 0; i < corridorMaxLength; i++) {
                try {
                    if (!getMapTilesArray()[room.roomXStartPos + HSpawn][room.roomYStartPos + room.roomHeight + i].getTypeOfTile().contains("Room")) {
                        getMapTilesArray()[room.roomXStartPos + HSpawn][room.roomYStartPos + room.roomHeight + i].setTypeOfTile("CorridorHorizontal");
                    }
                } catch (IndexOutOfBoundsException ignored) {

                } catch (NullPointerException e) {
                    getMapTilesArray()[room.roomXStartPos + HSpawn][room.roomYStartPos + room.roomHeight + i].setTypeOfTile("CorridorHorizontal");
                }
            }
        }
    }

    private boolean checkIfTheRoomHasEntrance(Room room) {
        boolean roomEntranceFound = false;
        for (int i = 0; i < room.roomWidth; i++) {
            for (int j = 0; j < room.roomHeight; j++) {
                try {
                    if (getMapTilesArray()[room.roomXStartPos + i][room.roomYStartPos + j].getTypeOfTile().contains("Corridor")) {
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
                            if (getMapTilesArray()[room.roomXStartPos + i][room.roomYStartPos + j].getTypeOfTile().contains("Room")) {
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
                    if (getMapTilesArray()[XPos + i][YPos].getTypeOfTile().contains("Room")) {
                        corridorIsInvalid = false;
                        break;
                    } else if ((getMapTilesArray()[XPos + i][YPos].getTypeOfTile().contains("Blank"))) {
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
                    if (getMapTilesArray()[XPos][YPos + i].getTypeOfTile().contains("Room")) {
                        corridorIsInvalid = false;
                        break;
                    } else if ((getMapTilesArray()[XPos][YPos + i].getTypeOfTile().contains("Blank"))) {
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
                if (getMapTilesArray()[i][j].getTypeOfTile().contains("Corridor")) {
                    trimThisTile = checkIfTheCorridorTileIsInvalid(getMapTilesArray()[i][j].getTypeOfTile(), i, j);
                    if (trimThisTile) {
                        getMapTilesArray()[i][j].setTypeOfTile("Blank");
                    }
                }
            }
        }
    }

    private void spawnMonstersInARoom(Room room) {
        Random randX = new Random();
        int currentMonsterXPos;
        Random randY = new Random();
        int currentMonsterYPos;
        //todo make encounter difficulty selection possible
        EncounterCalculator encounterCalculator = new EncounterCalculator();
        System.out.println("HERO LIST FOR MONSTER CALCULATIONS: ");
        for (Hero hero : heroList) {
            System.out.println(hero.getMonsterName() + " Hero Level: " + hero.getHeroLevel());
        }
        List<Monster> monsterList = encounterCalculator.getTheListOfMonsters(heroList, "Hard", currentMonsterUniqueID);
        currentMonsterUniqueID += monsterList.size();
        System.out.println("MONSTER LIST FOR MONSTER CALCULATIONS: ");
        for (Monster currentMonster : monsterList) {
            System.out.println(currentMonster.getMonsterName() + " Monster Experience: " + currentMonster.getXpValue());
        }
        for (int i = 0; i < monsterList.size(); i++) {
            currentMonsterXPos = randX.nextInt(room.roomWidth);
            currentMonsterYPos = randY.nextInt(room.roomHeight);
            Monster currentMonster = monsterList.get(i);
            System.out.println("Monster UUID: " + currentMonster.getCurrentMonsterUniqueID() + "---" + currentMonsterUniqueID);
            if (getMapTilesArray()[room.roomXStartPos + currentMonsterXPos][room.roomYStartPos + currentMonsterYPos].getOccupyingCreatureTypeId() == 0) {
                getMapTilesArray()[room.roomXStartPos + currentMonsterXPos][room.roomYStartPos + currentMonsterYPos].setOccupyingCreatureTypeId(currentMonster.getID());
                currentMonsterUniqueID++;
                getMapTilesArray()[room.roomXStartPos + currentMonsterXPos][room.roomYStartPos + currentMonsterYPos].setOccupyingCreatureUniqueID(currentMonster.getCurrentMonsterUniqueID());
                currentMonster.setMapXPos(room.roomXStartPos + currentMonsterXPos);
                currentMonster.setMapYPos(room.roomYStartPos + currentMonsterYPos);
                System.out.println("Monster Spawning: " + currentMonster.getMonsterName() + " X: " + currentMonster.getMapXPos() + " Y: " + currentMonster.getMapYPos());
                System.out.println("Monster UUID: " + currentMonster.getCurrentMonsterUniqueID() + "|||" + currentMonsterUniqueID);
            } else {
                i--;
            }
        }
        allMonstersList.addAll(monsterList);
    }



    public void clearMapReachableProperties() {
        for (int i = 0; i < numberOfTilesX; i++) {
            for (int j = 0; j < numberOfTilesY; j++) {
                this.getMapTilesArray()[i][j].setInWalkRange(false);
                this.getMapTilesArray()[i][j].setWithinInteractionRange(false);
                this.getMapTilesArray()[i][j].setInRangedAttackRange(false);

            }
        }
    }

    private void spawnHeroesInTheFirstRoom(Room room) {
        Random randX = new Random();
        int currentHeroXPos;
        Random randY = new Random();
        int currentHeroYPos;
        System.out.println("Number of heroes upon spawning: " + heroList.size());
        for (int i = 0; i < heroList.size(); i++) {
            currentHeroXPos = randX.nextInt(room.roomWidth);
            currentHeroYPos = randY.nextInt(room.roomHeight);
            Hero currentHero = heroList.get(i);
            System.out.println("Name of current spawning hero: " + heroList.get(i).getMonsterName());
            if (getMapTilesArray()[room.roomXStartPos + currentHeroXPos][room.roomYStartPos + currentHeroYPos].getOccupyingCreatureTypeId() == 0) {
                getMapTilesArray()[room.roomXStartPos + currentHeroXPos][room.roomYStartPos + currentHeroYPos].setOccupyingCreatureTypeId(currentHero.getID());
                currentHero.setMapXPos(room.roomXStartPos + currentHeroXPos);
                currentHero.setMapYPos(room.roomYStartPos + currentHeroYPos);
                System.out.println("Hero Class: " + currentHero.getHeroClass() + " X: " + currentHero.getMapXPos() + " Y: " + currentHero.getMapYPos());
            } else {
                i--;
            }
        }
    }

    private void checkTheBlankTilesForWalls() {
        for (int i = 0; i < numberOfTilesX; i++) {
            for (int j = 0; j < numberOfTilesY; j++) {
                String foundBorders = "";
                if (getMapTilesArray()[i][j].getTypeOfTile().contains("Blank")) {
                    foundBorders = checkForStraightWalls(i, j, foundBorders);
                    if (foundBorders.length() < 2) {
                        foundBorders = checkForCorners(i, j, foundBorders);
                    }
                    if (foundBorders.length() > 2) {
                        getMapTilesArray()[i][j].setTypeOfTile("Wall" + foundBorders);
                    }
                }
            }

        }
    }

    private String checkForStraightWalls(int i, int j, String foundBorders) {
        try {
            if (getMapTilesArray()[i + 1][j].getTypeOfTile().contains("Room")) {
                foundBorders += "East";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            if (getMapTilesArray()[i - 1][j].getTypeOfTile().contains("Room")) {
                foundBorders += "West";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            if (getMapTilesArray()[i][j + 1].getTypeOfTile().contains("Room")) {
                foundBorders += "North";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            if (getMapTilesArray()[i][j - 1].getTypeOfTile().contains("Room")) {
                foundBorders += "South";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        return foundBorders;
    }

    private String checkForCorners(int i, int j, String foundBorders) {
        try {
            if (getMapTilesArray()[i - 1][j - 1].getTypeOfTile().contains("Room")) {
                foundBorders = "CornerSW";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            if (getMapTilesArray()[i + 1][j - 1].getTypeOfTile().contains("Room")) {
                foundBorders = "CornerSE";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            if (getMapTilesArray()[i + 1][j + 1].getTypeOfTile().contains("Room")) {
                foundBorders = "CornerNW";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            if (getMapTilesArray()[i - 1][j + 1].getTypeOfTile().contains("Room")) {
                foundBorders = "CornerNE";
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        return foundBorders;
    }

    private void markTheDoorTiles() {
        for (int i = 0; i < numberOfTilesX; i++) {
            for (int j = 0; j < numberOfTilesY; j++) {
                if (getMapTilesArray()[i][j].getTypeOfTile().contains("Corridor") &&
                        getMapTilesArray()[i - 1][j].getTypeOfTile().contains("Room")) {
                    getMapTilesArray()[i][j].setTypeOfTile("ClosedDoorHorizontal");
                } else if (getMapTilesArray()[i][j].getTypeOfTile().contains("Corridor") &&
                        getMapTilesArray()[i + 1][j].getTypeOfTile().contains("Room")) {
                    getMapTilesArray()[i][j].setTypeOfTile("ClosedDoorHorizontal");
                } else if (getMapTilesArray()[i][j].getTypeOfTile().contains("Corridor") &&
                        getMapTilesArray()[i][j - 1].getTypeOfTile().contains("Room")) {
                    getMapTilesArray()[i][j].setTypeOfTile("ClosedDoorVertical");
                } else if (getMapTilesArray()[i][j].getTypeOfTile().contains("Corridor") &&
                        getMapTilesArray()[i][j + 1].getTypeOfTile().contains("Room")) {
                    getMapTilesArray()[i][j].setTypeOfTile("ClosedDoorVertical");
                }
            }
        }
    }

    public MapTile[][] getMapTilesArray() {
        return mapTilesArray;
    }

}
