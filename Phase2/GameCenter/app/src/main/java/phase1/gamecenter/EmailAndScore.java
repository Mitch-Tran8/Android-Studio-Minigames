package phase1.gamecenter;

import java.io.Serializable;

/**
 * The email and score of a user
 */
public class EmailAndScore implements Serializable {

    /**
     * The game score
     */
    public int gameScore;

    /**
     * The email
     */
    public String email;

    /**
     * The email and score
     *
     * @param
     * @param gameScore
     */
    public EmailAndScore(String email, int gameScore) {
        this.email = email;
        this.gameScore = gameScore;
    }

    /**
     * Get the user's email
     *
     * @return the user's email
     */
    public String getUserEmail() {
        return this.email;
    }

    /**
     * Get the user's game score
     *
     * @return the user's game score
     */
    public int getGameScore() {
        return this.gameScore;
    }
}

