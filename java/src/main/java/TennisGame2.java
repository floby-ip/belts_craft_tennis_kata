
public class TennisGame2 implements TennisGame
{
    public static final String SCORE_STR_LOVE = "Love";
    public static final String SCORE_STR_FIFTEEN = "Fifteen";
    public static final String SCORE_STR_THIRTY = "Thirty";
    public static final String SCORE_STR_DEUCE = "Deuce";
    public static final String SCORE_STR_FORTY = "Forty";
    public static final String SCORE_SEPARATOR = "-";
    public static final String SCORE_STR_ALL = "All";
    public static final String SCORE_STR_ADVANTAGE = "Advantage ";
    public static final String SCORE_STR_WIN_FOR = "Win for ";

    private static final String[] POINTS_AS_STR_ARRAY = {SCORE_STR_LOVE, SCORE_STR_FIFTEEN, SCORE_STR_THIRTY, SCORE_STR_FORTY};

    public int p1point = 0;
    public int p2point = 0;
    
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        if (p1point == p2point) { // p1 == p2
            if (p1point < 3) {
                return getScoreIfEqualityLessThan4();
            } else {
                return SCORE_STR_DEUCE;
            }
        }
        // p1 != p2
        if ( p1point < 4 && p2point < 4) // Pas de gestion avantage / win
        {
            return getScoreIfP1neqP2andP1lt4andP2lt4();
        }

        if (Math.max(p1point, p2point) - Math.min(p1point, p2point) < 2) // gestion avantage
        {
            return SCORE_STR_ADVANTAGE + getPlayerWithHighestScoreName() ;
        }

        // victoire
        return SCORE_STR_WIN_FOR + getPlayerWithHighestScoreName();
    }

    /**
     * Returns the name of the player with the highest score
     * @return
     */
    private String getPlayerWithHighestScoreName(){
        return p1point > p2point? player1Name : player2Name;
    }

    /**
     * Returns SCORE1-SCORE2 (simple case)
     * @return
     */
    private String getScoreIfP1neqP2andP1lt4andP2lt4() {
        return getPointsAsStr(p1point)
                + SCORE_SEPARATOR
                + getPointsAsStr(p2point);
    }

    /**
     * Returns the String equivalent of the points
     * @param points
     * @return
     */
    private String getPointsAsStr(int points){
        return POINTS_AS_STR_ARRAY[points];
    }

    /**
     * Returns SCORE1-ALL (equality)
     * @return
     */
    private String getScoreIfEqualityLessThan4() {
        return getPointsAsStr(p1point) + SCORE_SEPARATOR + SCORE_STR_ALL;
    }

    public void P1Score(){
        p1point++;
    }
    
    public void P2Score(){
        p2point++;
    }

    public void wonPoint(String player) {
        if (player.equals(player1Name))
            P1Score();
        else
            P2Score();
    }
}
