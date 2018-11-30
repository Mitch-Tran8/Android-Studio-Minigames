package phase1.gamecenter.matched;

import android.support.annotation.NonNull;

import phase1.gamecenter.R;
import phase1.gamecenter.interfaces.Tile;

/**
 * A MatchedTile in a sliding tiles puzzle.
 */
public class MatchedTile implements Tile {

    /**
     * The background id to find the tile image.
     */
    private int background;

    /**
     * The unique id.
     */
    private int id;

    /**
     * Return the background id.
     *
     * @return the background id
     */
    public int getBackground() {
        return background;
    }

    /**
     * Return the tile id.
     *
     * @return the tile id
     */
    public int getId() {
        return id;
    }

    /**
     * A MatchedTile with id and background. The background may not have a corresponding image.
     *
     * @param id         the id
     * @param background the background
     */
    public MatchedTile(int id, int background) {
        this.id = id;
        this.background = background;
    }

    /**
     * A tile with a background id; look up and set the id.
     *
     * @param backgroundId
     */
    public MatchedTile(int backgroundId) {
        id = backgroundId;
        // This looks so ugly.
        switch (backgroundId) {
            case 1:
                background = R.drawable.colour_1;
                break;
            case 2:
                background = R.drawable.colour_1;
                break;
            case 3:
                background = R.drawable.colour_1;
                break;
            case 4:
                background = R.drawable.colour_3;
                break;
            case 5:
                background = R.drawable.colour_3;
                break;
            case 6:
                background = R.drawable.colour_3;
                break;
            case 7:
                background = R.drawable.colour_4;
                break;
            case 8:
                background = R.drawable.colour_4;
                break;
            case 9:
                background = R.drawable.colour_4;
                break;
            case 10:
                background = R.drawable.colour_6;
                break;
            case 11:
                background = R.drawable.colour_6;
                break;
            case 12:
                background = R.drawable.colour_6;
                break;
            case 13:
                background = R.drawable.colour_6;
                break;
            case 14:
                background = R.drawable.colour_7;
                break;
            case 15:
                background = R.drawable.colour_7;
                break;
            case 16:
                background = R.drawable.colour_7;
                break;
            case 17:
                background = R.drawable.colour_7;
                break;
            case 18:
                background = R.drawable.colour_8;
                break;
            case 19:
                background = R.drawable.colour_8;
                break;
            case 20:
                background = R.drawable.colour_8;
                break;
            case 21:
                background = R.drawable.colour_8;
                break;
            case 22:
                background = R.drawable.colour_9;
                break;
            case 23:
                background = R.drawable.colour_9;
                break;
            case 24:
                background = R.drawable.colour_9;
                break;
            case 25:
                background = R.drawable.colour_9;
                break;
            case 26:
                background = R.drawable.colour_16;
                break;
            case 27:
                background = R.drawable.colour_16;
                break;
            case 28:
                background = R.drawable.colour_16;
                break;
            case 29:
                background = R.drawable.colour_16;
                break;
            case 30:
                background = R.drawable.colour_16;
                break;
            case 31:
                background = R.drawable.colour_17;
                break;
            case 32:
                background = R.drawable.colour_17;
                break;
            case 33:
                background = R.drawable.colour_17;
                break;
            case 34:
                background = R.drawable.colour_17;
                break;
            case 35:
                background = R.drawable.colour_17;
                break;
            case 36:
                background = R.drawable.colour_18;
                break;
            case 37:
                background = R.drawable.colour_18;
                break;
            case 38:
                background = R.drawable.colour_18;
                break;
            case 39:
                background = R.drawable.colour_18;
                break;
            case 40:
                background = R.drawable.colour_18;
                break;
            case 41:
                background = R.drawable.colour_19;
                break;
            case 42:
                background = R.drawable.colour_19;
                break;
            case 43:
                background = R.drawable.colour_19;
                break;
            case 44:
                background = R.drawable.colour_19;
                break;
            case 45:
                background = R.drawable.colour_20;
                break;
            case 46:
                background = R.drawable.colour_20;
                break;
            case 47:
                background = R.drawable.colour_20;
                break;
            case 48:
                background = R.drawable.colour_20;
                break;
            case 49:
                background = R.drawable.colour_20;
                break;
            case 50:
                background = R.drawable.colour_20;
                break;
        }
    }

    @Override
    public int compareTo(@NonNull Object o) {
        return ((MatchedTile)o).id - this.id;
    }
}
