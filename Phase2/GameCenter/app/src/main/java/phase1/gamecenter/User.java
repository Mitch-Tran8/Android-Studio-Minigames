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


    /**
     * A new user.
     * Precondition?
     *
     * @param email    the tiles for the board
     * @param name     the user's name
     */
    public User(String email, String name) {
        this.email = email;
        this.name = name;

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

    /**
     * returns the name of user
     * @return name
     */

    public String getName() {
        return name;
    }

    /**
     * sets user name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

}

