package katas.tennis;


public class Player {

    private Points score = Points.LOVE;

    private Player rival;

    public Points getPoints() {
        return score;
    }

    public void setPoints(Points points) {
        this.score = points;
    }

    public void setRival(Player rival) {
        this.rival = rival;
    }

    public void score() {
        score = score.score(rival);
    }

}
