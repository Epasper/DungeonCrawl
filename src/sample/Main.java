package sample;

import javafx.application.Application;;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GUI gui = new GUI();
        gui.DungeonCrawlGui();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(gui.mapGridPane, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException {

        launch(args);
    }
}
