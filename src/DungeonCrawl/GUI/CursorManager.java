package DungeonCrawl.GUI;

import DungeonCrawl.Model.EncounterManager;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

public class CursorManager {

    private BorderPane mapOuterPane;
    private EncounterManager encounterManager;


    CursorManager(BorderPane mapOuterPane, EncounterManager encounterManager) {
        this.mapOuterPane = mapOuterPane;
        this.encounterManager = encounterManager;
    }

    private void changeTheCursor(Image image, boolean backToDefault) {
        if (backToDefault) {
            mapOuterPane.setCursor(Cursor.DEFAULT);
        } else {
            mapOuterPane.setCursor(new ImageCursor(image));
            //System.out.println("Changing the cursor");
        }
    }

    public void changeTheCursorOnHover(int XPos, int YPos) {
        Image mapCursor = new Image("DungeonCrawl/GUI/Images/Cursors/WalkingCursor.png");
        Image lockCursor = new Image("DungeonCrawl/GUI/Images/Cursors/Lock.png");
        Image swordCursor = new Image("DungeonCrawl/GUI/Images/Cursors/Sword.png");
        //Image Cursor = new Image("DungeonCrawl/GUI/Images/Cursors/WalkingCursor.png");
        String currentTypeOfTile = encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].getTypeOfTile();
        boolean inWalkRange = encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].isInWalkRange();
        int occupyingMonsterID = encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].getOccupyingCreatureTypeId();
        boolean isTheTileInteractive = encounterManager.getDungeonMap().getMapTilesArray()[XPos][YPos].isWithinInteractionRange();
        if (isTheTileInteractive && occupyingMonsterID > 100) {
            changeTheCursor(swordCursor, false);
        } else if (inWalkRange) {
            changeTheCursor(mapCursor, false);
        } else {
            changeTheCursor(null, true);
        }
        if (currentTypeOfTile.contains("Door")) {
            changeTheCursor(lockCursor, false);
        }
    }
}
