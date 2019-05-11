package sample.Model;

import javafx.scene.image.Image;
import sample.Model.Hero;
import sample.Model.Monster;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FakeDatabase {
    private Monster monster1 = new Monster();
    private Monster monster2 = new Monster();
    private Monster monster3 = new Monster();
    private Monster monster4 = new Monster();
    private Monster monster5 = new Monster();
    private Monster monster6 = new Monster();
    private Image monster1img = new Image(getClass().getResourceAsStream("Images\\monster1.png"));
    private Image monster2img = new Image(getClass().getResourceAsStream("Images\\monster2.png"));
    private Image monster3img = new Image(getClass().getResourceAsStream("Images\\monster3.png"));
    private Image monster4img = new Image(getClass().getResourceAsStream("Images\\monster4.png"));
    private Image monster5img = new Image(getClass().getResourceAsStream("Images\\monster5.png"));
    private Image monster6img = new Image(getClass().getResourceAsStream("Images\\monster6.png"));
    public List<Monster> listOfMonsters = new ArrayList<>();

    public FakeDatabase() {
    }

//    public void populateDatabaseWithHeroes() {
//        hero1.heroName = "Hadrim";
//        hero2.heroName = "Gvydor";
//        hero3.heroName = "Tyr";
//        hero4.heroName = "Ravenlyss";
//        hero5.heroName = "Lavinia";
//        hero6.heroName = "Bianka";
//        hero1.heroClass = "Paladin";
//        hero2.heroClass = "Cleric";
//        hero3.heroClass = "Warrior";
//        hero4.heroClass = "Rogue";
//        hero5.heroClass = "Wizard";
//        hero6.heroClass = "Barbarian";
//        hero1.ID = 1;
//        hero2.ID = 2;
//        hero3.ID = 3;
//        hero4.ID = 4;
//        hero5.ID = 5;
//        hero6.ID = 6;
//        listOfHeroes.add(hero1);
//        listOfHeroes.add(hero2);
//        listOfHeroes.add(hero3);
//        listOfHeroes.add(hero4);
//        listOfHeroes.add(hero5);
//        listOfHeroes.add(hero6);
//    }


    public void populateDatabaseWithMonsters() {
        monster1.monsterType = "Lizardman";
        monster2.monsterType = "Orc";
        monster3.monsterType = "Ratfolk";
        monster4.monsterType = "Rat";
        monster5.monsterType = "Zombie";
        monster6.monsterType = "Rat Monk";
        monster1.ID = 101;
        monster2.ID = 102;
        monster3.ID = 103;
        monster4.ID = 104;
        monster5.ID = 105;
        monster6.ID = 106;
        monster1.monsterImage = monster1img;
        monster2.monsterImage = monster2img;
        monster3.monsterImage = monster3img;
        monster4.monsterImage = monster4img;
        monster5.monsterImage = monster5img;
        monster6.monsterImage = monster6img;
        listOfMonsters.add(monster1);
        listOfMonsters.add(monster2);
        listOfMonsters.add(monster3);
        listOfMonsters.add(monster4);
        listOfMonsters.add(monster5);
        listOfMonsters.add(monster6);
    }
}
