package DungeonCrawl.Model;

class Room {
    private int roomXStartPos;
    private int roomYStartPos;
    private int roomHeight;
    private int roomWidth;

    public int getRoomXStartPos() {
        return roomXStartPos;
    }

    public int getRoomYStartPos() {
        return roomYStartPos;
    }

    public int getRoomHeight() {
        return roomHeight;
    }

    public int getRoomWidth() {
        return roomWidth;
    }

    public void setRoomXStartPos(int roomXStartPos) {
        this.roomXStartPos = roomXStartPos;
    }

    public void setRoomYStartPos(int roomYStartPos) {
        this.roomYStartPos = roomYStartPos;
    }

    public void setRoomHeight(int roomHeight) {
        this.roomHeight = roomHeight;
    }

    public void setRoomWidth(int roomWidth) {
        this.roomWidth = roomWidth;
    }
}
