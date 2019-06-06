package DungeonCrawl.GUI;

import javafx.geometry.Rectangle2D;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class DungeonConsoleGUI {
    private ScrollPane dungeonConsole = new ScrollPane();
    private GridPane completeConsole = new GridPane();
    private Text dungeonConsoleText = new Text();

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
