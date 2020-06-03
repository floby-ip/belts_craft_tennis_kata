
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
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (P1point == P2point && P1point < 3)
        {
            return getScoreIfEqualityLessThan4(score);
        }
        if (P1point==P2point && P1point>=3) {
            return SCORE_STR_DEUCE;
        }
        
        if (P1point > 0 && P1point < 4 && P2point==0)
        {
            return getScoreIfP1gt0andP2eq0();
        }
        if (P2point > 0 && P2point < 4 && P1point==0)
        {
            return getScoreIfP2gt0andP1eq0();
        }

        if (P1point>P2point && P1point < 4)
        {
            return getScoreIfP1gtP2andP1lt4();
        }
        if (P2point>P1point && P2point < 4)
        {
            return getScoreIdP2gtP1andP2lt4();
        }

        if (P1point > P2point && P2point >= 3 && P1point - P2point < 2)
        {
            return SCORE_STR_ADVANTAGE + player1Name;
        }
        
        if (P2point > P1point && P1point >= 3 && P2point - P1point < 2)
        {
            return SCORE_STR_ADVANTAGE + player2Name;
        }
        
        if (P1point>=4 && P2point>=0 && (P1point-P2point)>=2)
        {
            return SCORE_STR_WIN_FOR + player1Name;
        }
        return SCORE_STR_WIN_FOR + player2Name;
    }

    private String getScoreIdP2gtP1andP2lt4() {
        String score;
        if (P2point==2)
            P2res=SCORE_STR_THIRTY;
        if (P2point==3)
            P2res=SCORE_STR_FORTY;
        if (P1point==1)
            P1res=SCORE_STR_FIFTEEN;
        if (P1point==2)
            P1res=SCORE_STR_THIRTY;
        score = P1res + SCORE_SEPARATOR + P2res;
        return score;
    }

    private String getScoreIfP1gtP2andP1lt4() {
        String score;
        if (P1point==2)
            P1res=SCORE_STR_THIRTY;
        if (P1point==3)
            P1res=SCORE_STR_FORTY;
        if (P2point==1)
            P2res=SCORE_STR_FIFTEEN;
        if (P2point==2)
            P2res=SCORE_STR_THIRTY;
        score = P1res + SCORE_SEPARATOR + P2res;
        return score;
    }

    private String getScoreIfP2gt0andP1eq0() {
        String score;
        if (P2point==1)
            P2res = SCORE_STR_FIFTEEN;
        if (P2point==2)
            P2res = SCORE_STR_THIRTY;
        if (P2point==3)
            P2res = SCORE_STR_FORTY;

        P1res = SCORE_STR_LOVE;
        score = P1res + SCORE_SEPARATOR + P2res;
        return score;
    }

    private String getScoreIfP1gt0andP2eq0() {
        String score;
        if (P1point==1)
            P1res = SCORE_STR_FIFTEEN;
        if (P1point==2)
            P1res = SCORE_STR_THIRTY;
        if (P1point==3)
            P1res = SCORE_STR_FORTY;

        P2res = SCORE_STR_LOVE;
        score = P1res + "-" + P2res;
        return score;
    }

    private String getScoreIfEqualityLessThan4(String score) {
        if (P1point==0)
            score = SCORE_STR_LOVE;
        if (P1point==1)
            score = SCORE_STR_FIFTEEN;
        if (P1point==2)
            score = SCORE_STR_THIRTY;
        score += SCORE_SEPARATOR + SCORE_STR_ALL;
        return score;
    }

    public void P1Score(){
        P1point++;
    }
    
    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player.equals(player1Name))
            P1Score();
        else
            P2Score();
    }
}
