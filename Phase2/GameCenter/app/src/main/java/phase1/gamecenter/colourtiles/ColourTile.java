package phase1.gamecenter.colourtiles;

import android.support.annotation.NonNull;

import java.io.Serializable;

import phase1.gamecenter.R;
import phase1.gamecenter.Tile;

/**
 * A ColourTile in a sliding tiles puzzle.
 */
public class ColourTile extends Tile implements Comparable<ColourTile>, Serializable {

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
     * A ColourTile with id and background. The background may not have a corresponding image.
     *
     * @param id         the id
     * @param background the background
     */
    public ColourTile(int id, int background) {
        this.id = id;
        this.background = background;
    }

    /**
     * A tile with a background id; look up and set the id.
     *
     * @param backgroundId
     */
    public ColourTile(int backgroundId) {
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
                background = R.drawable.colour_5;
                break;
            case 8:
                background = R.drawable.colour_5;
                break;
            case 9:
                background = R.drawable.colour_5;
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
                background = R.drawable.colour_11;
                break;
            case 27:
                background = R.drawable.colour_11;
                break;
            case 28:
                background = R.drawable.colour_11;
                break;
            case 29:
                background = R.drawable.colour_11;
                break;
            case 30:
                background = R.drawable.colour_11;
                break;
            case 31:
                background = R.drawable.colour_12;
                break;
            case 32:
                background = R.drawable.colour_12;
                break;
            case 33:
                background = R.drawable.colour_12;
                break;
            case 34:
                background = R.drawable.colour_12;
                break;
            case 35:
                background = R.drawable.colour_12;
                break;
            case 36:
                background = R.drawable.colour_13;
                break;
            case 37:
                background = R.drawable.colour_13;
                break;
            case 38:
                background = R.drawable.colour_13;
                break;
            case 39:
                background = R.drawable.colour_13;
                break;
            case 40:
                background = R.drawable.colour_13;
                break;
            case 41:
                background = R.drawable.colour_14;
                break;
            case 42:
                background = R.drawable.colour_14;
                break;
            case 43:
                background = R.drawable.colour_14;
                break;
            case 44:
                background = R.drawable.colour_14;
                break;
            case 45:
                background = R.drawable.colour_14;
                break;
            case 46:
                background = R.drawable.colour_15;
                break;
            case 47:
                background = R.drawable.colour_15;
                break;
            case 48:
                background = R.drawable.colour_15;
                break;
            case 49:
                background = R.drawable.colour_15;
                break;
            case 50:
                background = R.drawable.colour_15;
                break;
        }
    }

    @Override
    public int compareTo(@NonNull ColourTile o) {
        return o.id - this.id;
    }
}