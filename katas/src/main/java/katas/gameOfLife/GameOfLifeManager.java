package katas.gameOfLife;

import java.util.Stack;

public class GameOfLifeManager extends GameOfLife {

    private Stack<byte[][]> gens = new Stack<>();

    public GameOfLifeManager(byte[][] initGrid) {
        super(initGrid);
        System.out.println("************ Stat **************");
        print(spam());
    }

    private void print(byte[][] spam) {
        for (int i = 0; i < spam.length; i++) {
            for (int j = 0; j < spam[i].length; j++) {
                System.out.print(spam[i][j] == 1 ? '*' : '-');
            }
            System.out.println();
        }
    }

    public GameOfLife nextGen() {
        gens.push(spam());
        GameOfLife res = super.nextGen();
        System.out.println("next Generation");
        print(res.spam());
        return res;
    }

    public byte[][] spam() {
        return super.spam();
    }

    public void undo() {
        if (!gens.isEmpty()) {
            byte[][] rest = gens.pop();
            System.out.println("************ Restore to **************");
            print(rest);
            super.setSpam(rest);
        }
    }

}
