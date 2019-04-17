package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class GUI {

    private int mapWidth = 50;
    private int mapHeight = 50;
    private Button[][] buttonGrid = new Button[mapWidth][mapHeight];
    GridPane mapGridPane = new GridPane();

    public void DungeonCrawlGui() throws IOException {
        mapGridPane = FXMLLoader.load(getClass().getResource("sample.fxml"));
        MapGenerator mapGenerator = new MapGenerator();
        mapGenerator.drawAMap();
        copyTilesFromGeneratorToButtons(mapGenerator);
    }

    private void copyTilesFromGeneratorToButtons(MapGenerator mapGenerator) {
        String typeOfTile;
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {
                Button aButton = new Button();
                typeOfTile = mapGenerator.mapTilesArray[i][j].typeOfTile;
                switch (typeOfTile) {
                    case "RoomSeed":
                    case "Room":
                        aButton.setStyle("-fx-border-color: #000000");
                        break;
                    case "Corridor":
                        aButton.setStyle("-fx-border-color: #000000");
                        break;
                    case "CorridorVertical":
                        aButton.setStyle("-fx-border-color: #000000");
                        break;
                    case "CorridorHorizontal":
                        aButton.setStyle("-fx-border-color: #000000");
                        break;
                    case "Blank":
                        aButton.setStyle("-fx-border-color: #FFFFFF");
                        break;
                }
                buttonGrid[i][j] = aButton;
                mapGridPane.add(aButton, j, i);
            }
        }
    }

}
