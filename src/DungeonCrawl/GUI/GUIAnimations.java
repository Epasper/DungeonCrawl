package DungeonCrawl.GUI;

import DungeonCrawl.Main;
import DungeonCrawl.Model.EncounterManager;
import DungeonCrawl.Model.MapManager;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.util.Duration;

import java.awt.*;

public class GUIAnimations {

    public void visualsOnHit(Button button, String hitResult, MapManager mapManager, EncounterManager encounterManager) {
        String damageString = hitResult.replace("Hit - ", "");
        creatureWasHitAnimation(button, mapManager, encounterManager);
        Popup damagePopup = new Popup();
        VBox damageBox = new VBox();
        Label damage = new Label();
        damage.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        damage.setText(damageString);
        damage.setTextFill(Color.RED);
        damageBox.getChildren().add(damage);
        Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
        damagePopup.getContent().add(damageBox);
        damagePopup.show(Main.getPrimaryStage(), mouseLocation.getX() - 20, mouseLocation.getY() - 20);
        FadeTransition fadeTransition
                = new FadeTransition(Duration.millis(750), damageBox);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setOnFinished(e -> damagePopup.hide());
        fadeTransition.play();
    }

    public void heroClickAnimation(Button button) {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(180), button.getGraphic());
        scaleTransition.setByX(-0.1f);
        scaleTransition.setByY(-0.1f);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);
        System.out.println("heroClickAnimation Triggered");
        scaleTransition.play();
    }

    public void creatureWasHitAnimation(Button button, MapManager mapManager, EncounterManager encounterManager) {
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(180), button.getGraphic());
        rotateTransition.setByAngle(30);
        rotateTransition.setCycleCount(2);
        rotateTransition.setAutoReverse(true);
        rotateTransition.setOnFinished(e -> mapManager.updateMapGraphics(encounterManager.getDungeonMap()));
        System.out.println("Creature hit, rotating.");
        rotateTransition.play();
    }

    public void creatureWasMissedAnimation(Button button, MapManager mapManager, EncounterManager encounterManager) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(180), button.getGraphic());
        translateTransition.setByX(10);
        translateTransition.setCycleCount(2);
        translateTransition.setAutoReverse(true);
        translateTransition.setOnFinished(e -> mapManager.updateMapGraphics(encounterManager.getDungeonMap()));
        System.out.println("Creature missed, translating. Coordinates: " + button.getId());
        translateTransition.play();
    }

/*    public void walkingAnimation(int startingXPosition, int startingYPosition, int endXPosition, int endYPosition) {
        Button button = buttonGrid[startingXPosition][startingYPosition];
        button.toFront();
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(300), button.getGraphic());
        System.out.println("Walking Animation Triggered. " + (endXPosition - startingXPosition) + "   " + (endYPosition - startingYPosition));
        int yMovement = (endXPosition - startingXPosition) * 50;
        int xMovement = (endYPosition - startingYPosition) * 50;
        translateTransition.setByX(xMovement);
        translateTransition.setByY(yMovement);
        System.out.println("Animation transition values: " + xMovement + " " + yMovement);
        System.out.println("Animation graphic: " + button.getGraphic());
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(false);
        translateTransition.setOnFinished(e -> updateMapGraphics(encounterManager.getDungeonMap()));
        translateTransition.play();
    }*/
}
