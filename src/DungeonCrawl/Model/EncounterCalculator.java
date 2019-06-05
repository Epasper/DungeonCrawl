package DungeonCrawl.Model;

import DungeonCrawl.Monsters.GoblinSharpshooter;
import DungeonCrawl.Monsters.GoblinSkullcleaver;
import DungeonCrawl.Monsters.GoblinWarrior;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EncounterCalculator {

    private List<Monster> listOfChosenMonsters = new ArrayList<>();

    public List<Monster> getListOfChosenMonsters() {
        return listOfChosenMonsters;
    }

    public void setListOfChosenMonsters(List<Monster> listOfChosenMonsters) {
        this.listOfChosenMonsters = listOfChosenMonsters;
    }

    public EncounterCalculator() {
    }

    public List<Monster> getTheListOfMonsters(List<Hero> heroList, String difficulty, int currentMonsterUniqueID) {
        System.out.println("CALCULATING ENCOUNTER for " + heroList.size() + " characters.");
        int encounterLevel = calculateMediumPartyLevel(heroList);
        if (difficulty.contains("Hard")) {
            encounterLevel += 3;
            System.out.println("Hard Encounter. Level adjusted to " + encounterLevel);
        }
        if (difficulty.contains("Medium")) {
            encounterLevel += 2;
            System.out.println("Medium Encounter. Level adjusted to " + encounterLevel);
        }
        if (difficulty.contains("Easy")) {
            encounterLevel += 1;
            System.out.println("Easy Encounter. Level adjusted to " + encounterLevel);
        }
        int inputXP = calculateTheInputXP(encounterLevel, heroList.size());
        //todo add switch that cases depending on character input level
        System.out.println("Total encounter XP for this room: " + inputXP + "(Adjusted Party Level: " +
                encounterLevel +
                ", number of heroes: " +
                heroList.size() +
                ")");
        while (inputXP > 0) {
            List<Monster> listOfPossibleMonsters = getTheListOfPossibleMonsters();
            currentMonsterUniqueID++;
            Random random = new Random();
            int i = random.nextInt(listOfPossibleMonsters.size());
            Monster currentMonster = listOfPossibleMonsters.get(i);
            currentMonster.setCurrentMonsterUniqueID(currentMonsterUniqueID);
            listOfChosenMonsters.add(currentMonster);
            inputXP -= listOfPossibleMonsters.get(i).getXpValue();
            System.out.println("Added a monster: " + listOfChosenMonsters.get(listOfChosenMonsters.size() - 1).getMonsterName());
            System.out.println("Monster Fields: " +
                    listOfChosenMonsters.get(listOfChosenMonsters.size() - 1).getReflex() +
                    listOfChosenMonsters.get(listOfChosenMonsters.size() - 1).getFortitude() +
                    listOfChosenMonsters.get(listOfChosenMonsters.size() - 1).getWill());
            System.out.println("Input Xp after putting a monster: " + inputXP);
            System.out.println("Monster UUID: " + listOfChosenMonsters.get(listOfChosenMonsters.size() - 1).getCurrentMonsterUniqueID());
        }
        return listOfChosenMonsters;
    }

    public List<Monster> getTheListOfPossibleMonsters() {
        List<Monster> listOfPossibleMonsters = new ArrayList<>();
        listOfPossibleMonsters.add(new GoblinWarrior());
        listOfPossibleMonsters.add(new GoblinSharpshooter());
        listOfPossibleMonsters.add(new GoblinSkullcleaver());
        return listOfPossibleMonsters;
    }


    private int calculateTheInputXP(int mediumPartyLevel, int numberOfHeroes) {
        int encounterXp = 0;
        if (mediumPartyLevel < 6) {
            encounterXp = mediumPartyLevel * 25 * numberOfHeroes;
        }
        return encounterXp;
    }

    private int calculateMediumPartyLevel(List<Hero> heroList) {
        int mediumPartyLevel = 0;
        for (Hero currentHero : heroList) {
            mediumPartyLevel = +currentHero.getHeroLevel();
        }
        System.out.println("Medium Party level calculations: " + mediumPartyLevel);
        return mediumPartyLevel;
    }
}
