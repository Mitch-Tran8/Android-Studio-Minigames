package phase1.gamecenter;

public class Game<T> {

    /**
     * The current game state
     */
    private String gameName;

    /**
     * The current game score
     */
    private T first;

    /**
     * The game's name
     */
    private T second;

    /**
     * A game
     *
     * @param gameName  the game's name
     * @param first
     * @param second
     */
    public Game(String gameName, T first, T second) {
        this.gameName = gameName;
        this.first = first;
        this.second = second;
    }

    /**
     * Get the game's score
     *
     * @return the game's score
     */
    public T getFirst() {
        return first;
    }

    /**
     * Get the game's state
     *
     * @return the game's state
     */
    public T getSecond() {
        return second;
    }

    /**
     * Get the game's name
     *
     * @return the game's name
     */
    public String getGameName() {
        return gameName;
    }

}
