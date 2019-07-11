package DungeonCrawl.GUI;

import DungeonCrawl.Model.Creature;
import DungeonCrawl.Model.Hero;
import DungeonCrawl.Model.Monster;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.Screen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DungeonConsoleGUI {
    private ScrollPane dungeonConsole = new ScrollPane();
    private GridPane outerDungeonConsole = new GridPane();
    private GridPane completeConsole = new GridPane();
    private Text dungeonConsoleText = new Text();
    private ScrollPane initiativeTracker = new ScrollPane();
    private List<Button> listOfButtons = new ArrayList<>();
    private TilePane initiativeTilePane = new TilePane();
    private Creature[] initiativeArray = new Creature[50];

    public Creature[] getInitiativeArray() {
        return initiativeArray;
    }

    public void setInitiativeArray(Creature[] initiativeArray) {
        this.initiativeArray = initiativeArray;
    }

    public TilePane getInitiativeTilePane() {
        return initiativeTilePane;
    }

    public void setInitiativeTilePane(TilePane initiativeTilePane) {
        this.initiativeTilePane = initiativeTilePane;
    }

    public ScrollPane getInitiativeTracker() {
        return initiativeTracker;
    }

    public void setInitiativeTracker(ScrollPane initiativeTracker) {
        this.initiativeTracker = initiativeTracker;
    }

    public DungeonConsoleGUI() {
        initializeTheConsole();
    }


    private void initializeTheConsole() {
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        dungeonConsole.setPrefWidth(primaryScreenBounds.getWidth());
        Button changeConsoleSizeButton = new Button();
        changeConsoleSizeButton.setOnAction(event -> changeTheConsoleSize(changeConsoleSizeButton));
        changeConsoleSizeButton.setGraphic(new ImageView(new Image("DungeonCrawl/GUI/Images/consoleSize.png")));
        changeConsoleSizeButton.setMaxSize(30,60);
        dungeonConsole.setMinHeight(60);
        dungeonConsole.setMaxHeight(60);
        dungeonConsole.setFitToWidth(false);
        initiativeTracker.setMaxHeight(70);
        initiativeTracker.setMinHeight(70);
        outerDungeonConsole.add(dungeonConsole, 0,0);
        outerDungeonConsole.add(changeConsoleSizeButton, 1, 0);
        completeConsole.add(outerDungeonConsole, 0, 0);
        completeConsole.add(initiativeTracker, 0, 1);
        completeConsole.setMinHeight(120);
        completeConsole.setMinHeight(120);
    }

    private void changeTheConsoleSize(Button changeConsoleSizeButton) {
        if (dungeonConsole.getMinHeight() < 65) {
            dungeonConsole.setMinHeight(120);
            changeConsoleSizeButton.setGraphic(new ImageView(new Image("DungeonCrawl/GUI/Images/consoleSizeDown.png")));
            changeConsoleSizeButton.setMaxSize(30,120);
        } else {
            dungeonConsole.setMinHeight(60);
            changeConsoleSizeButton.setGraphic(new ImageView(new Image("DungeonCrawl/GUI/Images/consoleSize.png")));
            changeConsoleSizeButton.setMaxSize(30,60);
        }
    }

    public void clearInitiativeTracker() {
        initiativeTilePane.getChildren().clear();
        System.out.println("CLEARING THE WHOLE INITIATIVE TRACKER");
        Arrays.fill(initiativeArray, null);
        listOfButtons.clear();
    }

    public void fillTheInitiativeTracker(List<Hero> listOfHeroes, List<Monster> listOfMonsters, boolean shouldIRollForNewInitiative) {
        TilePane initiativeTilePane = new TilePane();
        initiativeTilePane.setPrefColumns(20);
        System.out.println("ROLLING INITIATIVE: ");
        if (shouldIRollForNewInitiative) {
            for (Hero hero : listOfHeroes) {
                rollForSingleInitiative(hero);
            }
            for (Monster monster : listOfMonsters) {
                rollForSingleInitiative(monster);
            }
        }
        for (int i = 0; i < initiativeArray.length; i++) {
            sortTheCreaturesAccordingToInitiative(i);
        }
        initiativeTilePane.getChildren().addAll(listOfButtons);
        initiativeTracker.setContent(initiativeTilePane);
        System.out.println(listOfButtons);
        this.initiativeTilePane = initiativeTilePane;
    }

    private void sortTheCreaturesAccordingToInitiative(int i) {
        System.out.println("Iterating through array: ");
        if (initiativeArray[i] != null) {
            Creature creature = initiativeArray[i];
            System.out.println("Found a creature in the array: " + creature.getMonsterName());
            Button initiativeButton = new Button();
            System.out.println(initiativeButton);
            initiativeButton.setGraphic(new ImageView(creature.getCreatureImage()));
            System.out.println(initiativeButton + initiativeButton.getGraphic().toString());
            listOfButtons.add(initiativeButton);
        }
    }

    private void rollForSingleInitiative(Creature currentCreature) {
        Random random = new Random();
        int roll = (random.nextInt(19)) + 1;
        int currentInitiative = roll + currentCreature.getInitiativeBonus();
        System.out.println("Current Initiative for " + currentCreature.getMonsterName() + ": " + currentInitiative);
        currentCreature.setCurrentInitiative(currentInitiative);
        System.out.println("Setting current initiative of " + currentCreature.getHeroName() + " to " + currentInitiative);
        if (initiativeArray[currentInitiative] == null) {
            initiativeArray[currentInitiative] = currentCreature;
            System.out.println("FILLING ARRAY FIELD: " + currentInitiative);
        } else {
            rollForSingleInitiative(currentCreature);
        }
    }

    public void updateTheDungeonConsole(String messageToUpdate) {
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
