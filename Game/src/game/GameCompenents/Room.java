package game.GameCompenents;

public class Room {
    private Wall top;
    private Wall right;
    private Wall left;
    private Wall bottom;
    private int number;
    private Room topRoom;
    private Room rightRoom;
    private Room bottomRoom;
    private Room leftRoom;

    public Room(Wall top, Wall right, Wall left, Wall bottom, int number) {
        this.top = top;
        this.right = right;
        this.left = left;
        this.bottom = bottom;
        this.number = number;

    }

    public Wall getTop() {
        return top;
    }

    public void setTop(Wall top) {
        this.top = top;
    }

    public Wall getRight() {
        return right;
    }

    public void setRight(Wall right) {
        this.right = right;
    }

    public Wall getLeft() {
        return left;
    }

    public void setLeft(Wall left) {
        this.left = left;
    }

    public Wall getBottom() {
        return bottom;
    }

    public void setBottom(Wall bottom) {
        this.bottom = bottom;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Room getTopRoom() {
        return topRoom;
    }

    public void setTopRoom(Room topRoom) {
        this.topRoom = topRoom;
    }

    public Room getRightRoom() {
        return rightRoom;
    }

    public void setRightRoom(Room rightRoom) {
        this.rightRoom = rightRoom;
    }

    public Room getBottomRoom() {
        return bottomRoom;
    }

    public void setBottomRoom(Room bottomRoom) {
        this.bottomRoom = bottomRoom;
    }

    public Room getLeftRoom() {
        return leftRoom;
    }

    public void setLeftRoom(Room leftRoom) {
        this.leftRoom = leftRoom;
    }

}
