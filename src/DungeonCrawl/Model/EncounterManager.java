package DungeonCrawl.Model;

import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class EncounterManager {

    private boolean fightAlreadyTakingPlace;
    private HeroManager heroManager;
    private Button[][] buttonGrid;
    private PathFinder pathFinder;


    public EncounterManager(HeroManager heroManager, Button[][] buttonGrid, PathFinder pathFinder) {
        this.heroManager = heroManager;
        this.buttonGrid = buttonGrid;
        this.pathFinder = pathFinder;
    }

    public boolean isFightAlreadyTakingPlace() {
        return fightAlreadyTakingPlace;
    }

    public void setFightAlreadyTakingPlace(boolean fightAlreadyTakingPlace) {
        this.fightAlreadyTakingPlace = fightAlreadyTakingPlace;
    }

    public void checkIfAllCreaturesInRoomAreDead() {
        for (Monster monster : pathFinder.getDiscoveredMonsters()) {
            if (!monster.isThisCreatureDead()) {
                System.out.println("Found a creature that's alive");
                fightAlreadyTakingPlace = true;
                return;
            }
        }
        System.out.println("All monsters are dead!");
        enableAllHeroButtons();
        List<Monster> emptyListOfMonsters = new ArrayList<>();
        pathFinder.setDiscoveredMonsters(emptyListOfMonsters);
        pathFinder.dungeonConsoleGUI.clearInitiativeTracker();
        fightAlreadyTakingPlace = false;
        pathFinder.setAlarmedMonsterVisible(false);
    }

    private void enableAllHeroButtons() {
        for (Hero hero : heroManager.getHeroList()) {
            buttonGrid[hero.getMapXPos()][hero.getMapYPos()].setDisable(false);
        }
    }
}
