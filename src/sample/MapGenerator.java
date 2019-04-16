package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

class MapGenerator {
    private int corridorMaxLength = 6;
    private int numberOfTilesY = 50;
    private int numberOfTilesX = 50;
    private int TileSize = 3;
    private int mapSizeX = numberOfTilesX * TileSize;
    private int mapSizeY = numberOfTilesY * TileSize;
    private String[][] mapSketch = new String[mapSizeX][mapSizeY];
    private MapTile[][] mapTilesArray = new MapTile[numberOfTilesX][numberOfTilesY];
    private boolean upperBorder, lowerBorder, leftBorder, rightBorder;
    private BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\A753403\\Desktop\\DEBUG.txt"));
    private boolean isThisTheFirstSpawningRoom = true;

    MapGenerator() throws IOException {
    }

    private void DEBUG(String typeOfTile) throws IOException {
        switch (typeOfTile) {
            case "RoomSeed":
            case "Room":
                writer.write("*");
                break;
            case "Corridor":
                writer.write("C");
                break;
            case "CorridorVertical":
                writer.write("V");
                break;
            case "CorridorHorizontal":
                writer.write("H");
                break;
            case "Blank":
                writer.write("#");
                break;
        }
    }

    private void fillTheMapWithRooms() {
        for (int i = 0; i < numberOfTilesX; i++) {
            for (int j = 0; j < numberOfTilesY; j++) {
                MapTile mapTile = new MapTile();
                mapTilesArray[i][j] = mapTile;
            }
        }
    }

    private boolean checkAroundForExistingRooms(int posX, int posY) {
        boolean foundRoom = false;
        try {
            foundRoom = (mapTilesArray[posX - 1][posY].typeOfTile.equals("Room"));
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            foundRoom = (mapTilesArray[posX][posY - 1].typeOfTile.equals("Room"));
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            foundRoom = mapTilesArray[posX - 1][posY - 1].typeOfTile.equals("Room");
        } catch (IndexOutOfBoundsException ignored) {
        }
        return foundRoom;
    }

    private void seedAMap() throws IOException {
        fillTheMapWithRooms();
        for (int i = 0; i < numberOfTilesX; i++) {
            for (int j = 0; j < numberOfTilesY; j++) {
                seedASingleTile(i, j);
            }

        }
    }

    private void seedASingleTile(int i, int j) throws IOException {
        checkBoundaries(i, j);
        boolean checkThisTileForRooms = false;
        boolean checkAroundForRooms = false;
        boolean checkThisTileForCorridors = false;
        try {
            checkThisTileForCorridors = mapTilesArray[i][j].typeOfTile.contains("Corridor");
        } catch (NullPointerException ignored) {
        }
        try {
            checkThisTileForRooms = (mapTilesArray[i][j].typeOfTile.equals("Room") || mapTilesArray[i][j].typeOfTile.equals("RoomSeed"));
        } catch (NullPointerException ignored) {
        }
        if (!checkThisTileForRooms) {
            checkAroundForRooms = checkAroundForExistingRooms(i, j);
        }
        mapTilesArray[i][j].rollForTypeOfTile(checkThisTileForRooms, checkAroundForRooms, checkThisTileForCorridors);
        if (mapTilesArray[i][j].typeOfTile.equals("RoomSeed")) {
            seedARoom(i, j);
        }
        mapTilesArray[i][j].fillTheTile(TileSize, upperBorder, lowerBorder, leftBorder, rightBorder);
        copyToMapSketch(i, j);
        addADebuggerFrame();
        writer.newLine();
    }

    private void copyToMapSketch(int i, int j) {
        for (int k = 0; k < TileSize; k++) {
            System.arraycopy(mapTilesArray[i][j].tileSketch[k], 0, mapSketch[i * TileSize + k], j * TileSize, TileSize);
        }
    }

    private void addADebuggerFrame() throws IOException {
        for (int k = 0; k < numberOfTilesX; k++) {
            for (int l = 0; l < numberOfTilesY; l++) {
                try {
                    DEBUG(mapTilesArray[k][l].typeOfTile);
                } catch (NullPointerException ignored) {
                    writer.write("@");
                }
            }
            writer.newLine();

        }
        writer.newLine();
        writer.newLine();
    }

    private void seedARoom(int initialXPos, int initialYPos) {
        Random randomH = new Random();
        Random randomW = new Random();
        Room room = new Room();
        room.roomYPos = initialYPos;
        room.roomXPos = initialXPos;
        int minRoomHeight = 8;
        int maxRoomHeight = 10;
        room.roomHeight = randomH.nextInt(maxRoomHeight - minRoomHeight);
        int minRoomWidth = 8;
        int maxRoomWidth = 10;
        room.roomWidth = randomW.nextInt(maxRoomWidth - minRoomWidth);
        room.roomHeight += minRoomHeight;
        room.roomWidth += minRoomWidth;
        if (checkIfTheRoomCanBeSeeded(room)) {
            for (int i = 0; i < room.roomWidth; i++) {
                for (int j = 0; j < room.roomHeight; j++) {
                    try {
                        mapTilesArray[initialXPos + i][initialYPos + j].typeOfTile = "Room";
                    } catch (IndexOutOfBoundsException ignored) {

                    }
                }
            }
            seedCorridors(room);
        } else {
            mapTilesArray[initialXPos][initialYPos].typeOfTile = "Blank";
        }
    }

    private boolean searchForCrossingCorridors(int XPos, int YPos, String typeOfCorridor) {
        boolean crossingCorridorFound = false;
        if (typeOfCorridor.contains("Vertical")) {
            try {
                for (int i = 0; i < corridorMaxLength + 1; i++) {
                    if (mapTilesArray[XPos + i][YPos].typeOfTile.contains("Corridor")) {
                        crossingCorridorFound = true;
                        break;
                    }
                }
            } catch (IndexOutOfBoundsException | NullPointerException ignored) {
            }
        } else if (typeOfCorridor.contains("Horizontal")) {
            try {
                for (int i = 0; i < corridorMaxLength + 1; i++) {
                    if (mapTilesArray[XPos][YPos + i].typeOfTile.contains("Corridor")) {
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
                    if (!mapTilesArray[room.roomXPos + room.roomWidth + i][room.roomYPos + VSpawn].typeOfTile.contains("Room")) {
                        mapTilesArray[room.roomXPos + room.roomWidth + i][room.roomYPos + VSpawn].typeOfTile = "CorridorVertical";
                    }
                } catch (IndexOutOfBoundsException ignored) {

                } catch (NullPointerException e) {
                    mapTilesArray[room.roomXPos + room.roomWidth + i][room.roomYPos + VSpawn].typeOfTile = "CorridorVertical";
                }
            }
        }
        if (!searchForCrossingCorridors(room.roomXPos + HSpawn, room.roomYPos + room.roomHeight, "CorridorHorizontal")) {
            for (int i = 0; i < corridorMaxLength; i++) {
                try {
                    if (!mapTilesArray[room.roomXPos + HSpawn][room.roomYPos + room.roomHeight + i].typeOfTile.contains("Room")) {
                        mapTilesArray[room.roomXPos + HSpawn][room.roomYPos + room.roomHeight + i].typeOfTile = "CorridorHorizontal";
                    }
                } catch (IndexOutOfBoundsException ignored) {

                } catch (NullPointerException e) {
                    mapTilesArray[room.roomXPos + HSpawn][room.roomYPos + room.roomHeight + i].typeOfTile = "CorridorHorizontal";
                }
            }
        }
    }

    private boolean checkIfTheRoomHasEntrance(Room room) {
        boolean roomEntranceFound = false;
        for (int i = 0; i < room.roomWidth; i++) {
            for (int j = 0; j < room.roomHeight; j++) {
                try {
                    if (mapTilesArray[room.roomXPos + i][room.roomYPos + j].typeOfTile.contains("Corridor")) {
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
                            if (mapTilesArray[room.roomXPos + i][room.roomYPos + j].typeOfTile.contains("Room")) {
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
            isThisTheFirstSpawningRoom = false;
        }
        return seedingAllowed;
    }


    void drawAMap() throws IOException {
        upperBorder = true;
        leftBorder = true;
        seedAMap();
        sysOutTheMap();
        trimAllInvalidCorridors();
        sysOutTheMap();
        writer.close();
    }

    private void sysOutTheMap() {
        for (int i = 0; i < mapSizeX; i++) {
            for (int j = 0; j < mapSizeY; j++) {
                System.out.print(mapSketch[i][j]);
                if (j == mapSizeY - 1) {
                    System.out.println();
                }
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private boolean checkIfTheCorridorTileIsInvalid(String typeOfCorridor, int XPos, int YPos) {
        boolean corridorIsInvalid = false;
        if (typeOfCorridor.contains("Vertical")) {
            for (int i = 0; i < corridorMaxLength + 1; i++) {
                try {
                    if (mapTilesArray[XPos + i][YPos].typeOfTile.contains("Room")) {
                        corridorIsInvalid = false;
                        break;
                    } else if ((mapTilesArray[XPos + i][YPos].typeOfTile.contains("Blank"))) {
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
                    if (mapTilesArray[XPos][YPos + i].typeOfTile.contains("Room")) {
                        corridorIsInvalid = false;
                        break;
                    } else if ((mapTilesArray[XPos][YPos + i].typeOfTile.contains("Blank"))) {
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

    private void trimAllInvalidCorridors() throws IOException {
        boolean trimThisTile;
        for (int i = 0; i < numberOfTilesX; i++) {
            for (int j = 0; j < numberOfTilesY; j++) {
                if (mapTilesArray[i][j].typeOfTile.contains("Corridor")) {
                    trimThisTile = checkIfTheCorridorTileIsInvalid(mapTilesArray[i][j].typeOfTile, i, j);
                    if (trimThisTile) {
                        mapTilesArray[i][j].typeOfTile = "Blank";
                        mapTilesArray[i][j].fillTheTile(TileSize, false, false, false, false);
                        copyToMapSketch(i, j);
                        addADebuggerFrame();
                    }
                }
            }
        }
    }


    private void checkBoundaries(int i, int j) {
        upperBorder = i == 0;
        leftBorder = j == 0;
        rightBorder = i == numberOfTilesX - 1;
        lowerBorder = j == numberOfTilesY - 1;
    }
}
