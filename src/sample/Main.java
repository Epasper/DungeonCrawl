package sample;

import javafx.application.Application;;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        MainMenuGUI mainMenuGUI = new MainMenuGUI();
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        Scene mapScene = mainMenuGUI.freshScene;
        primaryStage.setTitle("Dungeon");
        primaryStage.setScene(mapScene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
