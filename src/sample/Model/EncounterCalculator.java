package sample.Model;

import sample.Monsters.GoblinSharpshooter;
import sample.Monsters.GoblinSkullcleaver;
import sample.Monsters.GoblinWarrior;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EncounterCalculator {

    private int inputXP;
    private int encounterLevel;
    private List<Monster> listOfPossibleMonsters = new ArrayList<>();
    private List<Monster> listOfChosenMonsters = new ArrayList<>();

    public EncounterCalculator(List<Hero> heroList, String difficulty) {
        getTheListOfMonsters(heroList, difficulty);
    }

    private List<Monster> getTheListOfMonsters(List<Hero> heroList, String difficulty) {
        int encounterLevel = calculateMediumPartyLevel(heroList);
        if (difficulty.equals("Hard")) encounterLevel = +3;
        if (difficulty.equals("Medium")) encounterLevel = +2;
        if (difficulty.equals("Easy")) encounterLevel = +1;
        int inputXP = calculateTheInputXP(encounterLevel, heroList.size());
        //todo add switch that cases depending on character input level
        listOfPossibleMonsters.add(new GoblinWarrior());
        listOfPossibleMonsters.add(new GoblinSharpshooter());
        listOfPossibleMonsters.add(new GoblinSkullcleaver());
        while (inputXP < 0) {
            Random random = new Random();
            int i = random.nextInt(listOfPossibleMonsters.size());
            listOfChosenMonsters.add(listOfPossibleMonsters.get(i));
            inputXP = -listOfPossibleMonsters.get(i).getXpValue();
        }
        return listOfChosenMonsters;
    }

    private int calculateTheInputXP(int mediumPartyLevel, int numberOfHeroes) {
        int encounterXp = 0;
        if (mediumPartyLevel < 6) {
            mediumPartyLevel = mediumPartyLevel / numberOfHeroes;
            encounterXp = mediumPartyLevel * 25 * numberOfHeroes;
        }
        return encounterXp;
    }

    private int calculateMediumPartyLevel(List<Hero> heroList) {
        int mediumPartyLevel = 0;
        for (Hero currentHero : heroList) {
            mediumPartyLevel = +currentHero.getHeroLevel();
        }
        return mediumPartyLevel;
    }
}
