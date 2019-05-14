package sample.Model;

import sample.Monsters.GoblinWarrior;

import java.util.ArrayList;
import java.util.List;

public class EncounterCalculator {

    private int inputXP;
    private int encounterLevel;
    private String difficulty;
    List<Monster> listOfPossibleMonsters = new ArrayList<>();

    public EncounterCalculator(int encounterLevel, int inputXP, String difficulty) {
        this.inputXP = inputXP;
        this.encounterLevel = encounterLevel;
        this.difficulty = difficulty;
        //todo add switch that cases depending on character input level
        listOfPossibleMonsters.add(new GoblinWarrior());

    }
}
