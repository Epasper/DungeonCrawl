package DungeonCrawl.Model;

import java.util.Random;

public class MapTile {

    public String typeOfTile;
    private int occupyingCreatureTypeId = 0;
    private int occupyingCreatureUniqueID = 0;
    boolean inWalkRange = false;
    public boolean alreadyDiscovered = false;
    boolean withinInteractionRange = false;
    private boolean currentlyInvisible = false;
    private boolean currentlyBehindCover = false;

    public boolean isAlreadyDiscovered() {
        return alreadyDiscovered;
    }

    public int getOccupyingCreatureUniqueID() {
        return occupyingCreatureUniqueID;
    }

    public void setOccupyingCreatureUniqueID(int occupyingCreatureUniqueID) {
        this.occupyingCreatureUniqueID = occupyingCreatureUniqueID;
    }

    public void setAlreadyDiscovered(boolean alreadyDiscovered) {
        this.alreadyDiscovered = alreadyDiscovered;
    }

    public boolean isCurrentlyInvisible() {
        return currentlyInvisible;
    }

    public void setCurrentlyInvisible(boolean currentlyInvisible) {
        this.currentlyInvisible = currentlyInvisible;
    }

    public boolean isCurrentlyBehindCover() {
        return currentlyBehindCover;
    }

    public void setCurrentlyBehindCover(boolean currentlyBehindCover) {
        this.currentlyBehindCover = currentlyBehindCover;
    }

    public String getTypeOfTile() {
        return typeOfTile;
    }

    public void setTypeOfTile(String typeOfTile) {
        this.typeOfTile = typeOfTile;
    }

    public void setOccupyingCreatureTypeId(int occupyingCreatureTypeId) {
        this.occupyingCreatureTypeId = occupyingCreatureTypeId;
    }

    public int getOccupyingCreatureTypeId() {
        return occupyingCreatureTypeId;
    }

    public boolean isInWalkRange() {
        return inWalkRange;
    }

    public boolean isWithinInteractionRange() {
        return withinInteractionRange;
    }

    void rollForTypeOfTile(boolean skipToRoom, boolean skipToNonRoom, boolean skipTheCorridor) {
        Random random = new Random();
        int seed = random.nextInt(100);

        if (!skipTheCorridor) {
            if (seed < 60) {
                typeOfTile = "Blank";
            } else {
                typeOfTile = "RoomSeed";
            }
            if (skipToRoom) {
                typeOfTile = "Room";
            }
            if (skipToNonRoom) {
                typeOfTile = "Blank";
            }
        }
    }


}