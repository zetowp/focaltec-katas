package katas.MarsRoverkata;


public class MarsObject {

    protected int x;

    protected int y;

    public MarsObject(int x, int y) {
        this.x = x;
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
