package katas.bowling;

public class BowlingGame {

    private int score = 0;

    private int inFrame = -1;

    private final int strikeBonus = -1;

    private boolean lastRollWasSpare;

    private boolean lastRollWasStrike;

    private boolean addedOneForStrike;

    private boolean beforeLAstWasStrinke;

    public void roll(final int i) {
        this.score += i;
        if (this.lastRollWasSpare) {
            this.score += i;
            this.lastRollWasSpare = false;
        } else if (this.lastRollWasStrike) {
            this.score += i;
            this.addedOneForStrike = !this.addedOneForStrike;
            this.lastRollWasStrike = this.addedOneForStrike;
        }
        if (this.beforeLAstWasStrinke) {
            this.score += i;
            this.beforeLAstWasStrinke = false;
        }
        this.checkBonus(i);
    }

    private void checkBonus(final int i) {
        if (this.inFrame >= 0) {
            this.lastRollWasSpare = this.inFrame + i == 10;
            this.inFrame = -1;
        } else {
            if (i == 10) {
                this.lastRollWasStrike = true;
                this.beforeLAstWasStrinke = true;
                this.inFrame = -1;
            } else {
                this.inFrame = i;
            }
        }
    }

    public int score() {
        return this.score;
    }

}
