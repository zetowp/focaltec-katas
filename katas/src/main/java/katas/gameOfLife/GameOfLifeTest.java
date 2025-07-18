package katas.gameOfLife;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameOfLifeTest {

    private static byte[][] allIn(int bound, int k) {
        byte[][] spam = new byte[bound][bound];
        for (int i = 0; i < spam.length; i++) {
            for (int j = 0; j < spam.length; j++) {
                spam[i][j] = (byte) k;
            }
        }
        return spam;
    }


    private void assertSpam(byte[][] exp, byte[][] act) {
        for (int i = 0; i < exp.length; i++) {
            for (int j = 0; j < exp[i].length; j++) {
                assertEquals(String.format("Error en la posicion %d, %d", i, j), exp[i][j], act[i][j]);
            }

        }
    }

    @Test
    public void gameOfLifeTest() {
        assertSpam(allIn(2, 0), new GameOfLifeManager(allIn(2, 0)).nextGen().spam());
        assertSpam(allIn(2, 1), new GameOfLifeManager(allIn(2, 1)).nextGen().spam());
        GameOfLifeManager gof = new GameOfLifeManager(allIn(3, 1));
        assertSpam(new byte[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } }, gof.nextGen().spam());
        assertSpam(new byte[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } }, gof.nextGen().spam());
        gof = new GameOfLifeManager(new byte[][] { { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 } });
        assertSpam(new byte[][] { { 0, 1, 0 }, { 1, 0, 1 }, { 0, 1, 0 } }, gof.nextGen().spam());
        assertSpam(allIn(3, 0), gof.nextGen().spam());
        gof.undo();
        assertSpam(new byte[][] { { 0, 1, 0 }, { 1, 0, 1 }, { 0, 1, 0 } }, gof.spam());
        assertSpam(allIn(3, 0), gof.nextGen().spam());
        gof.undo();
        gof.undo();
        gof.undo();
        gof.undo();
        gof.undo();
        gof.undo();
        assertSpam(new byte[][] { { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 } }, gof.spam());
        assertSpam(allIn(3, 0), gof.nextGen().nextGen().spam());
    }

}
