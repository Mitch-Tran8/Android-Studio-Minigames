package phase1.gamecenter.registrationinfo;

import java.io.Serializable;

/**
 * The email and score of a user
 */
public class EmailAndScore implements Serializable {

    /**
     * The game score
     */
    private int gameScore;

    /**
     * The email
     */
    private String email;

    /**
     * The email and score
     *
     * @param email     the email
     * @param gameScore the game score
     */
    EmailAndScore(String email, int gameScore) {
        this.email = email;
        this.gameScore = gameScore;
    }

    /**
     * Get the user's email
     *
     * @return the user's email
     */
    String getUserEmail() {
        return this.email;
    }

    /**
     * Get the user's game score
     *
     * @return the user's game score
     */
    int getGameScore() {
        return this.gameScore;
    }
}

