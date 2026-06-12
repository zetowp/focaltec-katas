package katas.mastermind;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MastermindGameTest {

    @Test
    public void test() {
        MastermindGame game = new MastermindGame("qqqq");
        assertEquals("    ", game.guess("wwww"));
        assertEquals("++++", game.guess("qqqq"));
        assertEquals("+ + ", game.guess("qwqw"));
        game = new MastermindGame("qwer");
        assertEquals("-+--", game.guess("wwww"));
        assertEquals("-+  ", game.guess("rwtt"));
        assertEquals("+++ ", game.guess("qwet"));
        assertEquals("----", game.guess("rewq"));
    }
}
