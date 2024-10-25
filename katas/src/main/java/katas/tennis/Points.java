package katas.tennis;


public enum Points implements ScoreTenis {

    LOVE, FIFTEEN, THIRTY, FOURTY, DEUCE, VANTAGE, WIN;

    @Override
    public Points score(Player rival) {
        switch (this) {
            case LOVE:
                return FIFTEEN;
            case FIFTEEN:
                return THIRTY;
            case THIRTY:
                if(rival.getPoints() == FOURTY) {
                    rival.setPoints(DEUCE);
                    return DEUCE;
                } else 
                    return FOURTY;
            case FOURTY:
                if (rival.getPoints() == VANTAGE) {
                    rival.setPoints(DEUCE);
                    return DEUCE;
                } else
                    return WIN;
            case DEUCE:
                rival.setPoints(FOURTY);
                return VANTAGE;
            case VANTAGE:
                return WIN;
            case WIN:
                return WIN;
        }
        return null;
    }

}
