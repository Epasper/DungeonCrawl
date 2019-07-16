package DungeonCrawl.Model;


import javafx.scene.image.ImageView;

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

    public double determineTheDistanceToAttackedHero(Monster monster, Hero attackedHero) {
        int monsterXPos = monster.getMapXPos();
        int monsterYPos = monster.getMapYPos();
        int heroXPos = attackedHero.getMapXPos();
        int heroYPos = attackedHero.getMapYPos();
        int distance = 0;
        //todo determine the monster range algorithm
        while (heroXPos != monsterXPos || heroYPos != monsterYPos) {
            if (monsterXPos > heroXPos) {
                if (monsterYPos > heroYPos) {
                    distance += 1.41;
                    heroXPos++;
                    heroYPos++;
                } else if (monsterYPos < heroYPos) {
                    distance += 1.41;
                    heroXPos++;
                    heroYPos--;
                } else {
                    distance++;
                    heroXPos++;
                }
            } else if (monsterXPos < heroXPos) {
                if (monsterYPos > heroYPos) {
                    distance += 1.41;
                    heroXPos--;
                    heroYPos++;
                } else if (monsterYPos < heroYPos) {
                    distance += 1.41;
                    heroXPos--;
                    heroYPos--;
                } else {
                    distance++;
                    heroXPos--;
                }
            } else {
                if (monsterYPos > heroYPos) {
                    distance++;
                    heroYPos++;
                } else {
                    distance++;
                    heroYPos--;
                }
            }
        }
        return distance;
    }

    public int[][] determineSurroundings(EncounterManager encounterManager, Monster attackingMonster, Hero attackedHero) {
        int[][] surroundings = new int[3][3];
        DungeonMap map = encounterManager.getDungeonMap();
        System.out.println("Monster Coordinates: X: " + attackingMonster.getMapXPos() + " Y: " + attackingMonster.getMapYPos());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                try {
                    int x = attackingMonster.getMapXPos() + i -1;
                    int y = attackingMonster.getMapYPos() + j -1;
                    surroundings[i][j] = map.getMapTilesArray()[x][y].getOccupyingCreatureTypeId();
                    System.out.println("Surround check for tile: X: " + (x) + " Y: " + (y));
                    if (surroundings[i][j] == attackedHero.getID()) {
                        System.out.println("Found an attacked hero nearby");
                        break;
                    }
                } catch (IndexOutOfBoundsException ignored) {
                }
            }
        }
        return surroundings;
    }

    public void moveIntoMeleeRange(EncounterManager encounterManager, Monster monster, Hero attackedHero, double distance, int XDirection, int YDirection) {
        int[][] monsterSurroundings = determineSurroundings(encounterManager, monster, attackedHero);
        System.out.println(ConsoleColors.ANSI_RED
                + "Current Monster Coordinates: X:" + monster.getMapXPos() + " - - Y:" + monster.getMapYPos()
                + ConsoleColors.ANSI_RESET);
        for (int[] currentArray : monsterSurroundings) {
            for (int currentInt : currentArray) {
                try {
                    System.out.println("Current int:" + currentInt);
                    if (currentInt == attackedHero.getID()) {
                        System.out.println("FOUND A NEIGHBORING HERO; RETURNING");
                        return;
                    }
                } catch (NullPointerException e) {
                    System.out.println("FOUND A NEIGHBORING HERO; RETURNING");
                    return;
                }
            }
        }
        if (XDirection == 0) {
            if (monster.getMapXPos() > attackedHero.getMapXPos()) {
                XDirection = -1;
            } else if (monster.getMapXPos() < attackedHero.getMapXPos()) {
                XDirection = 1;
            }
        }
        if (YDirection == 0) {
            if (monster.getMapYPos() > attackedHero.getMapYPos()) {
                YDirection = -1;
            } else if (monster.getMapYPos() < attackedHero.getMapYPos()) {
                YDirection = 1;
            }
        }
        if (monsterSurroundings[XDirection + 1][YDirection + 1] > 0) {
            determineADifferentDirection(encounterManager, monster, attackedHero, monsterSurroundings, distance, XDirection, YDirection);
        } else {
            if (distance > 0) {
                encounterManager.getDungeonMap().getMapTilesArray()[monster.getMapXPos()][monster.getMapYPos()].setOccupyingCreatureTypeId(0);
                encounterManager.getDungeonMap().getMapTilesArray()[monster.getMapXPos()][monster.getMapYPos()].setOccupyingCreatureUniqueID(0);
                encounterManager.getDungeonMap().getMapTilesArray()[monster.getMapXPos() + XDirection][monster.getMapYPos() + YDirection].setOccupyingCreatureTypeId(monster.getID());
                encounterManager.getButtonGrid()[monster.getMapXPos() + XDirection][monster.getMapYPos() + YDirection].setGraphic(new ImageView(monster.getCreatureImage()));
                encounterManager.getDungeonMap().getMapTilesArray()[monster.getMapXPos() + XDirection][monster.getMapYPos() + YDirection].setOccupyingCreatureUniqueID(monster.getCurrentMonsterUniqueID());
                monster.setMapXPos(monster.getMapXPos() + XDirection);
                monster.setMapYPos(monster.getMapYPos() + YDirection);

                distance--;
                moveIntoMeleeRange(encounterManager, monster, attackedHero, distance, 0, 0);
            }
        }
    }

    private void determineADifferentDirection(EncounterManager encounterManager, Monster monster, Hero attackedHero, int[][] monsterSurroundings, double distance, int XDirection, int YDirection) {
        /*int deltaX = Math.abs(monster.getMapXPos() - attackedHero.getMapXPos());
        int deltaY = Math.abs(monster.getMapYPos() - attackedHero.getMapYPos());
        if (deltaX == 0) {
            moveIntoMeleeRange(encounterManager, monster, attackedHero, distance, XDirection, 1);
            return;
        } else if (deltaY == 0) {
            moveIntoMeleeRange(encounterManager, monster, attackedHero, distance, 1, YDirection);
            return;
        }
        if (deltaX > deltaY) {
            moveIntoMeleeRange(encounterManager, monster, attackedHero, distance, XDirection, 0);
        } else if (deltaX < deltaY) {
            moveIntoMeleeRange(encounterManager, monster, attackedHero, distance, 0, YDirection);
        }*/
    }

    public void moveAwayToRangedDistance(Monster monster) {

    }
}
