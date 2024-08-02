package katas.MarsRoverkata;


public class MarsRover extends MarsObject {

    Direction dir;

    public MarsRover() {
        this(0, 0, Direction.NORTH);
    }

    public MarsRover(int x, int y, Direction dir) {
        super(x, y);
        this.dir = dir;
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return super.toString() + ", dir=" + dir;
    }

}
