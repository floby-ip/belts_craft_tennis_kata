
public class TennisGame3 implements TennisGame {

    private static final String[] SCORES_AS_STRING = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
    private static final String SCORE_STR_ALL = "All";
    private static final String SCORE_STR_SEPARATOR = "-";
    private static final String SCORE_STR_ADVANTAGE = "Advantage ";
    private static final String SCORE_STR_WIN = "Win for ";
    private static final String SCORE_STR_DEUCE = "Deuce";

    private int scoreP1;
    private int scoreP2;
    private String nameP1;
    private String nameP2;

    public TennisGame3(String nameP1, String nameP2) {
        this.nameP1 = nameP1;
        this.nameP2 = nameP2;
    }

    public String getScore() {
        if (scoreP1 < 4 && scoreP2 < 4 && (scoreP1 + scoreP2 != 6)) {
            return concat(SCORES_AS_STRING[scoreP1], SCORE_STR_SEPARATOR, scoreP1 == scoreP2 ?  SCORE_STR_ALL : SCORES_AS_STRING[scoreP2]);
        }
        if (scoreP1 == scoreP2) {
            return SCORE_STR_DEUCE;
        }

        String currentWinner = scoreP1 > scoreP2 ? nameP1 : nameP2;
        return concat (Math.abs(scoreP1 - scoreP2) == 1 ? SCORE_STR_ADVANTAGE : SCORE_STR_WIN, currentWinner);
    }
    
    public void wonPoint(String playerName) {
        if (playerName.equals(nameP1)){
            this.scoreP1 += 1;
        } else {
            this.scoreP2 += 1;
        }
    }

    private String concat(String ... vars){
        StringBuilder sb = new StringBuilder();
        for(String s : vars){
            sb.append(s);
        }
        return sb.toString();
    }

}
