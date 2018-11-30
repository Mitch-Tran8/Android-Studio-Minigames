package phase1.gamecenter;

/*
Taken from:
https://github.com/DaveNOTDavid/sample-puzzle/blob/master/app/src/main/java/com/davenotdavid/samplepuzzle/CustomAdapter.java

This Class is an overwrite of the Base Adapter class
It is designed to aid setting the button sizes and positions in the GridView
 */


import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.ArrayList;

/**
 * the custom adapter
 */
public class CustomAdapter extends BaseAdapter {

    /**
     * the array of buttons
     */
    private ArrayList<Button> mButtons;

    /**
     * the column width and height
     */
    private int mColumnWidth, mColumnHeight;


    public CustomAdapter(ArrayList<Button> buttons, int columnWidth, int columnHeight) {
        mButtons = buttons;
        mColumnWidth = columnWidth;
        mColumnHeight = columnHeight;
    }

    /**
     * count getter
     * @return the button array size
     */
    @Override
    public int getCount() {
        return mButtons.size();
    }

    /**
     * item getter
     * @param position the position
     * @return the button at position
     */
    @Override
    public Object getItem(int position) {
        return mButtons.get(position);
    }

    /**
     * itemId getter
     * @param position the position
     * @return the itemId
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * view getter
     * @param position the position
     * @param convertView the convert view
     * @param parent the parent viewgroup
     * @return the button
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Button button;

        if (convertView == null) {
            button = mButtons.get(position);
        } else {
            button = (Button) convertView;
        }

        android.widget.AbsListView.LayoutParams params =
                new android.widget.AbsListView.LayoutParams(mColumnWidth, mColumnHeight);
        button.setLayoutParams(params);

        return button;
    }
}
