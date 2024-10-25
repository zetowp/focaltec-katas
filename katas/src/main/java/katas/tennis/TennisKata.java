package katas.tennis;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TennisKata {

    @Test
    public void givenPoints_returnScore() {
        assertEquals("LOVE - LOVE", new Game().print());
        assertEquals("FIFTEEN - LOVE", new Game().play("a"));
        assertEquals("THIRTY - LOVE", new Game().play("aa"));
        assertEquals("FOURTY - LOVE", new Game().play("aaa"));
        assertEquals("Player A WIN", new Game().play("aaaa"));
        assertEquals("Player A WIN", new Game().play("aaaaaaaabaaab"));
        assertEquals("DEUCE", new Game().play("aaabbb"));
        assertEquals("DEUCE", new Game().play("aaabbbba"));
        assertEquals("DEUCE", new Game().play("aaabbbab"));
        assertEquals("DEUCE", new Game().play("aaabbbabba"));
        assertEquals("Player A VANTAGE", new Game().play("aaabbbabbaa"));
        assertEquals("Player B VANTAGE", new Game().play("aaabbbabbab"));
        assertEquals("Player A WIN", new Game().play("aaabbbabbaaa"));
        assertEquals("Player B WIN", new Game().play("aaabbbabbabb"));
        assertEquals("Player B WIN", new Game().play("aaabbbabbabbaaaaaaaaa"));

    }

    class Game {

        Player a;

        Player b;

        public Game() {
            a = new Player();
            b = new Player();
            a.setRival(b);
            b.setRival(a);
        }

        public String play(String points) {
            System.out.println("\nGame Start");
            for (char p : points.toLowerCase().toCharArray()) {
                if (p == 'a') {
                    a.score();
                } else if (p == 'b') {
                    b.score();
                } else {
                    continue;
                }
                System.out.println(print());
                if (a.getPoints() == Points.WIN || b.getPoints() == Points.WIN)
                    break;
            }
            return print();
        }

        public String print() {
            if (a.getPoints() == Points.DEUCE)
                return a.getPoints().name();
            if (a.getPoints() == Points.VANTAGE || a.getPoints() == Points.WIN)
                return "Player A " + a.getPoints().name();
            if (b.getPoints() == Points.VANTAGE || b.getPoints() == Points.WIN)
                return "Player B " + b.getPoints().name();
            return String.format("%s - %s", a.getPoints().name(), b.getPoints().name());
        }

    }

}
