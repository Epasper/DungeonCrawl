package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class GUI {

    int mapWidth = 50;
    int mapHeight = 50;
    Button[][] buttonGrid = new Button[mapWidth][mapHeight];
    GridPane mapGridPane = new GridPane();

    public void startAGUI() throws IOException {
        mapGridPane = FXMLLoader.load(getClass().getResource("sample.fxml"));
        MapGenerator mapGenerator = new MapGenerator();
        mapGenerator.drawAMap();
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {
                Button aButton = new Button();
                buttonGrid[i][j] = aButton;
                mapGridPane.add(aButton, j, i);
            }
        }
    }

}
