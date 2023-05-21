package game.GameCompenents;

public class Player {
    private int size;
    private int posX;
    private int posY;
    private Room intRoom;
    private int nb;

    public Player(int size, int posX, int posY, Room intRoom) {
        this.size = size;
        this.posX = posX;
        this.posY = posY;
        this.intRoom = intRoom;
        nb = 2;
    }

    public void addNb(int ajout) {
        nb += ajout;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Room getIntRoom() {
        return intRoom;
    }

    public void setIntRoom(Room intRoom) {
        this.intRoom = intRoom;
    }

    public int getNb() {
        return nb;
    }
}
