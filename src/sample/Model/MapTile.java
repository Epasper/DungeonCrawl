package sample.Model;

import java.util.Random;

public class MapTile {

    public String typeOfTile;
    private int occupyingCreatureId = 0;
    public boolean inWalkRange = false;
    public boolean visible = false;
    public boolean withinInteractionRange = false;

    public String getTypeOfTile() {
        return typeOfTile;
    }

    public void setTypeOfTile(String typeOfTile) {
        this.typeOfTile = typeOfTile;
    }

    public void setOccupyingCreatureId(int occupyingCreatureId) {
        this.occupyingCreatureId = occupyingCreatureId;
    }

    public void setInWalkRange(boolean inWalkRange) {
        this.inWalkRange = inWalkRange;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setWithinInteractionRange(boolean withinInteractionRange) {
        this.withinInteractionRange = withinInteractionRange;
    }

    public int getOccupyingCreatureId() {
        return occupyingCreatureId;
    }

    public boolean isInWalkRange() {
        return inWalkRange;
    }

    public boolean isVisible() {
        return visible;
    }

    public boolean isWithinInteractionRange() {
        return withinInteractionRange;
    }

    public void rollForTypeOfTile(boolean skipToRoom, boolean skipToNonRoom, boolean skipTheCorridor) {
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