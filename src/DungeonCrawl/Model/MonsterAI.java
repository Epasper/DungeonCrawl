package DungeonCrawl.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonsterAI {

    public int makeAnAggressionRoll(List<Hero> listOfHeroes, Monster monster) {
        List<Integer> aggressionList = new ArrayList<>();
        int distanceModifier;
        int totalAggression;
        for (Hero hero : listOfHeroes) {
            distanceModifier = Math.abs(hero.getMapXPos() - monster.getMapXPos()) + Math.abs(hero.getMapYPos() - monster.getMapYPos());
            totalAggression = distanceModifier + hero.getAggressionLevel();
            System.out.println(ConsoleColors.ANSI_CYAN + "Aggression for " + hero.getHeroName() + " equals: " + totalAggression + ConsoleColors.ANSI_RESET);
            for (int i = 0; i < totalAggression; i++) {
                aggressionList.add(hero.getID());
            }
        }
        Random random = new Random();
        int aggressionRoll = random.nextInt(aggressionList.size());
        System.out.println("Current Aggression Roll: -> " + aggressionRoll);
        return aggressionList.get(aggressionRoll);
    }

    public void attackAHero(Monster monster, Hero hero) {

    }

    public void moveIntoMeleeRange(Monster monster) {

    }

    public void moveAwayToRangedDistance(Monster monster) {

    }
}
