package katas.bowling;

public class BowlingGame {

    private final int[] rolls = new int[21];

    private int currentRoll;

    public void roll(final int i) {
        this.rolls[this.currentRoll++] = i;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;

        for (int frame = 0; frame < 10 && hasRoll(frameIndex); frame++) {
            if (isStrike(frameIndex)) {
                score += 10;
                if (hasRoll(frameIndex + 2)) {
                    score += this.rolls[frameIndex + 1] + this.rolls[frameIndex + 2];
                }
                frameIndex += 1;
            } else {
                if (!hasRoll(frameIndex + 1)) {
                    score += this.rolls[frameIndex];
                    frameIndex += 1;
                    continue;
                }

                final int frameScore = this.rolls[frameIndex] + this.rolls[frameIndex + 1];
                score += frameScore;
                if (frameScore == 10 && hasRoll(frameIndex + 2)) {
                    score += this.rolls[frameIndex + 2];
                }
                frameIndex += 2;
            }
        }

        return score;
    }

    private boolean isStrike(final int frameIndex) {
        return this.rolls[frameIndex] == 10;
    }

    private boolean hasRoll(final int rollIndex) {
        return rollIndex < this.currentRoll;
    }
}
