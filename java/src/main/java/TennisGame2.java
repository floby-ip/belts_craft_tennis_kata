
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
    
    public String p1res = "";
    public String p2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        if (p1point == p2point) {
            if (p1point < 3) {
                return getScoreIfEqualityLessThan4();
            } else {
                return SCORE_STR_DEUCE;
            }
        }
        // p1 != p2
        
        if ( p1point < 4 && p2point < 4)
        {
            return getScoreIfP1neqP2andP1lt4andP2lt4();
        }

        if (p1point > p2point && p2point >= 3 && p1point - p2point < 2)
        {
            return SCORE_STR_ADVANTAGE + player1Name;
        }
        
        if (p2point > p1point && p1point >= 3 && p2point - p1point < 2)
        {
            return SCORE_STR_ADVANTAGE + player2Name;
        }
        
        if (p1point >=4 && p2point >=0 && (p1point - p2point)>=2)
        {
            return SCORE_STR_WIN_FOR + player1Name;
        }
        return SCORE_STR_WIN_FOR + player2Name;
    }

    private String getScoreIfP1neqP2andP1lt4andP2lt4() {
        return getPointsAsStr(p1point)
                + SCORE_SEPARATOR
                + getPointsAsStr(p2point);
    }

    private String getPointsAsStr(int points){
        return POINTS_AS_STR_ARRAY[points];
    }

    private String getScoreIfP2gt0andP1eq0() {
        if (p2point ==1)
            p2res = SCORE_STR_FIFTEEN;
        if (p2point ==2)
            p2res = SCORE_STR_THIRTY;
        if (p2point ==3)
            p2res = SCORE_STR_FORTY;

        p1res = SCORE_STR_LOVE;
        return p1res + SCORE_SEPARATOR + p2res;
    }

    private String getScoreIfEqualityLessThan4() {
        String score = "";
        if (p1point ==0)
            score = SCORE_STR_LOVE;
        if (p1point ==1)
            score = SCORE_STR_FIFTEEN;
        if (p1point ==2)
            score = SCORE_STR_THIRTY;
        score += SCORE_SEPARATOR + SCORE_STR_ALL;
        return score;
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
