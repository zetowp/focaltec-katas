package katas.mastermind;

public class MastermindGame {

    private final String init;

    public MastermindGame(String init) {
        this.init = init;
    }

    public String guess(String toEval) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < init.length(); i++) {
            if (toEval.charAt(i) == init.charAt(i)) {
                res.append("+");
            } else if (init.contains(String.valueOf(toEval.charAt(i)))) {
                res.append("-");
            } else {
                res.append(" ");
            }
        }
        return res.toString();
    }

}
