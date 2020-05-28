
public class TennisGame1 implements TennisGame {

    private static final String STR_ADVANTAGE = "Advantage ";
    private static final String STR_WIN = "Win for ";
    private static final String STR_0 = "Love";
    private static final String STR_15 = "Fifteen";
    private static final String STR_30 = "Thirty";
    private static final String STR_40 = "Forty";
    private static final String STR_DEUCE = "Deuce";
    private static final String STR_ALL = "All";
    private static final String STR_SCORE_SEP = "-";

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    /**
     * Incrementer le score du joueur en parametre
     *
     * @param playerName le nom du joueur qui vient de mettre le point
     */
    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    /**
     * Traduire le score "numerique" en score "tennis"
     *
     * @return le score en String
     */
    public String getScore() {
        // Egalité : gestion du A ou Deuce
        if (m_score1 == m_score2) {
            // Si < 3 : score1-All , sinon DEUCE
            return m_score1 < 3 ? getScoreStr(getStrForPoints(m_score1), STR_ALL) : STR_DEUCE;
        }

        // > 40 : Gestion Avantage ou victoire
        if (m_score1 >= 4 || m_score2 >= 4) {
            return getStrForScoreOver40();
        }

        // < 40 et non egal : score classique
        return getScoreStr(getStrForPoints(m_score1), getStrForPoints(m_score2));
    }

    /**
     * Traduit le score si un des deux score est > 40 et qu'il n'y a pas égalité
     *
     * @return
     */
    private String getStrForScoreOver40() {
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) { // Avantage player1
            return getAdvantageStr(player1Name);
        }

        if (minusResult == -1) { // Avantage player2
            return getAdvantageStr(player2Name);
        }

        if (minusResult >= 2) { // Victoire player1
            return getWinStr(player1Name);
        }
        // Victoire player2
        return getWinStr(player2Name);
    }



    /**
     * Concatenation de Advantage et le nom du joueur
     *
     * @param playerName
     * @return la string Advantage Joueur
     */
    private String getAdvantageStr(String playerName) {
        return new StringBuilder(STR_ADVANTAGE).append(playerName).toString();
    }

    /**
     * Concatenation de Win for est le nom du joueur
     *
     * @param playerName
     * @return la string Win for joueur
     */
    private String getWinStr(String playerName) {
        return new StringBuilder(STR_WIN).append(playerName).toString();
    }

    /**
     * Concatenation de score1 - score2
     *
     * @param score1
     * @param score2
     * @return score1 - score2
     */
    private String getScoreStr(String score1, String score2) {
        return new StringBuilder(score1).append(STR_SCORE_SEP).append(score2).toString();
    }

    /**
     * @param points : le nombre de points
     * @return la STR correspondante
     * @Throw RuntimeException si invoqué dans un mauvais cas de figure
     */
    private String getStrForPoints(int points) {
        switch (points) {
            case 0:
                return STR_0;
            case 1:
                return STR_15;
            case 2:
                return STR_30;
            case 3:
                return STR_40;
            default:
                throw new RuntimeException("getStrFroPoints :: Not enough information to handle score " + points);
        }
    }
}
