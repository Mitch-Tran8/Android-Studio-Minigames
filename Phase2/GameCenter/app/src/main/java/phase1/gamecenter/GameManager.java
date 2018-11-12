package phase1.gamecenter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

/**
 * Manage a game, including .
 */
public class GameManager {

    /**
     * A game's name.
     */
    private String gameName;

    /**
     * Firebase database
     */
    private DatabaseReference databaseReference;

    /**
     * A HashMap to store the game's name as key and itself as values
     */
    public Map<String, Game> games = new HashMap<String, Game>();

    /**
     * Manages games for a new user
     */
    public GameManager() {
    }

    /**
     * Manages a pre-populated game
     *
     * @param game the game
     */
    public GameManager(Game game) {
        this.gameName = game.getGameName();
        newGame(game);
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    /**
     * Put gameName and game onto hashMap as key and value accordingly
     *
     * @param game the game
     */
    public void newGame(Game game) {
        games.put(gameName, game);
    }

    /**
     * Retrieves the game with given gameName
     *
     * @param gameName the game's name
     * @return the gameName's corresponding game
     */
    public Game getGame(String gameName) {

        for (Map.Entry<String, Game> game : games.entrySet()) {
            if (game.getKey() == gameName) {
                return game.getValue();
            }
        }
        throw new java.lang.Error("no such game, try another search");
    }

}
