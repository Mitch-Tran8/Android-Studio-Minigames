package phase1.gamecenter;

/*
Adapted from:
https://github.com/DaveNOTDavid/sample-puzzle/blob/master/app/src/main/java/com/davenotdavid/samplepuzzle/GestureDetectGridView.java

This extension of GridView contains built in logic for handling swipes between buttons
 */

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.GridView;

import phase1.gamecenter.matched.MatchedBoardManager;
import phase1.gamecenter.slidingtiles.SlidingTileBoardManager;

public class GestureDetectGridView extends GridView {
    public static final int SWIPE_MIN_DISTANCE = 100;
    private GestureDetector gDetector;
    private MovementController mController;
    private boolean mFlingConfirmed = false;
    private float mTouchX;
    private float mTouchY;

    /**
     * the gesteure detected gridview
     *
     * @param context the context
     */
    public GestureDetectGridView(Context context) {
        super(context);
        init(context);
    }

    /**
     * the gesteure detected gridview
     *
     * @param context the context
     * @param attrs   the attribute set
     *                \
     */
    public GestureDetectGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    /**
     * the gesteure detected gridview
     *
     * @param context      the context
     * @param attrs        the attribute set
     * @param defStyleAttr the style attribute
     */
    public GestureDetectGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * the initiator
     *
     * @param context the context
     */
    private void init(final Context context) {
        mController = new MovementController();
        gDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onSingleTapConfirmed(MotionEvent event) {
                int position = GestureDetectGridView.this.pointToPosition
                        (Math.round(event.getX()), Math.round(event.getY()));
                mController.processTapMovement(context, position);

                return true;
            }

            @Override
            public boolean onDown(MotionEvent event) {
                return true;
            }

        });
    }

    /**
     * Return true to steal motion events from the children and have them dispatched to
     * this ViewGroup
     *
     * @param ev the motion event
     * @return true to steal motion events from the children
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getActionMasked();
        gDetector.onTouchEvent(ev);

        if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP) {
            mFlingConfirmed = false;
        } else if (action == MotionEvent.ACTION_DOWN) {
            mTouchX = ev.getX();
            mTouchY = ev.getY();
        } else {

            if (mFlingConfirmed) {
                return true;
            }

            float dX = (Math.abs(ev.getX() - mTouchX));
            float dY = (Math.abs(ev.getY() - mTouchY));
            if ((dX > SWIPE_MIN_DISTANCE) || (dY > SWIPE_MIN_DISTANCE)) {
                mFlingConfirmed = true;
                return true;
            }
        }

        return super.onInterceptTouchEvent(ev);
    }

    /**
     * @param ev the motion event
     * @return whether the motion event is proceeded
     */
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return gDetector.onTouchEvent(ev);
    }

    /**
     * sets up the sliding tiles board manager
     *
     * @param slidingTileBoardManager the slidingtile board manager
     */
    public void setSlidingTileBoardManager(SlidingTileBoardManager slidingTileBoardManager) {
        mController.setSlidingTileBoardManager(slidingTileBoardManager);
    }

    /**
     * sets up the matched board manager
     *
     * @param boardManager the matched board manager
     */
    public void setBoardManager(MatchedBoardManager boardManager) {
        mController.setBoardManager(boardManager);
    }
}
