package DungeonCrawl.Model;

import DungeonCrawl.GUI.DungeonImageLibraryGUI;
import DungeonCrawl.GUI.GUIUtilities;
import DungeonCrawl.GUI.FieldColors;
import javafx.scene.control.Button;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MapManager {

    private DungeonImageLibraryGUI dungeonImageLibraryGUI = new DungeonImageLibraryGUI();
    private GUIUtilities guiUtilities = new GUIUtilities();
    private HeroManager heroManager;
    private EncounterManager encounterManager;
    private int mapWidth;
    private int mapHeight;
//    private Button[][] buttonGrid;
    private DungeonMap dungeonMap;

/*    Button[][] getButtonGrid() {
        return buttonGrid;
    }*/

    public MapManager(int mapWidth, int mapHeight, EncounterManager encounterManager) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.encounterManager = encounterManager;
        this.dungeonMap = encounterManager.getDungeonMap();
        //buttonGrid = encounterManager.getButtonGrid();
        heroManager = encounterManager.getHeroManager();
    }

    public MapManager() {
    }

    public DungeonMap getDungeonMap() {
        return dungeonMap;
    }

    public void setDungeonMap(DungeonMap dungeonMap) {
        this.dungeonMap = dungeonMap;
    }

    public void updateMapGraphics() {
        updateMapGraphics(false);
    }

    //todo implement some random elements into room spawning - chairs, pillars, rubble and other.

    public void updateMapGraphics(boolean shouldWalkingTilesUpgradeBeSkipped) {
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {
                int currentEntityID = dungeonMap.getMapTilesArray()[i][j].getOccupyingCreatureTypeId();
                String typeOfTile;
                typeOfTile = dungeonMap.getMapTilesArray()[i][j].getTypeOfTile();
                //debug mode only - make the whole dungeonMap alreadyDiscovered:
                //dungeonMap.getMapTilesArray()[i][j].alreadyDiscovered = true;
                dungeonImageLibraryGUI.applyATileImageToAButton(typeOfTile, encounterManager.getButtonGrid()[i][j]);
                if (dungeonMap.getMapTilesArray()[i][j].isInRangedAttackRange() && shouldWalkingTilesUpgradeBeSkipped) {
                    encounterManager.getButtonGrid()[i][j].setStyle(FieldColors.ATTACK_RANGE);
                }
                if (currentEntityID > 0) {
                    applyEntityIconToAButton(currentEntityID, encounterManager.getButtonGrid()[i][j], dungeonMap.getMapTilesArray()[i][j].getOccupyingCreatureUniqueID());
                }
                if (!dungeonMap.getMapTilesArray()[i][j].isAlreadyDiscovered()) {
                    dungeonImageLibraryGUI.applyATileImageToAButton("Fog", encounterManager.getButtonGrid()[i][j]);
                }
            }
        }
    }

    private void applyEntityIconToAButton(int heroID, Button aButton, int uniqueMonsterID) {
        if (heroID < 100) {
            aButton.setGraphic(new ImageView(guiUtilities.getHeroByID(heroID, heroManager.getHeroList()).getCreatureImage()));
        } else {
            Monster monster = guiUtilities.getSingleMonsterByUniqueID(uniqueMonsterID, encounterManager.getAllMonstersList());
            if (!monster.isThisCreatureDead()) {
                aButton.setGraphic(new ImageView(monster.getCreatureImage()));
            } else {
                aButton.setGraphic(addDeathImageToCreatureImage(monster));
                return;
            }
            if (monster.isThisCreatureBloodied()) {
                aButton.setGraphic(addBloodDropImageToCreatureImage(monster));
            }
        }
    }

    ImageView addBloodDropImageToCreatureImage(Creature creature) {
        Image bloodDroplet = new Image("DungeonCrawl/GUI/Images/MapElements/CreatureBloodied.png");
        Image monsterImage = creature.getCreatureImage();
        ImageInput backImageView = new ImageInput(monsterImage);
        ImageInput frontImageView = new ImageInput(bloodDroplet);
        Blend imagesBlend = new Blend();
        imagesBlend.setBottomInput(backImageView);
        imagesBlend.setTopInput(frontImageView);
        imagesBlend.setMode(BlendMode.ADD);
        ImageView finalImageView = new ImageView(monsterImage);
        finalImageView.setEffect(imagesBlend);
        return finalImageView;
    }

    ImageView addDeathImageToCreatureImage(Creature creature) {
        Image skull = new Image("DungeonCrawl/GUI/Images/MapElements/Skull.jpg");
        Image monsterImage = creature.getCreatureImage();
        ImageInput backImageView = new ImageInput(monsterImage);
        ImageInput frontImageView = new ImageInput(skull);
        Blend imagesBlend = new Blend();
        imagesBlend.setBottomInput(backImageView);
        imagesBlend.setTopInput(frontImageView);
        imagesBlend.setMode(BlendMode.ADD);
        ImageView finalImageView = new ImageView(monsterImage);
        finalImageView.setEffect(imagesBlend);
        return finalImageView;
    }
}
