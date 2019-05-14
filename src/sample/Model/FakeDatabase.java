package sample.Model;

import javafx.scene.image.Image;

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
        monster1.setMonsterType("Lizardman");
        monster2.setMonsterType("Orc");
        monster3.setMonsterType("Ratfolk");
        monster4.setMonsterType("Rat");
        monster5.setMonsterType("Zombie");
        monster6.setMonsterType("Rat Monk");
        monster1.setID(101);
        monster2.setID(102);
        monster3.setID(103);
        monster4.setID(104);
        monster5.setID(105);
        monster6.setID(106);
        monster1.setMonsterImage(monster1img);
        monster2.setMonsterImage(monster2img);
        monster3.setMonsterImage(monster3img);
        monster4.setMonsterImage(monster4img);
        monster5.setMonsterImage(monster5img);
        monster6.setMonsterImage(monster6img);
        listOfMonsters.add(monster1);
        listOfMonsters.add(monster2);
        listOfMonsters.add(monster3);
        listOfMonsters.add(monster4);
        listOfMonsters.add(monster5);
        listOfMonsters.add(monster6);
    }
}
