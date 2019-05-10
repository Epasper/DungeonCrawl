package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.DAO.PutBLOBIntoDB;
import sample.GUI.MainMenuGUI;

public class Main extends Application {

    private static Stage pStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //debug SQL connection
        setPrimaryStage(primaryStage);
        MainMenuGUI mainMenuGUI = new MainMenuGUI();
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        Scene primaryScene = mainMenuGUI.aScene;
        primaryStage.setTitle("Dungeon");
        primaryStage.setScene(primaryScene);
        //debug use only to put blobs into database. Delete before production
        //PutBLOBIntoDB.putFiles();
    }

    public static Stage getPrimaryStage() {
        return pStage;
    }

    private void setPrimaryStage(Stage pStage) {
        Main.pStage = pStage;
    }

    public static void main(String[] args) {

        launch(args);
    }
}
