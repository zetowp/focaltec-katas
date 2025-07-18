package katas.gameOfLife;

public class GameOfLife {

    private byte[][] grid;

    public GameOfLife(byte[][] initGrid) {
        grid = initGrid;
    }

    public GameOfLife nextGen() {
        byte[][] next = new byte[grid.length][grid[0].length];
        for (int i = 0; i < next.length; i++) {
            for (int j = 0; j < next.length; j++) {
                next[i][j] = isAlive(i, j);
            }
        }
        grid = next;
        return this;
    }


    private byte isAlive(int i, int j) {
        int neighbours = get(i, j - 1) + get(i, j + 1) + get(i - 1, j) + get(i + 1, j);
        if (grid[i][j] == 0) {
            return (byte) (neighbours == 3 ? 1 : 0);
        } else {
            return (byte) (neighbours == 2 || neighbours == 3 ? 1 : 0);
        }
    }

    private int get(int i, int j) {
        try {
            return grid[i][j];
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }
    }

    public byte[][] spam() {
        return grid;
    }

    protected void setSpam(byte[][] stage) {
        this.grid = stage;
    }

}
