package katas.bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BowlingTest {

    private void rollAll(final BowlingGame game, final int roll) {
        this.rollMany(game, roll, 20);
    }

    private void rollMany(final BowlingGame game, final int roll, final int times) {
        for (int i = 0; i < times; i++)
            game.roll(roll);
    }

    @Test
    public void initTest() {
        BowlingGame game = new BowlingGame();
        this.rollAll(game, 0);
        assertEquals(0, game.score());
        game = new BowlingGame();
        this.rollAll(game, 1);
        assertEquals(20, game.score());
        game = new BowlingGame();
        this.rollAll(game, 2);
        assertEquals(40, game.score());
    }

    @Test
    public void spareTest() {
        BowlingGame game = new BowlingGame();
        game.roll(5);
        game.roll(5);
        game.roll(3);
        assertEquals(16, game.score());

        game = new BowlingGame();
        game.roll(0);
        game.roll(5);
        game.roll(5);
        game.roll(3);
        game.roll(5);
        game.roll(5);
        game.roll(3);
        game.roll(0);
        game.roll(0);
        game.roll(10);
        game.roll(3);

        assertEquals(45, game.score());
        game = new BowlingGame();
        this.rollAll(game, 5);
        assertEquals(145, game.score());
    }

    @Test
    public void strikeTest() {
        BowlingGame game = new BowlingGame();
        game.roll(10);
        game.roll(3);
        game.roll(4);
        assertEquals(24, game.score());
        game.roll(0);
        game.roll(10);
        game.roll(10);
        game.roll(3);
        game.roll(4);
        assertEquals(68, game.score());
        game = new BowlingGame();
        game.roll(10);
        game.roll(10);
        game.roll(10);
        assertEquals(50, game.score());
        game.roll(10);
        game.roll(10);
        assertEquals(110, game.score());
    }

    @Test
    public void perfectGameTest() {
        final BowlingGame game = new BowlingGame();
        this.rollMany(game, 10, 12);
        assertEquals(300, game.score());
    }
}
