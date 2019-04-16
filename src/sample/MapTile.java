package sample;

import java.util.Random;

class MapTile {

    String[][] tileSketch = new String[5][5];
    String typeOfTile;

    void rollForTypeOfTile(boolean skipToRoom, boolean skipToNonRoom, boolean skipTheCorridor) {
        Random random = new Random();
        int seed = random.nextInt(100);

        if (!skipTheCorridor) {
            if (seed < 60) {
                typeOfTile = "Blank";
            } else {
                typeOfTile = "RoomSeed";
            }
            if (skipToRoom) {
                typeOfTile = "Room";
            }
            if (skipToNonRoom) {
                typeOfTile = "Blank";
            }
        }
    }


    void fillTheTile(int tileSize, boolean upperBorder, boolean lowerBorder, boolean leftBorder, boolean rightBorder) {
        for (int i = 0; i < tileSize; i++) {
            for (int j = 0; j < tileSize; j++) {
                if (upperBorder && i == 0) {
                    tileSketch[i][j] = "V";
                } else if (leftBorder && j == 0) {
                    tileSketch[i][j] = ">";
                } else if (rightBorder && i == tileSize - 1) {
                    tileSketch[i][j] = "^";
                } else if (lowerBorder && j == tileSize - 1) {
                    tileSketch[i][j] = "<";
                } else {
                    fillTheInnerSideOfTile(i, j);


                }
            }
        }
    }

    void fillTheInnerSideOfTile(int i, int j) {
        switch (typeOfTile) {
            case "RoomSeed":
            case "Room":
                tileSketch[i][j] = "*";
                break;
            case "Corridor":
                tileSketch[i][j] = "C";
                break;
            case "CorridorVertical":
                tileSketch[i][j] = "V";
                break;
            case "CorridorHorizontal":
                tileSketch[i][j] = "H";
                break;
            case "Blank":
                tileSketch[i][j] = "#";
                break;
        }
    }
}
