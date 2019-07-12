package DungeonCrawl.Model;

import DungeonCrawl.GUI.GUIUtilities;

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

    public boolean checkIfTheHeroIsWithinMeleeRange(EncounterManager encounterManager, Monster monster, int idOfHeroToBeChecked) {
        DungeonMap map = encounterManager.getDungeonMap();
        int monsterXPos = monster.getMapXPos();
        int monsterYPos = monster.getMapYPos();
        for (int i = -1; i < 2; i++) { //todo in future, set this loop for melee reach instead of 1
            for (int j = -1; j < 2; j++) {
                if (map.getMapTilesArray()[monsterXPos + i][monsterYPos + j].getOccupyingCreatureTypeId() == idOfHeroToBeChecked) {
                    return true;
                }
            }
        }
        return false;
    }

    //todo add attack info to console after attacking

    public AttackResults attackAHero(Monster monster, Hero hero) {
        int chanceToHit = monster.getAttack1toHitBonus();
        int defenseToBeChecked = hero.getDefensesMap().get(monster.getAttack1DefenseToBeChecked().toLowerCase());
        int diceRoll = new Random().nextInt(19) + 1;
        AttackResults results = new AttackResults();
        if (chanceToHit + diceRoll > defenseToBeChecked) {
            results.setHitSuccess(true);
            results.setDamage((new Random().nextInt(monster.getAttack1DamageDiceType() - 1) + 1) *
                    monster.getAttack1DamageDiceAmount() +
                    monster.getAttack1DamageBonus());
        } else {
            results.setHitSuccess(false);
        }
        return results;
    }

    public void determineTheDistanceToAttackedHero(EncounterManager encounterManager, Monster monster, int attackedHeroId) {
    }

    public void moveIntoMeleeRange(Monster monster) {

    }

    public void moveAwayToRangedDistance(Monster monster) {

    }
}
