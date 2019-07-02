package DungeonCrawl.Model;

import DungeonCrawl.GUI.DungeonImageLibraryGUI;
import DungeonCrawl.GUI.GUIUtilities;
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
    private Button[][] buttonGrid;

    Button[][] getButtonGrid() {
        return buttonGrid;
    }

    public MapManager(int mapWidth, int mapHeight, EncounterManager encounterManager) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.encounterManager = encounterManager;
        buttonGrid = encounterManager.getButtonGrid();
        heroManager = encounterManager.getHeroManager();
    }

    public void updateMapGraphics(DungeonMap dungeonMap) {
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {
                int currentEntityID = dungeonMap.getMapTilesArray()[i][j].getOccupyingCreatureTypeId();
                String typeOfTile;
                typeOfTile = dungeonMap.getMapTilesArray()[i][j].typeOfTile;
                //debug mode only - make the whole dungeonMap alreadyDiscovered:
                //dungeonMap.getMapTilesArray()[i][j].alreadyDiscovered = true;
                dungeonImageLibraryGUI.applyATileImageToAButton(typeOfTile, buttonGrid[i][j]);
                if (currentEntityID > 0) {
                    applyEntityIconToAButton(currentEntityID, buttonGrid[i][j], dungeonMap.getMapTilesArray()[i][j].getOccupyingCreatureUniqueID());
                }
                if (!dungeonMap.getMapTilesArray()[i][j].alreadyDiscovered) {
                    dungeonImageLibraryGUI.applyATileImageToAButton("Fog", buttonGrid[i][j]);
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
            }
        }
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
