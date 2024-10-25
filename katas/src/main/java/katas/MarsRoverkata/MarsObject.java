package katas.MarsRoverkata;


public class MarsObject {

    private int x;

    private int y;

    public MarsObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }

    public boolean collition(MarsObject other) {
        return this.x == other.x && this.y == other.y;
    }

}
