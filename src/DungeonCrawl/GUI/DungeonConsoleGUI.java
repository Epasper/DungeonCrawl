package DungeonCrawl.GUI;

import DungeonCrawl.Model.Hero;
import DungeonCrawl.Model.Monster;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DungeonConsoleGUI {
    private ScrollPane dungeonConsole = new ScrollPane();
    private GridPane completeConsole = new GridPane();
    private Text dungeonConsoleText = new Text();
    private HBox initiativeTracker = new HBox();

    public DungeonConsoleGUI() {
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        dungeonConsole.setPrefWidth(primaryScreenBounds.getWidth());
        dungeonConsole.setMinHeight(60);
        dungeonConsole.setMaxHeight(60);
        dungeonConsole.setFitToWidth(false);
        completeConsole.add(dungeonConsole, 0, 0);
        completeConsole.setMinHeight(120);
        completeConsole.setMinHeight(120);
    }

    public void fillTheInitiativeTracker(List<Hero> listOfHeroes, List<Monster> listOfMonsters) {
        for (Hero hero : listOfHeroes) {
            Random random = new Random();
            int roll = (random.nextInt(19)) + 1;
            hero.setCurrentInitiative(roll + hero.getInitiativeBonus());
        }
        for (Monster monster : listOfMonsters) {
            Random random = new Random();
            int roll = (random.nextInt(19)) + 1;
            monster.setCurrentInitiative(roll + monster.getInitiativeBonus());
        }
    }

    void updateTheDungeonConsole(String messageToUpdate) {
        dungeonConsoleText.setText(dungeonConsoleText.getText() + "\n" + messageToUpdate);
        dungeonConsole.setVvalue(1.0);
    }

    public ScrollPane getDungeonConsole() {
        return dungeonConsole;
    }

    public void setDungeonConsole(ScrollPane dungeonConsole) {
        this.dungeonConsole = dungeonConsole;
    }

    public GridPane getCompleteConsole() {
        return completeConsole;
    }

    public void setCompleteConsole(GridPane completeConsole) {
        this.completeConsole = completeConsole;
    }

    public void setDungeonConsoleText(Text dungeonConsoleText) {
        this.dungeonConsoleText = dungeonConsoleText;
    }

    public Text getDungeonConsoleText() {
        return dungeonConsoleText;
    }
}
