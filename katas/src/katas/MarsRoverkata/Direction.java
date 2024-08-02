package katas.MarsRoverkata;


public enum Direction {

    NORTH(1, false), EAST(1, true), SOUTH(-1, false), WEST(-1, true);

    private int add;

    private boolean isX;

    Direction(int add, boolean isX) {
        this.add = add;
        this.isX = isX;
    }

    public int getAdd() {
        return add;
    }

    public boolean isX() {
        return isX;
    }

    public Direction spin(boolean clockWise) {
        return Direction.values()[inLimit(getIndex(), clockWise ? 1 : -1, Direction.values().length)];
    }

    private int getIndex() {
        for (int j = 0; j < Direction.values().length; j++) {
            if (this == Direction.values()[j])
                return j;
        }
        return -1;
    }

    public static int inLimit(int in, int add, int overLimit) {
        int val = in + add;
        if (val < 0)
            return overLimit - 1;
        if (val >= overLimit)
            return 0;
        return val;
    }
}
