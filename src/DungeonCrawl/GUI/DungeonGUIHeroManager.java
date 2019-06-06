package DungeonCrawl.GUI;

import DungeonCrawl.Model.Hero;

import java.util.List;

public class DungeonGUIHeroManager {
    private List<Hero> heroList;
    private int numberOfHeroesThatFinishedMovement;
    private int currentlyActiveHeroID;

    public int getCurrentlyActiveHeroID() {
        return currentlyActiveHeroID;
    }

    public void setCurrentlyActiveHeroID(int currentlyActiveHeroID) {
        this.currentlyActiveHeroID = currentlyActiveHeroID;
    }

    public int getNumberOfHeroesThatFinishedMovement() {
        return numberOfHeroesThatFinishedMovement;
    }

    public void setNumberOfHeroesThatFinishedMovement(int numberOfHeroesThatFinishedMovement) {
        this.numberOfHeroesThatFinishedMovement = numberOfHeroesThatFinishedMovement;
    }

    public List<Hero> getHeroList() {
        return heroList;
    }

    public void setHeroList(List<Hero> heroList) {
        this.heroList = heroList;
    }
}
