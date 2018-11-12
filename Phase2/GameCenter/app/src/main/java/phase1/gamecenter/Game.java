package phase1.gamecenter;

public class Game<T> {

    /**
     * The current game state
     */
    private T gameState;

    /**
     * The current game score
     */
    private T gameScore;

    /**
     * The game's name
     */
    private String gameName;

    /**
     * A game
     *
     * @param gameName  the game's name
     * @param gameState the game's current state
     * @param gameScore the game's score
     */
    public Game(String gameName, T gameState, T gameScore) {
        this.gameState = gameState;
        this.gameScore = gameScore;
        this.gameName = gameName;
    }

    /**
     * Get the game's score
     *
     * @return the game's score
     */
    public T getScore() {
        return gameScore;
    }

    /**
     * Get the game's state
     *
     * @return the game's state
     */
    public T getGameState() {
        return gameState;
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
