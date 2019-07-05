package DungeonCrawl.GUI;

import DungeonCrawl.Model.Hero;
import DungeonCrawl.Model.Monster;

import java.util.List;

public class GUIUtilities {

    public Hero getHeroByID(int ID, List<Hero> listOfHeroes) {
        Hero returnedHero = new Hero();
        returnedHero.updateTheDefensesMap();
        for (Hero aHero : listOfHeroes) {
            if (aHero.getID() == ID) {
                return aHero;
            }
        }
        return returnedHero;
    }

    public Monster getMonsterTypeByID(int ID, List<Monster> listOfMonsters) {
        Monster returnedMonster = new Monster();
        for (Monster aMonster : listOfMonsters) {
            if (aMonster.getID() == ID) {
                return aMonster;
            }
        }
        return returnedMonster;
    }

    public Monster getSingleMonsterByUniqueID(int uniqueID, List<Monster> listOfMonsters) {
        Monster returnedMonster = new Monster();
        for (Monster aMonster : listOfMonsters) {
            if (aMonster.getCurrentMonsterUniqueID() == uniqueID) {
                return aMonster;
            }
        }
        return returnedMonster;
    }
}
