package phase1.gamecenter;

/**
 * The user account.
 */
public class User<T> {

    /**
     * The user's email.
     */
    private String email;
    /**
     * The password to this user's account.
     */
    private String name;
    /**
     * The user's generic game score.
     */
    private GameManager allGames;

    /**
     * A new user.
     * Precondition?
     *
     * @param email    the tiles for the board
     * @param name     the user's name
     * @param allGames all of the user's games
     */
    public User(String email, String name, GameManager allGames) {
        this.email = email;
        this.name = name;
        this.allGames = allGames;

    }

    /**
     * Returns the score for user's gameName's score.
     */
    public GameManager getAllGames(T gameName) {
        return this.allGames;
    }

    /**
     * Returns the user's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email.
     */
    public void setUserEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

